
package br.com.inforium.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.inforium.DAO.LocadorasDAO;
import br.com.inforium.entidade.Locadoras;
import br.com.inforium.util.DataUtil;

public class TestaLocadora {

	public static void main(String[] args) {

		incluirVarios();
	}

	public static void incluir() {
		Locadoras a = new Locadoras();
		LocadorasDAO dao = new LocadorasDAO();
		a.setDataEntrega(new Date());
		a.setNome("Pedro");
		a.setDataRetirada(new Date());
		dao.incluir(a);
	}

	public static void incluirVarios() {

		for (int i = 0; i < 20; i++) {
			Locadoras a = new Locadoras();
			LocadorasDAO dao = new LocadorasDAO();
		
			a.setDataEntrega(new Date());
			a.setDataRetirada(new Date());
			a.setNome("Aluno " + (i + 1));
			
			dao.incluir(a);
		}

	}

	 public static void alterar() {
		Locadoras a = new Locadoras();
		LocadorasDAO dao = new LocadorasDAO();
		a.setId(1);
		a.setCurso("ADS Alterado");
		a.setDataResultado(new Date());
		a.setNome("Pedro Alterado");
		a.setNota(7);
		dao.atualizar(a);
	}

	public static void excluir() {
		Locadoras a = new Locadoras();
		LocadorasDAO dao = new LocadorasDAO();
		a.setId(1);
		dao.excluir(a);
	}

	public static void pesquisar() {
		Locadoras a = new Locadoras();
		LocadorasDAO dao = new LocadorasDAO();
		List<Locadoras> lista = new ArrayList<Locadoras>();
		lista = dao.recuperarTodos();

		for (Locadoras Locadoras : lista) {
			System.out.println(Locadoras.getNome());
			System.out.println(Locadoras.getCurso());
			System.out.println(Locadoras.getNota());
			System.out.println(DataUtil.parseDate(Locadoras.getDataResultado()));
			System.out.println("*******");

		}

	}/*/

}
