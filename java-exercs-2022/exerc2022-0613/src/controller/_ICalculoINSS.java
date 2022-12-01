package controller;

import model.Funcionario;

public interface _ICalculoINSS {

	public float calculaINSS(Funcionario f, float v);
	
	public void proximoCalculo(Funcionario f, float v);
}
