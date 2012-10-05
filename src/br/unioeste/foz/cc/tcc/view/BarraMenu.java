package br.unioeste.foz.cc.tcc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class BarraMenu extends JMenuBar implements ActionListener {

	private ArvoreEmpresas arvoreEmpresas;
	protected BarraMenuActionManager actionManager;

	public BarraMenu(ArvoreEmpresas arvoreEmpresas) {
		super();
		createBar();
		actionManager = new BarraMenuActionManager();
		this.arvoreEmpresas = arvoreEmpresas;
	}

	private void createBar() {
		JMenu mnArquivo = new JMenu("Arquivo");
		add(mnArquivo);

		JMenuItem mntmNovo = new JMenuItem("Novo");
		mnArquivo.add(mntmNovo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnArquivo.add(mntmAbrir);

		JSeparator separator = new JSeparator();
		mnArquivo.add(separator);

		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mnArquivo.add(mntmFechar);

		JMenuItem mntmFecharTodos = new JMenuItem("Fechar Todos");
		mnArquivo.add(mntmFecharTodos);

		JSeparator separator_2 = new JSeparator();
		mnArquivo.add(separator_2);

		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnArquivo.add(mntmSalvar);

		JMenuItem mntmSalvarTodos = new JMenuItem("Salvar Todos");
		mnArquivo.add(mntmSalvarTodos);

		JSeparator separator_1 = new JSeparator();
		mnArquivo.add(separator_1);

		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mnArquivo.add(mntmImprimir);

		JSeparator separator_3 = new JSeparator();
		mnArquivo.add(separator_3);

		JMenuItem mntmImportar = new JMenuItem("Importar");
		mnArquivo.add(mntmImportar);

		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mnArquivo.add(mntmExportar);

		JSeparator separator_4 = new JSeparator();
		mnArquivo.add(separator_4);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);

		JMenu mnEmpresas = new JMenu("Empresas");
		add(mnEmpresas);

		JMenu mnArvoreEmpresas = new JMenu("\u00C1rvore");
		mnEmpresas.add(mnArvoreEmpresas);

		JMenu mnOrdenar = new JMenu("Ordenar");
		mnArvoreEmpresas.add(mnOrdenar);

		JMenuItem mntmRazaoSocial = new JMenuItem("Raz\u00E3o Social");
		mntmRazaoSocial.addActionListener(this);
		mntmRazaoSocial.setActionCommand("ordenar por razao");
		mnOrdenar.add(mntmRazaoSocial);

		JMenuItem mnExpandir = new JMenuItem("Expandir nós");
		mnExpandir.addActionListener(this);
		mnExpandir.setActionCommand("expandir");
		mnArvoreEmpresas.add(mnExpandir);

		JMenuItem mnRecolher = new JMenuItem("Recolher nós");
		mnRecolher.addActionListener(this);
		mnRecolher.setActionCommand("recolher");
		mnArvoreEmpresas.add(mnRecolher);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		add(mnRelatorios);

		JMenu mnAnalisar = new JMenu("Analisar");
		mnRelatorios.add(mnAnalisar);

		JMenu mnIndicadores = new JMenu("Indicadores");
		mnAnalisar.add(mnIndicadores);

		JMenuItem mntmPrazos = new JMenuItem("Prazos");
		mnIndicadores.add(mntmPrazos);

		JMenuItem mntmGiros = new JMenuItem("Giros");
		mnIndicadores.add(mntmGiros);

		JMenu mnCvm = new JMenu("CVM");
		add(mnCvm);

		JMenuItem mntmEmpresasListadas = new JMenuItem("Empresas Listadas");
		mntmEmpresasListadas.addActionListener(this);
		mntmEmpresasListadas.setActionCommand("listar");
		mnCvm.add(mntmEmpresasListadas);

		JMenuItem mntmProcurarEmpresa = new JMenuItem("Procurar Empresa");
		mntmProcurarEmpresa.addActionListener(this);
		mntmProcurarEmpresa.setActionCommand("listar");
		mnCvm.add(mntmProcurarEmpresa);
		
		JMenuItem mntmAtualizarEmpresas = new JMenuItem("Atualizar Informações");
		mntmAtualizarEmpresas.addActionListener(this);
		mntmAtualizarEmpresas.setActionCommand("atualizar empresas");
		mnCvm.add(mntmAtualizarEmpresas);

		JMenu mnAjuda = new JMenu("Ajuda");
		add(mnAjuda);

		JMenuItem mntmTopicosDeAjuda = new JMenuItem("T\u00F3picos de Ajuda");
		mntmTopicosDeAjuda.setActionCommand("help");
		mntmTopicosDeAjuda.addActionListener(this);
		mnAjuda.add(mntmTopicosDeAjuda);

		JMenuItem mntmVerificarAtualizacoes = new JMenuItem(
				"Verificar Atualiza\u00E7\u00F5es");
		mnAjuda.add(mntmVerificarAtualizacoes);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("ordenar por razao")) {
				arvoreEmpresas.setModel(new DefaultTreeModel(ArvoreEmpresas
						.sortTree((DefaultMutableTreeNode) arvoreEmpresas
								.getModel().getRoot())));
			} else if (e.getActionCommand().equals("procurar")) {
				actionManager.procurar(arvoreEmpresas);
			} else if (e.getActionCommand().equals("listar")) {
				actionManager.listar(arvoreEmpresas);
			} else if (e.getActionCommand().equals("expandir")) {
				arvoreEmpresas.expandirTodos();
			} else if (e.getActionCommand().equals("recolher")) {
				arvoreEmpresas.recolherTodos();
			}
			else if (e.getActionCommand().equals("help")) {
				actionManager.helper();
			}
			else if (e.getActionCommand().equals("atualizar empresas")) {
				actionManager.atualizarEmpresas();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
