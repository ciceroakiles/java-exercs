package view;

import java.util.concurrent.Semaphore;
import controller.ThreadTransacao;
import model.Conta;

public class Principal {

	static Conta c1 = new Conta("C-139", 5000);
	static Conta c2 = new Conta("C-137", 6000);
	
	public static void main(String[] args) {
		// Definindo um semaforo para cada tipo de operacao
		Semaphore depositosSmp = new Semaphore(1);
		Semaphore saquesSmp = new Semaphore(1);
		// Criando as vinte threads
		for (int i = 0; i < 5; i++) {
			ThreadTransacao ttr1 = new ThreadTransacao(c1, 200, 0, depositosSmp);
			ttr1.start();
		}
		for (int i = 0; i < 5; i++) {
			ThreadTransacao ttr2 = new ThreadTransacao(c2, 150, 1, saquesSmp);
			ttr2.start();
		}
		for (int i = 0; i < 5; i++) {
			ThreadTransacao ttr3 = new ThreadTransacao(c1, 200, 1, saquesSmp);
			ttr3.start();
		}
		for (int i = 0; i < 5; i++) {
			ThreadTransacao ttr4 = new ThreadTransacao(c2, 150, 0, depositosSmp);
			ttr4.start();
		}
	}

}
