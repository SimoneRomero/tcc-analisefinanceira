package br.unioeste.foz.cc.tcc.empresa;

import java.util.Date;
import java.util.List;

import br.unioeste.foz.cc.tcc.demonstracao.RelatorioAnual;

public class Empresa {

	private int codigoCVM;
	private String nome;
	private String cnpj;
	private Setor setor;
	private Registro registro;
	private String site;
	private Date dataAlteracaoNome;
	private String nomeAnterior;
	private Date dataConstituicao;
	private Date dataRegCVM;
	private String situacaoRegCVM;
	private Date dataInícioCVM;
	private String paisOrigem;
	private String paisCustodiados;
	private List<RelatorioAnual> relatorios;

	public Empresa(int codigoCVM, String nome, String cnpj, Setor setor,
			Registro registro, String site, Date dataAlteracaoNome,
			String nomeAnterior, Date dataConstituicao, Date dataRegCVM,
			String situacaoRegCVM, Date dataInícioCVM, String paisOrigem,
			String paisCustodiados) {
		super();
		this.codigoCVM = codigoCVM;
		this.nome = nome;
		this.cnpj = cnpj;
		this.setor = setor;
		this.registro = registro;
		this.site = site;
		this.dataAlteracaoNome = dataAlteracaoNome;
		this.nomeAnterior = nomeAnterior;
		this.dataConstituicao = dataConstituicao;
		this.dataRegCVM = dataRegCVM;
		this.situacaoRegCVM = situacaoRegCVM;
		this.dataInícioCVM = dataInícioCVM;
		this.paisOrigem = paisOrigem;
		this.paisCustodiados = paisCustodiados;
	}

	public Empresa(String nome) {
		super();
		this.nome = nome;
	}

	public Empresa(String nome, int codigoCVM) {
		super();
		this.nome = nome;
		this.codigoCVM = codigoCVM;
	}

	public Empresa() {
	}

	public int getCodigoCVM() {
		return codigoCVM;
	}

	public void setCodigoCVM(int codigoCVM) {
		this.codigoCVM = codigoCVM;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getDataAlteracaoNome() {
		return dataAlteracaoNome;
	}

	public void setDataAlteracaoNome(Date dataAlteracaoNome) {
		this.dataAlteracaoNome = dataAlteracaoNome;
	}

	public String getNomeAnterior() {
		return nomeAnterior;
	}

	public void setNomeAnterior(String nomeAnterior) {
		this.nomeAnterior = nomeAnterior;
	}

	public Date getDataConstituicao() {
		return dataConstituicao;
	}

	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}

	public Date getDataRegCVM() {
		return dataRegCVM;
	}

	public void setDataRegCVM(Date dataRegCVM) {
		this.dataRegCVM = dataRegCVM;
	}

	public String getSituacaoRegCVM() {
		return situacaoRegCVM;
	}

	public void setSituacaoRegCVM(String situacaoRegCVM) {
		this.situacaoRegCVM = situacaoRegCVM;
	}

	public Date getDataInícioCVM() {
		return dataInícioCVM;
	}

	public void setDataInícioCVM(Date dataInícioCVM) {
		this.dataInícioCVM = dataInícioCVM;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getPaisCustodiados() {
		return paisCustodiados;
	}

	public void setPaisCustodiados(String paisCustodiados) {
		this.paisCustodiados = paisCustodiados;
	}

	/**
	 * @param relatorios the relatorios to set
	 */
	public void setRelatorios(List<RelatorioAnual> relatorios) {
		this.relatorios = relatorios;
	}

	/**
	 * @return the relatorios
	 */
	public List<RelatorioAnual> getRelatorios() {
		return relatorios;
	}

}