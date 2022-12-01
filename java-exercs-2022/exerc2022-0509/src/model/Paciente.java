package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@Column(name = "num_beneficiario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int numbenef;
	
	@Column(name = "pac_nome", length = 100)
	@NotNull
	private String nome;
	
	@Column(name = "pac_lograd", length = 200)
	@NotNull
	private String paclograd;
	
	@Column(name = "num_porta", length = 10)
	@NotNull
	private String numporta;
	
	@Column(name = "pac_cep", length = 8)
	@NotNull
	private String paccep;
	
	@Column(name = "pac_compl", length = 100)
	@NotNull
	private String paccompl;
	
	@Column(name = "telefone", length = 15)
	@NotNull
	private String telefone;
	
	public int getNumbenef() {
		return numbenef;
	}
	public void setNumbenef(int numbenef) {
		this.numbenef = numbenef;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaclograd() {
		return paclograd;
	}
	public void setPaclograd(String paclograd) {
		this.paclograd = paclograd;
	}
	public String getNumporta() {
		return numporta;
	}
	public void setNumporta(String numporta) {
		this.numporta = numporta;
	}
	public String getPaccep() {
		return paccep;
	}
	public void setPaccep(String paccep) {
		this.paccep = paccep;
	}
	public String getPaccompl() {
		return paccompl;
	}
	public void setPaccompl(String paccompl) {
		this.paccompl = paccompl;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
