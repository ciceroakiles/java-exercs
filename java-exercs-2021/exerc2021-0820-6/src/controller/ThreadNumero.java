package controller;

import javax.swing.JTextField;

public class ThreadNumero extends Thread {

	private JTextField t;
	
	public ThreadNumero(JTextField t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		alteraNumero();
	}
	
	private void alteraNumero() {
		// So pra ver os numeros girando mesmo.
		int delay = 50;
		int giros = (int) (Math.random() * 150) + 1;
		try {
			for (int i = 1; i <= giros; i++) {
				//System.out.println((int) (Math.random() * 7) + 1);
				t.setText(Integer.toString((int) (Math.random() * 7) + 1));
				sleep(delay);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
