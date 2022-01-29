package controller;

import view.Janela;
import view.Retangulo;

public class ThreadCarro extends Thread {
	
	private int dist;
	private int vmax;
	private String name;
	private Retangulo rect;
	
	public ThreadCarro(String name, Retangulo r) {
		this.dist = 5;
		this.vmax = 40;
		this.name = name;
		this.rect = r;
	}
	
	@Override
	public void run() {
		testDrive();
	}
	
	private void testDrive() {
		try {
			while (dist < 600) {
				int v = (int) (Math.random() * vmax);
				// Espera de 100ms e arranque
				sleep(100);
				dist += v;
				rect.setX(dist);
				//System.out.println(name + ": " + dist);
			}
			//System.out.println(name + " chegou no fim da pista");
			Janela.addToBuffer(name + "\n");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
