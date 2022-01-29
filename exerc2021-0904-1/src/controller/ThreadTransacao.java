package controller;

import java.util.concurrent.Semaphore;
import model.Conta;

public class ThreadTransacao extends Thread {

	private Conta conta;
	private double valor;
	private int tipo;
	private Semaphore sem;
	
	public ThreadTransacao(Conta conta, double valor, int tipo, Semaphore sem) {
		this.conta = conta;
		this.valor = valor;
		this.tipo = tipo;
		this.sem = sem;
	}
	
	@Override
	public void run() {
		try {
			// Inicia secao critica
			sem.acquire();
			action();
			// Finaliza secao critica
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sem.release();
		}
	}
	
	private void action() {
		delay(1000);
		conta.transacao(valor, tipo);
		System.out.println("T" + this.getId() + "> Tipo: " + tipoTransacao(tipo));
	}
	
	private void delay(int tempo) {
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private String tipoTransacao(int tipo) {
		switch (tipo) {
			case 0: return "Dep.";
			case 1: return "Saq.";
		}
		return "";
	}
}
