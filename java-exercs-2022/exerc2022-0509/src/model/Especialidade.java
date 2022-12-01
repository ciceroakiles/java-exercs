package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "especialidade")
public class Especialidade {

	@Id
	@Column(name = "cod_espec")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int codespec;
	
	@Column(name = "nome_espec", length = 100)
	@NotNull
	private String nomeespec;

	public int getCodespec() {
		return codespec;
	}
	public void setCodespec(int codespec) {
		this.codespec = codespec;
	}
	public String getNomeespec() {
		return nomeespec;
	}
	public void setNomeespec(String nomeespec) {
		this.nomeespec = nomeespec;
	}
}
