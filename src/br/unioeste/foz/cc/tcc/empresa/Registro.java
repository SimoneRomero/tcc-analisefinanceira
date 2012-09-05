package br.unioeste.foz.cc.tcc.empresa;

import java.util.Date;

public class Registro {

	private String tipoParticipante;
	private String categoriaRegCVM;
	private Date dataRegCategoria;
	private String situacaoEmissor;
	private Date dataInicioSituacao;
	private String especieConAcionario;
	private Date dataAlteracaoExercicio;

	public Registro(String tipoParticipante, String categoriaRegCVM,
			Date dataRegCategoria, String situacaoEmissor,
			Date dataInicioSituacao, String especieConAcionario,
			Date dataAlteracaoExercicio) {
		super();
		this.tipoParticipante = tipoParticipante;
		this.categoriaRegCVM = categoriaRegCVM;
		this.dataRegCategoria = dataRegCategoria;
		this.situacaoEmissor = situacaoEmissor;
		this.dataInicioSituacao = dataInicioSituacao;
		this.especieConAcionario = especieConAcionario;
		this.dataAlteracaoExercicio = dataAlteracaoExercicio;
	}

	public String getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(String tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public String getCategoriaRegCVM() {
		return categoriaRegCVM;
	}

	public void setCategoriaRegCVM(String categoriaRegCVM) {
		this.categoriaRegCVM = categoriaRegCVM;
	}

	public Date getDataRegCategoria() {
		return dataRegCategoria;
	}

	public void setDataRegCategoria(Date dataRegCategoria) {
		this.dataRegCategoria = dataRegCategoria;
	}

	public String getSituacaoEmissor() {
		return situacaoEmissor;
	}

	public void setSituacaoEmissor(String situacaoEmissor) {
		this.situacaoEmissor = situacaoEmissor;
	}

	public Date getDataInicioSituacao() {
		return dataInicioSituacao;
	}

	public void setDataInicioSituacao(Date dataInicioSituacao) {
		this.dataInicioSituacao = dataInicioSituacao;
	}

	public String getEspecieConAcionario() {
		return especieConAcionario;
	}

	public void setEspecieConAcionario(String especieConAcionario) {
		this.especieConAcionario = especieConAcionario;
	}

	public Date getDataAlteracaoExercicio() {
		return dataAlteracaoExercicio;
	}

	public void setDataAlteracaoExercicio(Date dataAlteracaoExercicio) {
		this.dataAlteracaoExercicio = dataAlteracaoExercicio;
	}

}
