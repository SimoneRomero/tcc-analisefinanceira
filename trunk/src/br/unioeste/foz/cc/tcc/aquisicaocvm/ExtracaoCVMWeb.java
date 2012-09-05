package br.unioeste.foz.cc.tcc.aquisicaocvm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.foz.cc.tcc.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.empresa.Empresa;
import br.unioeste.foz.cc.tcc.prototipos.HashBackMap;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 *
 * @author Jhonny Mertz
 *
 *         Classe para extração de dados a partir de um cliente web.
 *
 */
public class ExtracaoCVMWeb implements IExtracaoCVMWeb {

	private final static String urlEmpresaListadaCVM = "http://www.bmfbovespa.com.br/cias-listadas/empresas-listadas/"
			+ "ResumoDemonstrativosFinanceiros.aspx?codigoCvm=";
	private final static String urlListaEmpresas = "http://www.bmfbovespa.com.br/cias-listadas/empresas-listadas/"
			+ "BuscaEmpresaListada.aspx?Letra=";
	private final static String urlDemonstracoes = "http://www.rad.cvm.gov.br/enetconsulta/"
			+ "frmDemonstracaoFinanceiraITR.aspx?Informacao=1&Demonstracao=";
	private final static String urlNumeroDocumento = "&Periodo=&Grupo=&Quadro=&NomeTipoDocumento=&Titulo=&"
			+ "Empresa=&DataReferencia=&Versao=&NumeroSequencialDocumento=";

	private ClienteWeb clienteWeb;
	private ParserCVMWeb parserCVMWeb;

	public ExtracaoCVMWeb(ClienteWeb clienteWeb, ParserCVMWeb parserCVMWeb) {
		this.clienteWeb = clienteWeb;
		this.parserCVMWeb = parserCVMWeb;
	}

	public Empresa obterEmpresa(int codCVM)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException {
		HtmlPage listada = clienteWeb
				.obterPagina(urlEmpresaListadaCVM + codCVM);

		String link = parserCVMWeb.obterURLPrincipal(listada);

		clienteWeb.setJavaScriptEnabled(true);
		HtmlPage principal = clienteWeb.obterPagina(link);
		clienteWeb.setJavaScriptEnabled(false);

		Empresa empresa = parserCVMWeb.obterDadosGerais(principal);

		empresa.setRelatorios(obterRelatorios(link));

		return empresa;
	}

	private List<RelatorioAnual> obterRelatorios(String link)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException {

		int numeroDocumento = parserCVMWeb.obterNumeroDocumento(link);
		List<RelatorioAnual> relatorios = new ArrayList<RelatorioAnual>();

		relatorios.addAll(parserCVMWeb
				.obterRelatorios(
						clienteWeb.obterPagina(urlDemonstracoes + 2
								+ urlNumeroDocumento + numeroDocumento),
						clienteWeb.obterPagina(urlDemonstracoes + 3
								+ urlNumeroDocumento + numeroDocumento),
						clienteWeb.obterPagina(urlDemonstracoes + 4
								+ urlNumeroDocumento + numeroDocumento)));

		return relatorios;
	}

	public HashBackMap<Integer, Empresa> obterEmpresasListadas()
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {

		HashBackMap<Integer, Empresa> empresas = new HashBackMap<Integer, Empresa>();

		for (char letra = '0'; letra <= 'Z'; letra++) {
			if (!((letra >= '0' && letra <= '9') || (letra >= 'A' && letra <= 'Z')))
				continue;
			empresas.putAll(parserCVMWeb.obterEmpresasListadas(clienteWeb
					.obterPagina(urlListaEmpresas + letra + "&idioma=pt-br")));
		}
		return empresas;
	}

	public static void main(String args[])
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException {
		ExtracaoCVMWeb ex = new ExtracaoCVMWeb(new ClienteWeb(),
				new ParserCVMWeb());
		Empresa e = ex.obterEmpresa(9512);
		// HashBackMap<Integer, Empresa> a = ex.obterEmpresasListadas();

		System.out.println(e);
	}

}
