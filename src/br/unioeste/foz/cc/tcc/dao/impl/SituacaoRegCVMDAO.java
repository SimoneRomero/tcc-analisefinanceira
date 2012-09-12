package br.unioeste.foz.cc.tcc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.empresa.SituacaoRegCVM;
import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;

public class SituacaoRegCVMDAO{

	QueryMakerSingleton queryMaker;

	public SituacaoRegCVMDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(SituacaoRegCVM situacaoRegCVM) throws SQLException {
		String columns = "idsituacaoRegCVM, situacao";

		Object[] values = { getNextId(), situacaoRegCVM.getSituacao() };

		return queryMaker.insert("situacaoregcvm", columns, values);
	}

	public void alterar(SituacaoRegCVM situacaoRegCVM) throws SQLException {
		String[] columns = { "idsituacaoRegCVM", "situacao" };

		Object[] values = { situacaoRegCVM.getId(),
				situacaoRegCVM.getSituacao() };

		queryMaker.updateWhere("situacaoRegCVM", columns,
				"idsituacaoRegCVM = ?", values, situacaoRegCVM.getId());
	}

	public void remover(SituacaoRegCVM situacaoRegCVM) throws SQLException {
		queryMaker.deleteWhere("situacaoRegCVM", "idsituacaoRegCVM = ?",
				situacaoRegCVM.getId());
	}

	public SituacaoRegCVM obter(int id) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("situacaoRegCVM",
				"idsituacaoRegCVM = ?", id);
		SituacaoRegCVM s = new SituacaoRegCVM(rs.getString(2));
		s.setId(id);

		return s;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idsituacaoRegCVM");
	}

}
