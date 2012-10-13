package br.unioeste.foz.cc.tcc.analise.indicadores;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.analise.indicadores.giros.NCG;
import br.unioeste.foz.cc.tcc.analise.indicadores.prazos.PMPC;
import br.unioeste.foz.cc.tcc.analise.indicadores.prazos.PMRE;
import br.unioeste.foz.cc.tcc.analise.indicadores.prazos.PMRV;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

public abstract class IndicadorFactory {
	
	public abstract HashBackMap<Date, Double> calcular(Empresa empresa);

	public static IndicadorFactory getInstance(String nomeIndicador) {

		if (nomeIndicador.equals("PMRV"))
			return new PMRV();
		else if (nomeIndicador.equals("PMPC"))
			return new PMPC();
		else if (nomeIndicador.equals("PMRE"))
			return new PMRE();
		else if (nomeIndicador.equals("NCG"))
			return new NCG();
		else
			return null;
	}

}
