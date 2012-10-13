package br.unioeste.foz.cc.tcc.view.util;

import javax.swing.JOptionPane;

public class Mensagens {

	public static void SQLException() {
		JOptionPane.showMessageDialog(null,
				"Verifique se não há outra instância dessa aplicação.",
				"Erro no banco de dados", JOptionPane.ERROR_MESSAGE);
	}

	public static void FileNotFoundException(String message) {
		JOptionPane
				.showMessageDialog(
						null,
						"Verifique se o arquivo existe.",
						"Não foi possível encontrar o arquivo", JOptionPane.ERROR_MESSAGE);
	}

	public static void ClassNotFoundException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro através de jhonnymertz@gmail.com.",
						"Erro na extração de informações da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void FailingHttpStatusCodeException() {
		JOptionPane.showMessageDialog(null,
				"Verifique a conexão com a internet.",
				"Erro de conexão com o site da CVM", JOptionPane.ERROR_MESSAGE);
	}

	public static void IOException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Verifique se você tem permissões para modificar/alterar arquivos.",
						"Erro ao acessar aquivo do banco de dados",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void ParseException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro através de jhonnymertz@gmail.com.",
						"Erro na extração de informações da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void ParserConfigurationException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro através de jhonnymertz@gmail.com.",
						"Erro na extração de informações da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void SAXException() {
		JOptionPane
				.showMessageDialog(
						null,
						"Por favor, comunique o desenvolvedor sobre este erro através de jhonnymertz@gmail.com.",
						"Erro na extração de informações da CVM",
						JOptionPane.ERROR_MESSAGE);
	}

	public static void NumberFormatException() {
		JOptionPane
		.showMessageDialog(
				null,
				"Por favor, comunique o desenvolvedor sobre este erro através de jhonnymertz@gmail.com.",
				"Erro na conversão de dados",
				JOptionPane.ERROR_MESSAGE);		
	}

	public static void NullPointerException(String message) {
		JOptionPane
		.showMessageDialog(
				null,
				"Arquivo não encontrado.",
				"Erro na leitura dos dados",
				JOptionPane.ERROR_MESSAGE);		
	}

}
