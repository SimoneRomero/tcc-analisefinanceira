package br.unioeste.foz.cc.tcc.aquisicaocvm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

import unioeste.tcc.empresa.Empresa;
import unioeste.tcc.prototipos.HashBackMap;

public interface IExtracaoCVMWeb {

	public Empresa obterEmpresa(int codCVM)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException;

	public HashBackMap<Integer, Empresa> obterEmpresasListadas()
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException;

}
