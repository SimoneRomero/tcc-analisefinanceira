package br.unioeste.foz.cc.tcc.analise.indicadores.giros;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.analise.indicadores.IIndicador;
import br.unioeste.foz.cc.tcc.aquisicaocvm.HashBackMap;
import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class NCG implements IIndicador {

	@Override
	public HashBackMap<Date, Double> calcular(Empresa empresa) {

		HashBackMap<Date, Double> indicadores = new HashBackMap<Date, Double>();

		for(RelatorioAnual ra : empresa.getRelatorios()){

			double ncg = 0;

			for(int i = 3; i <= 8; i++){
				ncg += ra.getValorByCodigo("1.01.0" + i);
			}

			for(int i = 2; i <= 5; i++){
				ncg -= ra.getValorByCodigo("2.01.0" + i);
			}

			indicadores.put(ra.getFinalPeriodo(), ncg);
		}

		return indicadores;
	}

}
