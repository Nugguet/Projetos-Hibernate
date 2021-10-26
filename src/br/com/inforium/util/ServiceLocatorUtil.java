package br.com.inforium.util;

import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ServiceLocatorUtil {

	/**
	 * Atributo static que armazer� a inst�ncia da classe
	 */
	private static ServiceLocatorUtil instance = null;

	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Map que mant�m organizados as Sessions j� configuradas
	 */
	@SuppressWarnings("rawtypes")
	private HashMap cache = null;

	/**
	 * Construtor privado,garantindo que nenhuma entidade exterior conseguir�
	 * criar uma nova inst�ncia
	 * 
	 * @throws NamingException
	 */
	@SuppressWarnings("rawtypes")
	private ServiceLocatorUtil() throws NamingException {
		cache = new HashMap();
	}

	/**
	 * Utilizado para recuperar a inst�ncia da classe ServiceLocatorDAO na
	 * mem�ria
	 * 
	 * @return ServiceLocatorDAO
	 * @throws NamingException
	 */
	public static ServiceLocatorUtil getInstance() throws NamingException {
		if (instance == null) {
			instance = new ServiceLocatorUtil();
		}
		return instance;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public org.hibernate.Session getHibernateSession(String fileName) {
		org.hibernate.cfg.Configuration cfg;
		org.hibernate.SessionFactory f = null;
		if (!cache.containsKey(fileName)) {
			cfg = new AnnotationConfiguration();
			cfg.configure(fileName);
			f = cfg.buildSessionFactory();
			cache.put(fileName, f);
		}
		f = (SessionFactory) cache.get(fileName);

		Session s = null;

		try {

			s = f.getCurrentSession();
		} catch (HibernateException e) {
			s = f.openSession();
		}

		try {
			if (!s.isOpen()) {
				// Se a sessao corrente est� fechada, retorna uma nova
				s = f.openSession();
			} else {
				// Se a sessao corrente est� aberta mas a conection fechada,
				// retorna
				// uma nova conexao
				if (s.connection().isClosed()) {
					s.close();
					s = f.openSession();
				}
			}
			/*
			 * if (!s.isOpen()||s.connection().isClosed()){ s.close(); s =
			 * f.openSession(); }
			 */
		} catch (HibernateException e) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ e.getMessage(), e);
		} catch (SQLException ex) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ ex.getMessage(), ex);
		}
		return s;
	}

	/**
	 * Retorna uma sess�o hibernate associada com uma transa��o atual, dessa
	 * forma utilizamos o padr�o conhecido como session-per-request ao inv�s do
	 * anti-pattern session-per-operation que abre e fecha uma Hibernate Session
	 * para cada opera��o. O arquivo de configura��es utilizado ser� o
	 * hibernate.cfg.xml, que dever� estar localizado no classpath da aplica��o
	 * 
	 * @return Uma sess�o Hibernate
	 * 
	 */
	public org.hibernate.Session getHibernateSession() {
		return getHibernateSession("/hibernate.cfg.xml");
	}

	/**
	 * Abre uma sess�o hibernate
	 * 
	 * @return Uma sess�o Hibernate
	 * @param Nome
	 *            do arquivo de confirura��es do Hibernate
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public org.hibernate.Session openHibernateSession(String fileName) {
		org.hibernate.cfg.Configuration cfg;
		org.hibernate.SessionFactory f = null;
		if (!cache.containsKey(fileName)) {
			cfg = new org.hibernate.cfg.Configuration();
			cfg.configure(fileName);
			f = cfg.buildSessionFactory();
			cache.put(fileName, f);
		}
		f = (SessionFactory) cache.get(fileName);
		Session s = f.openSession();
		try {
			if (!s.isOpen() || s.connection().isClosed()) {
				s.close();
				s = f.openSession();
			}
		} catch (HibernateException e) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ e.getMessage(), e);
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ e.getMessage(), e);
		}
		return s;
	}

	/**
	 * Abre uma sess�o hibernate
	 * 
	 * @return Uma sess�o Hibernate
	 * @param Nome
	 *            do arquivo de confirura��es do Hibernate
	 */
	public org.hibernate.Session openHibernateSession() {
		return openHibernateSession("/hibernate.cfg.xml");
	}

}