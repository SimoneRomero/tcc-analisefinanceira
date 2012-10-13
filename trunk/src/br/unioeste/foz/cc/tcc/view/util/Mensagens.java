package br.unioeste.foz.cc.tcc.view.util;

import javax.swing.JOptionPane;

public class Mensagens {

	public static void SQLException() {
		JOptionPane.showMessageDialog(null,
				"Verifique se n�o h� outra inst�ncia dessa aplica��o.",
				"Erro no banco de dados", JOptionPane.ERROR_MESSAGE);
	}

	public static void FileNotFoundException(String message) {
		JOptionPane
				.showMessageDialog(
						null,
						"Verifique se o arquivo existe.",
						"N�o foi poss�vel encontrar o arquivo", JOptionPane.ERROR_MESSAGE);
	}

	public static void ClassNotFoundException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro atrav�s de jhonnymertz@gmail.com.",
						"Erro na extra��o de informa��es da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void FailingHttpStatusCodeException() {
		JOptionPane.showMessageDialog(null,
				"Verifique a conex�o com a internet.",
				"Erro de conex�o com o site da CVM", JOptionPane.ERROR_MESSAGE);
	}

	public static void IOException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Verifique se voc� tem permiss�es para modificar/alterar arquivos.",
						"Erro ao acessar aquivo do banco de dados",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void ParseException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro atrav�s de jhonnymertz@gmail.com.",
						"Erro na extra��o de informa��es da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void ParserConfigurationException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro atrav�s de jhonnymertz@gmail.com.",
						"Erro na extra��o de informa��es da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void SAXException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro atrav�s de jhonnymertz@gmail.com.",
						"Erro na extra��o de informa��es da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void NumberFormatException() {
		JOptionPane
		.showMessageDialog(
				null,
				"Por favor, comunique o desenvolvedor sobre este erro atrav�s de jhonnymertz@gmail.com.",
				"Erro na convers�o de dados",
				JOptionPane.ERROR_MESSAGE);		
	}

	public static void NullPointerException(String message) {
		JOptionPane
		.showMessageDialog(
				null,
				"Arquivo n�o encontrado.",
				"Erro na leitura dos dados",
				JOptionPane.ERROR_MESSAGE);		
	}

}
