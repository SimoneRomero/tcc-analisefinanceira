package br.unioeste.foz.cc.tcc.view.util;

import javax.swing.JFrame;

public class Ajuda {

	public static void initFrame(){
		JFrame helpFrame = new net.sourceforge.helpgui.gui.MainFrame("docs/help/","java");
		helpFrame.setVisible(true);
	}
	
}
