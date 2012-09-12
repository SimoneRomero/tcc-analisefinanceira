package br.unioeste.foz.cc.tcc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.dao.IDAO;
import br.unioeste.foz.cc.tcc.empresa.Pais;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class PaisDAO implements IDAO {

	QueryMakerSingleton qm;

	public PaisDAO() throws SQLException {
		qm = QueryMakerSingleton.getInstance();
	}

	@Override
	public int inserir(Object object) throws SQLException {

		return 0;
	}

	@Override
	public void alterar(Object object) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Object object) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object obter(int id) throws SQLException {
		ResultSet rs = qm.selectAllWhere("pais", "idpais = ?", id);
		return new Pais(rs.getString(2));
	}

}
