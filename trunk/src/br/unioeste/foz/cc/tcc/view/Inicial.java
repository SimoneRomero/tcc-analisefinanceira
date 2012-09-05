package br.unioeste.foz.cc.tcc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

public class Inicial {

	private JFrame frmSistemaDeAdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
					window.frmSistemaDeAdf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeAdf = new JFrame();
		frmSistemaDeAdf.setTitle("Sistema de ADF");
		frmSistemaDeAdf.setBounds(100, 100, 450, 300);
		frmSistemaDeAdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeAdf.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JSeparator separator = new JSeparator();
		mnArquivo.add(separator);
		
		JMenuItem mntmImportarXml = new JMenuItem("Importar XML");
		mnArquivo.add(mntmImportarXml);
		
		JMenuItem mntmExportarXml = new JMenuItem("Exportar XML");
		mnArquivo.add(mntmExportarXml);
		
		JSeparator separator_1 = new JSeparator();
		mnArquivo.add(separator_1);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnEmpresas = new JMenu("Empresas");
		menuBar.add(mnEmpresas);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnEmpresas.add(mntmConsultar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar ");
		mnEmpresas.add(mntmCadastrar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnEmpresas.add(mntmAlterar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnEmpresas.add(mntmExcluir);
		
		JMenu mnAnalisar = new JMenu("Analisar");
		menuBar.add(mnAnalisar);
		
		JMenu mnCvm = new JMenu("CVM");
		menuBar.add(mnCvm);
		
		JMenuItem mntmProcurarEmpresa = new JMenuItem("Procurar Empresa");
		mnCvm.add(mntmProcurarEmpresa);
		
		JMenu mnEmpresasListadas = new JMenu("Empresas Listadas");
		mnCvm.add(mnEmpresasListadas);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mnEmpresasListadas.add(mntmVisualizar);
		
		JMenuItem mntmAtualizarLista = new JMenuItem("Atualizar Lista");
		mnEmpresasListadas.add(mntmAtualizarLista);
		frmSistemaDeAdf.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 434, 241);
		frmSistemaDeAdf.getContentPane().add(splitPane);
		
		JTree tree = new JTree();
		splitPane.setLeftComponent(tree);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
	}

}
