package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		Semaphore smp = new Semaphore(1);
		for (int i = 1; i < 5; i++) {
			ThreadCarro tc = new ThreadCarro(i, smp);
			tc.start();
		}
	}

}
