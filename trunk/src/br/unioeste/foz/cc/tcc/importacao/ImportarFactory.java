package br.unioeste.foz.cc.tcc.importacao;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import br.unioeste.foz.cc.tcc.model.empresa.Empresas;

public abstract class ImportarFactory {

	public abstract Empresas importar(String nomeArquivo) throws UnsupportedEncodingException, FileNotFoundException;

	public static ImportarFactory getInstance(String nomeTecnologia){
		if(nomeTecnologia.equals("xml"))
			return new ImportarXML();
		else if(nomeTecnologia.equals("txt"))
			return new ImportarTXT();
		else if(nomeTecnologia.equals("csv"))
			return new ImportarCSV();
		else return null;
	}

}
