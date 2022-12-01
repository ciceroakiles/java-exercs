package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Medico")
@Inheritance(strategy = InheritanceType.JOINED)
public class Medico {

	@Id
	@Column(name = "CRM", length = 7)
	@NotNull
	private String crm;
	
	@Column(name = "Nome", length = 60)
	@NotNull
	private String nome;
	
	@Column(name = "Telefone_Celular", length = 11)
	@NotNull
	private String telefone;
	
	@Column(name = "Especialidade", length = 30)
	@NotNull
	private String espec;

	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEspec() {
		return espec;
	}
	public void setEspec(String espec) {
		this.espec = espec;
	}
}
