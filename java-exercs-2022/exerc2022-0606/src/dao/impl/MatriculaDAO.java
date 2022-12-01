package dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import dao.iface.IMatriculaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Matricula;
import view.Principal;

public class MatriculaDAO implements IMatriculaDAO {

	public SessionFactory sf;

	public MatriculaDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void inserir(Matricula obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(obj);
		transaction.commit();
	}

	@Override
	public void remover(Matricula obj) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(obj);
		transaction.commit();
	}

	@Override
	public List<Matricula> selectAllDisciplina(Matricula obj) {
		List<Matricula> listaMatricula = new ArrayList<Matricula>();
		EntityManager em = sf.createEntityManager();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT m.* FROM matricula m ");
		buffer.append("JOIN aluno a on a.ra=m.ra ");
		buffer.append("JOIN disciplina d on d.codigo_disc=m.codigo_disc");
		Query query = (Query) em.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] objArr: lista) {
			Matricula m = new Matricula();
			m.setChave();
			m.getChave().setAluno(Principal.aDao.buscarPorRA(objArr[1].toString()));
			m.getChave().setDisciplina(Principal.dDao.buscarPorId((int) objArr[0]));
			listaMatricula.add(m);
		}
		return listaMatricula;
	}
}
