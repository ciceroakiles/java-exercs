package controller;

import model.Pessoa;

public class VetorListas {

	private ListDupEncadeada[] listas;
	
	public VetorListas(int tamanho) {
		// Padrao de 26 listas, com letras do indice 0 ao 25, e inicializacao de cada uma
		this.listas = new ListDupEncadeada[tamanho];
		for (int i = 0; i < tamanho; i++) {
			this.listas[i] = new ListDupEncadeada(i);
		}
	}
	
	public void adicionar(Pessoa p) {
		// Adiciona elemento em indice determinado pelo nome
		this.listas[Pessoa.indice(p.getNome())].adicionar(p);
	}
	
	public boolean pesquisar(String nome) {
		// Pesquisa feita em lista de indice determinado pelo nome
		return this.listas[Pessoa.indice(nome)].pesquisaNome(nome);
	}
	
	public boolean excluir(String nome) {
		// Exclusao de acordo com o indice
		return this.listas[Pessoa.indice(nome)].excluir(nome);
	}
	
	public boolean renomear(String nome1, String nome2) {
		// Para a renomeacao, primeiro o nome1 precisa ter sido excluido
		if (excluir(nome1)) {
			Pessoa p = new Pessoa(nome2);
			adicionar(p);
			return true;
		}
		return false;
	}
	
	public boolean estaVazio() {
		for (ListDupEncadeada l : listas) {
			// Caso uma das listas tenha um elemento
			if (!l.estaVazia()) return false;
		}
		return true;
	}
	
	public int getTotal() {
		// Variavel para acumular quantidades
		int sum = 0;
		for (ListDupEncadeada l : listas) {
			sum += l.getQtde();
		}
		return sum;
	}
	
	public void imprimir() {
		for (ListDupEncadeada l : listas) {
			System.out.println("---- Imprimindo lista " + l.getIndice() + " (letra " + (char)(l.getIndice()+65) + ")");
			l.imprimir();
			System.out.println("---- Fim da lista " + l.getIndice());
		}
	}
}
