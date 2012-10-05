package br.unioeste.foz.cc.tcc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ProcurarEmpresa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfBuscarPor;
	private JTable tableResults;
	private ProcurarEmpresaActionManager actionManager = new ProcurarEmpresaActionManager();
	private JButton btnCarregar;
	private JButton btnFechar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	private JScrollPane scrollResults;
	private DefaultTableModel tbModel;
	private ArvoreEmpresas arvoreEmpresas;

	/**
	 * Create the frame.
	 * 
	 * @param arvoreEmpresas
	 */
	public ProcurarEmpresa(ArvoreEmpresas arvoreEmpresas) {
		this.arvoreEmpresas = arvoreEmpresas;
		setTitle("Procurar Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tbModel = new DefaultTableModel(new Object[][] {}, new String[] {
				"Nome", "Cod. CVM" });
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

		JPanel panelOptions = new JPanel();
		contentPane.add(panelOptions, BorderLayout.SOUTH);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		panelOptions.setLayout(new GridLayout(0, 4, 20, 0));
		panelOptions.add(btnBuscar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		panelOptions.add(btnCancelar);

		btnCarregar = new JButton("Carregar");
		panelOptions.add(btnCarregar);

		btnFechar = new JButton("Fechar");
		panelOptions.add(btnFechar);

		JPanel panelInput = new JPanel();
		contentPane.add(panelInput, BorderLayout.NORTH);
		panelInput.setLayout(new BorderLayout(20, 0));

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		panelInput.add(lblBuscarPor, BorderLayout.WEST);

		tfBuscarPor = new JTextField();
		panelInput.add(tfBuscarPor);
		tfBuscarPor.setColumns(10);
		btnFechar.addActionListener(this);
		btnCarregar.addActionListener(this);
	}

	public JTextField getTfBuscarPor() {
		return tfBuscarPor;
	}

	public void setTfBuscarPor(JTextField tfBuscarPor) {
		this.tfBuscarPor = tfBuscarPor;
	}

	public JTable getTableResults() {
		return tableResults;
	}

	public void setTableResults(JTable tableResults) {
		this.tableResults = tableResults;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		try {
			if (source.equals(btnBuscar)) {
				tbModel.setRowCount(0);
				actionManager.buscarEmpresa(tfBuscarPor.getText(), tbModel);
			} else if (source.equals(btnCancelar)) {
				dispose();
			} else if (source.equals(btnCarregar)) {
				arvoreEmpresas.addEmpresa(actionManager
						.carregarEmpresas(tableResults));
				arvoreEmpresas.expandirTodos();
			} else if (source.equals(btnFechar)) {
				dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
