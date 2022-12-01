package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bebe_Medico")
public class Bebe_Medico {

	@Id
	@ManyToOne(targetEntity = Bebe.class)
	@JoinColumn(name = "ID_Bebe")
	private int id_bebe;
	
	@Id
	@ManyToOne(targetEntity = Medico.class)
	@JoinColumn(name = "CRM")
	private String crm;

	public int getId_bebe() {
		return id_bebe;
	}
	public void setId_bebe(int id_bebe) {
		this.id_bebe = id_bebe;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
}
