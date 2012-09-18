package br.unioeste.foz.cc.tcc.comunicacao;

import java.util.List;

import br.unioeste.foz.cc.tcc.empresa.Empresa;

public abstract class ImportarFactory {

	public abstract List<Empresa> importar(String nomeArquivo);

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
