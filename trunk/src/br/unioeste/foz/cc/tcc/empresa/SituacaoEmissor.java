package br.unioeste.foz.cc.tcc.empresa;

public class SituacaoEmissor {

	private int id;
	private String situacao;

	public SituacaoEmissor(String situacao) {
		super();
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
	};

}
