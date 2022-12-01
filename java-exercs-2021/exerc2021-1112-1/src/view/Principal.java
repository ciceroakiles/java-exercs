package view;

import java.io.IOException;
import controller.FifaController;

public class Principal {

	public static void main(String[] args) {
		final String PATH = "C:\\Temp";
		final String FILENAME = "data.csv";
		FifaController fc = new FifaController();
		try {
			// Operacoes com pilha
			fc.desempilhaBonsBrasileiros(fc.empilhaBrasileiros(PATH, FILENAME));
			System.out.println();
			// Operacoes com lista encadeada
			fc.buscaListaBonsJovens(fc.listaRevelacoes(PATH, FILENAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
