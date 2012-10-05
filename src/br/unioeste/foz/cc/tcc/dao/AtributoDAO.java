package br.unioeste.foz.cc.tcc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.demonstracao.Atributo;

public class AtributoDAO {

	private QueryMakerSingleton queryMaker;

	public AtributoDAO() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(Atributo atributo) throws SQLException {

		try {
			return existe(atributo);
		} catch (SQLException e) {
		}

		String columns = "idatributo, descricao, codigo";

		Object[] values = { getNextId(), atributo.getDescricao(),
				atributo.getCodigo() };

		return queryMaker.insert("atributo", columns, values);
	}

	public int existe(Atributo atributo) throws SQLException {
		ResultSet rs = queryMaker.selectWhere("atributo", "idatributo",
				"codigo = ?", atributo.getCodigo());
		return rs.getInt(1);
	}

	public void alterar(Atributo atributo) throws SQLException {
		
		atributo.setId(inserir(atributo));
		
		String[] columns = {"descricao", "codigo" };

		Object[] values = { atributo.getDescricao(),
				atributo.getCodigo() };

		queryMaker.updateWhere("atributo", columns, "idatributo = ?", values,
				atributo.getId());
	}

	public void remover(Atributo atributo) throws SQLException {
		queryMaker.deleteWhere("atributo", "idatributo = ?", atributo.getId());
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
