package model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class MatriculaPKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ra")
	@NotNull
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "codigo_disc")
	@NotNull
	private Disciplina disciplina;

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aluno, disciplina);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaPKey other = (MatriculaPKey) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(disciplina, other.disciplina);
	}
	
	@Override
	public String toString() {
		return "MatriculaPKey [aluno=" + aluno + ", disciplina=" + disciplina + "]";
	}
}
