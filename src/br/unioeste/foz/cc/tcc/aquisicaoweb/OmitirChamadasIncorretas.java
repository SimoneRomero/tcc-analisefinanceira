package br.unioeste.foz.cc.tcc.aquisicaoweb;

import com.gargoylesoftware.htmlunit.IncorrectnessListener;

/**
 * OmitirChamadasIncorretas para esconder notificações de erros encontrados em
 * páginas do cliente web. Essa prática aumenta a performance da captura da
 * página web.
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
