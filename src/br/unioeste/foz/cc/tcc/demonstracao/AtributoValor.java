package br.unioeste.foz.cc.tcc.demonstracao;

public class AtributoValor {

	private int idAtributo;
	private int idRelatorioAnual;
	private String valor;
	private Atributo atributo;

	public AtributoValor(String valor, Atributo atributo) {
		this.valor = valor;
		this.atributo = atributo;
	}

	public AtributoValor(int idRelatorioanual, int idAtributo, String valor,
			Atributo atributo) {
		this.valor = valor;
		this.atributo = atributo;
		this.idAtributo = idAtributo;
		this.idRelatorioAnual = idRelatorioanual;
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

	public int getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(int idAtributo) {
		this.idAtributo = idAtributo;
	}

	public int getIdRelatorioAnual() {
		return idRelatorioAnual;
	}

	public void setIdRelatorioAnual(int idRelatorioAnual) {
		this.idRelatorioAnual = idRelatorioAnual;
	}

}
