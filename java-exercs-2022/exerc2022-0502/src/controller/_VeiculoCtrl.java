package controller;

import model._Veiculo;

public class _VeiculoCtrl {

	public static _Veiculo initVeiculo(
			String placa, String marca,
			String modelo, String cor,
			int velMaxima) {
		_Veiculo v = new _Veiculo();
		v.setPlaca(placa);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setCor(cor);
		v.setVelMaxima(velMaxima);
		return v;
	}
}
