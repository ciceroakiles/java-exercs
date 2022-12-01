package model;

public class Motocicleta extends _Veiculo {

	private int cilindradas;
	
	public Motocicleta(_Veiculo v) {
		this.setPlaca(v.getPlaca());
		this.setMarca(v.getMarca());
		this.setModelo(v.getModelo());
		this.setCor(v.getCor());
		this.setVelMaxima(v.getVelMaxima());
	}
	
	public int getCilindradas() {
		return cilindradas;
	}
	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public String toString() {
		return "Motocicleta [cilindradas=" + cilindradas + ", getPlaca()=" + getPlaca() + ", getMarca()=" + getMarca()
				+ ", getModelo()=" + getModelo() + ", getCor()=" + getCor() + ", getVelMaxima()=" + getVelMaxima()
				+ "]";
	}
}
