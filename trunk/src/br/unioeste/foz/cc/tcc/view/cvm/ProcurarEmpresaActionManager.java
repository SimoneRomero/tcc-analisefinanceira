package br.unioeste.foz.cc.tcc.view.cvm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;

public class ProcurarEmpresaActionManager {

	public void buscarEmpresa(String text, DefaultTableModel tbModel) throws SQLException,
			FileNotFoundException, ClassNotFoundException, IOException {

		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();

		int row = 0;
		for (Empresa e : ucManterEmpresa.obterEmpresasListadas(text)) {
			Object[] data = { e.getNome(), e.getCodigoCVM() };
			tbModel.insertRow(row, data);
			row++;
		}

	}

	public void carcelarBusca() {

	}

	public void fechar() {

	}

	public List<Empresa> carregarEmpresas(JTable tableResults)
			throws SQLException, FileNotFoundException, ClassNotFoundException,
			IOException {

		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();
		List<Empresa> empresas = new ArrayList<Empresa>();

		DefaultListSelectionModel selectionModel = (DefaultListSelectionModel) tableResults
				.getSelectionModel();

		for (int i = 0; i < tableResults.getModel().getRowCount(); i++) {
			if (selectionModel.isSelectedIndex(i)) {
				empresas.add(ucManterEmpresa.obterEmpresa(
						(Integer) tableResults.getModel().getValueAt(i, 1),
						true));
			}

		}

		return empresas;

	}
}
