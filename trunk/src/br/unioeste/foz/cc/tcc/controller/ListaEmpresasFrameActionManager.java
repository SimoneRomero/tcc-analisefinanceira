package br.unioeste.foz.cc.tcc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.ParserConfigurationException;

import org.jfree.ui.RefineryUtilities;
import org.xml.sax.SAXException;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCAnalisarDemonstrativos;
import br.unioeste.foz.cc.tcc.uc.UCExportar;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;
import br.unioeste.foz.cc.tcc.uc.UCObterInfosCVM;
import br.unioeste.foz.cc.tcc.view.base.ListaEmpresasFrame;
import br.unioeste.foz.cc.tcc.view.graficos.GraficoBarras;
import br.unioeste.foz.cc.tcc.view.util.Mensagens;
import br.unioeste.foz.cc.tcc.view.util.SeletorArquivos;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class ListaEmpresasFrameActionManager implements ActionListener {

	private ListaEmpresasFrame procurarEmpresaFrame;

	public ListaEmpresasFrameActionManager(ListaEmpresasFrame pr) {
		this.procurarEmpresaFrame = pr;
	}

	public void buscarEmpresa(String text, DefaultTableModel tbModel)
			throws SQLException, FileNotFoundException, ClassNotFoundException,
			IOException {

		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();

		int row = 0;
		for (Empresa e : ucManterEmpresa.obterEmpresasListadas(text)) {
			Object[] data = { e.getNome(), e.getCodigoCVM() };
			tbModel.insertRow(row, data);
			row++;
		}

	}

	private List<Empresa> obterEmpresas(JTable tableResults)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();
		List<Empresa> empresas = new ArrayList<Empresa>();

		DefaultListSelectionModel selectionModel = (DefaultListSelectionModel) tableResults
				.getSelectionModel();

		for (int i = 0; i < tableResults.getModel().getRowCount(); i++) {
			if (selectionModel.isSelectedIndex(i)) {
				try {
					empresas.add(ucManterEmpresa.obterEmpresa(
							(Integer) tableResults.getModel().getValueAt(
									tableResults.convertRowIndexToModel(i), 1),
							true));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return empresas;
	}

	public List<Empresa> carregarEmpresas(JTable tableResults)
			throws FileNotFoundException, ClassNotFoundException, IOException,
			SQLException, FailingHttpStatusCodeException, ParseException {

		UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();
		List<Empresa> empresas = new ArrayList<Empresa>();
		HashBackMap<Integer, String> listadas = new HashBackMap<Integer, String>();

		DefaultListSelectionModel selectionModel = (DefaultListSelectionModel) tableResults
				.getSelectionModel();

		for (int i = 0; i < tableResults.getModel().getRowCount(); i++) {
			if (selectionModel.isSelectedIndex(i)) {
				try {
					empresas.add(ucManterEmpresa.obterEmpresa(
							(Integer) tableResults.getModel().getValueAt(
									tableResults.convertRowIndexToModel(i), 1),
							true));
				} catch (SQLException e) {
					listadas.put(
							(Integer) tableResults.getModel().getValueAt(
									tableResults.convertRowIndexToModel(i), 1),
							(String) tableResults.getModel().getValueAt(
									tableResults.convertRowIndexToModel(i), 0));
				}
			}

		}

		if (!listadas.isEmpty()) {
			UCObterInfosCVM ucO = new UCObterInfosCVM();
			for (String s : listadas.values()) {
				if (JOptionPane.OK_OPTION == JOptionPane
						.showConfirmDialog(
								null,
								"A empresa "
										+ s
										+ " não consta na base de dados.\n Deseja baixar informações de "
										+ s + "?")) {
					Empresa empresa = ucO.obterEmpresa((Integer) listadas
							.getKeyByValue(s));
					ucManterEmpresa.inserir(empresa);
					empresas.add(empresa);
				}
			}
		}

		return empresas;

	}

	private void exportar(JTable tableResults) throws FileNotFoundException,
			ClassNotFoundException, IOException, SQLException,
			FailingHttpStatusCodeException, ParseException,
			ParserConfigurationException, SAXException {

		SeletorArquivos selector = new SeletorArquivos();
		String filename;
		if (selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			if (selector.getSelectedFile().exists()) {
				if (JOptionPane.showConfirmDialog(null,
						"O arquivo já existe. Deseja sobrescrever?") == JOptionPane.OK_OPTION) {
					filename = selector.getSelectedFile().getPath();
				} else
					return;
			} else
				filename = selector.getSelectedFile().getPath() + "."
						+ selector.getExtensionFilterChoose();

			List<Empresa> empresas = obterEmpresas(tableResults);

			UCExportar ucE = new UCExportar();
			ucE.exportar(empresas, filename,
					selector.getExtensionFilterChoose());

			JOptionPane.showMessageDialog(null,
					"Exportação realizada com sucesso!", "Exportação",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void analisar(JTable tableResults, String indicador, String eixoX,
			String eixoY) throws FileNotFoundException, ClassNotFoundException,
			IOException {

		List<Empresa> empresas = obterEmpresas(tableResults);

		GraficoBarras gb = new GraficoBarras("Análise de " + indicador,
				indicador, eixoX, eixoY);

		UCAnalisarDemonstrativos ucA = new UCAnalisarDemonstrativos();

		for (Empresa e : empresas) {
			gb.addEmpresa(e, ucA.calcular(indicador, e));
		}

		gb.pack();
		RefineryUtilities.centerFrameOnScreen(gb);
		gb.setVisible(true);

	}

	public void buscarEmpresasArvore(Object raiz, DefaultTableModel tbModel)
			throws FileNotFoundException, ClassNotFoundException, SQLException,
			IOException {
		DefaultMutableTreeNode currentNode = ((DefaultMutableTreeNode) raiz)
				.getNextNode();

		try {
			UCManterEmpresa ucM = new UCManterEmpresa();
			int row = 0;
			do {
				if (currentNode.getLevel() == 1) {
					Empresa e = ucM.obterEmpresa(currentNode.toString());
					Object[] data = { e.getNome(), e.getCodigoCVM() };
					tbModel.insertRow(row, data);
					row++;
				}

				currentNode = currentNode.getNextNode();
			} while (currentNode != null);
		} catch (NullPointerException e) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("buscar")) {
				procurarEmpresaFrame.getTbModel().setRowCount(0);
				buscarEmpresa(procurarEmpresaFrame.getTfBuscarPor().getText(),
						procurarEmpresaFrame.getTbModel());
			} else if (e.getActionCommand().equals("cancelar")) {
				procurarEmpresaFrame.dispose();
			} else if (e.getActionCommand().equals("carregar")) {
				procurarEmpresaFrame.getArvoreEmpresas()
						.addEmpresa(
								carregarEmpresas(procurarEmpresaFrame
										.getTableResults()));
				JOptionPane
						.showMessageDialog(
								null,
								"Empresas carregadas! \nAcesse-as pela árvore de empresas.",
								"Procurar Empresas.",
								JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getActionCommand().equals("fechar")) {
				procurarEmpresaFrame.dispose();
			} else if (e.getActionCommand().equals("exportar")) {
				exportar(procurarEmpresaFrame.getTableResults());
			} else if (e.getActionCommand().equals("prazo compra")) {
				analisar(procurarEmpresaFrame.getTableResults(), "PMPC",
						"Período", "Dias");
			} else if (e.getActionCommand().equals("prazo estoque")) {
				analisar(procurarEmpresaFrame.getTableResults(), "PMRE",
						"Período", "Dias");
			} else if (e.getActionCommand().equals("prazo venda")) {
				analisar(procurarEmpresaFrame.getTableResults(), "PMRV",
						"Período", "Dias");
			} else if (e.getActionCommand().equals("analisar giros")) {
				analisar(procurarEmpresaFrame.getTableResults(), "NCG",
						"Período", "Reais");
			}
		} catch (SQLException ex) {
			Mensagens.SQLException();
		} catch (FileNotFoundException e1) {
			Mensagens.FileNotFoundException(e1.toString());
		} catch (ClassNotFoundException e1) {
			Mensagens.ClassNotFoundException();
		} catch (FailingHttpStatusCodeException e1) {
			Mensagens.FailingHttpStatusCodeException();
		} catch (IOException e1) {
			Mensagens.IOException();
		} catch (ParseException e1) {
			Mensagens.ParseException();
		} catch (ParserConfigurationException e1) {
			Mensagens.ParserConfigurationException();
		} catch (SAXException e1) {
			Mensagens.SAXException();
		}
	}
}
