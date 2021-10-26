package br.com.inforium.entidade;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Professor")
public class Professor {

	
		@Id
		@GeneratedValue
		@Column(name = "id", length = 11)
		private int id;

		@Column(name = "salario", length = 40)
		private String salario;

		@Column(name = "curriculo", length = 30)
		private String curriculo;

		@ManyToOne
		@JoinColumn(name = "pessoa")
		private Pessoa pessoa;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSalario() {
			return salario;
		}

		public void setSalario(String salario) {
			this.salario = salario;
		}

		public String getCurriculo() {
			return curriculo;
		}

		public void setCurriculo(String curriculo) {
			this.curriculo = curriculo;
		}

		public Pessoa getPessoa() {
			return pessoa;
		}

		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
	
}
