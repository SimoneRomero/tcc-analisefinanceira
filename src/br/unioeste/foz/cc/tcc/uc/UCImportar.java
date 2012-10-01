package br.unioeste.foz.cc.tcc.uc;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.unioeste.foz.cc.tcc.importacao.ImportarFactory;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class UCImportar {

	public UCImportar() {

	}

	public List<Empresa> importarEmpresas(String nomeArquivo,
			String nomeTecnologia) throws UnsupportedEncodingException,
			FileNotFoundException {
		ImportarFactory fabrica = ImportarFactory.getInstance(nomeTecnologia);
		return fabrica.importar(nomeArquivo).getList();
	}

}
