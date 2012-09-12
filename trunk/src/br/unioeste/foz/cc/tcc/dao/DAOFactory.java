package br.unioeste.foz.cc.tcc.dao;

import br.unioeste.foz.cc.tcc.dao.impl.EmpresaDAO;
import br.unioeste.foz.cc.tcc.dao.impl.PaisDAO;

public class DAOFactory implements IDAOFactory {

	@Override
	public IDAO createDAO(String dao) {

		if(dao.equals("pais"))
			return new PaisDAO();
		else if(dao.equals("empresa"))
			return new EmpresaDAO();
		else if(dao.equals("atributo"))
			return new AtributoDAO();
		else if(dao.equals("registro"))
			return new RegistroDAO();
		else if(dao.equals("situacaoregCVM"))
			return new SituacaoRegCVMDAO();
		else if(dao.equals("setor"))
			return new SetorDAO();
		else return null;

	}

}
