package br.unioeste.foz.cc.tcc.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.JTableHeader;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class AbasDemonstracoes extends JTabbedPane {

	private TabelaEmpresa tabelaEmpresa;

	public AbasDemonstracoes() {
		super(JTabbedPane.TOP);
	}

	public void addAba(String atributos, int ano, Empresa empresa) {
		addTab(empresa.getNome() + " - " + atributos, null,
				createTable(empresa, ano, atributos), null);
		setTabComponentAt(getTabCount() - 1, new ButtonTabComponent(this));
	}

	private JPanel createTable(Empresa empresa, int ano, String atributos) {

		tabelaEmpresa = new TabelaEmpresa();

		tabelaEmpresa.setEmpresa(empresa, ano, atributos);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JTableHeader jth = tabelaEmpresa.getTableHeader();

		JScrollPane j2 = new JScrollPane();
		j2.setViewportView(tabelaEmpresa);

		jp.add(jth, BorderLayout.PAGE_START);
		jp.add(j2, BorderLayout.CENTER);

		return jp;
	}

}
