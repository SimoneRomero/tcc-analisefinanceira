package br.unioeste.foz.cc.tcc.dao;

import java.sql.SQLException;

public interface IDAO {

	public int inserir(Object object) throws SQLException;

	public void alterar(Object object) throws SQLException;

	public void remover(Object object) throws SQLException;

	public Object obter(int id) throws SQLException;

}
