package br.com.inforium.util;

import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sf;

	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		return sf.openSession();
	}

	public static Statement getStatement() throws Exception {
		Statement stm = null;

		try {
			stm = getStatement();
		} catch (SQLException e) {
			throw new Exception(e);
		}

		return stm;
	}

}
