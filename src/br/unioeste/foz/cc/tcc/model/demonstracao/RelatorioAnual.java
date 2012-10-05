package br.unioeste.foz.cc.tcc.model.demonstracao;

import java.sql.Date;
import java.util.ArrayList;
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

	public double getValorByCodigo(String codigo) {
		try {
			for (AtributoValor av : this.atributos) {
				if (av.getAtributo().getCodigo().equals(codigo))
					return Double.valueOf(av.getValor().replace(".", "")
							.replace(",", "."));
			}
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public String getValor(String codigo) {
		try {
			for (AtributoValor av : this.atributos) {
				if (av.getAtributo().getCodigo().equals(codigo))
					return av.getValor();
			}
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public double getValorByDescricao(String descricao) {
		for (AtributoValor av : this.atributos) {
			if (av.getAtributo().getDescricao().equals(descricao))
				return Double.valueOf(av.getValor().replace(".", "")
						.replace(",", "."));
		}
		return 0;
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

	public List<AtributoValor> getAtributos(String atributos) {
		
		char pattern;

		if (atributos.equals("Ativo")) {
			pattern = '1';
		} else if (atributos.equals("Passivo")) {
			pattern = '2';
		} else {
			pattern = '3';
		}
		
		List<AtributoValor> atrs = new ArrayList<AtributoValor>();
		
		for(AtributoValor av : this.atributos){
			if(av.getAtributo().getCodigo().charAt(0) == pattern){
				atrs.add(av);
			}
		}

		return atrs;
	}

}
