package br.com.inforium.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.inforium.entidade.Pessoa;
import br.com.inforium.entidade.testLocadora2;



public class DataGeneration {
	/**
	 * M�todo que vai criar a tabela Especificar a entidade em
	 * conf.addAnnotatedClass Baseado nos atributos da classe, vai criar os
	 * campos da tabela
	 */
	public static void main(String[] args) {

		AnnotationConfiguration an = new AnnotationConfiguration();
		
		// Cadastra no servidor
		
		an.addAnnotatedClass(Pessoa.class);
		an.addAnnotatedClass(testLocadora2.class);
	
		an.configure();

		new SchemaExport(an).create(true, true);

	}
}