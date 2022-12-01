package controller;

import controller.iface.IObservador;

public class ClasseObservadora implements IObservador {

	@Override
	public void update(int num) {
		if (num % 2 == 0) {
			System.out.println("Gerado numero par");
		} else {
			System.out.println("Gerado numero impar");
		}
	}
}
