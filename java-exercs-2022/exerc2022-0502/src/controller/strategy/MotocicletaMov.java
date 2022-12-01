package controller.strategy;

import controller._MovimentacaoCtrl;
import model._Veiculo;
import model.Motocicleta;

public class MotocicletaMov implements _Strategy {

	@Override
	public void movimentacaoVeiculo(_Veiculo v) {
		if (v instanceof Motocicleta) {
			System.out.println(
				_MovimentacaoCtrl.gerarRandom(20, 100) + " - " +
				_MovimentacaoCtrl.gerarRandom(30, 80)
			);
		}
	}
}
