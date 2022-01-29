package controller;

import java.util.concurrent.Semaphore;
import view.Principal;

public class ThreadComprador extends Thread {

	private int id;
	private int tickets;
	private Semaphore smp;
	
	public ThreadComprador(int id, int tickets, Semaphore smp) {
		this.id = id;
		this.tickets = tickets;
		this.smp = smp;
	}
	
	@Override
	public void run() {
		//System.out.println("Cliente " + id + " deseja comprar " + tickets + " ingressos");
		if (Principal.getTotal() > 0) {
			if (esperas()) {
				try {
					smp.acquire();
					// Inicio da secao critica
					validacao();
					// Fim da secao critica
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					smp.release();
				}
			}
		}
	}
	
	private boolean esperas() {
		// Passo 1 - Login - De 50 a 2000ms
		int tempo = (int) (Math.random() * 1951) + 50; 		//System.out.println("Cliente " + id + " demorou " + tempo + "ms (login)");
		esperaReal(tempo);
		if (tempo < 1000) {
			// Passo 2 - Processo de compra - De 1000 a 3000ms
			tempo = (int) (Math.random() * 2001) + 1000; 	//System.out.println("Cliente " + id + " demorou " + tempo + "ms (sessao)");
			esperaReal(tempo);
			if (tempo < 2500) return true; 			//else System.out.println("(-) Cliente " + id + " recebeu um timeout (sessao)");
		} 							//else System.out.println("(-) Cliente " + id + " recebeu um timeout (login)");
		return false;
	}
	
	private void esperaReal(int t) {
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Passo 3 - Validacao da compra
	private void validacao() {
		if (tickets <= Principal.getTotal()) {
			Principal.diminuiTotal(tickets);
			System.out.println("($) Cliente " + id + " comprou " + tickets + " ingresso(s) - Restantes: " + Principal.getTotal());
		} else if (Principal.getTotal() != 0) {
			System.out.println("(!) Cliente " + id + " pediu " + tickets + " ingresso(s) - Restantes: " + Principal.getTotal());
		}
	}
}
