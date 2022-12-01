package dao.iface;

import java.util.List;
import model.Matricula;

public interface IMatriculaDAO {

	public void inserir(Matricula obj);
	public void remover(Matricula obj);
	public List<Matricula> selectAllDisciplina(Matricula obj);
}
