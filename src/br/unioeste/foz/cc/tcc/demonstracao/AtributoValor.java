package br.unioeste.foz.cc.tcc.demonstracao;

public class AtributoValor {

	private String valor;
	private Atributo atributo;

	public AtributoValor(String valor, Atributo atributo) {
		this.valor = valor;
		this.atributo = atributo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

}
