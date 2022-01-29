package model;

public class Carro implements Comparable<Carro> {

	private String escuderia;
	private int numero;
	private int melhorTempo;
	
	public Carro(String escuderia, int numero) {
		this.escuderia = escuderia;
		this.numero = numero;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Integer getMelhorTempo() {
		return melhorTempo;
	}

	public void setMelhorTempo(int melhorTempo) {
		this.melhorTempo = melhorTempo;
	}
	
	@Override
	public String toString() {
		return ("Carro " + numero + " da " + escuderia + " - Melhor tempo: " + melhorTempo + "s");
	}
	
	@Override
	public int compareTo(Carro c) {
		return this.getMelhorTempo().compareTo(c.getMelhorTempo());
	}
}
