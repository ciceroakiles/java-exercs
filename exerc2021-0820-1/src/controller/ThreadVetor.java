package controller;

import java.math.BigDecimal;

public class ThreadVetor extends Thread {
	
	private int num;
	private int[] vet;
	
	public ThreadVetor(int num, int[] vetor) {
		this.num = num;
		this.vet = vetor;
	}
	
	@Override
	public void run() {
		calcTempo();
	}
	
	private void calcTempo() {
		double t1, t2;
		if (num % 2 == 0) {
			// Par: laço for
			t1 = System.nanoTime();
			for (int i = 0; i < vet.length; i++) {
				vet[i]++;
				//System.out.print(vet[i] + " ");
			}
			t2 = System.nanoTime();
		} else {
			// Ímpar: foreach
			t1 = System.nanoTime();
			for (int i : vet) {
				i++;
				//System.out.print(i + " ");
			}
			t2 = System.nanoTime();
		}
		System.out.println(
			((num % 2 == 0) ? "(Par)" : "(Ímpar)")
			+ " Tempo: "
			+ BigDecimal.valueOf((t2-t1)/Math.pow(10, 9)) + " s"
		);
	}
}
