package br.unioeste.foz.cc.tcc.analise.indicadores.prazos;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.analise.indicadores.IIndicador;
import br.unioeste.foz.cc.tcc.aquisicaocvm.HashBackMap;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class PMRE implements IIndicador {

	@Override
	public HashBackMap<Date, Double> calcular(Empresa empresa) {

		HashBackMap<Date, Double> indicadores = new HashBackMap<Date, Double>();

		for(RelatorioAnual ra : empresa.getRelatorios()){

			double pmre = 360*(ra.getValorByCodigo("1.01.04") / Math.abs(ra.getValorByCodigo("3.02")));

			indicadores.put(ra.getFinalPeriodo(), pmre);
		}

		return indicadores;
	}
}
