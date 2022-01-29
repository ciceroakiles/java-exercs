package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rcont = new RedesController();
		String input = "";
		int op = -1;
		do {
			input = JOptionPane.showInputDialog(
				"Opcoes:\n"
				+ "1 - ip\n"
				+ "2 - ping\n"
				+ "3 - Finalizar"
			);
			try {
				op = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				op = -1;
			}
			switch (op) {
				case 1: {
					rcont.ip();
				} break;
				case 2: {
					rcont.ping();
				} break;
			}
		} while (op != 3); 
	}

}
