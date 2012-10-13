package br.unioeste.foz.cc.tcc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCImportar;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.barraferramentas.BarraFerramentas;
import br.unioeste.foz.cc.tcc.view.cvm.EmpresasListadas;
import br.unioeste.foz.cc.tcc.view.cvm.EscolhaEmpresas;
import br.unioeste.foz.cc.tcc.view.cvm.ProcurarEmpresa;
import br.unioeste.foz.cc.tcc.view.util.Ajuda;
import br.unioeste.foz.cc.tcc.view.util.Mensagens;
import br.unioeste.foz.cc.tcc.view.util.SeletorArquivos;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class BarraFerramentasActionManager implements ActionListener {

	private BarraFerramentas barraFerramentas;

	public BarraFerramentasActionManager(BarraFerramentas barraFerramentas) {
		this.barraFerramentas = barraFerramentas;
	}

	public void procurar(ArvoreEmpresas arvoreEmpresas) {
		ProcurarEmpresa frame = new ProcurarEmpresa(arvoreEmpresas);
		frame.setVisible(true);
	}

	public void listar(ArvoreEmpresas arvoreEmpresas)
			throws FileNotFoundException, ClassNotFoundException, SQLException,
			IOException {
		EmpresasListadas frame = new EmpresasListadas(arvoreEmpresas);
		frame.setVisible(true);
	}
	
	private void importar(ArvoreEmpresas arvoreEmpresas) throws ClassNotFoundException, SQLException, IOException {

		SeletorArquivos selector = new SeletorArquivos();
		if (selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			UCImportar ucI = new UCImportar();

			List<Empresa> empresas = ucI.importarEmpresas(selector
					.getSelectedFile().getPath(), selector.getExtension());

			UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();
			
			for(Empresa e : empresas){
				ucManterEmpresa.inserir(e);
			}

			arvoreEmpresas.addEmpresa(empresas);
			
			JOptionPane.showMessageDialog(null,
					"Importação realizada com sucesso!", "Importação",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("procurar")) {
				procurar(barraFerramentas.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("listar")) {
				listar(barraFerramentas.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("importar")) {
				importar(barraFerramentas.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("exportar")) {
				EscolhaEmpresas frame = new EscolhaEmpresas(
						barraFerramentas.getArvoreEmpresas(), "exportar");
				frame.setVisible(true);
			} else if (e.getActionCommand().equals("ajuda")) {
				Ajuda.initFrame();
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
		} catch (NullPointerException e1){
			Mensagens.NullPointerException(e1.getMessage());
		}

	}

}
