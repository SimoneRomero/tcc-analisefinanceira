package br.unioeste.foz.cc.tcc.aquisicaocvm;

import org.w3c.css.sac.CSSException;
import org.w3c.css.sac.CSSParseException;
import org.w3c.css.sac.ErrorHandler;

// TODO: Auto-generated Javadoc
/**
 * OmitirErrosCSS para esconder notifica��es de css na p�gina web do cliente
 * web. Utiliza��o para aumentar a performance da extra��o da p�gina.
 */
public class OmitirErrosCSS implements ErrorHandler {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.w3c.css.sac.ErrorHandler#error(org.w3c.css.sac.CSSParseException)
	 */
	@Override
	public void error(CSSParseException e) throws CSSException {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.w3c.css.sac.ErrorHandler#fatalError(org.w3c.css.sac.CSSParseException
	 * )
	 */
	@Override
	public void fatalError(CSSParseException e) throws CSSException {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.w3c.css.sac.ErrorHandler#warning(org.w3c.css.sac.CSSParseException)
	 */
	@Override
	public void warning(CSSParseException e) throws CSSException {
	}

}
