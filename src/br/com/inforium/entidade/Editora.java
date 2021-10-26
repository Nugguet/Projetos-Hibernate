package br.com.inforium.entidade;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Editora")
public class Editora {

	@Id
	@GeneratedValue
	@Column(name = "codigo_editora", length = 6)
	private int codigoEditora;

	@Column(name = "razao_social", length = 100)
	private String razaoSocial;

	@Column(name = "contato", length = 100)
	private String contato;

	@Column(name = "telefone", length = 15)
	private String telefone;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "editora")
	private Set<Livro> livros;

	public int getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(int codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

}
