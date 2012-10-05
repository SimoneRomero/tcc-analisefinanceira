package br.unioeste.foz.cc.tcc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.empresa.SituacaoRegCVM;

public class SituacaoRegCVMDAO{

	private QueryMakerSingleton queryMaker;

	public SituacaoRegCVMDAO() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(SituacaoRegCVM situacaoRegCVM) throws SQLException {

		try{return existe(situacaoRegCVM);}
		catch (SQLException e) {}

		String columns = "idsituacaoRegCVM, situacao";

		Object[] values = { getNextId(), situacaoRegCVM.getSituacao() };

		return queryMaker.insert("situacaoregcvm", columns, values);
	}

	public int existe(SituacaoRegCVM situacaoRegCVM) throws SQLException {
			ResultSet rs = queryMaker.selectWhere("situacaoregcvm", "idsituacaoregcvm",
					"situacao = ?", situacaoRegCVM.getSituacao());
			return rs.getInt(1);
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
