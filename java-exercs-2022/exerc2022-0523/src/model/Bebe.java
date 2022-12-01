package model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Bebe")
public class Bebe {

	@Id
	@Column(name = "ID_Bebe")
	@NotNull
	private int id_bebe;
	
	@Column(name = "Nome", length = 60)
	@NotNull
	private String nome;
	
	@Column(name = "Data_Nasc")
	@NotNull
	private Date data_nasc;
	
	@Column(name = "Altura")
	@NotNull
	private double altura;
	
	@ManyToOne(targetEntity = Mae.class)
	@JoinColumn(name = "ID_Mae")
	@NotNull
	private Mae mae;

	public int getId_bebe() {
		return id_bebe;
	}
	public void setId_bebe(int id_bebe) {
		this.id_bebe = id_bebe;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Mae getMae() {
		return mae;
	}
	public void setMae(Mae mae) {
		this.mae = mae;
	}
}
