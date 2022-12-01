package dao;

import java.util.List;
import model.Funcionario;

public interface _IFuncionarioDAO {

	public void inserir(Funcionario f);
	
	public void alterar(Funcionario f);
	
	public void remover(Funcionario f);
	
	public Funcionario buscar(Funcionario f);
	
	public List<Funcionario> selectAll();
}
