package dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import dao.iface.IObjetoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Aluno;

public class AlunoDAO implements IObjetoDAO<Aluno> {

	public SessionFactory sf;
	
	public AlunoDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void inserir(Aluno obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(obj);
		transaction.commit();
	}

	@Override
	public void alterar(Aluno obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(obj);
		transaction.commit();
	}

	@Override
	public void remover(Aluno obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(obj);
		transaction.commit();
	}

	@Override
	public Aluno buscar(Aluno obj) {
		EntityManager entityManager = sf.createEntityManager();
		Aluno a = entityManager.find(Aluno.class, obj.getRA());
		return a;
	}
	
	public Aluno buscarPorRA(String ra) {
		EntityManager entityManager = sf.createEntityManager();
		Aluno a = entityManager.find(Aluno.class, ra);
		return a;
	}

	@Override
	public List<Aluno> selectAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		EntityManager entityManager = sf.createEntityManager();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ra, nome, email, posicao_vestibular ");
		buffer.append("FROM aluno ORDER BY posicao_vestibular");
		Query query = (Query) entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Aluno a = new Aluno();
			a.setRA(obj[0].toString());
			a.setNome(obj[1].toString());
			a.setEmail(obj[2].toString());
			a.setPosicao_vestibular(Integer.valueOf(obj[3].toString()));
			alunos.add(a);
		}
		return alunos;
	}
}
