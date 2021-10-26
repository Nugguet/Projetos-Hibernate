package br.com.inforium.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.inforium.DAO.AlunosDao;
import br.com.inforium.DAO.PessoasDao;
import br.com.inforium.DAO.ProfessorDao;
import br.com.inforium.entidade.Aluno;
import br.com.inforium.entidade.Pessoa;
import br.com.inforium.entidade.Professor;

public class TestaPessoa {

	public static void main(String[] args) {
		pesquisarProfessor();
	}


	public static void incluirPessoaAlunos() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Eduardo");
		pessoa.setEndereco("Rua Sabara 112");
		pessoa.setIdade("31");
		Set<Aluno> alunos = new LinkedHashSet<Aluno>();

		for (int i = 1; i <= 3; i++) {
			Aluno l = new Aluno();
			l.setMatricula("15153" + i);
			l.setPessoa(pessoa);
			l.setCurso("ads" + i);
			alunos.add(l);

		}
		
		
		pessoa.setAlunos(alunos);

		PessoasDao dao = new PessoasDao();
		dao.incluir(pessoa);
	}
	
	public static void incluirPessoaProfessor() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Eduardo");
		pessoa.setEndereco("Rua Sabara 112");
		pessoa.setIdade("31");
		Set<Professor> professors = new LinkedHashSet<Professor>();

		
		
		for (int i = 1; i <= 5; i++) {
			Professor l = new Professor();
			l.setCurriculo("Adm" + i);
			l.setPessoa(pessoa);
			l.setSalario("3112" + i);
			professors.add(l);

		}

		pessoa.setProfessors(professors);

		PessoasDao dao = new PessoasDao();
		dao.incluir(pessoa);
	}
	
	public static void excluir() {
		Pessoa a = new Pessoa();
		PessoasDao dao = new PessoasDao();
		a.setId(1);
		dao.excluir(a);
		}
	
	public static void excluirAluno() {
		Aluno a = new Aluno();
		AlunosDao dao = new AlunosDao();
		a.setId(19);
		dao.excluir(a);
		}
	
	public static void excluirProfessor() {
		Professor a = new Professor();
		ProfessorDao dao = new ProfessorDao();
		a.setId(5);
		dao.excluir(a);
		}

	public static void alterarPessoa() {
		Pessoa a = new Pessoa();
		PessoasDao dao = new PessoasDao();
		a.setId(1);
		a.setNome("Eduardo5");
		a.setEndereco("Rua Sabara 1125");
		a.setIdade("31");
		dao.atualizar(a);
	}
	
	public static void alterarAluno() {
		Aluno l = new Aluno();
		AlunosDao dao = new AlunosDao();
		l.setId(18);
		l.setMatricula("151543");
		l.setCurso("ads prado");
		dao.atualizar(l);
	}
	
	public static void alterarProfessor() {
		Professor l = new Professor();
		ProfessorDao dao = new ProfessorDao();
		l.setCurriculo("Adm");
		l.setSalario("3112");
		dao.atualizar(l);
	}
	
	public static void pesquisarPessoa() {
		Pessoa a = new Pessoa();
		PessoasDao dao = new PessoasDao();
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista = dao.recuperarTodos();

		for (Pessoa Pessoas : lista) {
			System.out.println(Pessoas.getId());
			System.out.println(Pessoas.getNome());
			System.out.println(Pessoas.getEndereco());
			System.out.println(Pessoas.getIdade());
			System.out.println("*******");
			
		}
	
	}
	
	public static void pesquisarAluno() {
		Aluno a = new Aluno();
		AlunosDao dao = new AlunosDao();
		List<Aluno> lista = new ArrayList<Aluno>();
		lista = dao.recuperarTodos();

		for (Aluno Aluno : lista) {
			System.out.println(Aluno.getId());
			System.out.println(Aluno.getCurso());
			System.out.println(Aluno.getMatricula());
			System.out.println(Aluno.getPessoa());
			System.out.println("*******");
			
		}
	
	}
	
	public static void pesquisarProfessor() {
		Professor a = new Professor();
		ProfessorDao dao = new ProfessorDao();
		List<Professor> lista = new ArrayList<Professor>();
		lista = dao.recuperarTodos();

		for (Professor Professor : lista) {
			System.out.println(Professor.getId());
			System.out.println(Professor.getCurriculo());
			System.out.println(Professor.getSalario());
			System.out.println(Professor.getPessoa());
			System.out.println("*******");
			
		}
	
	}
	
	
}

	

