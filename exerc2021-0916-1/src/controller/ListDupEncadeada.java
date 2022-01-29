package controller;

import model.Pessoa;

public class ListDupEncadeada {
	// Atributos
	private int indice;
	private int qtde;
	private Pessoa anterior;
	private Pessoa proximo;
	
	// Construtor
	public ListDupEncadeada(int i) {
		this.indice = i;
	}
	
	// Alguns getters
	public int getIndice() {
		return this.indice;
	}
	
	public int getQtde() {
		return this.qtde;
	}
	
	// Outros métodos
	public void adicionar(Pessoa p) {
		if (anterior == null) {
			// Insere o primeiro
			anterior = p;
		} else if (proximo == null) {
			// Insere o segundo
			proximo = p;
			anterior.setProximo(p);
			proximo.setAnterior(anterior);
			proximo.setProximo(null);
		} else {
			// Insere qualquer um a partir do segundo
			Pessoa temp = anterior;
			while (temp.getProximo() != null) {
				temp = temp.getProximo();
			}
			temp.setProximo(p);
			p.setAnterior(temp);
			proximo = p;
		}
		qtde++;
	}
	
	public boolean pesquisaNome(String nome) {
		Pessoa temp = anterior;
		while (temp != null) {
	        if (temp.getNome().toUpperCase().equals(nome.toUpperCase())) {
	            // Encontrado
	            return true;
	        }
	        // Passa para o proximo
	        temp = temp.getProximo();
	    }
	    // Nao encontrado
	    return false;
    }
	
	public boolean excluir(String nome) {
		// Para a exclusao, primeiro o nome deve estar presente
		if (pesquisaNome(nome)) {
			Pessoa temp = anterior;
			while (temp != null) {
				// Percorre ate achar um nome igual
				if (temp.getNome().equals(nome)) {
					if (temp.getAnterior() == null) {
						// Caso 1: exclusao do primeiro
						anterior = temp.getProximo();
						if (getQtde() > 1) temp.getProximo().setAnterior(null);
					} else {
						if (temp.getProximo() == null) {
							// Caso 3: exclusao do ultimo
							temp.getAnterior().setProximo(null);
						} else {
							// Caso 2: exclusao do meio
							temp.getProximo().setAnterior(temp.getAnterior());
							temp.getAnterior().setProximo(temp.getProximo());
						}
					}
					// Menos um no total
					qtde--;
					return true;
				}
				// Proximo elemento
				temp = temp.getProximo();
			}
		}
		return false;
	}
	
	public boolean estaVazia() {
        return (getQtde() == 0);
    }
	
	public void imprimir() {
		Pessoa temp = anterior;
		while (temp != null) {
			System.out.println(temp.getNome());
			temp = temp.getProximo();
		}
	}
}
