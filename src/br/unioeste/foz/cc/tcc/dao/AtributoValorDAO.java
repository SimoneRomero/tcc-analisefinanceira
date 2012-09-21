package br.unioeste.foz.cc.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.demonstracao.AtributoValor;

public class AtributoValorDAO{

	private QueryMakerSingleton queryMaker;

	public AtributoValorDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(AtributoValor atributoValor) throws SQLException {
		String columns = "idatributo, idrelatorioanual, valor";

		Object[] values = { atributoValor.getIdAtributo(),
				atributoValor.getIdRelatorioAnual(), atributoValor.getValor() };

		return queryMaker.insert("atributoValor", columns, values);
	}

	public void alterar(AtributoValor atributoValor) throws SQLException {
		String[] columns = { "idatributo", "idrelatorioanual", "valor" };

		Object[] values = { atributoValor.getIdAtributo(),
				atributoValor.getIdRelatorioAnual(), atributoValor.getValor() };

		queryMaker.updateWhere(
				"atributoValor",
				columns,
				"idatributo = ? and idrelatorioanual = "
						+ atributoValor.getIdRelatorioAnual(), values,
				atributoValor.getIdAtributo());
	}

	public void remover(AtributoValor a) throws SQLException {
		queryMaker.deleteWhere("atributoValor", "idatributoValor = ? and idrelatorioanual = " +
				a.getIdRelatorioAnual(), a.getIdAtributo());
	}

	public List<AtributoValor> obterAtributos(int idRelatorioanual) throws SQLException {
		List<AtributoValor> atrs = new ArrayList<AtributoValor>();

		AtributoDAO atrDAO = new AtributoDAO();

		ResultSet rs = queryMaker.selectAllWhere("atributoValor",
				"idrelatorioanual = ?", idRelatorioanual);

		atrs.add(new AtributoValor(idRelatorioanual, rs.getInt("idatributo"),
				rs.getString("valor"), atrDAO.obter(rs.getInt("idatributo"))));
		while(rs.next())
			atrs.add(new AtributoValor(idRelatorioanual, rs.getInt("idatributo"),
					rs.getString("valor"), atrDAO.obter(rs.getInt("idatributo"))));

		return atrs;
	}

}
