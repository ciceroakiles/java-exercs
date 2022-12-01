package view;

import controller.AutomovelCtrl;
import controller.CaminhaoCtrl;
import controller.MotocicletaCtrl;
import controller._MovimentacaoCtrl;
import controller.strategy.AutomovelMov;
import controller.strategy.CaminhaoMov;
import controller.strategy.MotocicletaMov;
import model.Automovel;
import model.Caminhao;
import model.Motocicleta;

public class Main {

	public static void main(String[] args) {
		Automovel a = new AutomovelCtrl()
			.initAutomovel(
				"ABC-1234", "VW", "Fusca", "Preto", 200, 2, 1960
			);
		Caminhao c = new CaminhaoCtrl()
			.initCaminhao(
				"DEF-2345", "Volvo", "V-4500", "Branco", 180, 4, 3500
			);
		Motocicleta m = new MotocicletaCtrl()
			.initMotocicleta(
				"GHI-3456", "Honda", "CB200", "Azul", 220, 200
			);
		
		_MovimentacaoCtrl.inicioMovimentacao(a);
		_MovimentacaoCtrl.movimentacaoVeiculo(a, new AutomovelMov());
		System.out.println();
		_MovimentacaoCtrl.inicioMovimentacao(c);
		_MovimentacaoCtrl.movimentacaoVeiculo(c, new CaminhaoMov());
		System.out.println();
		_MovimentacaoCtrl.inicioMovimentacao(m);
		_MovimentacaoCtrl.movimentacaoVeiculo(m, new MotocicletaMov());
	}
}
