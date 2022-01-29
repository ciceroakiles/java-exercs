package controller;

public class ThreadVetor extends Thread {
	
	private int num;
	private int[] vet;
	
	public ThreadVetor(int num, int[] vetor) {
		this.num = num;
		this.vet = vetor;
	}

	@Override
	public void run() {
		calcSum();
	}
	
	private void calcSum() {
		int sum = 0;
		for (int i = 0; i < vet.length; i++) {
			sum += vet[i];
		}
		System.out.println("Linha " + num + ": soma = " + sum);
	}
}
