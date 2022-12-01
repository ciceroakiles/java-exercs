package controller;

public class FilaCircular {
	
    private int ini; 
	private int fim;
	private Object[] vetor;
	
	// Cria a fila
	public FilaCircular(int tam) {
		this.vetor = new Object[tam];
		this.ini = 0;
		this.fim = 0;
	}
	
	public void enfileira(Object obj) {
		if (!cheia()) {
			fim++;
			if (fim == vetor.length) fim = ini;
			vetor[fim] = obj;
		} else {
			System.out.println("Erro: a fila ja esta cheia");
		}
	}
	
	public Object desenfileira() {
		// Primeiro elemento sempre esta apos o ini
		Object res = vetor[ini+1];
		boolean estavaCheia = false;
		if (cheia()) {
			fim = vetor.length-1;
			estavaCheia = true;
		}
		for (int i = ini+1; i < fim; i++) {
			if (vetor[i+1] != null) vetor[i] = vetor[i+1];
		}
		if (estavaCheia) {
			// Move o elemento da posicao ini para o final (na direita)
			vetor[fim] = vetor[ini];
			vetor[ini] = null;
		} else {
			vetor[fim] = null;
			fim--;
		}
		return res;
	}
	
	public Object cabeca() {
		return vetor[ini+1];
	}
	
	public Object cauda() {
		return vetor[fim];
	}
	
	public boolean vazia() {
		return (vetor[ini+1] == null);
	}
	
	// Checa se fim e ini coincidem (sem valor nulo em ini)
	public boolean cheia() {
		return (ini == fim && vetor[ini] != null);
	}
	
	public void mostrarFila() {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {
				System.out.print(vetor[i].toString() + " ");
			}
		}
		System.out.println();
	}
	
	public boolean pesquisa(Object obj) {
		boolean found = false;
		for (int i = ini+1; i < vetor.length; i++) {
			if (vetor[i].equals(obj)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public int tamanho() {
		return (ini != fim ? (fim-ini) : vetor.length);
	}
}
