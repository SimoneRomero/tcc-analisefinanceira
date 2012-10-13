package br.unioeste.foz.cc.tcc.view.util;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class SeletorArquivos extends JFileChooser {

	public SeletorArquivos() {
		super();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Arquivos formatados XML (*.xml)", "xml");
		addChoosableFileFilter(filter);
		addChoosableFileFilter(new FileNameExtensionFilter(
				"Arquivos de texto (*.txt)", "txt"));
		addChoosableFileFilter(new FileNameExtensionFilter(
				"Arquivos tabelados (*.csv)", "csv"));
		setAcceptAllFileFilterUsed(false);
		setFileFilter(filter);
	}

	public String getExtension() {
		return getSelectedFile().getName()
				.substring(getSelectedFile().getName().lastIndexOf(".") + 1)
				.toLowerCase();
	}

	public String getExtensionFilterChoose() {
		if (getFileFilter().toString().contains("txt"))
			return "txt";
		else if (getFileFilter().toString().contains("csv"))
			return "csv";
		else
			return "xml";
	}

}
