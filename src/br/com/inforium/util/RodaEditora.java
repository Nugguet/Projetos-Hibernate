package br.com.inforium.util;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.inforium.DAO.EditoraDAO;
import br.com.inforium.entidade.Editora;
import br.com.inforium.entidade.Livro;

public class RodaEditora {

	public static void main(String[] args) {
		incluirEditora();
	}

	public static void recuperaEditora() {
		EditoraDAO dao = new EditoraDAO();
		Editora editora = dao.recuperar(1);
		for (Livro l : editora.getLivros()) {
			System.out.println(l.getDescLivro());
		}
	}

	public static void incluirEditora() {
		Editora editora = new Editora();
		editora.setContato("Eduardo");
		editora.setRazaoSocial("Editora Pretinho");
		editora.setTelefone("31-5600900");
		Set<Livro> livros = new LinkedHashSet<Livro>();

		for (int i = 1; i <= 5; i++) {
			Livro l = new Livro();
			l.setDescLivro("A volta dos que não Foram " + i);
			l.setEditora(editora);
			l.setISBN("3121212" + i);
			livros.add(l);

		}

		editora.setLivros(livros);

		EditoraDAO dao = new EditoraDAO();
		dao.incluir(editora);
	}

}
