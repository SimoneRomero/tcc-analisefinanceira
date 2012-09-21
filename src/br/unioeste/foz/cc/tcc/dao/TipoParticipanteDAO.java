package br.unioeste.foz.cc.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.empresa.TipoParticipante;

public class TipoParticipanteDAO{

	private QueryMakerSingleton queryMaker;

	public TipoParticipanteDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(TipoParticipante tipoParticipante) throws SQLException {

		try{return existe(tipoParticipante);}
		catch (SQLException e) {}

		String columns = "idtipoParticipante, tipo";

		Object[] values = { getNextId(), tipoParticipante.getTipo() };

		return queryMaker.insert("tipoparticipante", columns, values);
	}

	public int existe(TipoParticipante tipoParticipante) throws SQLException {
		ResultSet rs = queryMaker.selectWhere("tipoparticipante", "idtipoparticipante",
				"tipo = ?", tipoParticipante.getTipo());
		return rs.getInt(1);
	}

	public void alterar(TipoParticipante tipoParticipante) throws SQLException {
		String[] columns = { "idtipoParticipante", "tipo" };

		Object[] values = { tipoParticipante.getId(),
				tipoParticipante.getTipo() };

		queryMaker.updateWhere("tipoParticipante", columns,
				"idtipoParticipante = ?", values, tipoParticipante.getId());
	}

	public void remover(TipoParticipante tipoParticipante) throws SQLException {
		queryMaker.deleteWhere("tipoParticipante", "idtipoParticipante = ?",
				tipoParticipante.getId());
	}

	public TipoParticipante obter(int id) throws SQLException {
		ResultSet rs = queryMaker.selectAllWhere("tipoParticipante",
				"idtipoParticipante = ?", id);
		TipoParticipante t = new TipoParticipante(rs.getString(2));
		t.setId(id);
		return t;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idtipoParticipante");
	}

}
