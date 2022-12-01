package controller;

import model.Funcionario;

public class FaixaSalarial2 implements _ICalculoINSS {

	@Override
	public float calculaINSS(Funcionario f, float v) {
		if (f.getSalario() > 1212) {
			if (f.getSalario() < 2427.35) {
				v += (float) ((f.getSalario() - 1212) * 0.09);
			} else {
				v += (float) ((2427.35 - 1212) * 0.09);
			}
		}
		return v;
	}

	@Override
	public void proximoCalculo(Funcionario f, float v) {
		float valor = calculaINSS(f, v);
		
		FaixaSalarial3 fsl3 = new FaixaSalarial3();
		fsl3.proximoCalculo(f, valor);
	}

}
