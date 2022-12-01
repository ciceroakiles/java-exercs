package model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Mae")
public class Mae {

	@Id
	@Column(name = "ID_Mae")
	@NotNull
	private int id_mae;
	
	@Column(name = "Nome", length = 60)
	@NotNull
	private String nome;
	
	@Column(name = "Logradouro_Endereco", length = 100)
	@NotNull
	private String lograd_end;
	
	@Column(name = "Numero_Endereco")
	@NotNull
	private int num_end;
	
	@Column(name = "CEP_Endereco", length = 8)
	@NotNull
	private String cep_end;
	
	@Column(name = "Complemento_Endereco", length = 200)
	private String compl_end;
	
	@Column(name = "Telefone", length = 10)
	@NotNull
	private String telefone;
	
	@Column(name = "Data_Nasc")
	@NotNull
	private Date data_nasc;
	
	public int getId_mae() {
		return id_mae;
	}
	public void setId_mae(int id_mae) {
		this.id_mae = id_mae;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLograd_end() {
		return lograd_end;
	}
	public void setLograd_end(String lograd_end) {
		this.lograd_end = lograd_end;
	}
	public int getNum_end() {
		return num_end;
	}
	public void setNum_end(int num_end) {
		this.num_end = num_end;
	}
	public String getCep_end() {
		return cep_end;
	}
	public void setCep_end(String cep_end) {
		this.cep_end = cep_end;
	}
	public String getCompl_end() {
		return compl_end;
	}
	public void setCompl_end(String compl_end) {
		this.compl_end = compl_end;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
}
