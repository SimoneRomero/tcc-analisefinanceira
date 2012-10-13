package br.unioeste.foz.cc.tcc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.h2.jdbc.JdbcSQLException;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.uc.UCImportar;
import br.unioeste.foz.cc.tcc.uc.UCManterEmpresa;
import br.unioeste.foz.cc.tcc.uc.UCObterInfosCVM;
import br.unioeste.foz.cc.tcc.view.arvore.ArvoreEmpresas;
import br.unioeste.foz.cc.tcc.view.cvm.EmpresasListadas;
import br.unioeste.foz.cc.tcc.view.cvm.EscolhaEmpresas;
import br.unioeste.foz.cc.tcc.view.cvm.ProcurarEmpresa;
import br.unioeste.foz.cc.tcc.view.menu.BarraMenu;
import br.unioeste.foz.cc.tcc.view.util.Ajuda;
import br.unioeste.foz.cc.tcc.view.util.Mensagens;
import br.unioeste.foz.cc.tcc.view.util.SeletorArquivos;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class BarraMenuActionManager implements ActionListener {

	private BarraMenu barraMenu;

	public BarraMenuActionManager(BarraMenu barraMenu) {
		this.barraMenu = barraMenu;
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

	public void atualizarEmpresas() throws FailingHttpStatusCodeException,
			MalformedURLException, ClassNotFoundException, SQLException,
			IOException, ParseException {
		UCObterInfosCVM ucO = new UCObterInfosCVM();
		try {
			ucO.atualizarEmpresas();
		} catch (JdbcSQLException ex) {
		}
		ucO.atualizarListadas();
	}

	public void sobre() {
		ImageIcon a = new ImageIcon("docs/imagens/logo.jpg");
		JOptionPane
				.showMessageDialog(
						null,
						"Sistema Computacional para An�lise de Demonstra��es Financeiras \n\n      Trabalho de Conclus�o de Curso - Ci�ncia da Computa��o - 2012\n      Universidade Estadual do Oeste do Paran� - UNIOESTE\n         Campus de Foz do Igua�u\n         Centro de Engenharia e Ci�ncias Exatas - CECE\n\n   Desenvolvedores:\n      Jhonny Marcos Acordi Mertz\n\n   Vers�o Atual: 1.0\n\n   Mais Informa��es: code.google.com/p/tcc-analisefinanceira/",
						"Sobre", 0, a);

	}

	private void importar(ArvoreEmpresas arvoreEmpresas)
			throws ClassNotFoundException, SQLException, IOException {

		SeletorArquivos selector = new SeletorArquivos();
		if (selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			UCImportar ucI = new UCImportar();

			List<Empresa> empresas = ucI.importarEmpresas(selector
					.getSelectedFile().getPath(), selector.getExtension());

			UCManterEmpresa ucManterEmpresa = new UCManterEmpresa();

			for (Empresa e : empresas) {
				ucManterEmpresa.inserir(e);
			}

			arvoreEmpresas.addEmpresa(empresas);

			JOptionPane.showMessageDialog(null,
					"Importa��o realizada com sucesso!", "Importa��o",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("ordenar por razao")) {
				barraMenu.getArvoreEmpresas().sortTree();
			} else if (e.getActionCommand().equals("procurar")) {
				
				procurar(barraMenu.getArvoreEmpresas());
				
			} else if (e.getActionCommand().equals("listar")) {
//				barraMenu.getMonitorProgressBar().start();
				System.out.println("asdas");
				listar(barraMenu.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("expandir")) {
				
				barraMenu.getArvoreEmpresas().expandirTodos();
				
			} else if (e.getActionCommand().equals("recolher")) {
				
				barraMenu.getArvoreEmpresas().recolherTodos();
				
			} else if (e.getActionCommand().equals("help")) {
				Ajuda.initFrame();
			} else if (e.getActionCommand().equals("sobre")) {
				sobre();
			} else if (e.getActionCommand().equals("atualizar empresas")) {
				
				atualizarEmpresas();
				
			} else if (e.getActionCommand().equals("analisar giros")) {
				EscolhaEmpresas frame = new EscolhaEmpresas(
						barraMenu.getArvoreEmpresas(), "analisar giros");
				frame.setVisible(true);
			} else if (e.getActionCommand().equals("prazo compra")) {
				EscolhaEmpresas frame = new EscolhaEmpresas(
						barraMenu.getArvoreEmpresas(), "prazo compra");
				frame.setVisible(true);
			} else if (e.getActionCommand().equals("prazo estoque")) {
				EscolhaEmpresas frame = new EscolhaEmpresas(
						barraMenu.getArvoreEmpresas(), "prazo estoque");
				frame.setVisible(true);
			} else if (e.getActionCommand().equals("prazo venda")) {
				EscolhaEmpresas frame = new EscolhaEmpresas(
						barraMenu.getArvoreEmpresas(), "prazo venda");
				frame.setVisible(true);
			} else if (e.getActionCommand().equals("exportar")) {
				EscolhaEmpresas frame = new EscolhaEmpresas(
						barraMenu.getArvoreEmpresas(), "exportar");
				frame.setVisible(true);
			} else if (e.getActionCommand().equals("importar")) {
				importar(barraMenu.getArvoreEmpresas());
			} else if (e.getActionCommand().equals("sair")) {
				System.exit(0);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
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
		}

	}

}
