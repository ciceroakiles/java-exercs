package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Residente")
public class Residente extends Medico {

	@Column(name = "MedicoCRM", length = 7)
	@NotNull
	private String medico_crm;
	
	@Column(name = "Instituicao_Ensino", length = 50)
	@NotNull
	private String inst_ensino;
	
	@Column(name = "Ano_Ingresso")
	@NotNull
	private int ano_ingr;
}
