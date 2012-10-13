package br.unioeste.foz.cc.tcc.uc;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.analise.indicadores.IndicadorFactory;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

public class UCAnalisar {

	public UCAnalisar() {
	}

	public HashBackMap<Date, Double> calcular(String nomeIndicador,
			Empresa empresa) {
		IndicadorFactory fabrica = IndicadorFactory.getInstance(nomeIndicador);
		return fabrica.calcular(empresa);
	}

}
