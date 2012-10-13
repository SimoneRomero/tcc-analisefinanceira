package br.unioeste.foz.cc.tcc.uc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.foz.cc.tcc.dao.EmpresaDAO;
import br.unioeste.foz.cc.tcc.dao.EmpresaListadaDAO;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class UCManterEmpresa {

	public UCManterEmpresa() {

	}

	public List<Empresa> obterEmpresasCarregadas() throws SQLException,
			FileNotFoundException, ClassNotFoundException, IOException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.obterTodos();
	}

	public List<Empresa> obterEmpresasListadas(String nome)
			throws SQLException, FileNotFoundException, ClassNotFoundException,
			IOException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		EmpresaListadaDAO listadaDAO = new EmpresaListadaDAO();

		nome = "%" + nome.toUpperCase() + "%";

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {
			empresas = empresaDAO.obterTodosPorNome(nome);
		} catch (Exception e) {
		}
		try {
			empresas.addAll(listadaDAO.obterTodosPorNome(nome));
		} catch (Exception e) {

		}
		return empresas;
	}

	public Empresa obterEmpresa(int id, boolean isCodCVM) throws SQLException,
			FileNotFoundException, ClassNotFoundException, IOException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.obter(id, isCodCVM);
	}

	public Empresa obterEmpresa(String nome) throws FileNotFoundException,
			ClassNotFoundException, SQLException, IOException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.obter(nome);
	}

	public int inserir(Empresa empresa) throws FileNotFoundException,
			ClassNotFoundException, SQLException, IOException {
		EmpresaDAO empresaDAO = new EmpresaDAO();
		return empresaDAO.inserir(empresa);
	}

}
