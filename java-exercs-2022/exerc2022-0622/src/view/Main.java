package view;

import controller.ClasseObservadora;
import controller.GeradorNumeros;

public class Main {

	public static void main(String[] args) {
		ClasseObservadora c = new ClasseObservadora();
		GeradorNumeros g = new GeradorNumeros(c);
		
		for (int i = 0; i < 10; i++) {
			g.gerarNumero();
		}
	}
}
