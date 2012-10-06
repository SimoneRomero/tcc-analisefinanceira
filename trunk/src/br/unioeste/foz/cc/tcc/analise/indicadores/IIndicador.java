package br.unioeste.foz.cc.tcc.analise.indicadores;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;
import br.unioeste.foz.cc.tcc.web.cvm.HashBackMap;

public interface IIndicador {

	public HashBackMap<Date, Double> calcular(Empresa empresa);

}
