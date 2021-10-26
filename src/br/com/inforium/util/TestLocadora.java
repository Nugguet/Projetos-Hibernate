package br.com.inforium.util;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.inforium.DAO.LocadoraDAO;
import br.com.inforium.entidade.Veiculos;
import br.com.inforium.entidade.testLocadora2;

public class TestLocadora {

	public static void main(String[] args) {
		incluirLocadora();
	}

	public static void recuperaLocadora() {
		LocadoraDAO dao = new LocadoraDAO();
		testLocadora2 locadora = dao.recuperar(1);
		for (Veiculos l : locadora.getVeiculos()) {
			System.out.println(l.getPlaca());
		}
	}

	public static void incluirLocadora() {
		testLocadora2 locadora = new testLocadora2();
		locadora.setContato("Eduardo");
		locadora.setRazaoSocial("Localiza");
		locadora.setTelefone("31-5600900");
		Set<Veiculos> veiculos = new LinkedHashSet<Veiculos>();

		for (int i = 1; i <= 5; i++) {
			Veiculos l = new Veiculos();
			l.setPlaca("HOJ-256" + i);
			l.setModelo("HB20S");
			l.setLocadora(locadora);
			l.setAno("2021");
			l.setCor("Preto");
			veiculos.add(l);

		}

		locadora.setVeiculos(veiculos);

		LocadoraDAO dao = new LocadoraDAO();
		dao.incluir(locadora);
	}

}
	

