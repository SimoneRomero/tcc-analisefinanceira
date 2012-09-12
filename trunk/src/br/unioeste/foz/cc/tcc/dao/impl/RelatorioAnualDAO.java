package br.unioeste.foz.cc.tcc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.foz.cc.tcc.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class RelatorioAnualDAO {

	QueryMakerSingleton queryMaker;

	public RelatorioAnualDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(RelatorioAnual relatorioAnual) throws SQLException {
		String columns = "idrelatorioAnual, finalPeriodo";

		Object[] values = { getNextId(), relatorioAnual.getFinalPeriodo() };

		return queryMaker.insert("relatorioAnual", columns, values);
	}

	public void alterar(RelatorioAnual relatorioAnual) throws SQLException {
		String[] columns = { "idrelatorioAnual", "finalPeriodo" };

		Object[] values = { relatorioAnual.getId(),
				relatorioAnual.getFinalPeriodo() };

		queryMaker.updateWhere("relatorioAnual", columns,
				"idrelatorioAnual = ?", values, relatorioAnual.getId());
	}

	public void remover(RelatorioAnual relatorioAnual) throws SQLException {
		queryMaker.deleteWhere("relatorioAnual", "idrelatorioAnual = ?",
				relatorioAnual.getId());
	}

	public RelatorioAnual obter(int id) throws SQLException {
		AtributoValorDAO atrDAO = new AtributoValorDAO();

		ResultSet rs = queryMaker.selectAllWhere("relatorioAnual",
				"idrelatorioAnual = ?", id);
		RelatorioAnual relatorioAnual = new RelatorioAnual(rs.getDate(2));
		relatorioAnual.setId(id);

		relatorioAnual.setAtributoValor(atrDAO.obterAtributos(rs
				.getInt("idrelatorioanual")));

		return relatorioAnual;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idrelatorioAnual");
	}

	public List<RelatorioAnual> obterRelatorios(int idEmpresa) throws SQLException {

		List<RelatorioAnual> relatorios = new ArrayList<RelatorioAnual>();

		AtributoValorDAO atrDAO = new AtributoValorDAO();

		ResultSet rs = queryMaker.selectAllWhere("relatorioanual",
				"empresa_idempresa = ?", idEmpresa);

		relatorios.add(new RelatorioAnual(rs.getInt("idrelatorioanual"), rs
				.getDate("finalperiodo"), atrDAO.obterAtributos(rs
				.getInt("idrelatorioanual"))));
		while (rs.next())
			relatorios.add(new RelatorioAnual(rs.getInt("idrelatorioanual"), rs
					.getDate("finalperiodo"), atrDAO.obterAtributos(rs
					.getInt("idrelatorioanual"))));

		return relatorios;
	}

}
