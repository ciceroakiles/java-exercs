package view;

import java.io.IOException;
import java.time.Month;
import controller.SteamController;

public class Principal {

	private static String converterMes(int mes) {
		return Month.of(mes).name();
	}
	
	public static void main(String[] args) {
		try {
			SteamController.imprimirDados("2020", converterMes(11), 50000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
