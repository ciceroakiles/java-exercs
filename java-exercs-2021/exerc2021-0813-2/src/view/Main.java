package view;

import java.util.Scanner;
import controller.KillController;

public class Main {

	public static void main(String[] args) {
		int op = -1;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("1 - Listar processos");
			System.out.println("2 - Matar um processo");
			System.out.println("3 - Finalizar");
			try {
				op = Integer.parseInt(s.nextLine());
			} catch (NumberFormatException e) {
				op = -1;
			}
			switch (op) {
				case 1: {
					KillController.listaProcessos();
				} break;
				case 2: {
					System.out.println("Nome ou pid do processo:");
					KillController.nomeOuPid(s.nextLine());
				} break;
			}
		} while (op != 3);
		s.close();
	}

}
