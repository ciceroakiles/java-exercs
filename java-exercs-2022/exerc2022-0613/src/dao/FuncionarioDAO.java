package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Funcionario;

public class FuncionarioDAO implements _IFuncionarioDAO {

	public SessionFactory sf;
	
	public FuncionarioDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void inserir(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(f);
		transaction.commit();
	}

	@Override
	public void alterar(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(f);
		transaction.commit();
	}

	@Override
	public void remover(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(f);
		transaction.commit();
	}

	@Override
	public Funcionario buscar(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		Funcionario fbusca = entityManager.find(Funcionario.class, f.getId());
		return fbusca;
	}

	@Override
	public List<Funcionario> selectAll() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		EntityManager entityManager = sf.createEntityManager();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT id, nome, salario ");
		buffer.append("FROM funcionario ORDER BY id");
		Query query = (Query) entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Funcionario f = new Funcionario();
			f.setId(Integer.valueOf(obj[0].toString()));
			f.setNome(obj[1].toString());
			f.setSalario(Float.valueOf(obj[2].toString()));
			funcionarios.add(f);
		}
		return funcionarios;
	}
}
