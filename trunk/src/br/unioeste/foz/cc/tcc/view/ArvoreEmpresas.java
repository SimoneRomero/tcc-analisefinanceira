package br.unioeste.foz.cc.tcc.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;

public class ArvoreEmpresas extends JTree implements MouseListener{

	protected DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(
			"Empresas");

	protected DefaultTreeModel model = new DefaultTreeModel(raiz);

	protected AbasDemonstracoes abas;

	public ArvoreEmpresas(AbasDemonstracoes abas) {
		super();
		setModel(model);
		this.abas = abas;
		addMouseListener(this);
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
		raiz.remove(new DefaultMutableTreeNode(empresa.getNome()));
	}

	public void expandirTodos() {
		for (int i = 0; i < getRowCount(); i++) {
			expandRow(i);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int selRow = getRowForLocation(e.getX(), e.getY());
		TreePath selPath = getPathForLocation(e.getX(), e.getY());
		if (selRow != -1) {
			if (e.getClickCount() == 1) {
				// mySingleClick(selRow, selPath);
			} else if (e.getClickCount() == 2) {
				if (getModel().isLeaf(selPath.getLastPathComponent())) {
					UCManterEmpresa ucM = new UCManterEmpresa();
					try {
						this.abas.addAba(selPath.getLastPathComponent()
								.toString(), Integer.valueOf(selPath
								.getPathComponent(2).toString()), ucM
								.obterEmpresa(selPath.getPathComponent(1)
										.toString()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param root of tree
	 * @return sorted elements alphabetically
	 */
	public static DefaultMutableTreeNode sortTree(DefaultMutableTreeNode root) {
		for (int i = 0; i < root.getChildCount(); i++) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) root
					.getChildAt(i);
			String nt = node.getUserObject().toString();
			for (int j=0; j<i; j++) {
				DefaultMutableTreeNode prevNode = (DefaultMutableTreeNode) root
				.getChildAt(j);
				String np = prevNode.getUserObject().toString();
				if (nt.compareToIgnoreCase(np)<0) {
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

}
