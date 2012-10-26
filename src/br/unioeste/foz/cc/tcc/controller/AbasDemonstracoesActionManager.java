package br.unioeste.foz.cc.tcc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import br.unioeste.foz.cc.tcc.view.abas.AbasDemonstracoes;

public class AbasDemonstracoesActionManager implements MouseListener,
		ActionListener {

	private AbasDemonstracoes abasDemonstracoes;

	public AbasDemonstracoesActionManager(AbasDemonstracoes abasDemonstracoes) {
		this.abasDemonstracoes = abasDemonstracoes;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (e.getModifiers()) {
		case InputEvent.BUTTON1_MASK: {
			// System.out.println("That's the LEFT button");
			break;
		}
		case InputEvent.BUTTON2_MASK: {
			// System.out.println("That's the MIDDLE button");
			int i = abasDemonstracoes.getSelectedIndex();
			if (i != -1) {
				abasDemonstracoes.remove(i);
			}

			break;
		}
		case InputEvent.BUTTON3_MASK: {
			// System.out.println("That's the RIGHT button");
			break;
		}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			abasDemonstracoes.getPopup().show((JComponent) e.getSource(),
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("fechar")) {
			int i = abasDemonstracoes.getSelectedIndex();
			if (i != -1) {
				abasDemonstracoes.remove(i);
			}
		}else if(e.getActionCommand().equals("fechar todos")){
			for(int i = 0; i < abasDemonstracoes.getTabCount(); i++)
				abasDemonstracoes.remove(i);
		}
	}

}
