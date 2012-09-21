package br.unioeste.foz.cc.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.empresa.CategoriaRegCVM;

public class CategoriaRegCVMDAO {

	private QueryMakerSingleton queryMaker;

	public CategoriaRegCVMDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(CategoriaRegCVM categoriaRegCVM) throws SQLException {

		try{return existe(categoriaRegCVM);}
		catch (SQLException e) {}

		String columns = "idcategoriaRegCVM, categoria";

		Object[] values = { getNextId(), categoriaRegCVM.getCategoria() };

		return queryMaker.insert("categoriaregcvm", columns, values);
	}

	public int existe(CategoriaRegCVM categoriaRegCVM) throws SQLException {
		ResultSet rs = queryMaker.selectWhere("categoriaregcvm",
				"idcategoriaregcvm", "categoria = ?",
				categoriaRegCVM.getCategoria());
		return rs.getInt(1);
	}

	public void alterar(CategoriaRegCVM categoriaRegCVM) throws SQLException {
		String[] columns = { "idcategoriaRegCVM", "categoria" };

		Object[] values = { categoriaRegCVM.getId(),
				categoriaRegCVM.getCategoria() };

		queryMaker.updateWhere("categoriaRegCVM", columns,
				"idcategoriaRegCVM = ?", values, categoriaRegCVM.getId());
	}

	public void remover(CategoriaRegCVM categoriaRegCVM) throws SQLException {
		queryMaker.deleteWhere("categoriaRegCVM", "idcategoriaRegCVM = ?",
				categoriaRegCVM.getId());
	}

	public CategoriaRegCVM obter(int id) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("categoriaRegCVM",
				"idcategoriaRegCVM = ?", id);
		CategoriaRegCVM c = new CategoriaRegCVM(rs.getString(2));
		c.setId(id);

		return c;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idcategoriaRegCVM");
	}

}
