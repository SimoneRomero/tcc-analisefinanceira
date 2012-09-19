package br.unioeste.foz.cc.tcc.comunicacao;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import br.unioeste.foz.cc.tcc.dao.EmpresaDAO;
import br.unioeste.foz.cc.tcc.empresa.Empresa;
import br.unioeste.foz.cc.tcc.empresa.Registro;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.thoughtworks.xstream.XStream;

public class ExportarXML extends ExportarFactory {

	private void exportar(Empresa empresa, String nomeArquivo)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setNamespaceAware(false);

		DocumentBuilder docBuilder = dbf.newDocumentBuilder();

		Document doc = docBuilder.parse(new File(nomeArquivo));

		Element e = doc.createElement("empresas");

		XMLSerializer serializer = new XMLSerializer(System.out, new

		OutputFormat(doc, "iso-8859-1", true));

		serializer.serialize(doc);
	}

	@Override
	public void exportar(List<Empresa> empresas, String nomeArquivo)
			throws ParserConfigurationException, SAXException, IOException {
		for (Empresa e : empresas) {
			exportar(e, nomeArquivo);
		}
	}

	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException, SQLException,
			ParserConfigurationException, SAXException {
		// ExtracaoCVMWeb ec = new ExtracaoCVMWeb(new ClienteWeb(), new
		// ParserCVMWeb());
		EmpresaDAO ep = new EmpresaDAO();

		// ExportarFactory ef = ExportarFactory.getInstance("xml");
		// ef.exportar(ep.obterTodos(), "abc.xml");

		// cria objeto Pessoa, setando o valor para seus atributos
		Empresa e = ep.obter(9512, true);

		// cria objeto XStream
		XStream x = new XStream();
		// indica qual o nome do nó principal
		x.alias("empresa", Empresa.class);

		x.alias("registro", Registro.class);

		// indica qual o nome do nó endereco
		// imprime o XML gerado a partir do objeto Pessoa
		System.out.println(x.toXML(e));
	}

}
