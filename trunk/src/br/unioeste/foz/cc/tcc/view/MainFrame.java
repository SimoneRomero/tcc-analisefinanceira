package br.unioeste.foz.cc.tcc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainFrame extends JFrame implements ActionListener {
	JDesktopPane desktop;
	private JTable table;

	public MainFrame() {
		super("Sistema de ADF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Make the big window be indented 50 pixels from each edge
		// of the screen.
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, 819, 668);

		// Set up the GUI.
		desktop = new JDesktopPane(); // a specialized layered pane
		// createFrame(); // create first "window"
		setContentPane(desktop);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 42, 803, 567);
		desktop.add(splitPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);

		tabbedPane.addTab("Balan\u00E7o Patrimonial - Ativo", null, tabela(),
				null);
		tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1,
				new ButtonTabComponent(tabbedPane));

		// for (int i = 0; i < tree.getRowCount(); i++) {
		// tree.expandRow(i);
		// }
		splitPane.setLeftComponent(createTree());
		setJMenuBar(createMenuBar());

		// Make dragging a little faster but perhaps uglier.
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		desktop.add(createToolBar());

	}

	protected JToolBar createToolBar() {

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(0, 0, 1250, 42);

		JButton btnProcurarEmpresa = new JButton("Procurar Empresa");
		toolBar_1.add(btnProcurarEmpresa);

		JButton btnListaDeEmpresas = new JButton("Empresas Listadas");
		toolBar_1.add(btnListaDeEmpresas);

		toolBar_1.addSeparator();
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(1, 100));
		toolBar_1.add(separator);
		toolBar_1.addSeparator();

		JButton btnImportar = new JButton("Importar");
		toolBar_1.add(btnImportar);

		JButton btnExportar = new JButton("Exportar");
		toolBar_1.add(btnExportar);
		btnExportar.setIcon(null);

		toolBar_1.addSeparator();
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setMaximumSize(new Dimension(1, 100));
		toolBar_1.add(separator_1);
		toolBar_1.addSeparator();

		JButton btnAjuda = new JButton("Ajuda");
		toolBar_1.add(btnAjuda);
		return toolBar_1;

	}

	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

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
		menuBar.add(mnEmpresas);

		JMenu mnOrdenarArvore = new JMenu("Ordenar \u00C1rvore");
		mnEmpresas.add(mnOrdenarArvore);

		JMenuItem mntmPorCodigoCvm = new JMenuItem("Codigo CVM");
		mnOrdenarArvore.add(mntmPorCodigoCvm);

		JMenuItem mntmRazaoSocial = new JMenuItem("Raz\u00E3o Social");
		mnOrdenarArvore.add(mntmRazaoSocial);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);

		JMenu mnAnalisar = new JMenu("Analisar");
		mnRelatorios.add(mnAnalisar);

		JMenu mnIndicadores = new JMenu("Indicadores");
		mnAnalisar.add(mnIndicadores);

		JMenuItem mntmPrazos = new JMenuItem("Prazos");
		mnIndicadores.add(mntmPrazos);

		JMenuItem mntmGiros = new JMenuItem("Giros");
		mnIndicadores.add(mntmGiros);

		JMenu mnCvm = new JMenu("CVM");
		menuBar.add(mnCvm);

		JMenuItem mntmEmpresasListadas = new JMenuItem("Empresas Listadas");
		mnCvm.add(mntmEmpresasListadas);

		JMenuItem mntmProcurarEmpresa = new JMenuItem("Procurar Empresa");
		mnCvm.add(mntmProcurarEmpresa);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmTopicosDeAjuda = new JMenuItem("T\u00F3picos de Ajuda");
		mnAjuda.add(mntmTopicosDeAjuda);

		JMenuItem mntmVerificarAtualizacoes = new JMenuItem(
				"Verificar Atualiza\u00E7\u00F5es");
		mnAjuda.add(mntmVerificarAtualizacoes);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);

		return menuBar;
	}

	protected JTree createTree() {
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Empresas");
		DefaultMutableTreeNode emp = null;
		DefaultMutableTreeNode ano = null;
		DefaultMutableTreeNode df = null;
		DefaultMutableTreeNode subdf = null;

		emp = new DefaultMutableTreeNode("PETROLEO BRASILEIRO S.A. PETROBRAS");
		raiz.add(emp);

		ano = new DefaultMutableTreeNode("2011");
		emp.add(ano);

		df = new DefaultMutableTreeNode("Balanço Patrimonial");
		ano.add(df);
		subdf = new DefaultMutableTreeNode("Ativo");
		df.add(subdf);
		subdf = new DefaultMutableTreeNode("Passivo");
		df.add(subdf);

		df = new DefaultMutableTreeNode("Demontração de Resultado");
		ano.add(df);

		ano = new DefaultMutableTreeNode("2010");
		emp.add(ano);

		df = new DefaultMutableTreeNode("Balanço Patrimonial");
		ano.add(df);
		subdf = new DefaultMutableTreeNode("Ativo");
		df.add(subdf);
		subdf = new DefaultMutableTreeNode("Passivo");
		df.add(subdf);

		df = new DefaultMutableTreeNode("Demontração de Resultado");
		ano.add(df);

		ano = new DefaultMutableTreeNode("2009");
		emp.add(ano);

		df = new DefaultMutableTreeNode("Balanço Patrimonial");
		ano.add(df);
		subdf = new DefaultMutableTreeNode("Ativo");
		df.add(subdf);
		subdf = new DefaultMutableTreeNode("Passivo");
		df.add(subdf);

		df = new DefaultMutableTreeNode("Demontração de Resultado");
		ano.add(df);

		emp = new DefaultMutableTreeNode("VALE S.A.");
		raiz.add(emp);

		ano = new DefaultMutableTreeNode("2011");
		emp.add(ano);

		df = new DefaultMutableTreeNode("Balanço Patrimonial");
		ano.add(df);
		subdf = new DefaultMutableTreeNode("Ativo");
		df.add(subdf);
		subdf = new DefaultMutableTreeNode("Passivo");
		df.add(subdf);

		df = new DefaultMutableTreeNode("Demontração de Resultado");
		ano.add(df);

		ano = new DefaultMutableTreeNode("2010");
		emp.add(ano);

		df = new DefaultMutableTreeNode("Balanço Patrimonial");
		ano.add(df);
		subdf = new DefaultMutableTreeNode("Ativo");
		df.add(subdf);
		subdf = new DefaultMutableTreeNode("Passivo");
		df.add(subdf);

		df = new DefaultMutableTreeNode("Demontração de Resultado");
		ano.add(df);

		ano = new DefaultMutableTreeNode("2009");
		emp.add(ano);

		df = new DefaultMutableTreeNode("Balanço Patrimonial");
		ano.add(df);
		subdf = new DefaultMutableTreeNode("Ativo");
		df.add(subdf);
		subdf = new DefaultMutableTreeNode("Passivo");
		df.add(subdf);

		df = new DefaultMutableTreeNode("Demontração de Resultado");
		ano.add(df);

		return new JTree(raiz);
	}

	// React to menu selections.
	public void actionPerformed(ActionEvent e) {
		if ("new".equals(e.getActionCommand())) { // new
			// createFrame();
		} else { // quit
			quit();
		}
	}

	// // Create a new internal frame.
	// protected void createFrame() {
	// MyInternalFrame frame = new MyInternalFrame();
	// frame.setLocation(313, 53);
	// frame.setVisible(true); // necessary as of 1.3
	// desktop.add(frame);
	// try {
	// frame.setSelected(true);
	// } catch (java.beans.PropertyVetoException e) {
	// }
	// }

	// Quit the application.
	protected void quit() {
		System.exit(0);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		// JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the window.
		frame.setVisible(true);
	}

	public JPanel tabela() {
		String[] columnNames = { "Código", "Descrição", "2011", "2010", "2009" };

		JTable table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JTableHeader jth = table.getTableHeader();
		table.setAutoCreateRowSorter(true);

		JScrollPane j2 = new JScrollPane();
		j2.setViewportView(table);

		jp.add(jth, BorderLayout.PAGE_START);
		jp.add(j2, BorderLayout.CENTER);

		return jp;
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}