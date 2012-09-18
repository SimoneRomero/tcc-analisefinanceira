package br.unioeste.foz.cc.tcc.comunicacao;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.unioeste.foz.cc.tcc.empresa.Empresa;

public abstract class ExportarFactory {

	public abstract void exportar(List<Empresa> empresas, String nomeArquivo) throws ParserConfigurationException, SAXException, IOException;

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
