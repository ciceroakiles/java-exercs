package model;

public class Automovel extends _Veiculo {

	private int numPortas;
	private int ano;
	
	public Automovel(_Veiculo v) {
		this.setPlaca(v.getPlaca());
		this.setMarca(v.getMarca());
		this.setModelo(v.getModelo());
		this.setCor(v.getCor());
		this.setVelMaxima(v.getVelMaxima());
	}
	
	public int getNumPortas() {
		return numPortas;
	}
	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return "Automovel [numPortas=" + numPortas + ", ano=" + ano + ", getPlaca()=" + getPlaca()
				+ ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCor()=" + getCor()
				+ ", getVelMaxima()=" + getVelMaxima() + "]";
	}
}
