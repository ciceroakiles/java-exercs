package controller;

import java.util.List;
import java.util.Random;

public class ThreadInstance extends Thread {

	private int id;
	private List<String> arquivoLido;
	
	public ThreadInstance(int id, List<String> list) {
		this.id = id;
		this.arquivoLido = list;
	}
	
	@Override
	public void run() {
		exec();
	}
	
	private void exec() {
		Random r = new Random();
		int randomIndex = r.nextInt(arquivoLido.size());
		int port = Integer.parseInt(arquivoLido.get(randomIndex));
		System.out.println("#T" + id + " -> " + port);
	}
}
