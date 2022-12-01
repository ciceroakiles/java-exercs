package model;

import java.time.LocalDateTime;
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
@Table(name = "consulta")
public class Consulta {

	@Id
	@Column(name = "cod_consulta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int codconsulta;
	
	@Column(name = "dthr_consulta")
	@NotNull
	private LocalDateTime dthrconsulta;
	
	@ManyToOne(targetEntity = Paciente.class)
	@JoinColumn(name = "num_beneficiario")
	@NotNull
	private Paciente paciente;

	public int getCodconsulta() {
		return codconsulta;
	}
	public void setCodconsulta(int codconsulta) {
		this.codconsulta = codconsulta;
	}
	public LocalDateTime getDthrconsulta() {
		return dthrconsulta;
	}
	public void setDthrconsulta(LocalDateTime dthrconsulta) {
		this.dthrconsulta = dthrconsulta;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
