package br.unioeste.foz.cc.tcc.web.cvm;

import java.util.HashMap;

/**
 * Classe HashBackMap para situa��es onde o valor e a chave de acesso s�o
 * �nicos.
 *
 * @param <K>
 *            O tipo de chave
 * @param <V>
 *            O tipo de valor
 */
public class HashBackMap<K, V> extends HashMap<K, V> {

	/** Serial ID. */
	private static final long serialVersionUID = -6329347396110966510L;

	/**
	 * Obt�m a chave atrav�s do valor informado.
	 *
	 * @param value
	 *            O valor
	 * @return a chave do valor
	 */
	public Object getKeyByValue(V value) {

		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

}
