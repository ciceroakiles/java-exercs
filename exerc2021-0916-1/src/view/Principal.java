package view;

import controller.VetorListas;
import model.Pessoa;

public class Principal {
	
	public static void main(String[] args) {
		VetorListas vetor = new VetorListas(26);
		
		// Criacao
		Pessoa p1 = new Pessoa("Aline");
		Pessoa p2 = new Pessoa("Bia");
		Pessoa p3 = new Pessoa("Carla");
		Pessoa p4 = new Pessoa("Debora");
		Pessoa p5 = new Pessoa("Zaza");
		Pessoa p6 = new Pessoa("Amanda");
		Pessoa p7 = new Pessoa("Beatriz");
		Pessoa p8 = new Pessoa("Carlos");
		Pessoa p9 = new Pessoa("Zoraide");
		Pessoa p10 = new Pessoa("Ana");
		Pessoa p11 = new Pessoa("Cesar");
		Pessoa p12 = new Pessoa("Zuleika");
		Pessoa p13 = new Pessoa("Ananda");
		Pessoa p14 = new Pessoa("Cosme");
		
		//System.out.println("Vazio? " + vetor.estaVazio());
		
		// Insercao
		vetor.adicionar(p1);
		vetor.adicionar(p2);
		vetor.adicionar(p3);
		vetor.adicionar(p4);
		vetor.adicionar(p5);
		vetor.adicionar(p6);
		vetor.adicionar(p7);
		vetor.adicionar(p8);
		vetor.adicionar(p9);
		vetor.adicionar(p10);
		vetor.adicionar(p11);
		vetor.adicionar(p12);
		vetor.adicionar(p13);
		vetor.adicionar(p14);
		
		// Testes
		System.out.println("Vazio? " + vetor.estaVazio());
		System.out.println("Nomes: " + vetor.getTotal());
		System.out.println("Pesquisar: Barbosa => Encontrou? " + vetor.pesquisar("Barbosa"));
		System.out.println("Pesquisar: Zoraide => Encontrou? " + vetor.pesquisar("Zoraide"));
		System.out.println();
		
		System.out.println("Excluir: Barbara => Sucesso? " + vetor.excluir("Barbara"));
		System.out.println("Excluir: Ana => Sucesso? " + vetor.excluir("Ana"));
		System.out.println("Excluir: Aline => Sucesso? " + vetor.excluir("Aline"));
		System.out.println("Excluir: Cosme => Sucesso? " + vetor.excluir("Cosme"));
		System.out.println("Excluir: Aline => Sucesso? " + vetor.excluir("Aline"));
		System.out.println("Excluir: Zaza => Sucesso? " + vetor.excluir("Zaza"));
		System.out.println();
		
		System.out.println("Renomear: Alice->Alex => Sucesso? " + vetor.renomear("Alice", "Alex"));
		System.out.println("Renomear: Ananda->Alex => Sucesso? " + vetor.renomear("Ananda", "Alex"));
		System.out.println("Renomear: Carlos->Karlos => Sucesso? " + vetor.renomear("Carlos", "Karlos"));
		System.out.println();
		
		System.out.println("Nomes: " + vetor.getTotal());
		System.out.println();
		
		vetor.imprimir();
	}
}
