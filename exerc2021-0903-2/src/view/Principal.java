package view;

import java.util.concurrent.Semaphore;
import controller.ThreadPessoa;

public class Principal {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		for (int i = 1; i < 5; i++) {
			ThreadPessoa corredor = new ThreadPessoa(i, 200, sem);
			corredor.start();
		}
	}

}
