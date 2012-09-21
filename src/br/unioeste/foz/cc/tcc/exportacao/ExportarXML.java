package br.unioeste.foz.cc.tcc.exportacao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.unioeste.foz.cc.tcc.model.demonstracao.Atributo;
import br.unioeste.foz.cc.tcc.model.demonstracao.AtributoValor;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.CategoriaRegCVM;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.model.empresa.Empresas;
import br.unioeste.foz.cc.tcc.model.empresa.Pais;
import br.unioeste.foz.cc.tcc.model.empresa.Registro;
import br.unioeste.foz.cc.tcc.model.empresa.Setor;
import br.unioeste.foz.cc.tcc.model.empresa.SituacaoEmissor;
import br.unioeste.foz.cc.tcc.model.empresa.SituacaoRegCVM;
import br.unioeste.foz.cc.tcc.model.empresa.TipoParticipante;

import com.thoughtworks.xstream.XStream;

public class ExportarXML extends ExportarFactory {

	@Override
	public void exportar(Empresas empresas, String nomeArquivo)
			throws ParserConfigurationException, SAXException, IOException {

		XStream x = new XStream();

		x.alias("empresa", Empresa.class);
		x.omitField(Empresa.class, "id");

		x.alias("setor", Setor.class);

		x.alias("registro", Registro.class);
		x.omitField(Registro.class, "id");

		x.alias("tipoparticipante", TipoParticipante.class);
		x.omitField(TipoParticipante.class, "id");

		x.alias("relatorioanual", RelatorioAnual.class);
		x.omitField(RelatorioAnual.class, "id");

		x.alias("atributovalor", AtributoValor.class);
		x.omitField(AtributoValor.class, "id");
		x.omitField(AtributoValor.class, "idAtributo");
		x.omitField(AtributoValor.class, "idRelatorioAnual");

		x.alias("atributo", Atributo.class);
		x.omitField(Atributo.class, "id");
		x.omitField(Atributo.class, "descricao");

		x.alias("situacaoregcvm", SituacaoRegCVM.class);
		x.omitField(SituacaoRegCVM.class, "id");

		x.alias("situacaoemissor", SituacaoEmissor.class);
		x.omitField(SituacaoEmissor.class, "id");

		x.alias("pais", Pais.class);
		x.omitField(Pais.class, "id");

		x.alias("categoriaregcvm", CategoriaRegCVM.class);
		x.omitField(CategoriaRegCVM.class, "id");

		x.alias("empresas", Empresas.class);
		x.addImplicitCollection(Empresas.class, "list");

		Writer saida = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(nomeArquivo), "UTF8"));
		saida.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");

		saida.write(x.toXML(empresas));
		saida.close();
	}

//	public static void main(String[] args)
//			throws FailingHttpStatusCodeException, MalformedURLException,
//			IOException, ParseException, SQLException,
//			ParserConfigurationException, SAXException {
//		// ExtracaoCVMWeb ec = new ExtracaoCVMWeb(new ClienteWeb(), new
//		// ParserCVMWeb());
//		EmpresaDAO ep = new EmpresaDAO();
//
//		ExportarFactory ef = ExportarFactory.getInstance("xml");
//		// ef.exportar(ep.obterTodos(), "abc.xml");
//
//		// cria objeto Pessoa, setando o valor para seus atributos
//		Empresa e = ep.obter(9512, true);
//		Empresas l = new Empresas();
//		l.add(e);
//		ef.exportar(l, "saida.xml");
//
//		ImportarFactory ifc = ImportarFactory.getInstance("xml");
//
//		l = ifc.importar("saida.xml");
//
//		ef.exportar(l, "saida.xml");
//
//	}

}
