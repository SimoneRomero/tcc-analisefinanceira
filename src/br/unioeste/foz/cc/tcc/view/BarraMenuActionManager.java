package br.unioeste.foz.cc.tcc.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

import br.unioeste.foz.cc.tcc.uc.UCObterInfosCVM;

public class BarraMenuActionManager {
	
	public BarraMenuActionManager(){
		
	}
	
	public void procurar(ArvoreEmpresas arvoreEmpresas) {
		ProcurarEmpresa frame = new ProcurarEmpresa(arvoreEmpresas);
		frame.setVisible(true);
	}
	
	public void listar(ArvoreEmpresas arvoreEmpresas) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		EmpresasListadas frame = new EmpresasListadas(arvoreEmpresas);
		frame.setVisible(true);
	}
	
	public void helper(){
		JFrame helpFrame = new net.sourceforge.helpgui.gui.MainFrame("/docs/help","java");
		helpFrame.setVisible(true);
	}

	public void atualizarEmpresas() throws FailingHttpStatusCodeException, MalformedURLException, ClassNotFoundException, SQLException, IOException, ParseException {
		UCObterInfosCVM ucO = new UCObterInfosCVM();
		ucO.atualizarEmpresas();
		ucO.atualizarListadas();		
	}
	

}
