package model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@EmbeddedId
	private MatriculaPKey chave;

	public MatriculaPKey getChave() {
		return chave;
	}
	public void setChave() {
		this.chave = new MatriculaPKey();
	}
	
	@Override
	public String toString() {
		return "Matricula [chave=" + chave + "]";
	}
}
