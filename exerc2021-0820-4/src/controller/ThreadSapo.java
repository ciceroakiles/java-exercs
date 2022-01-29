package controller;

public class ThreadSapo extends Thread {
	// Numero para identificar, dist. inicial e dist. maxima
	private int num;
	private int dist;
	private int lim;
	
	public ThreadSapo(int num) {
		this.num = num;
		this.dist = 0;
		this.lim = ThreadCorrida.getLimit();
	}
	
	@Override
	public void run() {
		jump();
	}
	
	private void jump() {
		while (dist < lim) {
			int s = (int) (Math.random() * 10);
			dist += s;
			System.out.println("Sapo " + num + " saltou " + s + "m (Total = " + dist + "m)");
		}
		System.out.println("Sapo " + num + " chegou >>> Lugar: " + ThreadCorrida.finish());
	}
}
