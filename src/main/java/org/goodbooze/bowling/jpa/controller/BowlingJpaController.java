package org.goodbooze.bowling.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA Controller class for Bowling example.
 * @author Jeff
 *
 */
public class BowlingJpaController {

	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "org.goodbooze.bowling.jpa" );
			entityManager = entityManagerFactory.createEntityManager();
		}
		
		return entityManager;
	}
	
	

}
