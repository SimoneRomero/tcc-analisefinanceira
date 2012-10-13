package br.unioeste.foz.cc.tcc.view.abas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.unioeste.foz.cc.tcc.model.demonstracao.AtributoValor;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

@SuppressWarnings("serial")
public class TabelaEmpresa extends JTable {

	DefaultTableModel data;

	public TabelaEmpresa() {
		super();
		data = new DefaultTableModel();
		setModel(data);
		setCellSelectionEnabled(true);
		// setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setColumnSelectionAllowed(true);
		setAutoCreateRowSorter(true);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return false; // Disallow the editing of any cell
	}

	public void setEmpresa(Empresa empresa, int ano, String atributos) {

		String[] columnNames = { "Código", "Descrição", String.valueOf(ano),
				String.valueOf(ano - 1), String.valueOf(ano - 2) };
		data.setColumnIdentifiers(columnNames);

		RelatorioAnual raAno = empresa.getRelatorio(ano);
		RelatorioAnual raAno1 = empresa.getRelatorio(ano - 1);
		RelatorioAnual raAno2 = empresa.getRelatorio(ano - 2);

		for (AtributoValor av : raAno.getAtributos(atributos)) {
			String raAno2valor;
			try {
				raAno2valor = raAno2.getValor(av.getAtributo().getCodigo());
			} catch (NullPointerException exc) {
				raAno2valor = "";
			}

			Object[] row = { av.getAtributo().getCodigo(),
					av.getAtributo().getDescricao(), av.getValor(),
					raAno1.getValor(av.getAtributo().getCodigo()), raAno2valor };
			data.addRow(row);
		}

	}

}
