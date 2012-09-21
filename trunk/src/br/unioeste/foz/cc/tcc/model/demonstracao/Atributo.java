package br.unioeste.foz.cc.tcc.model.demonstracao;

import java.util.List;

public class Atributo {

	private int id;
	private String descricao;
	private String codigo;
	private List<AtributoValor> valores;

	public Atributo(String descricao, String codigo) {
		this.descricao = descricao;
		this.setCodigo(codigo);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AtributoValor> getValores() {
		return valores;
	}

	public void setValores(List<AtributoValor> valores) {
		this.valores = valores;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param id the id to set
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
