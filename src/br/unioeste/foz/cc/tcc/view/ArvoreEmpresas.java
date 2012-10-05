package br.unioeste.foz.cc.tcc.view;

import java.util.Calendar;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import br.unioeste.foz.cc.tcc.model.demonstracao.RelatorioAnual;
import br.unioeste.foz.cc.tcc.model.empresa.Empresa;

public class ArvoreEmpresas extends JTree {
	
	private static DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Empresas");
	
	public ArvoreEmpresas(){
		super(raiz);		 		
	}
	
	public void addEmpresa(Empresa empresa){
		DefaultMutableTreeNode emp = new DefaultMutableTreeNode(empresa.getNome());
		raiz.add(emp);
		
		for(RelatorioAnual ra : empresa.getRelatorios()){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ra.getFinalPeriodo());
			
			if(calendar.get(Calendar.YEAR) < 2010)
				continue;
			
			DefaultMutableTreeNode ano = new DefaultMutableTreeNode(calendar.get(Calendar.YEAR));
			emp.add(ano);
			
			DefaultMutableTreeNode df = new DefaultMutableTreeNode("Balanço Patrimonial");
			ano.add(df);
			df.add(new DefaultMutableTreeNode("Ativo"));
			df.add(new DefaultMutableTreeNode("Passivo"));

			ano.add(new DefaultMutableTreeNode("Demonstração de Resultado"));
		}
	}
	
	public void removeEmpresa(Empresa empresa){
		raiz.remove(new DefaultMutableTreeNode(empresa.getNome()));
	}
	
	public void expandirTodos(){
		 for (int i = 0; i < getRowCount(); i++) {
				 expandRow(i);
		 }
	}

}
