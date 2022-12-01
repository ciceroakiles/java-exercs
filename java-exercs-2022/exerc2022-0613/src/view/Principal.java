package view;

import org.hibernate.SessionFactory;

import controller.FaixaSalarial1;
import dao.FuncionarioDAO;
import model.Funcionario;
import util.HibernateUtil;

public class Principal {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	public static FuncionarioDAO fDao = new FuncionarioDAO(sf);
	
	public static void main(String[] args) {
		FaixaSalarial1 fsl = new FaixaSalarial1();
		
		Funcionario f1 = new Funcionario();
		f1.setId(1);
		f1.setNome("Joao Silva");
		f1.setSalario(3000);
		fDao.inserir(f1);
		
		fsl.proximoCalculo(f1, 0);
		
		Funcionario f2 = new Funcionario();
		f2.setId(2);
		f2.setNome("Maria Santos");
		f2.setSalario(1500);
		fDao.inserir(f2);
		
		fsl.proximoCalculo(f2, 0);
	}
}
