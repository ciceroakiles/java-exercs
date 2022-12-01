package controller;

import model.Funcionario;

public class FaixaSalarial1 implements _ICalculoINSS {

	@Override
	public float calculaINSS(Funcionario f, float v) {
		v += (float) (1212 * 0.075);
		return v;
	}

	@Override
	public void proximoCalculo(Funcionario f, float v) {
		float valor = calculaINSS(f, v);
		
		FaixaSalarial2 fsl2 = new FaixaSalarial2();
		fsl2.proximoCalculo(f, valor);
	}

}
