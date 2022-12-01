package controller;

import model.Automovel;

public class AutomovelCtrl extends _VeiculoCtrl {

	public static Automovel initAutomovel(
			String placa, String marca, String modelo, String cor, int velMaxima,
			int numPortas, int ano) {
		Automovel a = new Automovel(initVeiculo(placa, marca, modelo, cor, velMaxima));
		a.setNumPortas(numPortas);
		a.setAno(ano);
		return a;
	}
}
