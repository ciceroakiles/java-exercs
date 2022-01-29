package view;

import controller.ThreadCorrida;

public class Principal {

	public static void main(String[] args) {
		// Cria corrida com um argumento de distancia
		ThreadCorrida th = new ThreadCorrida(100);
		th.start();
	}

}
