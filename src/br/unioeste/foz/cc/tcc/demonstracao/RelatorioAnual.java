package br.unioeste.foz.cc.tcc.demonstracao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioAnual {

	private Date finalPeriodo;
	private List<AtributoValor> atributos;

	public RelatorioAnual(Date finalPeriodo) {
		this.finalPeriodo = finalPeriodo;
		this.atributos = new ArrayList<AtributoValor>();
	}

	public RelatorioAnual(Date finalPeriodo, List<AtributoValor> atributos) {
		this.finalPeriodo = finalPeriodo;
		this.atributos = atributos;
	}

	public Date getFinalPeriodo() {
		return finalPeriodo;
	}

	public void setFinalPeriodo(Date finalPeriodo) {
		this.finalPeriodo = finalPeriodo;
	}

	public List<AtributoValor> getAtributoValor() {
		return atributos;
	}

	public void setAtributoValor(List<AtributoValor> atributoValor) {
		this.atributos = atributoValor;
	}

	public void addAtributoValor(AtributoValor atributoValor){
		this.atributos.add(atributoValor);
	}

	public void addAtributoValor(List<AtributoValor> atributos){
		this.atributos.addAll(atributos);
	}

}
