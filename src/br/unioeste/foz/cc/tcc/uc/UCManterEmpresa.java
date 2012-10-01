package br.unioeste.foz.cc.tcc.uc;

import java.sql.SQLException;
import java.util.List;

import br.unioeste.foz.cc.tcc.dao.EmpresaDAO;
import br.unioeste.foz.cc.tcc.dao.EmpresaListadaDAO;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class UCManterEmpresa {

	public UCManterEmpresa() {

	}

	public List<Empresa> obterEmpresasCarregadas() throws SQLException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.obterTodos();
	}

	public List<Empresa> obterEmpresasListadas(String nome) throws SQLException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		EmpresaListadaDAO listadaDAO = new EmpresaListadaDAO();
		
		nome = "%" + nome.toUpperCase() + "%";
		
		List<Empresa> empresas = empresaDAO.obterTodosPorNome(nome);
		empresas.addAll(listadaDAO.obterTodosPorNome(nome));
		return empresas;
	}

}
