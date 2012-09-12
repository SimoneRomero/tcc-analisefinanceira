package br.unioeste.foz.cc.tcc.aquisicaoweb;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 *
 * @author Jhonny Mertz
 *
 *         Classe ClienteWeb para obten��o das p�ginas web. Herda todos os
 *         m�todos de WebClient da HTMLUnit e personaliza configura��es do
 *         cliente web para a aplica��o necess�ria. Implementa Serializable para
 *         aplica��es distribu�das.
 *
 */
public class ClienteWeb extends WebClient implements Serializable {

	/** N�mero serial do objeto, serialVersionUID. */
	private static final long serialVersionUID = 2690875877198037009L;

	/**
	 * Inst�ncia um novo cliente web com as configura��es necess�rias.
	 */
	public ClienteWeb() {
		super(BrowserVersion.FIREFOX_10);
		setIncorrectnessListener(new OmitirChamadasIncorretas());
		setCssErrorHandler(new OmitirErrosCSS());
		setJavaScriptEnabled(true);
		setCssEnabled(false);
		setThrowExceptionOnScriptError(false);
		setThrowExceptionOnFailingStatusCode(false);
		setPopupBlockerEnabled(false);
		setActiveXNative(false);
	}

	/**
	 *
	 * @param url
	 * @return
	 * @throws FailingHttpStatusCodeException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public HtmlPage obterPagina(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		return this.getPage(url);
	}

	/**
	 *
	 * @param url
	 * @return
	 * @throws FailingHttpStatusCodeException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public HtmlPage obterPagina(URL url) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		return this.getPage(url);
	}
}