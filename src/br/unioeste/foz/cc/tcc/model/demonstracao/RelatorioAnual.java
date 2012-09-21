package br.unioeste.foz.cc.tcc.model.demonstracao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioAnual {

	private int id;
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

	public RelatorioAnual(int id, java.sql.Date finalPeriodo,
			List<AtributoValor> atributos) {
		this.finalPeriodo = finalPeriodo;
		this.atributos = atributos;
		this.id = id;
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

	public void addAtributoValor(AtributoValor atributoValor) {
		this.atributos.add(atributoValor);
	}

	public void addAtributoValor(List<AtributoValor> atributos) {
		this.atributos.addAll(atributos);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
