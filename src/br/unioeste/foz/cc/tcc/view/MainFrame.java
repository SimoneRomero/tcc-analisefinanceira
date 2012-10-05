package br.unioeste.foz.cc.tcc.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTree;

public class MainFrame extends JFrame implements ActionListener {
	JDesktopPane desktop;
	private ArvoreEmpresas arvoreEmpresas;
	private BarraFerramentas barraFerramentas;
	private Abas abas;

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

		
		splitPane.setRightComponent(createTabs());
		splitPane.setLeftComponent(createTree());
		setJMenuBar(createMenuBar());

		// Make dragging a little faster but perhaps uglier.
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		desktop.add(createToolBar());

	}

	protected JTabbedPane createTabs() {
		abas = new Abas();
		return abas;
	}

	protected JToolBar createToolBar() {

		barraFerramentas = new BarraFerramentas();
		barraFerramentas.setBounds(0, 0, 803, 42);

		return barraFerramentas;

	}

	protected JMenuBar createMenuBar() {

		return new BarraMenu();
	}

	protected JTree createTree() {
		arvoreEmpresas = new ArvoreEmpresas();

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
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}