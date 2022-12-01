package controller;

import model.Caminhao;

public class CaminhaoCtrl extends _VeiculoCtrl {

	public static Caminhao initCaminhao(
			String placa, String marca, String modelo, String cor, int velMaxima,
			int qtdeEixos, int cargaMax) {
		Caminhao c = new Caminhao(initVeiculo(placa, marca, modelo, cor, velMaxima));
		c.setQtdeEixos(qtdeEixos);
		c.setCargaMax(cargaMax);
		return c;
	}
}
