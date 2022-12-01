package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ficha")
public class Ficha {

	@Id
	@Column(name = "num_ficha")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int numficha;
	
	@Column(name = "info", length = 255)
	private String info;
	
	@ManyToOne(targetEntity = Paciente.class)
	@JoinColumn(name = "num_beneficiario")
	@NotNull
	private Paciente paciente;
	
	@ManyToOne(targetEntity = Especialidade.class)
	@JoinColumn(name = "cod_espec")
	@NotNull
	private Especialidade espec;

	public int getNumficha() {
		return numficha;
	}
	public void setNumficha(int numficha) {
		this.numficha = numficha;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Especialidade getEspec() {
		return espec;
	}
	public void setEspec(Especialidade espec) {
		this.espec = espec;
	}
}
