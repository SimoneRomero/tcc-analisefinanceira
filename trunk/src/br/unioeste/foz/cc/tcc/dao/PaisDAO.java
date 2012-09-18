package br.unioeste.foz.cc.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.empresa.Pais;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class PaisDAO{

	private QueryMakerSingleton queryMaker;

	public PaisDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(Pais pais) throws SQLException {

		try{return existe(pais);}
		catch (SQLException e) {}

		String columns = "idpais, nome";

		Object[] values = { getNextId(), pais.getNome() };

		return queryMaker.insert("pais", columns, values);
	}

	public void alterar(Pais pais) throws SQLException {
		String[] columns = { "idpais", "nome" };

		Object[] values = { pais.getId(), pais.getNome() };

		queryMaker.updateWhere("pais", columns, "idpais = ?", values,
				pais.getId());
	}

	public void remover(Pais pais) throws SQLException {
		queryMaker.deleteWhere("pais", "idpais = ?", pais.getId());
	}

	public void remover(int id) throws SQLException {
		queryMaker.deleteWhere("pais", "idpais = ?", id);
	}

	public Pais obter(int id) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("pais", "idpais = ?", id);
		Pais pais = new Pais(rs.getString(2));
		pais.setId(id);
		return pais;
	}

	public int existe(Pais pais) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("pais", "nome = ?", pais.getNome());
		return rs.getInt(1);
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idpais");
	}
}
