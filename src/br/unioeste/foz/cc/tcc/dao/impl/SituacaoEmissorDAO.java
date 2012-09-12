package br.unioeste.foz.cc.tcc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.empresa.SituacaoEmissor;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class SituacaoEmissorDAO {

	QueryMakerSingleton queryMaker;

	public SituacaoEmissorDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(SituacaoEmissor situacaoEmissor) throws SQLException {

		String columns = "idsituacaoEmissor, situacao";

		Object[] values = { getNextId(), situacaoEmissor.getSituacao() };

		return queryMaker.insert("situacaoemissor", columns, values);
	}

	public void alterar(SituacaoEmissor situacaoEmissor) throws SQLException {
		String[] columns = { "idsituacaoEmissor", "situacao" };

		Object[] values = { situacaoEmissor.getId(),
				situacaoEmissor.getSituacao() };

		queryMaker.updateWhere("situacaoEmissor", columns,
				"idsituacaoEmissor = ?", values, situacaoEmissor.getId());
	}

	public void remover(SituacaoEmissor situacaoEmissor) throws SQLException {
		queryMaker.deleteWhere("situacaoEmissor", "idsituacaoEmissor = ?",
				situacaoEmissor.getId());
	}

	public SituacaoEmissor obter(int id) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("situacaoEmissor",
				"idsituacaoEmissor = ?", id);
		SituacaoEmissor s = new SituacaoEmissor(rs.getString(2));
		s.setId(id);
		return s;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idsituacaoEmissor");
	}

}
