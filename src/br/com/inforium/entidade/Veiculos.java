package br.com.inforium.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "veiculo")
	public class Veiculos {

		@Id
		@GeneratedValue
		@Column(name = "id", length = 11)
		private int id;	
		
		@Column(name = "placa", length = 60)
		private String placa;

		@Column(name = "modelo", length = 100)
		private String modelo;

		@Column(name = "ano", length = 30)
		private String ano;

		@Column(name = "cor", length = 30)
		private String cor;
		
		@Column(name = "diaria", length = 30)
		private int diaria;

		@ManyToOne
		@JoinColumn(name = "id_locadora")
		private testLocadora2 locadora;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getAno() {
			return ano;
		}

		public void setAno(String ano) {
			this.ano = ano;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		public int getDiaria() {
			return diaria;
		}

		public void setDiaria(int diaria) {
			this.diaria = diaria;
		}

		public testLocadora2 getLocadora() {
			return locadora;
		}

		public void setLocadora(testLocadora2 locadora) {
			this.locadora = locadora;
		}

	
		
		}

