package view;

import java.util.List;
import org.hibernate.SessionFactory;
import dao.impl.AlunoDAO;
import dao.impl.DisciplinaDAO;
import dao.impl.MatriculaDAO;
import model.Aluno;
import model.Disciplina;
import model.Matricula;
import util.HibernateUtil;

public class Principal {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	public static AlunoDAO aDao = new AlunoDAO(sf);
	public static DisciplinaDAO dDao = new DisciplinaDAO(sf);
	public static MatriculaDAO mDao = new MatriculaDAO(sf);
	
	private static Aluno a4;
	private static Disciplina d4;
	
	public static void main(String[] args) {
		operacoesAluno();
		operacoesDisciplina();
		operacoesMatricula();
	}
	
	private static void operacoesAluno() {
		Aluno a = new Aluno();
		// Dados
		a.setRA("1110202020");
		a.setNome("Joao Silva");
		a.setEmail("student@example.com");
		a.setPosicao_vestibular(12);
		// (create)
		aDao.inserir(a);
		// (delete)
		aDao.remover(a);
		// (read)
		aDao.inserir(a);
		Aluno a2 = aDao.buscar(a);
		System.out.println(a2.getNome());
		// (update)
		Aluno a3 = a2;
		a3.setNome("John Silva");
		aDao.alterar(a3);
		a4 = aDao.buscar(a3);
		System.out.println(a4.getNome());
	}
	
	private static void operacoesDisciplina() {
		Disciplina d = new Disciplina();
		// Dados
		d.setCodigo_disc(1);
		d.setNome_disc("Logica de Programacao");
		d.setCarga_horaria(120);
		// (create)
		dDao.inserir(d);
		// (delete)
		dDao.remover(d);
		// (read)
		dDao.inserir(d);
		Disciplina d2 = dDao.buscar(d);
		System.out.println(d2.getNome_disc());
		// (update)
		Disciplina d3 = d2;
		d3.setNome_disc("Inteligencia Artificial");
		dDao.alterar(d3);
		d4 = dDao.buscar(d3);
		System.out.println(d4.getNome_disc());
	}
	
	private static void operacoesMatricula() {
		Matricula m1 = new Matricula();
		// Dados
		m1.setChave();
		m1.getChave().setAluno(a4);
		m1.getChave().setDisciplina(d4);
		// (create)
		mDao.inserir(m1);
		// (delete)
		mDao.remover(m1);
		// (read)
		mDao.inserir(m1);
		
		Aluno a1 = new Aluno();
		a1.setRA("1110202021");
		a1.setNome("Maria Silva");
		a1.setEmail("student2@example.com");
		a1.setPosicao_vestibular(23);
		aDao.inserir(a1);
		
		Aluno a2 = new Aluno();
		a2.setRA("1110202022");
		a2.setNome("Pedro Santos");
		a2.setEmail("student3@example.com");
		a2.setPosicao_vestibular(20);
		aDao.inserir(a2);
		
		Matricula m2 = new Matricula();
		m2.setChave();
		m2.getChave().setAluno(a1);
		m2.getChave().setDisciplina(d4);
		mDao.inserir(m2);
		
		Matricula m3 = new Matricula();
		m3.setChave();
		m3.getChave().setAluno(a2);
		m3.getChave().setDisciplina(d4);
		mDao.inserir(m3);
		
		List<Matricula> lista = mDao.selectAllDisciplina(m1);
		lista.forEach(m -> System.out.println(m));
	}
}
