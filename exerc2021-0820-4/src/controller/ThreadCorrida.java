package controller;

public class ThreadCorrida extends Thread {

	private static int pos;
	private static int lim;
	
	public ThreadCorrida(int lim) {
		this.lim = lim;
	}
	
	public static int getLimit() {
		return lim;
	}
	
	@Override
	public void run() {
		criaCorrida();
	}
	
	// Posicoes
	public static synchronized int finish() {
		return ++pos;
	}
	
	private void criaCorrida() {
		// Quantidade configuravel
		int qtde = 5;
		for (int i = 1; i <= qtde; i++) {
			ThreadSapo th = new ThreadSapo(i);
			th.start();
		}
	}
}
