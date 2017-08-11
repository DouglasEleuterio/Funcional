package com.funcional.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		/*
		 * Estamos definindo o método que de fato cria uma sessão para acessarmos o
		 * banco de dados por meio do Hibernate.
		 */

		try {
			Configuration configuration = new Configuration().configure();
			/*
			 * O método Configuration.configure() carrega o arquivo hibernate.cfg.xml e lê
			 * suas configurações para criar um objeto com as informações de configuração do
			 * Hibernate.
			 */
			
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			/*
			 * estamos apenas criando uma instância de StandardServiceRegistryBuilder e
			 * posteriormente estamos aplicando um conjunto de chave-valor (Map) obtidos do
			 * arquivo de configuração hibernate.cfg.xml a essa instância.
			 */
			

			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
