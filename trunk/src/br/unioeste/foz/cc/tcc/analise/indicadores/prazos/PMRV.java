package br.unioeste.foz.cc.tcc.analise.indicadores.prazos;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.analise.indicadores.IIndicador;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

public class PMRV implements IIndicador {

	@Override
	public HashBackMap<Date, Double> calcular(Empresa empresa) {

		HashBackMap<Date, Double> indicadores = new HashBackMap<Date, Double>();

		for(RelatorioAnual ra : empresa.getRelatorios()){

			double pmrv = 360*(ra.getValorByCodigo("1.01.02") / ra.getValorByCodigo("3.03"));

			indicadores.put(ra.getFinalPeriodo(), pmrv);
		}

		return indicadores;
	}
}
