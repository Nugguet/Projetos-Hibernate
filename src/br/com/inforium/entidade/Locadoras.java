package br.com.inforium.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_locadora")
public class Locadoras {
	
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11)
	private int id;
	
	@Column(name = "nome", length = 40)
	private String nome;

	@Column(name = "data_retirada")
	private Date dataRetirada;

	@Column(name = "data_entrega")
	private Date dataEntrega;


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

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	

}
