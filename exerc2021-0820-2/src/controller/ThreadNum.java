package controller;

public class ThreadNum extends Thread {
	
	public ThreadNum() {
		super();
	}
	
	@Override
	public void run() {
		showId();
	}
	
	private void showId() {
		System.out.println("TID #" + getId());
	}
}
