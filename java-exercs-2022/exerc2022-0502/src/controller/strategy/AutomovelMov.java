package controller.strategy;

import controller._MovimentacaoCtrl;
import model._Veiculo;
import model.Automovel;

public class AutomovelMov implements _Strategy {

	@Override
	public void movimentacaoVeiculo(_Veiculo v) {
		if (v instanceof Automovel) {
			System.out.println(
				_MovimentacaoCtrl.gerarRandom(10, 30) + " - " +
				_MovimentacaoCtrl.gerarRandom(50, 650) + " - " +
				_MovimentacaoCtrl.gerarRandom(1, 4)
			);
		}
	}
}
