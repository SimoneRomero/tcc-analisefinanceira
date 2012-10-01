package br.unioeste.foz.cc.tcc.uc;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.unioeste.foz.cc.tcc.exportacao.ExportarFactory;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.model.empresa.Empresas;

public class UCExportar {

	public UCExportar() {

	}

	public void exportar(List<Empresa> empresas, String nomeArquivo,
			String nomeTecnologia) throws ParserConfigurationException,
			SAXException, IOException {
		ExportarFactory ef = ExportarFactory.getInstance(nomeTecnologia);
		ef.exportar(new Empresas(empresas), nomeArquivo);
	}

}
