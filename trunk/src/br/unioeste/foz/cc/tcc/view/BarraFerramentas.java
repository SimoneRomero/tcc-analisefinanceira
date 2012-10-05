package br.unioeste.foz.cc.tcc.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class BarraFerramentas extends JToolBar implements ActionListener {

	private MainFrame mainFrame;
	private BarraFerramentasActionManager actionManager;

	public BarraFerramentas(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.actionManager = new BarraFerramentasActionManager();
		createMenuBar();
	}

	private void createMenuBar() {
		JButton btnProcurarEmpresa = new JButton("Procurar Empresa");
		btnProcurarEmpresa.setActionCommand("procurar");
		btnProcurarEmpresa.addActionListener(this);
		add(btnProcurarEmpresa);

		JButton btnListaDeEmpresas = new JButton("Empresas Listadas");
		btnListaDeEmpresas.setActionCommand("listar");
		btnListaDeEmpresas.addActionListener(this);
		add(btnListaDeEmpresas);

		addSeparator();
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(1, 100));
		add(separator);
		addSeparator();

		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(this);
		btnImportar.setActionCommand("importar");
		add(btnImportar);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		btnExportar.setActionCommand("exportar");
		add(btnExportar);
		btnExportar.setIcon(null);

		addSeparator();
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setMaximumSize(new Dimension(1, 100));
		add(separator_1);
		addSeparator();

		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.addActionListener(this);
		btnAjuda.setActionCommand("ajuda");
		add(btnAjuda);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("procurar")) {
				actionManager.procurar(mainFrame.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("listar")) {
				actionManager.listar(mainFrame.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("importar")) {

			} else if (e.getActionCommand().equals("exportar")) {

			} else if (e.getActionCommand().equals("ajuda")) {

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
