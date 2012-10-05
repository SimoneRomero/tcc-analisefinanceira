package br.unioeste.foz.cc.tcc.aquisicaocvm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.unioeste.foz.cc.tcc.aquisicaoweb.ClienteWeb;
import br.unioeste.foz.cc.tcc.aquisicaoweb.IObterEmpresaWeb;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 
 * @author Jhonny Mertz
 * 
 *         Classe para extração de dados a partir de um cliente web.
 * 
 */
public class ExtracaoCVMWeb implements IObterEmpresaWeb {

	private final static String urlListaEmpresas = "http://www.bmfbovespa.com.br/cias-listadas/empresas-listadas/"
			+ "BuscaEmpresaListada.aspx?Letra=";
	private final static String urlDemonstracoes = "http://www.rad.cvm.gov.br/enetconsulta/"
			+ "frmDemonstracaoFinanceiraITR.aspx?Informacao=2&Demonstracao=";
	private final static String urlNumeroDocumento = "&Periodo=&Grupo=&Quadro=&NomeTipoDocumento=&Titulo=&"
			+ "Empresa=&DataReferencia=&Versao=&NumeroSequencialDocumento=";
	private final static String urlHistorico = "http://www.bmfbovespa.com.br/cias-listadas/empresas-listadas/HistoricoFormularioReferencia.aspx?codigoCVM=";

	private ClienteWeb clienteWeb;
	private ParserCVMWeb parserCVMWeb;

	public ExtracaoCVMWeb(ClienteWeb clienteWeb, ParserCVMWeb parserCVMWeb) {
		this.clienteWeb = clienteWeb;
		this.parserCVMWeb = parserCVMWeb;
	}

	public Empresa obterEmpresa(int codCVM)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException {

		HtmlPage historico = clienteWeb.obterPagina(urlHistorico + codCVM
				+ "&tipo=dfp&ano=0&idioma=pt-br");

		HashBackMap<String, String> links = parserCVMWeb.obterLinks(historico);

		clienteWeb.setJavaScriptEnabled(true);
		HtmlPage principal = clienteWeb.obterPagina(links
				.get(java.util.Collections.max(links.keySet())));
		clienteWeb.setJavaScriptEnabled(false);

		Empresa empresa = parserCVMWeb.obterDadosGerais(principal);

		empresa.setRelatorios(obterRelatorios(links.values()));

		return empresa;
	}

	private List<RelatorioAnual> obterRelatorios(Collection<String> links)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException {

		List<RelatorioAnual> relatorios = new ArrayList<RelatorioAnual>();
		for (String link : links) {

			int numeroDocumento = parserCVMWeb.obterNumeroDocumento(link);

			for (RelatorioAnual r : parserCVMWeb.obterRelatorios(
					clienteWeb.obterPagina(urlDemonstracoes + 2
							+ urlNumeroDocumento + numeroDocumento),
					clienteWeb.obterPagina(urlDemonstracoes + 3
							+ urlNumeroDocumento + numeroDocumento),
					clienteWeb.obterPagina(urlDemonstracoes + 4
							+ urlNumeroDocumento + numeroDocumento))) {

				ArrayList<Date> datas = new ArrayList<Date>();
				for (RelatorioAnual relat : relatorios)
					datas.add(relat.getFinalPeriodo());
				if (!datas.contains(r.getFinalPeriodo()))
					relatorios.add(r);
			}

		}

		return relatorios;
	}

	public List<Empresa> obterEmpresasListadas()
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {

		List<Empresa> empresas = new ArrayList<Empresa>();

		for (char letra = '0'; letra <= 'Z'; letra++) {
			if (!((letra >= '0' && letra <= '9') || (letra >= 'A' && letra <= 'Z')))
				continue;
			empresas.addAll(parserCVMWeb.obterEmpresasListadas(clienteWeb
					.obterPagina(urlListaEmpresas + letra + "&idioma=pt-br")));
		}
		return empresas;
	}
}
