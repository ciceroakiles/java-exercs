package view;

import java.util.concurrent.Semaphore;
import controller.ThreadComprador;

public class Principal {
	// Capacidade
	private static int total = 100;

	public static int getTotal() {
		return total;
	}
	
	public static void diminuiTotal(int n) {
		total -= n;
	}
	
	public static void main(String[] args) {
		// Um por vez
		Semaphore sinal = new Semaphore(1);
		for (int i = 0; i < 300; i++) {
			ThreadComprador tc = new ThreadComprador(i+1, ((int)(Math.random()*4)+1), sinal);
			tc.start();
		}
	}

}
