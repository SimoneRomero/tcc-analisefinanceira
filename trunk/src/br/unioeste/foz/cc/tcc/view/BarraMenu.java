package br.unioeste.foz.cc.tcc.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class BarraMenu extends JMenuBar {
	
	public BarraMenu(){
		super();
		createBar();
	}
	
	private void createBar(){
		JMenu mnArquivo = new JMenu("Arquivo");
		add(mnArquivo);

		JMenuItem mntmNovo = new JMenuItem("Novo");
		mnArquivo.add(mntmNovo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnArquivo.add(mntmAbrir);

		JSeparator separator = new JSeparator();
		mnArquivo.add(separator);

		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mnArquivo.add(mntmFechar);

		JMenuItem mntmFecharTodos = new JMenuItem("Fechar Todos");
		mnArquivo.add(mntmFecharTodos);

		JSeparator separator_2 = new JSeparator();
		mnArquivo.add(separator_2);

		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mnArquivo.add(mntmSalvar);

		JMenuItem mntmSalvarTodos = new JMenuItem("Salvar Todos");
		mnArquivo.add(mntmSalvarTodos);

		JSeparator separator_1 = new JSeparator();
		mnArquivo.add(separator_1);

		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mnArquivo.add(mntmImprimir);

		JSeparator separator_3 = new JSeparator();
		mnArquivo.add(separator_3);

		JMenuItem mntmImportar = new JMenuItem("Importar");
		mnArquivo.add(mntmImportar);

		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mnArquivo.add(mntmExportar);

		JSeparator separator_4 = new JSeparator();
		mnArquivo.add(separator_4);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);

		JMenu mnEmpresas = new JMenu("Empresas");
		add(mnEmpresas);

		JMenu mnOrdenarArvore = new JMenu("Ordenar \u00C1rvore");
		mnEmpresas.add(mnOrdenarArvore);

		JMenuItem mntmPorCodigoCvm = new JMenuItem("Codigo CVM");
		mnOrdenarArvore.add(mntmPorCodigoCvm);

		JMenuItem mntmRazaoSocial = new JMenuItem("Raz\u00E3o Social");
		mnOrdenarArvore.add(mntmRazaoSocial);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		add(mnRelatorios);

		JMenu mnAnalisar = new JMenu("Analisar");
		mnRelatorios.add(mnAnalisar);

		JMenu mnIndicadores = new JMenu("Indicadores");
		mnAnalisar.add(mnIndicadores);

		JMenuItem mntmPrazos = new JMenuItem("Prazos");
		mnIndicadores.add(mntmPrazos);

		JMenuItem mntmGiros = new JMenuItem("Giros");
		mnIndicadores.add(mntmGiros);

		JMenu mnCvm = new JMenu("CVM");
		add(mnCvm);

		JMenuItem mntmEmpresasListadas = new JMenuItem("Empresas Listadas");
		mnCvm.add(mntmEmpresasListadas);

		JMenuItem mntmProcurarEmpresa = new JMenuItem("Procurar Empresa");
		mnCvm.add(mntmProcurarEmpresa);

		JMenu mnAjuda = new JMenu("Ajuda");
		add(mnAjuda);

		JMenuItem mntmTopicosDeAjuda = new JMenuItem("T\u00F3picos de Ajuda");
		mnAjuda.add(mntmTopicosDeAjuda);

		JMenuItem mntmVerificarAtualizacoes = new JMenuItem(
				"Verificar Atualiza\u00E7\u00F5es");
		mnAjuda.add(mntmVerificarAtualizacoes);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
	}
	
	
	

}
