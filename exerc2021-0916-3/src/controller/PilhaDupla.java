package controller;

public class PilhaDupla {
	// Atributos
	private Object[] vetor;
	private int topoA;
	private int topoB;
	
	// Construtor: seria o equivalente a criaPilha()
	public PilhaDupla(int tam) {
		this.vetor = new Object[tam];
		this.topoA = tam-1;
		this.topoB = 0;
	}
	
	// Empilhar em A: obj vai para o topo da pilha A, que tem inicio em tam-1, e atualiza topoA
	public void empilhaA(Object obj) {
		vetor[topoA] = obj;
		topoA--;
	}
	
	// Empilhar em B: obj vai para o topo da pilha B, que tem inicio em 0, e atualiza topoB
	public void empilhaB(Object obj) {
		vetor[topoB] = obj;
		topoB++;
	}
	
	// Checa se pilha A esta vazia, no caso, se o ultimo elemento do vetor corresponde a null
	public boolean vaziaA() {
		return (vetor[vetor.length-1] == null);
	}
	
	// Checa se pilha B esta vazia, no caso, se o primeiro elemento do vetor corresponde a null
	public boolean vaziaB() {
		return (vetor[0] == null);
	}
	
	// Desempilhar de A: atualiza topoA, recupera objeto em res antes de setar a posicao como null
	public Object desempilhaA() {
		topoA++;
		Object res = vetor[topoA];
		vetor[topoA] = null;
		return res;
	}
	
	// Desempilhar de B: atualiza topoB, recupera objeto em res antes de setar a posicao como null
	public Object desempilhaB() {
		topoB--;
		Object res = vetor[topoB];
		vetor[topoB] = null;
		return res;
	}
	
	// Checa se pilha A esta cheia, pelo indice em topoA
	public boolean cheiaA() {
		return (vetor[topoA] != null);
	}
	
	// Checa se pilha B esta cheia, pelo indice em topoB
	public boolean cheiaB() {
		return (vetor[topoB] != null);
	}
	
	// Topo de A: objeto situado antes de topoA
	public Object topoA() {
		return vetor[topoA+1];
	}
	
	// Topo de B: objeto situado antes de topoB
	public Object topoB() {
		return vetor[topoB-1];
	}
	
	// Imprime objetos da pilha A, da ultima posicao do vetor ate topoA
	public void mostrarPilhaA() {
		System.out.print("A => ");
		for (int i = vetor.length-1; i > topoA; i--) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println();
	}
	
	// Imprime objetos da pilha B, da primeira posicao do vetor ate topoB
	public void mostrarPilhaB() {
		System.out.print("B => ");
		for (int i = 0; i < topoB; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println();
	}
	
	// Tamanho da pilha A
	public int tamanhoA() {
		return ((vetor.length-1) - topoA);
	}
	
	// Tamanho da pilha B
	public int tamanhoB() {
		return topoB;
	}
}
