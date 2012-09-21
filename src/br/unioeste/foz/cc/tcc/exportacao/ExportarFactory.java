package br.unioeste.foz.cc.tcc.exportacao;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.unioeste.foz.cc.tcc.model.empresa.Empresas;

public abstract class ExportarFactory {

	public abstract void exportar(Empresas empresas, String nomeArquivo) throws ParserConfigurationException, SAXException, IOException;

	public static ExportarFactory getInstance(String nomeTecnologia){
		if(nomeTecnologia.equals("xml"))
			return new ExportarXML();
		else if(nomeTecnologia.equals("txt"))
			return new ExportarTXT();
		else if(nomeTecnologia.equals("csv"))
			return new ExportarCSV();
		else return null;
	}

}
