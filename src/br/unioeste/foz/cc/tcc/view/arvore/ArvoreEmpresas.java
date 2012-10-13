package br.unioeste.foz.cc.tcc.view.arvore;

import java.util.Calendar;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import br.unioeste.foz.cc.tcc.controller.ArvoreEmpresasActionManager;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.view.abas.AbasDemonstracoes;

@SuppressWarnings("serial")
public class ArvoreEmpresas extends JTree {

	private ArvoreEmpresasActionManager actionManager;
	private JPopupMenu popup;
	private DefaultTreeModel model;
	private AbasDemonstracoes abas;

	public ArvoreEmpresas(AbasDemonstracoes abas) {
		super();
		model = new DefaultTreeModel(new DefaultMutableTreeNode(
				"Empresas"));
		actionManager = new ArvoreEmpresasActionManager(this);
		setModel(model);
		this.abas = abas;
		addMouseListener(actionManager);

		popup = new JPopupMenu();
		popup.setOpaque(true);
		popup.setLightWeightPopupEnabled(true);

		JMenuItem mr;
		mr = new JMenuItem("Remover");
		mr.addActionListener(actionManager);
		mr.setActionCommand("remover");
		popup.add(mr);

		JMenuItem mo;
		mo = new JMenuItem("Ordenar");
		mo.addActionListener(actionManager);
		mo.setActionCommand("ordenar");
		popup.add(mo);
	}

	public void addEmpresa(List<Empresa> empresas) {

		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

		for (Empresa empresa : empresas) {
			DefaultMutableTreeNode emp = new DefaultMutableTreeNode(
					empresa.getNome());

			model.insertNodeInto(emp, root, root.getChildCount());

			for (RelatorioAnual ra : empresa.getRelatorios()) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(ra.getFinalPeriodo());

				if (calendar.get(Calendar.YEAR) < 2010)
					continue;

				DefaultMutableTreeNode ano = new DefaultMutableTreeNode(
						calendar.get(Calendar.YEAR));
				model.insertNodeInto(ano, emp, emp.getChildCount());

				DefaultMutableTreeNode df = new DefaultMutableTreeNode(
						"Balanço Patrimonial");

				model.insertNodeInto(df, ano, ano.getChildCount());

				model.insertNodeInto(new DefaultMutableTreeNode("Ativo"), df,
						df.getChildCount());
				model.insertNodeInto(new DefaultMutableTreeNode("Passivo"), df,
						df.getChildCount());

				model.insertNodeInto(new DefaultMutableTreeNode(
						"Demonstração de Resultado"), ano, ano.getChildCount());
			}
		}
	}

	public void removeEmpresa(Empresa empresa) {
		((DefaultMutableTreeNode) model.getRoot()).remove(new DefaultMutableTreeNode(empresa.getNome()));
	}

	public void expandirTodos() {
		for (int i = 0; i < getRowCount(); i++) {
			expandRow(i);
		}
	}

	public void recolherTodos() {
		DefaultMutableTreeNode currentNode = ((DefaultMutableTreeNode) model.getRoot()).getNextNode();
		do {
			if (currentNode.getLevel() == 1)
				collapsePath(new TreePath(currentNode.getPath()));
			currentNode = currentNode.getNextNode();
		} while (currentNode != null);
	}

	public void sortTree() {
		model = new DefaultTreeModel(sortTree(((DefaultMutableTreeNode) model.getRoot())));
		((DefaultTreeModel) getModel()).nodeStructureChanged((TreeNode) ((DefaultMutableTreeNode) model.getRoot()));
	}

	/**
	 * @param root
	 *            of tree
	 * @return sorted elements alphabetically
	 */
	private DefaultMutableTreeNode sortTree(DefaultMutableTreeNode root) {
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);
			String nt = node.getUserObject().toString();
			for (int j = 0; j < i; j++) {
				DefaultMutableTreeNode prevNode = (DefaultMutableTreeNode) root
						.getChildAt(j);
				String np = prevNode.getUserObject().toString();
				if (nt.compareToIgnoreCase(np) < 0) {
					root.insert(node, j);
					root.insert(prevNode, i);
				}
			}
			if (node.getChildCount() > 0) {
				node = sortTree(node);
			}
		}
		return root;
	}

	public JPopupMenu getPopup() {
		return popup;
	}

	public void setPopup(JPopupMenu popup) {
		this.popup = popup;
	}

	public AbasDemonstracoes getAbas() {
		return abas;
	}

	public void setAbas(AbasDemonstracoes abas) {
		this.abas = abas;
	}
}
