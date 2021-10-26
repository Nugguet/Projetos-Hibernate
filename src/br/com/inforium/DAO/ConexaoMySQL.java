
package br.com.inforium.DAO;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.inforium.entidade.Aprovados;

//Início da classe de conexão//

public class ConexaoMySQL {

	public static String status = "Não conectou...";

//Método Construtor da Classe//

	public ConexaoMySQL() {

	}

//Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection

		try {

// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//

			String serverName = "localhost"; // caminho do servidor do BD

			String mydatabase = "aula"; // nome do seu banco de dados

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root"; // nome de um usuário de seu BD

			String password = ""; // sua senha de acesso

			connection = DriverManager.getConnection(url, username, password);

			// Testa sua conexão//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");
				System.out.println("STATUS--->Conectado com sucesso!\"");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

//Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

	// Método que retorna o status da sua conexão//

	public static String statusConection() {

		return status;

	}

	// Método que fecha sua conexão//

	public static boolean FecharConexao() {

		try {

			ConexaoMySQL.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return ConexaoMySQL.getConexaoMySQL();

	}

	public static void main(String[] args) {
		Connection connection = ReiniciarConexao();
		try {
			if (connection != null) {
				Aprovados a = new Aprovados();
				a.setCurso("ADS Alterado");
				a.setNome("Nelson Alterado");

				// inserir(connection, a);
				// pesquisar(connection);

				// alterar(connection, a);

				excluir(connection, a);

			}

			connection.close();
		} catch (Exception e) {
			System.out.println("Erro  de Conexão!");
		}

	}

	public static void inserir(Connection connection, Aprovados Aprovados) throws SQLException {
		Statement stmt = connection.createStatement();

		int insert = stmt.executeUpdate("insert into Aprovados (matricula, nome, curso, periodo, sexo, dataNascimento) VALUES(" + Aprovados.getId()
				+ ", " + Aprovados.getNome() + "," + Aprovados.getCurso() +  ","  + Aprovados.getNota() + ") ");
		System.out.println("Insert: " + insert);

	}
	
	

/*/	
	
	public static List<Aprovados> pesquisar(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery("select * from Aprovados ");
		List<Aprovados> listaAprovados = new ArrayList<Aprovados>();

		while (res.next()) {
			Aprovados a = new Aprovados();
			a.setNome(res.getString("nome"));
			a.setCurso(res.getString("curso"));
			a.setMatricula(res.getInt("matricula"));
			a.setPeriodo(res.getInt("Periodo"));
			a.setSexo(res.getString("Sexo"));
			a.setDataNascimento(res.getString("dataNascimento"));
			listaAprovados.add(a);
		}

		res.close();
		stmt.close();
		return listaAprovados;
	}
	
	/*/
	
	
	public static List<Aprovados> pesquisar(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery("select * from Aprovados ");
		List<Aprovados> listaAprovados = new ArrayList<Aprovados>();

		while (res.next()) {
			Aprovados a = new Aprovados();
			a.setNome(res.getString("nome"));
			a.setCurso(res.getString("curso"));
			a.setNota(res.getInt("Nota"));
			a.setId(res.getInt("Id"));
			listaAprovados.add(a);
		}

		res.close();
		stmt.close();
		return listaAprovados;
	}


	

	public static boolean excluir(Connection connection, Aprovados a) {
		try {
			// Create a statement
			Statement stmt = connection.createStatement();

			// Prepare a statement to insert a record
			String sql = "DELETE FROM Aprovados WHERE matricula = " + a.getId();

			// Execute the delete statement
			int deleteCount = stmt.executeUpdate(sql);

			if (deleteCount > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro na excluisão do Registro!");
			return false;
		}

	}

	public static boolean alterar(Connection connection, Aprovados a) {
		try {
			// Create a statement
			String sql = "UPDATE Aprovados SET matricula = " + a.getId() + ", nome = " + " ' " + a.getNome() + " ' "
					+ ", curso = " + " ' " + a.getCurso() + " ' " +  ", nota = " + " ' " + a.getNota();

			// Execute the insert statement
			Statement stmt = connection.createStatement();
			int updateCount = stmt.executeUpdate(sql);

			if (updateCount > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro na excluisão do Registro!");
			return false;
		}

	}

}