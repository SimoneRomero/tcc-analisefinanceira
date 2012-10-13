package br.unioeste.foz.cc.tcc.view.cvm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.unioeste.foz.cc.tcc.controller.ListaEmpresasFrameActionManager;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.base.ListaEmpresasFrame;

@SuppressWarnings("serial")
public class EscolhaEmpresas extends ListaEmpresasFrame {

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public EscolhaEmpresas(ArvoreEmpresas arvoreEmpresas, String option)
			throws FileNotFoundException, ClassNotFoundException, SQLException,
			IOException {
		this.arvoreEmpresas = arvoreEmpresas;
		actionManager = new ListaEmpresasFrameActionManager(this);
		setTitle("Empresa Listadas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tbModel = new DefaultTableModel(new Object[][] {}, new String[] {
				"Nome", "Cod. CVM" });
		tbModel.setRowCount(0);
		actionManager.buscarEmpresasArvore(arvoreEmpresas.getModel().getRoot(), tbModel);
		contentPane.setLayout(new BorderLayout(0, 0));
		tableResults = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Disallow the editing of any cell
			}
		};
		tableResults
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableResults.setModel(tbModel);
		scrollResults = new JScrollPane();
		scrollResults.setViewportView(tableResults);
		tableResults.setAutoCreateRowSorter(true);
		contentPane.add(scrollResults, BorderLayout.CENTER);
		contentPane.add(tableResults.getTableHeader(), BorderLayout.PAGE_START);

		JPanel panelCarregar = new JPanel();
		panelCarregar.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelCarregar, BorderLayout.SOUTH);

		btnCarregar = new JButton("Ir");
		btnCarregar.addActionListener(actionManager);
		panelCarregar.setLayout(new GridLayout(0, 2, 20, 0));
		panelCarregar.add(btnCarregar);
		btnCarregar.setActionCommand(option);

		btnFechar = new JButton("Fechar");
		panelCarregar.add(btnFechar);
		btnFechar.addActionListener(actionManager);
		btnFechar.setActionCommand("fechar");

	}

}
