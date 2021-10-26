package br.com.inforium.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.inforium.entidade.Aprovados;

public class DataGeneration {
	/**
	 * M�todo que vai criar a tabela Especificar a entidade em
	 * conf.addAnnotatedClass Baseado nos atributos da classe, vai criar os
	 * campos da tabela
	 */
	public static void main(String[] args) {

		AnnotationConfiguration an = new AnnotationConfiguration();
		an.addAnnotatedClass(Aprovados.class);
	
		an.configure();

		new SchemaExport(an).create(true, true);

	}
}