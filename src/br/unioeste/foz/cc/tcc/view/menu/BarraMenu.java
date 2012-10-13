package br.unioeste.foz.cc.tcc.view.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import br.unioeste.foz.cc.tcc.controller.BarraMenuActionManager;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.util.MonitorBarraProgresso;

@SuppressWarnings("serial")
public class BarraMenu extends JMenuBar{

	private ArvoreEmpresas arvoreEmpresas;
	private BarraMenuActionManager actionManager;
	private MonitorBarraProgresso monitorProgressBar;

	public BarraMenu(ArvoreEmpresas arvoreEmpresas, MonitorBarraProgresso monitorProgressBar) {
		super();
		this.arvoreEmpresas = arvoreEmpresas;
		this.monitorProgressBar = monitorProgressBar;
		actionManager = new BarraMenuActionManager(this);
		createBar();		
	}

	private void createBar() {
		JMenu mnArquivo = new JMenu("Arquivo");
		add(mnArquivo);

//		JMenuItem mntmNovo = new JMenuItem("Novo");
//		mnArquivo.add(mntmNovo);
//
//		JMenuItem mntmAbrir = new JMenuItem("Abrir");
//		mnArquivo.add(mntmAbrir);
//
//		JSeparator separator = new JSeparator();
//		mnArquivo.add(separator);
//
//		JMenuItem mntmFechar = new JMenuItem("Fechar");
//		mnArquivo.add(mntmFechar);
//
//		JMenuItem mntmFecharTodos = new JMenuItem("Fechar Todos");
//		mnArquivo.add(mntmFecharTodos);
//
//		JSeparator separator_2 = new JSeparator();
//		mnArquivo.add(separator_2);
//
//		JMenuItem mntmSalvar = new JMenuItem("Salvar");
//		mnArquivo.add(mntmSalvar);
//
//		JMenuItem mntmSalvarTodos = new JMenuItem("Salvar Todos");
//		mnArquivo.add(mntmSalvarTodos);
//
//		JSeparator separator_1 = new JSeparator();
//		mnArquivo.add(separator_1);
//
//		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
//		mnArquivo.add(mntmImprimir);
//
//		JSeparator separator_3 = new JSeparator();
//		mnArquivo.add(separator_3);

		JMenuItem mntmImportar = new JMenuItem("Importar");
		mntmImportar.setActionCommand("importar");
		mntmImportar.addActionListener(actionManager);
		mnArquivo.add(mntmImportar);

		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mntmExportar.setActionCommand("exportar");
		mntmExportar.addActionListener(actionManager);
		mnArquivo.add(mntmExportar);

		JSeparator separator_4 = new JSeparator();
		mnArquivo.add(separator_4);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(actionManager);
		mntmSair.setActionCommand("sair");
		mnArquivo.add(mntmSair);

		JMenu mnEmpresas = new JMenu("Empresas");
		add(mnEmpresas);

		JMenu mnArvoreEmpresas = new JMenu("\u00C1rvore");
		mnEmpresas.add(mnArvoreEmpresas);

		JMenu mnOrdenar = new JMenu("Ordenar");
		mnArvoreEmpresas.add(mnOrdenar);

		JMenuItem mntmRazaoSocial = new JMenuItem("Raz\u00E3o Social");
		mntmRazaoSocial.addActionListener(actionManager);
		mntmRazaoSocial.setActionCommand("ordenar por razao");
		mnOrdenar.add(mntmRazaoSocial);

		JMenuItem mnExpandir = new JMenuItem("Expandir nós");
		mnExpandir.addActionListener(actionManager);
		mnExpandir.setActionCommand("expandir");
		mnArvoreEmpresas.add(mnExpandir);

		JMenuItem mnRecolher = new JMenuItem("Recolher nós");
		mnRecolher.addActionListener(actionManager);
		mnRecolher.setActionCommand("recolher");
		mnArvoreEmpresas.add(mnRecolher);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		add(mnRelatorios);

		JMenu mnAnalisar = new JMenu("Analisar");
		mnRelatorios.add(mnAnalisar);

		JMenu mnIndicadores = new JMenu("Indicadores");
		mnAnalisar.add(mnIndicadores);

		JMenu mnPrazos = new JMenu("Prazos Médios");
		mnIndicadores.add(mnPrazos);
		
		JMenuItem mntmPrazoVendas = new JMenuItem("Recebimento de Vendas");
		mntmPrazoVendas.addActionListener(actionManager);
		mntmPrazoVendas.setActionCommand("prazo venda");
		mnPrazos.add(mntmPrazoVendas);
		
		JMenuItem mntmPrazoCompras = new JMenuItem("Pagamento de Compras");
		mntmPrazoCompras.addActionListener(actionManager);
		mntmPrazoCompras.setActionCommand("prazo compra");
		mnPrazos.add(mntmPrazoCompras);
		
		JMenuItem mntmPrazoEstoque = new JMenuItem("Renovação de Estoques");
		mntmPrazoEstoque.addActionListener(actionManager);
		mntmPrazoEstoque.setActionCommand("prazo estoque");
		mnPrazos.add(mntmPrazoEstoque);

		JMenuItem mntmGiros = new JMenuItem("Giros");
		mntmGiros.setActionCommand("analisar giros");
		mntmGiros.addActionListener(actionManager);
		mnIndicadores.add(mntmGiros);

		JMenu mnCvm = new JMenu("CVM");
		add(mnCvm);

		JMenuItem mntmEmpresasListadas = new JMenuItem("Empresas Listadas");
		mntmEmpresasListadas.addActionListener(actionManager);
		mntmEmpresasListadas.setActionCommand("listar");
		mnCvm.add(mntmEmpresasListadas);

		JMenuItem mntmProcurarEmpresa = new JMenuItem("Procurar Empresa");
		mntmProcurarEmpresa.addActionListener(actionManager);
		mntmProcurarEmpresa.setActionCommand("procurar");
		mnCvm.add(mntmProcurarEmpresa);
		
		JMenuItem mntmAtualizarEmpresas = new JMenuItem("Atualizar Informações");
		mntmAtualizarEmpresas.addActionListener(actionManager);
		mntmAtualizarEmpresas.setActionCommand("atualizar empresas");
		mnCvm.add(mntmAtualizarEmpresas);

		JMenu mnAjuda = new JMenu("Ajuda");
		add(mnAjuda);

		JMenuItem mntmTopicosDeAjuda = new JMenuItem("T\u00F3picos de Ajuda");
		mntmTopicosDeAjuda.setActionCommand("help");
		mntmTopicosDeAjuda.addActionListener(actionManager);
		mnAjuda.add(mntmTopicosDeAjuda);

		JMenuItem mntmVerificarAtualizacoes = new JMenuItem(
				"Verificar Atualiza\u00E7\u00F5es");
		mnAjuda.add(mntmVerificarAtualizacoes);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setActionCommand("sobre");
		mntmSobre.addActionListener(actionManager);
		mnAjuda.add(mntmSobre);
	}

	

	public ArvoreEmpresas getArvoreEmpresas() {
		return arvoreEmpresas;
	}

	public void setArvoreEmpresas(ArvoreEmpresas arvoreEmpresas) {
		this.arvoreEmpresas = arvoreEmpresas;
	}

	public MonitorBarraProgresso getMonitorProgressBar() {
		return monitorProgressBar;
	}

	public void setMonitorProgressBar(MonitorBarraProgresso monitorProgressBar) {
		this.monitorProgressBar = monitorProgressBar;
	}
}
