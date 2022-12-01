package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@Column(name = "ra", length = 10)
	@NotNull
	private String RA;
	
	@Column(name = "nome", length = 50)
	@NotNull
	private String nome;
	
	@Column(name = "email", length = 40)
	@NotNull
	private String email;
	
	@Column(name = "posicao_vestibular")
	@NotNull
	private int posicao_vestibular;
	
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPosicao_vestibular() {
		return posicao_vestibular;
	}
	public void setPosicao_vestibular(int posicao_vestibular) {
		this.posicao_vestibular = posicao_vestibular;
	}
	
	@Override
	public String toString() {
		return "Aluno [RA=" + RA + ", nome=" + nome + ", email=" + email + ", posicao_vestibular=" + posicao_vestibular
				+ "]";
	}
}
