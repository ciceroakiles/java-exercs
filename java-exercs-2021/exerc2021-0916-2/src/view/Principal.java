package view;

import controller.FilaCircular;

public class Principal {

	public static void main(String[] args) {
		FilaCircular f = new FilaCircular(4);
		
		System.out.println("Fila cheia? " + f.cheia());
		System.out.println("Fila vazia? " + f.vazia());
		
		f.enfileira("1");
		f.mostrarFila();
		f.enfileira("2");
		f.mostrarFila();
		f.enfileira("3");
		f.mostrarFila();
		
		f.enfileira("4");
		f.mostrarFila();
		System.out.println("Fila cheia? " + f.cheia());
		f.enfileira("5");
		
		System.out.println("> Remove: " + f.desenfileira());
		f.mostrarFila();
		System.out.println("> Remove: " + f.desenfileira());
		f.mostrarFila();
		System.out.println("> Remove: " + f.desenfileira());
		f.mostrarFila();
		System.out.println("> Remove: " + f.desenfileira());
		f.mostrarFila();
		
		System.out.println("Fila vazia? " + f.vazia());
	}

}
