package br.unioeste.foz.cc.tcc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.demonstracao.Atributo;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class AtributoDAO{

	QueryMakerSingleton queryMaker;

	public AtributoDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(Atributo atributo) throws SQLException {
		String columns = "idatributo, descricao, codigo";

		Object[] values = { getNextId(), atributo.getDescricao(),
				atributo.getCodigo() };

		return queryMaker.insert("atributo", columns, values);
	}

	public void alterar(Atributo atributo) throws SQLException {
		String[] columns = { "idatributo", "descricao", "codigo" };

		Object[] values = { atributo.getId(), atributo.getDescricao(),
				atributo.getCodigo() };

		queryMaker.updateWhere("atributo", columns, "idatributo = ?", values,
				atributo.getId());
	}

	public void remover(Atributo atributo) throws SQLException {
		queryMaker.deleteWhere("atributo", "idatributo = ?",
				atributo.getId());
	}

	public Atributo obter(int id) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("atributo", "idatributo = ?",
				id);

		Atributo a = new Atributo(rs.getString(2), rs.getString(3));
		a.setId(id);

		return a;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idatributo");
	}

}
