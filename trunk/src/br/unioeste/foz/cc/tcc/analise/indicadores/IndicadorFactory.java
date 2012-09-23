package br.unioeste.foz.cc.tcc.analise.indicadores;

import br.unioeste.foz.cc.tcc.analise.indicadores.giros.NCG;
import br.unioeste.foz.cc.tcc.analise.indicadores.prazos.PMPC;
import br.unioeste.foz.cc.tcc.analise.indicadores.prazos.PMRE;
import br.unioeste.foz.cc.tcc.analise.indicadores.prazos.PMRV;

public class IndicadorFactory {

	public IIndicador factoryMethod(String nomeIndicador) {

		if (nomeIndicador.equals("PMRV"))
			return new PMRV();
		else if (nomeIndicador.equals("PMPC"))
			return new PMPC();
		else if (nomeIndicador.equals("PMRE"))
			return new PMRE();
		else if (nomeIndicador.equals("Giro"))
			return new NCG();
		else
			return null;
	}

}
