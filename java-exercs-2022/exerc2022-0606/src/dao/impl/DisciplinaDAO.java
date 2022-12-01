package dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import dao.iface.IObjetoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Disciplina;

public class DisciplinaDAO implements IObjetoDAO<Disciplina> {

	public SessionFactory sf;
	
	public DisciplinaDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void inserir(Disciplina obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(obj);
		transaction.commit();
	}

	@Override
	public void alterar(Disciplina obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(obj);
		transaction.commit();
	}

	@Override
	public void remover(Disciplina obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(obj);
		transaction.commit();
	}

	@Override
	public Disciplina buscar(Disciplina obj) {
		EntityManager entityManager = sf.createEntityManager();
		Disciplina d = entityManager.find(Disciplina.class, obj.getCodigo_disc());
		return d;
	}

	public Disciplina buscarPorId(int id) {
		EntityManager entityManager = sf.createEntityManager();
		Disciplina d = entityManager.find(Disciplina.class, id);
		return d;
	}
	
	@Override
	public List<Disciplina> selectAll() {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		EntityManager entityManager = sf.createEntityManager();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT codigo_disc, nome_disc, carga_horaria ");
		buffer.append("FROM disciplina ORDER BY codigo_disc");
		Query query = (Query) entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Disciplina d = new Disciplina();
			d.setCodigo_disc(Integer.valueOf(obj[0].toString()));
			d.setNome_disc(obj[1].toString());
			d.setCarga_horaria(Integer.valueOf(obj[2].toString()));
			disciplinas.add(d);
		}
		return disciplinas;
	}
}
