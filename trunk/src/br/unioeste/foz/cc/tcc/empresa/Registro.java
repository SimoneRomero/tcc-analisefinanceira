package br.unioeste.foz.cc.tcc.empresa;

import java.util.Date;

public class Registro {

	private int id;
	private Date dataRegCategoria;
	private Date dataInicioSituacao;
	private Date dataRegCVM;
	private TipoParticipante tipo;
	private CategoriaRegCVM categoriaCVM;
	private SituacaoEmissor situacaoEmissor;
	private SituacaoRegCVM situacaoRegCVM;

	public Registro(Date dataRegCategoria, Date dataInicioSituacao,
			Date dataRegCVM,
			TipoParticipante tipo, CategoriaRegCVM categoriaCVM,
			SituacaoEmissor situacaoEmissor, SituacaoRegCVM situacaoRegCVM) {
		super();
		this.dataRegCategoria = dataRegCategoria;
		this.dataInicioSituacao = dataInicioSituacao;
		this.dataRegCVM = dataRegCVM;
		this.tipo = tipo;
		this.categoriaCVM = categoriaCVM;
		this.situacaoEmissor = situacaoEmissor;
		this.situacaoRegCVM = situacaoRegCVM;
	}

	public Date getDataRegCategoria() {
		return dataRegCategoria;
	}

	public void setDataRegCategoria(Date dataRegCategoria) {
		this.dataRegCategoria = dataRegCategoria;
	}

	public Date getDataInicioSituacao() {
		return dataInicioSituacao;
	}

	public void setDataInicioSituacao(Date dataInicioSituacao) {
		this.dataInicioSituacao = dataInicioSituacao;
	}

	public Date getDataRegCVM() {
		return dataRegCVM;
	}

	public void setDataRegCVM(Date dataRegCVM) {
		this.dataRegCVM = dataRegCVM;
	}

	public TipoParticipante getTipo() {
		return tipo;
	}

	public void setTipo(TipoParticipante tipo) {
		this.tipo = tipo;
	}

	public CategoriaRegCVM getCategoriaCVM() {
		return categoriaCVM;
	}

	public void setCategoriaCVM(CategoriaRegCVM categoriaCVM) {
		this.categoriaCVM = categoriaCVM;
	}

	public SituacaoEmissor getSituacaoEmissor() {
		return situacaoEmissor;
	}

	public void setSituacaoEmissor(SituacaoEmissor situacaoEmissor) {
		this.situacaoEmissor = situacaoEmissor;
	}

	public SituacaoRegCVM getSituacaoRegCVM() {
		return situacaoRegCVM;
	}

	public void setSituacaoRegCVM(SituacaoRegCVM situacaoRegCVM) {
		this.situacaoRegCVM = situacaoRegCVM;
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
