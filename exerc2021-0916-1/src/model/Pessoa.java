package model;

public class Pessoa {
	// Atributos
	private String nome;
	private Pessoa ant;
	private Pessoa prox;

	// Construtor
	public Pessoa(String s) {
		this.nome = s;
	}
	
	// Retorna o indice (i recebe um valor de acordo com a tabela ASCII)
	public static int indice(String nome) {
		int i = nome.toUpperCase().charAt(0)-65;
		return i;
	}
	
	// Alguns getters e setters
	public Pessoa getAnterior() {
		return ant;
	}

	public void setAnterior(Pessoa ant) {
		this.ant = ant;
	}

	public Pessoa getProximo() {
		return prox;
	}

	public void setProximo(Pessoa prox) {
		this.prox = prox;
	}
	
	public String getNome() {
		return this.nome;
	}
}
