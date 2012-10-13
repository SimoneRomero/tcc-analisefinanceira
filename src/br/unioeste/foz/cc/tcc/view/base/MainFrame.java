package br.unioeste.foz.cc.tcc.view.base;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTree;

import br.unioeste.foz.cc.tcc.view.abas.AbasDemonstracoes;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.barraferramentas.BarraFerramentas;
import br.unioeste.foz.cc.tcc.view.menu.BarraMenu;
import br.unioeste.foz.cc.tcc.view.util.BarraProgresso;
import br.unioeste.foz.cc.tcc.view.util.MonitorBarraProgresso;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {
	JDesktopPane desktop;
	private ArvoreEmpresas arvoreEmpresas;
	private BarraFerramentas barraFerramentas;
	private AbasDemonstracoes abasDemonstracoes;
	private MonitorBarraProgresso monitorProgressBar;

	public MainFrame() {
		super("Sistema de ADF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Make the big window be indented 50 pixels from each edge
		// of the screen.
		int inset = 50;
		setBounds(inset, inset, 819, 668);

		// Set up the GUI.
		desktop = new JDesktopPane(); // a specialized layered pane
		// createFrame(); // create first "window"
		setContentPane(desktop);
		desktop.setLayout(new BorderLayout(0, 0));
		
		BarraProgresso progressBar = new BarraProgresso();
		desktop.add(progressBar, BorderLayout.SOUTH);
		monitorProgressBar = new MonitorBarraProgresso(progressBar);

		JSplitPane splitPane = new JSplitPane();
		desktop.setLayer(splitPane, 0);
		desktop.add(splitPane);

		splitPane.setRightComponent(createTabs());
		splitPane.setOneTouchExpandable(true);

		JScrollPane j2 = new JScrollPane();
		j2.setViewportView(createTree());
		splitPane.setLeftComponent(j2);
		setJMenuBar(createMenuBar());

		// Make dragging a little faster but perhaps uglier.
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		desktop.add(createToolBar(), BorderLayout.NORTH);
		
	}

	protected JTabbedPane createTabs() {
		abasDemonstracoes = new AbasDemonstracoes();
		return abasDemonstracoes;
	}

	protected JToolBar createToolBar() {

		barraFerramentas = new BarraFerramentas(arvoreEmpresas);

		return barraFerramentas;

	}

	protected JMenuBar createMenuBar() {

		return new BarraMenu(arvoreEmpresas, monitorProgressBar);
	}

	protected JTree createTree() {

		arvoreEmpresas = new ArvoreEmpresas(abasDemonstracoes);

		return arvoreEmpresas;
	}

	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		// JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the window.
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.

		createAndShowGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public ArvoreEmpresas getArvoreEmpresas() {
		return arvoreEmpresas;
	}

	public void setArvoreEmpresas(ArvoreEmpresas arvoreEmpresas) {
		this.arvoreEmpresas = arvoreEmpresas;
	}

	public BarraFerramentas getBarraFerramentas() {
		return barraFerramentas;
	}

	public void setBarraFerramentas(BarraFerramentas barraFerramentas) {
		this.barraFerramentas = barraFerramentas;
	}

	public AbasDemonstracoes getAbas() {
		return abasDemonstracoes;
	}

	public void setAbas(AbasDemonstracoes abas) {
		this.abasDemonstracoes = abas;
	}
}