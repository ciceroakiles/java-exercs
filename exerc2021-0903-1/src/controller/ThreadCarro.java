package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private Semaphore sinal;
	private int direcao;
	
	public ThreadCarro(int d, Semaphore s) {
		this.direcao = d;
		this.sinal = s;
	}
	
	@Override
	public void run() {
		try {
			// Secao critica abaixo
			sinal.acquire();
			System.out.print("Carro passando... - direcao: " + direcao);
			sleep(1000);
			System.out.println(" - passou");
			// Secao critica acima
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sinal.release();
		}
	}
}
