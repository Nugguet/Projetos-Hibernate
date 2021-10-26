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
@Table(name = "Pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name = "id", length = 11)
	private int id;

	@Column(name = "nome", length = 40)
	private String nome;

	@Column(name = "endereco", length = 30)
	private String endereco;

	@Column(name = "idade", length = 4)
	private String idade;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "pessoa")
	private Set<Professor> professors;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "pessoa")
	private Set<Aluno> alunos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	
	
}
