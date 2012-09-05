package br.unioeste.foz.cc.tcc.aquisicaocvm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import br.unioeste.foz.cc.tcc.empresa.Empresa;
import br.unioeste.foz.cc.tcc.prototipos.HashBackMap;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public interface IExtracaoCVMWeb {

	public Empresa obterEmpresa(int codCVM)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException;

	public HashBackMap<Integer, Empresa> obterEmpresasListadas()
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException;

}
