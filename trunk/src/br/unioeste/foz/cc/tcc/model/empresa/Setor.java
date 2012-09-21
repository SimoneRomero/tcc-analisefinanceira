package br.unioeste.foz.cc.tcc.model.empresa;

public class Setor {

	private String atividade;
	private String descricao;

	public Setor(String atividade, String descricao) {
		super();
		this.atividade = atividade;
		this.descricao = descricao;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
