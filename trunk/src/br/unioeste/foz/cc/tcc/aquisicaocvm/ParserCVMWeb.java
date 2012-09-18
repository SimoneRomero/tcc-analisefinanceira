package br.unioeste.foz.cc.tcc.aquisicaocvm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.unioeste.foz.cc.tcc.demonstracao.Atributo;
import br.unioeste.foz.cc.tcc.demonstracao.AtributoValor;
import br.unioeste.foz.cc.tcc.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.empresa.CategoriaRegCVM;
import br.unioeste.foz.cc.tcc.empresa.Empresa;
import br.unioeste.foz.cc.tcc.empresa.Pais;
import br.unioeste.foz.cc.tcc.empresa.Registro;
import br.unioeste.foz.cc.tcc.empresa.Setor;
import br.unioeste.foz.cc.tcc.empresa.SituacaoEmissor;
import br.unioeste.foz.cc.tcc.empresa.SituacaoRegCVM;
import br.unioeste.foz.cc.tcc.empresa.TipoParticipante;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class ParserCVMWeb {

	public ParserCVMWeb() {

	}

	public HashBackMap<String, String> obterLinks(HtmlPage historico) {
		HashBackMap<String, String> links = new HashBackMap<String, String>();

		HtmlDivision div = historico
				.getHtmlElementById("ctl00_contentPlaceHolderConteudo_divDemonstrativo");

		List<HtmlElement> elements = div.getHtmlElementsByTagName("li");
		java.util.Collections.reverse(elements);
		for (HtmlElement li : elements) {
			String date = li.getElementsByTagName("a").get(0).getTextContent();
			date = date.substring(date.lastIndexOf("/") + 1, date.indexOf("-") - 1);

			if (Integer.valueOf(date) > 2009) {

				String link = li.getElementsByTagName("a").get(0)
						.getAttribute("href");

				links.put(
						date,
						link.substring(link.indexOf("'") + 1,
								link.lastIndexOf("'")));
			}
		}

		return links;
	}

	public Empresa obterDadosGerais(HtmlPage principal) throws ParseException {

		HtmlPage hp = (HtmlPage) principal.getFrames().get(0).getEnclosedPage();

		HtmlTable ht = hp.getHtmlElementById("ctl00_cphPopUp_Table1");
		HtmlTable htRegistro = hp
				.getHtmlElementById("ctl00_cphPopUp_tabelaDadosRegistro");
		HtmlTable htSetor = hp
				.getHtmlElementById("ctl00_cphPopUp_tabelaDadosSetor");

		Empresa empresa = new Empresa(ht.getRows().get(0).getCells().get(1)
				.asText(), ht.getRows().get(2).getCells().get(3).asText(), ht
				.getRows().get(6).getCells().get(1).asText(),
				Formatador.string2codCvm(ht.getRows().get(3).getCells().get(1)
						.asText()), new Setor(htSetor.getRows().get(0)
						.getCells().get(1).asText(), htSetor.getRows().get(1)
						.getCells().get(1).asText()), new Registro(
						Formatador.string2date(htRegistro.getRows().get(1)
								.getCells().get(3).asText()),
						Formatador.string2date(htRegistro.getRows().get(2)
								.getCells().get(3).asText()),
						Formatador.string2date(ht.getRows().get(3).getCells()
								.get(3).asText()), new TipoParticipante(
								htRegistro.getRows().get(0).getCells().get(1)
										.asText()), new CategoriaRegCVM(
								htRegistro.getRows().get(1).getCells().get(1)
										.asText()), new SituacaoEmissor(
								htRegistro.getRows().get(2).getCells().get(1)
										.asText()), new SituacaoRegCVM(ht
								.getRows().get(4).getCells().get(1).asText())),
				ht.getRows().get(1).getCells().get(3).asText(),
				Formatador.string2date(ht.getRows().get(1).getCells().get(1)
						.asText()), Formatador.string2date(ht.getRows().get(2)
						.getCells().get(1).asText()), Formatador.string2date(ht
						.getRows().get(4).getCells().get(3).asText()),
				new Pais(ht.getRows().get(5).getCells().get(1).asText()));

		return empresa;
	}

	public HashBackMap<Integer, Empresa> obterEmpresasListadas(HtmlPage pagina) {

		HashBackMap<Integer, Empresa> empresas = new HashBackMap<Integer, Empresa>();

		HtmlTable htable = pagina
				.getHtmlElementById("ctl00_contentPlaceHolderConteudo_BuscaNomeEmpresa1_grdEmpresa_ctl01");

		for (HtmlTableRow hr : htable.getBodies().get(0).getRows()) {
			empresas.put(Integer.valueOf(hr
					.getCells()
					.get(0)
					.asXml()
					.substring(
							hr.getCells().get(0).asXml().lastIndexOf("=") + 1,
							hr.getCells().get(0).asXml().lastIndexOf("\""))),
					new Empresa(hr.getCells().get(0).asText()));
		}

		return empresas;
	}

	public int obterNumeroDocumento(String link) {
		return Integer.valueOf(link.substring(link.indexOf("=") + 1, link.indexOf("&")));
	}

	private List<AtributoValor> obterAtributos(HtmlPage pagina, int coluna) {

		List<AtributoValor> atributos = new ArrayList<AtributoValor>();

		HtmlTable ht = pagina.getHtmlElementById("ctl00_cphPopUp_tbDados");

		for (int i = 1; i < ht.getRows().size(); i++) {
			atributos.add(new AtributoValor(ht.getRows().get(i).getCells()
					.get(coluna).asText().trim(), new Atributo(ht.getRows()
					.get(i).getCells().get(1).asText().trim(), ht.getRows()
					.get(i).getCells().get(0).asText().trim())));
		}

		return atributos;
	}

	private HashBackMap<Date, Integer> obterColunas(HtmlTableRow header)
			throws IndexOutOfBoundsException, ParseException {
		HashBackMap<Date, Integer> colunas = new HashBackMap<Date, Integer>();

		for (int i = 2; i < header.getCells().size(); i++)
			colunas.put(
					Formatador.string2date(header
							.getCell(i)
							.asText()
							.substring(
									header.getCell(i).asText()
											.lastIndexOf("\n"))
							.replace("\n", "").trim()), i);

		return colunas;
	}

	public List<RelatorioAnual> obterRelatorios(HtmlPage paginaAtivo,
			HtmlPage paginaPassivo, HtmlPage paginaExercicio)
			throws IndexOutOfBoundsException, ParseException {

		List<RelatorioAnual> relatorios = new ArrayList<RelatorioAnual>();

		HtmlTable ht = paginaAtivo.getHtmlElementById("ctl00_cphPopUp_tbDados");

		HashBackMap<Date, Integer> colunas = obterColunas(ht.getRow(0));

		for (Date d : colunas.keySet()) {
			RelatorioAnual relatorioAnual = new RelatorioAnual(d);
			relatorioAnual.addAtributoValor(obterAtributos(paginaAtivo,
					colunas.get(d)));
			relatorioAnual.addAtributoValor(obterAtributos(paginaPassivo,
					colunas.get(d)));
			relatorioAnual.addAtributoValor(obterAtributos(paginaExercicio,
					colunas.get(d)));
			relatorios.add(relatorioAnual);
		}

		return relatorios;
	}
}
