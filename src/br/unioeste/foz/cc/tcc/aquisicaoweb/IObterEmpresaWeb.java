package br.unioeste.foz.cc.tcc.aquisicaoweb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import br.unioeste.foz.cc.tcc.aquisicaocvm.HashBackMap;
import br.unioeste.foz.cc.tcc.empresa.Empresa;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public interface IObterEmpresaWeb {

	public Empresa obterEmpresa(int codCVM)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException;

	public HashBackMap<Integer, Empresa> obterEmpresasListadas()
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException;

}
