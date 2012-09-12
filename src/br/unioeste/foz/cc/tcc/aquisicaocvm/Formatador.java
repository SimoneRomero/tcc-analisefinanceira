package br.unioeste.foz.cc.tcc.aquisicaocvm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jhonny Mertz Formatadores para captura de informações
 */
public class Formatador {

	private static DateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

	public static Date string2date(String data) throws ParseException {
		if (data.equals(""))
			return null;
		else
			return (Date) formatterDate.parse(data);
	}

	public static int string2codCvm(String codCVM) {
		return Integer.valueOf(codCVM.replace("-", ""));
	}

}