package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import model.Carro;
import model.Grid;

public class ThreadCarro extends Thread {

	private Carro carro;
	private Semaphore smpEquipe;
	private Semaphore smpPista;
	private List<Integer> voltas;
	
	public ThreadCarro(Carro carro, Semaphore smp1, Semaphore smp2) {
		this.carro = carro;
		this.smpEquipe = smp1;
		this.smpPista = smp2;
		this.voltas = new ArrayList<>();
	}
	
	@Override
	public void run() {
		try {
			smpEquipe.acquire();
			segundoSemaforo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smpEquipe.release();
		}
	}
	
	private void segundoSemaforo() {
		try {
			smpPista.acquire();
			action();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smpPista.release();
		}
	}
	
	private void action() {
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			// 500 a 1000ms
			voltas.add((r.nextInt(501) + 500));
			delay(voltas.get(i));
		}
		// Envia melhor tempo para o objeto, e o objeto para o grid 
		carro.setMelhorTempo(Collections.min(voltas));
		Grid.addItem(carro);
		// Saida: numero, escuderia, tempos das voltas
		System.out.printf("Carro %d da %s: v1=%ds, v2=%ds, v3=%ds\n", carro.getNumero(), carro.getEscuderia(), voltas.get(0), voltas.get(1), voltas.get(2));
	}
	
	private void delay(int tempo) {
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
