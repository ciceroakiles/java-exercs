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
@Table(name = "medico")
public class Medico {

	@Id
	@Column(name = "cod_medico")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int codmedico;
	
	@Column(name = "med_nome", length = 100)
	@NotNull
	private String nome;
	
	@Column(name = "med_lograd", length = 200)
	@NotNull
	private String medlograd;
	
	@Column(name = "numero", length = 10)
	@NotNull
	private String numero;
	
	@Column(name = "med_cep", length = 8)
	@NotNull
	private String medcep;
	
	@Column(name = "med_compl", length = 100)
	@NotNull
	private String medcompl;
	
	@Column(name = "telcontato", length = 15)
	@NotNull
	private String contato;
	
	@ManyToOne(targetEntity = Consulta.class)
	@JoinColumn(name = "cod_consulta")
	@NotNull
	private Consulta consulta;
	
	@ManyToOne(targetEntity = Especialidade.class)
	@JoinColumn(name = "cod_espec")
	@NotNull
	private Especialidade espec;

	public int getCodmedico() {
		return codmedico;
	}
	public void setCodmedico(int codmedico) {
		this.codmedico = codmedico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMedlograd() {
		return medlograd;
	}
	public void setMedlograd(String medlograd) {
		this.medlograd = medlograd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMedcep() {
		return medcep;
	}
	public void setMedcep(String medcep) {
		this.medcep = medcep;
	}
	public String getMedcompl() {
		return medcompl;
	}
	public void setMedcompl(String medcompl) {
		this.medcompl = medcompl;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Especialidade getEspec() {
		return espec;
	}
	public void setEspec(Especialidade espec) {
		this.espec = espec;
	}
}
