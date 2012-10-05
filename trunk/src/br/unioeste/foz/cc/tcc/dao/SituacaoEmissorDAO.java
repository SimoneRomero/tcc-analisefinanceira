package br.unioeste.foz.cc.tcc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.empresa.SituacaoEmissor;

public class SituacaoEmissorDAO {

	private QueryMakerSingleton queryMaker;

	public SituacaoEmissorDAO() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(SituacaoEmissor situacaoEmissor) throws SQLException {

		try {
			return existe(situacaoEmissor);
		} catch (SQLException e) {
		}

		String columns = "idsituacaoEmissor, situacao";

		Object[] values = { getNextId(), situacaoEmissor.getSituacao() };

		return queryMaker.insert("situacaoemissor", columns, values);
	}

	public int existe(SituacaoEmissor situacaoEmissor) throws SQLException {
		ResultSet rs = queryMaker.selectWhere("situacaoemissor",
				"idsituacaoemissor", "situacao = ?",
				situacaoEmissor.getSituacao());
		return rs.getInt(1);
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
