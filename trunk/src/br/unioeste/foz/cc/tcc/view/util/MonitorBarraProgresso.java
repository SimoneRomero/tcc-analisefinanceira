package br.unioeste.foz.cc.tcc.view.util;

public class MonitorBarraProgresso extends Thread {
	
	private BarraProgresso barraProgresso;
	
	public MonitorBarraProgresso(BarraProgresso barraProgresso) {
		this.barraProgresso = barraProgresso;
	}
	
	public void run(){
		barraProgresso.setStart();
	}
	
	public void interrupt(){
		barraProgresso.setFinish();
	}

}
