package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	
	private Semaphore sig;
	private int id;
	private double distPercorrida;
	private double distMax;
	
	public ThreadPessoa(int id, int dm, Semaphore semaforo) {
		this.id = id;
		this.distMax = dm;
		this.sig = semaforo;
		this.distPercorrida = 0;
	}
	
	@Override
	public void run() {
		action();
		// Tempo de espera (1000 a 2000ms)
		int tempoPorta = (int) Math.random() * 1001 + 1000;
		try {
			// Secao critica
			sig.acquire();
			sleep(tempoPorta);
			System.out.println("Corredor " + id + " cruzou a porta");
			// Fim da secao critica
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sig.release();
		}
	}
	
	private void action() {
		while (distPercorrida < distMax) {
			// Percorrer de 4 a 6 m
			double x = Math.random() * 2 + 4;
			distPercorrida += (int)x;
			System.out.printf("Corredor %d percorreu %.2fm - total: %.0fm\n", id, x, distPercorrida);
		}
	}
}
