package br.unioeste.foz.cc.tcc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;

public class ProcurarEmpresaActionManager {

	public void buscarEmpresa(String text, JProgressBar progressBar,
			DefaultTableModel tbModel) throws SQLException {

		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();

		int row = 0;
		for (Empresa e : ucManterEmpresa.obterEmpresasListadas(text)) {
			Object[] data = { e.getNome(), e.getCodigoCVM() };
			tbModel.insertRow(row, data);
			progressBar.setValue(row);

			row++;
		}

	}

	public void carcelarBusca() {

	}

	public void fechar() {

	}

	public List<Empresa> carregarEmpresas(JTable tableResults)
			throws SQLException {

		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();
		List<Empresa> empresas = new ArrayList<Empresa>();

		for (int i = tableResults.getSelectedRow(); i <= (tableResults
				.getSelectedRow() + tableResults.getSelectedRowCount()); i++) {

			empresas.add(ucManterEmpresa.obterEmpresa((Integer) tableResults
					.getModel().getValueAt(i, 2), false));
		}
		return empresas;

	}

}