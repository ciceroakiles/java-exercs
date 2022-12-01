package view;

import controller.PilhaDupla;

public class Principal {

	public static void main(String[] args) {
		PilhaDupla p = new PilhaDupla(6);
		//System.out.println(p.vaziaA());
		//System.out.println(p.vaziaB());
		p.empilhaA("0");
		p.desempilhaA();
		p.empilhaA("1");
		p.empilhaA("2");
		//p.empilhaA("5");
		//p.empilhaA("6");
		//System.out.println(p.vaziaA());
		//System.out.println(p.topoA());
		p.mostrarPilhaA();
		p.empilhaB("7");
		//System.out.println(p.vaziaB());
		p.desempilhaB();
		p.empilhaB("3");
		//System.out.println(p.topoB());
		p.empilhaB("4");
		//p.empilhaB("8");
		//p.empilhaB("9");
		p.mostrarPilhaB();
		//System.out.println(p.tamanhoA());
		//System.out.println(p.tamanhoB());
		//System.out.println(p.cheiaA());
		//System.out.println(p.cheiaB());
	}

}
