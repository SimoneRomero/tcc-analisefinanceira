package br.unioeste.foz.cc.tcc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.util.Mensagens;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class ArvoreEmpresasActionManager implements MouseListener,
		ActionListener {

	private ArvoreEmpresas arvoreEmpresas;

	public ArvoreEmpresasActionManager(ArvoreEmpresas arvoreEmpresas) {
		this.arvoreEmpresas = arvoreEmpresas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("remover")) {

			DefaultMutableTreeNode dmtn, node;

			TreePath path = arvoreEmpresas.getSelectionPath();
			dmtn = (DefaultMutableTreeNode) path.getLastPathComponent();

			node = (DefaultMutableTreeNode) dmtn.getParent();
			int nodeIndex = node.getIndex(dmtn); // declare an integer to hold
													// the selected nodes index
			dmtn.removeAllChildren(); // remove any children of selected node
			node.remove(nodeIndex); // remove the selected node, retain its
									// siblings
			((DefaultTreeModel) arvoreEmpresas.getModel())
					.nodeStructureChanged((TreeNode) dmtn);
		}

		if (e.getActionCommand().equals("ordenar")) {
			arvoreEmpresas.sortTree();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			int selRow = arvoreEmpresas.getRowForLocation(e.getX(), e.getY());
			TreePath selPath = arvoreEmpresas.getPathForLocation(e.getX(),
					e.getY());
			if (selRow != -1) {
				if (e.getClickCount() == 1) {
					// mySingleClick(selRow, selPath);
				} else if (e.getClickCount() == 2) {
					if (arvoreEmpresas.getModel().isLeaf(
							selPath.getLastPathComponent())) {
						UCManterEmpresa ucM = new UCManterEmpresa();

						arvoreEmpresas.getAbas().addAba(
								selPath.getLastPathComponent().toString(),
								Integer.valueOf(selPath.getPathComponent(2)
										.toString()),
								ucM.obterEmpresa(selPath.getPathComponent(1)
										.toString()));
					}
				}
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
		} catch (NumberFormatException e1) {
			Mensagens.NumberFormatException();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			arvoreEmpresas.getPopup().show((JComponent) e.getSource(),
					e.getX(), e.getY());
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
