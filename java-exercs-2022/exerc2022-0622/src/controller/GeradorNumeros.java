package controller;

import java.util.Random;

import controller.iface.IObservavel;

public class GeradorNumeros implements IObservavel {

	private ClasseObservadora cl;
	
	public GeradorNumeros(ClasseObservadora cl) {
		this.cl = cl;
	}
	
	@Override
	public void notificacao(int num) {
		cl.update(num);
	}
	
	public void gerarNumero() {
		Random r = new Random();
		int n = r.nextInt(1001);
		notificacao(n);
	}
}
