package br.unioeste.foz.cc.tcc.demonstracao;

import java.util.List;

public class Atributo {

	private String descricao;
	private String codigo;
	private List<AtributoValor> valores;

	public Atributo(String descricao, String codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getId() {
		return codigo;
	}

	public void setId(String id) {
		this.codigo = id;
	}

	public List<AtributoValor> getValores() {
		return valores;
	}

	public void setValores(List<AtributoValor> valores) {
		this.valores = valores;
	}

}
