package br.unioeste.foz.cc.tcc.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JCheckBox chckbxCdigoCvm;
	private JCheckBox chckbxNomeDaEmpresa;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(10, 21, 86, 14);
		contentPane.add(lblBuscarPor);

		tfBuscarPor = new JTextField();
		tfBuscarPor.setBounds(106, 18, 450, 20);
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
		scrollResults.setSize(337, 275);
		scrollResults.setLocation(10, 42);
		scrollResults.setViewportView(tableResults);
		tableResults.setAutoCreateRowSorter(true);
		contentPane.add(scrollResults);
		contentPane.add(tableResults.getTableHeader());

		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setBorder(new TitledBorder(null, "Op\u00E7\u00F5es",
				TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panelOpcoes.setBounds(357, 49, 199, 113);
		contentPane.add(panelOpcoes);
		panelOpcoes.setLayout(null);

		JLabel lblIncluir = new JLabel("Incluir:");
		lblIncluir.setBounds(10, 11, 71, 14);
		panelOpcoes.add(lblIncluir);

		chckbxNomeDaEmpresa = new JCheckBox("Nome da Empresa");
		chckbxNomeDaEmpresa.setBounds(46, 32, 147, 23);
		panelOpcoes.add(chckbxNomeDaEmpresa);
		chckbxNomeDaEmpresa.setSelected(true);

		chckbxCdigoCvm = new JCheckBox("C\u00F3digo CVM");
		chckbxCdigoCvm.setBounds(46, 58, 147, 23);
		panelOpcoes.add(chckbxCdigoCvm);

		JPanel panelAcoes = new JPanel();
		panelAcoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es",
				TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panelAcoes.setBounds(357, 166, 200, 120);
		contentPane.add(panelAcoes);
		panelAcoes.setLayout(null);

		btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(10, 22, 89, 23);
		btnBuscar.addActionListener(this);
		panelAcoes.add(btnBuscar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(101, 22, 89, 23);
		panelAcoes.add(btnCancelar);

		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(10, 90, 89, 23);
		panelAcoes.add(btnFechar);

		btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(10, 56, 89, 23);
		panelAcoes.add(btnCarregar);

		progressBar = new JProgressBar();
		progressBar.setBounds(357, 297, 199, 20);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		contentPane.add(progressBar);
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

	public JCheckBox getChckbxCdigoCvm() {
		return chckbxCdigoCvm;
	}

	public void setChckbxCdigoCvm(JCheckBox chckbxCdigoCvm) {
		this.chckbxCdigoCvm = chckbxCdigoCvm;
	}

	public JCheckBox getChckbxNomeDaEmpresa() {
		return chckbxNomeDaEmpresa;
	}

	public void setChckbxNomeDaEmpresa(JCheckBox chckbxNomeDaEmpresa) {
		this.chckbxNomeDaEmpresa = chckbxNomeDaEmpresa;
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
				actionManager.buscarEmpresa(
						tfBuscarPor.getText(),
						chckbxNomeDaEmpresa.isSelected(),
						chckbxCdigoCvm.isSelected(), progressBar, tbModel);
			} else if (source.equals(btnCancelar)) {

			} else if (source.equals(btnCarregar)) {

			} else if (source.equals(btnFechar)) {

			}
		} catch (Exception exception) {
			// TODO: handle exception
		}

	}
}
