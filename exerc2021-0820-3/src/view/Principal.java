package view;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		// Linhas e colunas
		int l = 3, c = 5;
		int[][] matriz = new int[l][c];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				// Inserindo numeros aleatorios
				matriz[i][j] = (int) (Math.random() * 10);
			}
		}
		/*
		// Impressao para testes
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		*/
		// Coletando valores para as threads
		for (int i = 0; i < l; i++) {
			int[] temp = new int[c];
			for (int j = 0; j < c; j++) {
				temp[j] = matriz[i][j];
			}
			ThreadVetor thr = new ThreadVetor(i, temp);
			thr.start();
		}
	}

}
