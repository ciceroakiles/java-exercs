package view;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		// Tamanho configuravel
		int size = 1000;
		int[] vetor = new int[size];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 100) + 1;
			//System.out.print(i + " ");
		}
		ThreadVetor th1 = new ThreadVetor(1, vetor);
		ThreadVetor th2 = new ThreadVetor(2, vetor);
		th1.start();
		th2.start();
	}

}
