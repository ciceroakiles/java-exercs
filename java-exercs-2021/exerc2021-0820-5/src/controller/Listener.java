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
					ThreadCarro t1 = new ThreadCarro("Skyline (Azul)", Janela.getRetangulo1());
					t1.start();
					ThreadCarro t2 = new ThreadCarro("Firebird (Vermelho)", Janela.getRetangulo2());
					t2.start();
				}
			}
		});
	}
}
