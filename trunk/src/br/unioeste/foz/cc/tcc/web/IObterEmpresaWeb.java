package br.unioeste.foz.cc.tcc.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public interface IObterEmpresaWeb {

	public Empresa obterEmpresa(int codCVM)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException, ParseException;

	public List<Empresa> obterEmpresasListadas()
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException;

}
