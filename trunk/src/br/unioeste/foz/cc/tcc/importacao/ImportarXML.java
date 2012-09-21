package br.unioeste.foz.cc.tcc.importacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

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

public class ImportarXML extends ImportarFactory {

	@Override
	public Empresas importar(String nomeArquivo)
			throws UnsupportedEncodingException, FileNotFoundException {

		XStream x = new XStream();

		x.alias("empresa", Empresa.class);
		x.alias("setor", Setor.class);
		x.alias("registro", Registro.class);
		x.alias("tipoparticipante", TipoParticipante.class);
		x.alias("relatorioanual", RelatorioAnual.class);
		x.alias("atributovalor", AtributoValor.class);
		x.alias("atributo", Atributo.class);
		x.alias("situacaoregcvm", SituacaoRegCVM.class);
		x.alias("situacaoemissor", SituacaoEmissor.class);
		x.alias("pais", Pais.class);
		x.alias("categoriaregcvm", CategoriaRegCVM.class);
		x.alias("empresas", Empresas.class);
		x.addImplicitCollection(Empresas.class, "list");

//		Reader entrada = new BufferedReader(new InputStreamReader(
		FileInputStream f = new FileInputStream(new File(nomeArquivo));

		return (Empresas) x.fromXML(f);
	}

}
