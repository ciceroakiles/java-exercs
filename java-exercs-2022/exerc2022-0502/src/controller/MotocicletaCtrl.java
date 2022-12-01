package controller;

import model.Motocicleta;

public class MotocicletaCtrl extends _VeiculoCtrl {

	public static Motocicleta initMotocicleta(
			String placa, String marca, String modelo, String cor, int velMaxima,
			int cilindradas) {
		Motocicleta m = new Motocicleta(initVeiculo(placa, marca, modelo, cor, velMaxima));
		m.setCilindradas(cilindradas);
		return m;
	}
}
