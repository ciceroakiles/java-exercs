package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarro;
import model.Carro;
import model.Grid;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// Nomes das escuderias
		String nomesEsc[] = {"Ferrari", "Mercedes", "McLaren", "Red Bull", "Williams", "Lotus", "Force India"};
		// Um semaforo para cada equipe e um para a pista
		Semaphore semaforosEsc[] = new Semaphore[nomesEsc.length];
		Semaphore semaforoPista = new Semaphore(5);
		// Cria os carros e as threads
		for (int i = 0; i < nomesEsc.length; i++) {
			semaforosEsc[i] = new Semaphore(1);
			for (int j = 1; j <= 2; j++) {
				Carro c = new Carro(nomesEsc[i], j);
				ThreadCarro tc = new ThreadCarro(c, semaforosEsc[i], semaforoPista);
				tc.start();
			}
		}
		// Espera antes de exibir as posicoes
		Thread.sleep(10000);
		System.out.println();
		int pos = 1;
		for (Carro c : Grid.getGrid()) {
			System.out.println(pos + " - " + c.toString());
			pos++;
		}
	}

}
