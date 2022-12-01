package view;

import controller.ThreadNum;

public class Principal {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			ThreadNum t = new ThreadNum();
			t.start();
		}
	}

}
