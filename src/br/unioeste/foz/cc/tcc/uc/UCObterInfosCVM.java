package br.unioeste.foz.cc.tcc.uc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.unioeste.foz.cc.tcc.aquisicaocvm.ExtracaoCVMWeb;
import br.unioeste.foz.cc.tcc.aquisicaocvm.ParserCVMWeb;
import br.unioeste.foz.cc.tcc.aquisicaoweb.ClienteWeb;
import br.unioeste.foz.cc.tcc.dao.EmpresaDAO;
import br.unioeste.foz.cc.tcc.dao.EmpresaListadaDAO;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class UCObterInfosCVM {
	
	private ExtracaoCVMWeb etWeb;
	
	public UCObterInfosCVM(){
		this.etWeb = new ExtracaoCVMWeb(new ClienteWeb(), new ParserCVMWeb());
	}
	
	public List<Empresa> obterEmpresasListadas() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		this.etWeb = new ExtracaoCVMWeb(new ClienteWeb(), new ParserCVMWeb());
		return etWeb.obterEmpresasListadas();
	}
	
	public Empresa obterEmpresa(int codCVM) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException{
		return this.etWeb.obterEmpresa(codCVM);
	}
	
	public void atualizarListadas() throws FailingHttpStatusCodeException, MalformedURLException, IOException, SQLException{
		EmpresaListadaDAO listadaDAO = new EmpresaListadaDAO();
		for(Empresa e : this.etWeb.obterEmpresasListadas()){
			listadaDAO.inserir(e);
		}
	}
	
	public void atualizarEmpresas() throws FailingHttpStatusCodeException, MalformedURLException, SQLException, IOException, ParseException{
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		for(Empresa e : empresaDAO.obterTodos()){
			empresaDAO.alterar(this.etWeb.obterEmpresa(e.getCodigoCVM()));
		}
	}

}
