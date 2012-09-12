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
 *         Classe ClienteWeb para obtenção das páginas web. Herda todos os
 *         métodos de WebClient da HTMLUnit e personaliza configurações do
 *         cliente web para a aplicação necessária. Implementa Serializable para
 *         aplicações distribuídas.
 *
 */
public class ClienteWeb extends WebClient implements Serializable {

	/** Número serial do objeto, serialVersionUID. */
	private static final long serialVersionUID = 2690875877198037009L;

	/**
	 * Instância um novo cliente web com as configurações necessárias.
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