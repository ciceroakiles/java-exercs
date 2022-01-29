package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.Janela;

public class Listener {

	public static void addClick(JButton btn) {
		// Verificacao de clique
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Chama outro controller
				if (e.getSource() == btn) {
					//System.out.println("Clicou no botao");
					btn.getParent().setVisible(false);
					ThreadNumero t1 = new ThreadNumero(Janela.getN1());
					t1.start();
					ThreadNumero t2 = new ThreadNumero(Janela.getN2());
					t2.start();
					ThreadNumero t3 = new ThreadNumero(Janela.getN3());
					t3.start();
				}
			}
		});
	}
}
