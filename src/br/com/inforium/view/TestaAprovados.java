package br.com.inforium.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.inforium.DAO.AprovadosDAO;
import br.com.inforium.entidade.Aprovados;
import br.com.inforium.util.DataUtil;

public class TestaAprovados {

	public static void main(String[] args) {

		incluirVarios();
	}

	public static void incluir() {
		Aprovados a = new Aprovados();
		AprovadosDAO dao = new AprovadosDAO();
		a.setCurso("ADS");
		a.setDataResultado(new Date());
		a.setNome("Pedro");
		a.setNota(8);
		dao.incluir(a);
	}

	public static void incluirVarios() {

		for (int i = 0; i < 20; i++) {
			Aprovados a = new Aprovados();
			AprovadosDAO dao = new AprovadosDAO();
			a.setCurso("ADS " + (2000 + i));
			a.setDataResultado(new Date());
			a.setNome("Aluno " + (i + 1));
			a.setNota(8 * i);
			dao.incluir(a);
		}

	}

	public static void alterar() {
		Aprovados a = new Aprovados();
		AprovadosDAO dao = new AprovadosDAO();
		a.setId(1);
		a.setCurso("ADS Alterado");
		a.setDataResultado(new Date());
		a.setNome("Pedro Alterado");
		a.setNota(7);
		dao.atualizar(a);
	}

	public static void excluir() {
		Aprovados a = new Aprovados();
		AprovadosDAO dao = new AprovadosDAO();
		a.setId(1);
		dao.excluir(a);
	}

	public static void pesquisar() {
		Aprovados a = new Aprovados();
		AprovadosDAO dao = new AprovadosDAO();
		List<Aprovados> lista = new ArrayList<Aprovados>();
		lista = dao.recuperarTodos();

		for (Aprovados aprovados : lista) {
			System.out.println(aprovados.getNome());
			System.out.println(aprovados.getCurso());
			System.out.println(aprovados.getNota());
			System.out.println(DataUtil.parseDate(aprovados.getDataResultado()));
			System.out.println("*******");

		}

	}

}
