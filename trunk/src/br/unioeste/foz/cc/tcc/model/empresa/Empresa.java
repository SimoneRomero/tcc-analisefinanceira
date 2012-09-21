package br.unioeste.foz.cc.tcc.model.empresa;

import java.util.Date;
import java.util.List;

import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;

public class Empresa {

	private int id;
	private String nome;
	private String cnpj;
	private String site;
	private int codigoCVM;
	private Setor setor;
	private Registro registro;
	private String nomeAnterior;
	private Date dataAlteracaoNome;
	private Date dataConstituicao;
	private Date dataInicioCVM;
	private Pais pais;
	private List<RelatorioAnual> relatorios;

	public Empresa(String nome, String cnpj, String site, int codigoCVM,
			Setor setor, Registro registro, String nomeAnterior,
			Date dataAlteracaoNome, Date dataConstituicao, Date dataInicioCVM,
			Pais pais) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.site = site;
		this.codigoCVM = codigoCVM;
		this.setor = setor;
		this.registro = registro;
		this.nomeAnterior = nomeAnterior;
		this.dataAlteracaoNome = dataAlteracaoNome;
		this.dataConstituicao = dataConstituicao;
		this.dataInicioCVM = dataInicioCVM;
		this.pais = pais;
	}

	public Empresa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getCodigoCVM() {
		return codigoCVM;
	}

	public void setCodigoCVM(int codigoCVM) {
		this.codigoCVM = codigoCVM;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public String getNomeAnterior() {
		return nomeAnterior;
	}

	public void setNomeAnterior(String nomeAnterior) {
		this.nomeAnterior = nomeAnterior;
	}

	public Date getDataAlteracaoNome() {
		return dataAlteracaoNome;
	}

	public void setDataAlteracaoNome(Date dataAlteracaoNome) {
		this.dataAlteracaoNome = dataAlteracaoNome;
	}

	public Date getDataConstituicao() {
		return dataConstituicao;
	}

	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}

	public Date getDataInicioCVM() {
		return dataInicioCVM;
	}

	public void setDataInicioCVM(Date dataInicioCVM) {
		this.dataInicioCVM = dataInicioCVM;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<RelatorioAnual> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<RelatorioAnual> relatorios) {
		this.relatorios = relatorios;
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