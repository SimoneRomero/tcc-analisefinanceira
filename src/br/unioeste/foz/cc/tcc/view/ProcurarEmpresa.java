package br.unioeste.foz.cc.tcc.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ProcurarEmpresa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfBuscarPor;
	private JTable tableResults;
	private JProgressBar progressBar;
	private ProcurarEmpresaActionManager actionManager = new ProcurarEmpresaActionManager();
	private JButton btnCarregar;
	private JButton btnFechar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	private JScrollPane scrollResults;
	private DefaultTableModel tbModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarEmpresa frame = new ProcurarEmpresa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProcurarEmpresa() {
		setTitle("Buscar Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(10, 21, 86, 14);
		contentPane.add(lblBuscarPor);

		tfBuscarPor = new JTextField();
		tfBuscarPor.setBounds(106, 18, 555, 20);
		contentPane.add(tfBuscarPor);
		tfBuscarPor.setColumns(10);

		tbModel = new DefaultTableModel(new Object[][] {}, new String[] {
				"Nome", "Cod. CVM" });
		tableResults = new JTable();
		tableResults
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableResults.setModel(tbModel);
		tableResults.setBounds(344, 57, -333, 260);
		scrollResults = new JScrollPane();
		scrollResults.setSize(441, 372);
		scrollResults.setLocation(10, 42);
		scrollResults.setViewportView(tableResults);
		tableResults.setAutoCreateRowSorter(true);
		contentPane.add(scrollResults);
		contentPane.add(tableResults.getTableHeader());

		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelBuscar.setBounds(461, 49, 200, 80);
		contentPane.add(panelBuscar);
		panelBuscar.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(38, 11, 124, 23);
		btnBuscar.addActionListener(this);
		panelBuscar.add(btnBuscar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(38, 45, 124, 23);
		btnCancelar.addActionListener(this);
		panelBuscar.add(btnCancelar);

		progressBar = new JProgressBar();
		progressBar.setBounds(462, 394, 199, 20);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		contentPane.add(progressBar);

		JPanel panelCarregar = new JPanel();
		panelCarregar.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCarregar.setBounds(461, 140, 200, 80);
		contentPane.add(panelCarregar);
		panelCarregar.setLayout(null);

		btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(38, 11, 124, 23);
		btnCarregar.addActionListener(this);
		panelCarregar.add(btnCarregar);

		JButton btnCarregarTodos = new JButton("Carregar Todos");
		btnCarregarTodos.setBounds(38, 45, 124, 23);
		panelCarregar.add(btnCarregarTodos);

		JPanel panelFechar = new JPanel();
		panelFechar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelFechar.setBounds(461, 231, 200, 80);
		contentPane.add(panelFechar);
		panelFechar.setLayout(null);

		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(38, 28, 124, 23);
		btnFechar.addActionListener(this);
		panelFechar.add(btnFechar);
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

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		try {
			if (source.equals(btnBuscar)) {
				progressBar.setValue(0);
				tbModel.setRowCount(0);
				actionManager.buscarEmpresa(tfBuscarPor.getText(), progressBar,
						tbModel);
			} else if (source.equals(btnCancelar)) {
				dispose();
			} else if (source.equals(btnCarregar)) {
//				mainFrame.addEmpresa(actionManager.carregarEmpresas(tableResults));
			} else if (source.equals(btnFechar)) {
				dispose();
			}
		} catch (Exception exception) {
			// TODO: handle exception
		}

	}
}
