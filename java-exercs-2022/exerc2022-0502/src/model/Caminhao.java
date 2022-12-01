package model;

public class Caminhao extends _Veiculo {

	private int qtdeEixos;
	private int cargaMax;
	
	public Caminhao(_Veiculo v) {
		this.setPlaca(v.getPlaca());
		this.setMarca(v.getMarca());
		this.setModelo(v.getModelo());
		this.setCor(v.getCor());
		this.setVelMaxima(v.getVelMaxima());
	}
	
	public int getQtdeEixos() {
		return qtdeEixos;
	}
	public void setQtdeEixos(int qtdeEixos) {
		this.qtdeEixos = qtdeEixos;
	}
	public int getCargaMax() {
		return cargaMax;
	}
	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	@Override
	public String toString() {
		return "Caminhao [qtdeEixos=" + qtdeEixos + ", cargaMax=" + cargaMax + ", getPlaca()=" + getPlaca()
				+ ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getCor()=" + getCor()
				+ ", getVelMaxima()=" + getVelMaxima() + "]";
	}
}
