package br.unioeste.foz.cc.tcc.analise.indicadores;

import java.sql.Date;

import br.unioeste.foz.cc.tcc.aquisicaocvm.HashBackMap;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public interface IIndicador {

	public HashBackMap<Date, Double> calcular(Empresa empresa);

}
