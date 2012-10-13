package br.unioeste.foz.cc.tcc.view.util;

import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class BarraProgresso extends JProgressBar {

	public BarraProgresso() {
		super();
	}

	public void setFinish() {
		setStringPainted(false);
		setIndeterminate(false);
	}

	public void setStart() {
		setStringPainted(true);
		setIndeterminate(true);
	}

}
