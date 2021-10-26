package br.com.inforium.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue
	@Column(name = "codigo", length = 6)
	private int codigo;

	@Column(name = "descLivro", length = 100)
	private String descLivro;

	@Column(name = "ISBN", length = 30)
	private String ISBN;

	@ManyToOne
	@JoinColumn(name = "id_editora")
	private Editora editora;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescLivro() {
		return descLivro;
	}

	public void setDescLivro(String descLivro) {
		this.descLivro = descLivro;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
