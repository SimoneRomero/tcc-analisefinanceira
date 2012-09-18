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

import br.unioeste.foz.cc.tcc.aquisicaocvm.ExtracaoCVMWeb;
import br.unioeste.foz.cc.tcc.aquisicaocvm.ParserCVMWeb;
import br.unioeste.foz.cc.tcc.aquisicaoweb.ClienteWeb;
import br.unioeste.foz.cc.tcc.dao.EmpresaDAO;
import br.unioeste.foz.cc.tcc.empresa.Empresa;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class ExportarXML extends ExportarFactory {


	private void exportar(Empresa empresa, String nomeArquivo) throws ParserConfigurationException, SAXException, IOException{
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
	public void exportar(List<Empresa> empresas, String nomeArquivo) throws ParserConfigurationException, SAXException, IOException {
		for(Empresa e : empresas){
			exportar(e, nomeArquivo);
		}
	}

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException, SQLException {
		ExtracaoCVMWeb ec = new ExtracaoCVMWeb(new ClienteWeb(), new ParserCVMWeb());
		EmpresaDAO ep = new EmpresaDAO();
		ep.inserir(ec.obterEmpresa(9512));
	}

}
