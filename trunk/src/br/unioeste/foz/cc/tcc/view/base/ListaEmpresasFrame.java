package br.unioeste.foz.cc.tcc.view.base;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.unioeste.foz.cc.tcc.controller.ListaEmpresasFrameActionManager;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;

@SuppressWarnings("serial")
public abstract class ListaEmpresasFrame extends JFrame {

	protected JPanel contentPane;
	protected JTable tableResults;
	protected ListaEmpresasFrameActionManager actionManager;
	protected JButton btnCarregar;
	protected JButton btnFechar;
	protected JScrollPane scrollResults;
	protected DefaultTableModel tbModel;
	protected ArvoreEmpresas arvoreEmpresas;
	protected JTextField tfBuscarPor;
	protected JButton btnBuscar;
	protected JButton btnCancelar;

	public JTable getTableResults() {
		return tableResults;
	}

	public void setTableResults(JTable tableResults) {
		this.tableResults = tableResults;
	}

	public JTextField getTfBuscarPor() {
		return tfBuscarPor;
	}

	public void setTfBuscarPor(JTextField tfBuscarPor) {
		this.tfBuscarPor = tfBuscarPor;
	}

	public ArvoreEmpresas getArvoreEmpresas() {
		return arvoreEmpresas;
	}

	public void setArvoreEmpresas(ArvoreEmpresas arvoreEmpresas) {
		this.arvoreEmpresas = arvoreEmpresas;
	}

	public DefaultTableModel getTbModel() {
		return tbModel;
	}

	public void setTbModel(DefaultTableModel tbModel) {
		this.tbModel = tbModel;
	}
}
