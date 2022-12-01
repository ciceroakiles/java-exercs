package controller;

import controller.strategy._Strategy;
import model._Veiculo;

public class _MovimentacaoCtrl {

	public static int gerarRandom(int menor, int maior) {
		return (int)((Math.random() * (maior-menor+1)) + menor);
	}
	
	public static void inicioMovimentacao(_Veiculo v) {
		System.out.println("Inicio mov.: " + v.toString());
	}
	
	public static void movimentacaoVeiculo(_Veiculo v, _Strategy strat) {
		strat.movimentacaoVeiculo(v);
	}
}
