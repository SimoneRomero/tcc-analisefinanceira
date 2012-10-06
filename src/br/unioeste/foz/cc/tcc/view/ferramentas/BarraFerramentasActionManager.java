package br.unioeste.foz.cc.tcc.view.ferramentas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.cvm.EmpresasListadas;
import br.unioeste.foz.cc.tcc.view.cvm.ProcurarEmpresa;

public class BarraFerramentasActionManager {

	public BarraFerramentasActionManager() {

	}

	public void procurar(ArvoreEmpresas arvoreEmpresas) {
		ProcurarEmpresa frame = new ProcurarEmpresa(arvoreEmpresas);
		frame.setVisible(true);
	}
	
	public void listar(ArvoreEmpresas arvoreEmpresas) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		EmpresasListadas frame = new EmpresasListadas(arvoreEmpresas);
		frame.setVisible(true);
	}

}
