package br.unioeste.foz.cc.tcc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.dao.IDAO;
import br.unioeste.foz.cc.tcc.empresa.Empresa;
import br.unioeste.foz.cc.tcc.empresa.Pais;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class EmpresaDAO implements IDAO {

	QueryMakerSingleton queryMaker;

	public EmpresaDAO() throws SQLException{
		queryMaker = QueryMakerSingleton.getInstance();
	}

	@Override
	public int inserir(Object object) throws SQLException {
		// TODO Auto-generated method stub
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

		ResultSet result = queryMaker.selectAllWhere("empresa", "codigoCVM = ?", codCVM);

		Pais pais = new Pais(
				result.getInt(15)
				);
		Empresa empresa = new Empresa(result.getString(2), result.getString(3), result.getString(4),
				result.getInt(5), setor, registro, result.getString(6), result.getDate(7),
				result.getDate(8), result.getDate(10), pais);
		result.getInt(1);

		return empresa;
	}

}
