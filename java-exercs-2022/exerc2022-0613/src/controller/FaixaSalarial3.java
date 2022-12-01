package controller;

import model.Funcionario;

public class FaixaSalarial3 implements _ICalculoINSS {

	@Override
	public float calculaINSS(Funcionario f, float v) {
		if (f.getSalario() > 2427.35) {
			if (f.getSalario() < 3641.03) {
				v += (float) ((f.getSalario() - 2427.35) * 0.12);
			} else {
				v += (float) ((3641.03 - 2427.35) * 0.12);
			}
		}
		return v;
	}

	@Override
	public void proximoCalculo(Funcionario f, float v) {
		float valor = calculaINSS(f, v);
		
		FaixaSalarial4 fsl4 = new FaixaSalarial4();
		fsl4.proximoCalculo(f, valor);
	}

}
