package br.unioeste.foz.cc.tcc.model.empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresas {

	private List<Empresa> list;

	public Empresas() {
		list = new ArrayList<Empresa>();
	}

	public void add(Empresa e) {
		list.add(e);
	}

}
