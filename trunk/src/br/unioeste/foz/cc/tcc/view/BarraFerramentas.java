package br.unioeste.foz.cc.tcc.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class BarraFerramentas extends JToolBar {
	
	public BarraFerramentas(){
		super();
		createMenuBar();
	}
	
	private void createMenuBar(){
		JButton btnProcurarEmpresa = new JButton("Procurar Empresa");
		add(btnProcurarEmpresa);

		JButton btnListaDeEmpresas = new JButton("Empresas Listadas");
		add(btnListaDeEmpresas);

		addSeparator();
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(1, 100));
		add(separator);
		addSeparator();

		JButton btnImportar = new JButton("Importar");
		add(btnImportar);

		JButton btnExportar = new JButton("Exportar");
		add(btnExportar);
		btnExportar.setIcon(null);

		addSeparator();
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setMaximumSize(new Dimension(1, 100));
		add(separator_1);
		addSeparator();

		JButton btnAjuda = new JButton("Ajuda");
		add(btnAjuda);
	}

}
