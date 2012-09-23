package br.unioeste.foz.cc.tcc.analise.indicadores.prazos;

import java.sql.Date;
import java.util.Calendar;

import br.unioeste.foz.cc.tcc.analise.indicadores.IIndicador;
import br.unioeste.foz.cc.tcc.aquisicaocvm.HashBackMap;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class PMPC implements IIndicador {

	@Override
	public HashBackMap<Date, Double> calcular(Empresa empresa) {

		HashBackMap<Date, Double> indicadores = new HashBackMap<Date, Double>();

		for (RelatorioAnual ra : empresa.getRelatorios()) {

			double pmpc = 360 * (ra.getValorByCodigo("2.01.02") / (empresa
					.getRelatorioByFinalPeriodo(
							getDataAnterior(ra.getFinalPeriodo()))
					.getValorByCodigo("1.01.04")
					- ra.getValorByCodigo("1.01.04") + Math.abs(ra
					.getValorByCodigo("3.02"))));

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
