package br.com.inforium.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aprovados")
public class Aprovados {

	@Id
	@GeneratedValue
	@Column(name = "id", length = 11)
	private int id;

	@Column(name = "nome", length = 40)
	private String nome;

	@Column(name = "curso", length = 30)
	private String curso;

	@Column(name = "nota", length = 3)
	private double nota;

	@Column(name = "data_resultado")
	private Date dataResultado;

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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Date getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(Date dataResultado) {
		this.dataResultado = dataResultado;
	}

}
