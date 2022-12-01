package controller.strategy;

import controller._MovimentacaoCtrl;
import model._Veiculo;
import model.Caminhao;

public class CaminhaoMov implements _Strategy {

	@Override
	public void movimentacaoVeiculo(_Veiculo v) {
		if (v instanceof Caminhao) {
			System.out.println(
				_MovimentacaoCtrl.gerarRandom(1000, 3000) + " - " +
				_MovimentacaoCtrl.gerarRandom(500, 3000) + " - " +
				_MovimentacaoCtrl.gerarRandom(2000, 5000)
			);
		}
	}
}
