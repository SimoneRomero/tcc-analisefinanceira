package br.unioeste.foz.cc.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.foz.cc.tcc.infra.QueryMakerSingleton;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class EmpresaListadaDAO{

	private QueryMakerSingleton queryMaker;

	public EmpresaListadaDAO() throws SQLException {
		queryMaker = QueryMakerSingleton.getInstance();
	}

	public int inserir(Empresa empresa) throws SQLException {

		try{ return existe(empresa);}
		catch (SQLException e) {}

		String columns = "idempresalistada, codigoCVM, nome";

		Object[] values = { getNextId(),
				empresa.getCodigoCVM(),
				empresa.getNome()
				};

		int idEmpresa = queryMaker.insert("empresalistada", columns, values);

		return idEmpresa;
	}

	public int existe(Empresa empresa) throws SQLException {
			ResultSet rs = queryMaker.selectWhere("empresalistada", "idempresalistada",
					"codigoCVM = ?", empresa.getCodigoCVM());
			return rs.getInt(1);
	}

	public void remover(Empresa empresa) throws SQLException {
		queryMaker.deleteWhere("empresalistada", "idempresalistada = ?",
				empresa.getId());
	}

	public Empresa obter(int id, boolean isCodCVM) throws SQLException {

		String coluna = "idempresalistada";
		if(isCodCVM)
			coluna = "codigocvm";

		ResultSet result = queryMaker.selectAllWhere("empresalistada",
				coluna + " = ?", id);
		
		Empresa empresa = new Empresa(result.getString(2), result.getInt(3));
		empresa.setId(result.getInt(1));

		return empresa;
	}

	private int getNextId() throws SQLException {
		return queryMaker.selectSequence("idempresalistada");
	}

	public List<Empresa> obterTodos() throws SQLException {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();

		ResultSet rs = queryMaker.select("empresalistada","idempresalistada");

		empresas.add(obter(rs.getInt(1), false));

		while(rs.next())
			empresas.add(obter(rs.getInt(1), false));

		return empresas;


	}

	public List<Empresa> obterTodosPorNome(String nome) throws SQLException {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();

		ResultSet rs = queryMaker.selectWhere("empresalistada", "idempresalistada", "nome LIKE ?", nome);
		empresas.add(obter(rs.getInt(1), false));

		while (rs.next())
			empresas.add(obter(rs.getInt(1), false));

		return empresas;
	}
}
