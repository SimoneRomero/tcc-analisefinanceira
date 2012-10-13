package br.unioeste.foz.cc.tcc.view.barraferramentas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import br.unioeste.foz.cc.tcc.controller.BarraFerramentasActionManager;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;

@SuppressWarnings("serial")
public class BarraFerramentas extends JToolBar{

	private ArvoreEmpresas arvoreEmpresas;
	private BarraFerramentasActionManager actionManager;

	public BarraFerramentas(ArvoreEmpresas arvoreEmpresas) {
		super();
		this.setArvoreEmpresas(arvoreEmpresas);
		this.actionManager = new BarraFerramentasActionManager(this);
		createMenuBar();
	}

	private void createMenuBar() {
		JButton btnProcurarEmpresa = new JButton("Procurar Empresa");
		btnProcurarEmpresa.setActionCommand("procurar");
		btnProcurarEmpresa.addActionListener(actionManager);
		add(btnProcurarEmpresa);

		JButton btnListaDeEmpresas = new JButton("Empresas Listadas");
		btnListaDeEmpresas.setActionCommand("listar");
		btnListaDeEmpresas.addActionListener(actionManager);
		add(btnListaDeEmpresas);

		addSeparator();
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(1, 100));
		add(separator);
		addSeparator();

		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(actionManager);
		btnImportar.setActionCommand("importar");
		add(btnImportar);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(actionManager);
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
		btnAjuda.addActionListener(actionManager);
		btnAjuda.setActionCommand("ajuda");
		add(btnAjuda);
	}

	/**
	 * @return the arvoreEmpresas
	 */
	public ArvoreEmpresas getArvoreEmpresas() {
		return arvoreEmpresas;
	}

	/**
	 * @param arvoreEmpresas the arvoreEmpresas to set
	 */
	public void setArvoreEmpresas(ArvoreEmpresas arvoreEmpresas) {
		this.arvoreEmpresas = arvoreEmpresas;
	}

	
}
