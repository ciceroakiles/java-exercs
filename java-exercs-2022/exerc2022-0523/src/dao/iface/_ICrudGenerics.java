package dao.iface;

import java.util.List;

public interface _ICrudGenerics<T> {

	public void inserir(T obj);
	
	public void alterar(T obj);
	
	public void excluir(T obj);
	
	public T buscar(T obj);
	
	public List<T> listar();
}
