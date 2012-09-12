package br.unioeste.foz.cc.tcc.aquisicaoweb;

import com.gargoylesoftware.htmlunit.IncorrectnessListener;

/**
 * OmitirChamadasIncorretas para esconder notifica��es de erros encontrados em
 * p�ginas do cliente web. Essa pr�tica aumenta a performance da captura da
 * p�gina web.
 *
 * Implementa IncorrectListener do HTMLUnit.
 */
public class OmitirChamadasIncorretas implements IncorrectnessListener {

	/*
	 * @see
	 * com.gargoylesoftware.htmlunit.IncorrectnessListener#notify(java.lang.
	 * String, java.lang.Object)
	 */
	@Override
	public void notify(String message, Object origin) {
	}
}
