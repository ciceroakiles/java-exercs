package controller;

import model.Funcionario;
import view.Principal;

public class FaixaSalarial4 implements _ICalculoINSS {

	@Override
	public float calculaINSS(Funcionario f, float v) {
		if (f.getSalario() > 3641.03) {
			if (f.getSalario() < 7087.22) {
				v += (float) ((f.getSalario() - 3641.03) * 0.14);
			} else {
				v += (float) ((7087.22 - 3641.03) * 0.14);
			}
		}
		return v;
	}

	@Override
	public void proximoCalculo(Funcionario f, float v) {
		float valor = calculaINSS(f, v);
		
		System.out.println("Total a recolher: " + valor);
		
		f.setSalario(f.getSalario() - valor);
		Principal.fDao.alterar(f);
		System.out.println("Valor descontado do salario.");
	}

}
