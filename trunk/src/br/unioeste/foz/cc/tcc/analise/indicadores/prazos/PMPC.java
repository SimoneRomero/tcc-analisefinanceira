package br.unioeste.foz.cc.tcc.analise.indicadores.prazos;

import java.sql.Date;
import java.util.Calendar;

import br.unioeste.foz.cc.tcc.analise.indicadores.IndicadorFactory;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

public class PMPC extends IndicadorFactory {

	@Override
	public HashBackMap<Date, Double> calcular(Empresa empresa) {

		HashBackMap<Date, Double> indicadores = new HashBackMap<Date, Double>();

		for (RelatorioAnual ra : empresa.getRelatorios()) {

			double pmpc = 0;
			try {
				pmpc = 360 * (ra.getValorByCodigo("2.01.02") / (empresa
						.getRelatorioByFinalPeriodo(
								getDataAnterior(ra.getFinalPeriodo()))
						.getValorByCodigo("1.01.04")
						- ra.getValorByCodigo("1.01.04") + Math.abs(ra
						.getValorByCodigo("3.02"))));
			} catch (NullPointerException ex) {

			}

			indicadores.put(ra.getFinalPeriodo(), pmpc);
		}

		return indicadores;
	}

	private Date getDataAnterior(Date data) {
		Calendar calendarData = Calendar.getInstance();
		calendarData.setTime(data);
		calendarData.add(Calendar.YEAR, -1);
		return new Date(calendarData.getTime().getTime());
	}
}
