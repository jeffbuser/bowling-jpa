package org.goodbooze.bowling.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.goodbooze.bowling.jpa.controller.BowlingJpaController;
import org.goodbooze.bowling.jpa.model.Bowler;

/**
 * Data access object for Bowler to encapsulate all interactions
 * with the persistence layer.
 * 
 * @author Jeff
 *
 */
public class BowlerDao {
	
	/**
	 * Add a new bowler.
	 * 
	 * @param name
	 * @param usbcNumber
	 * @throws PersistenceException
	 */
	public void addNewBowler(String name, String usbcNumber) throws PersistenceException {
		
		if (name == null || usbcNumber == null) {
			throw new PersistenceException("Name and USBC Number are required fields");
		}
		
		EntityManager entityManager = BowlingJpaController.getEntityManager();
		
		Bowler newBowler = new Bowler();
		newBowler.setBowlerName(name);
		newBowler.setBowlerUsbcNumber(usbcNumber);
		
		entityManager.persist(newBowler);

		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	/**
	 * Retrieve a bowler based on his/her usbc number.
	 * 
	 * @param usbcNumber
	 * @return {@code org.goodbooze.bowler.jpa.model.Bowler} 
	 */
	public Bowler getBowlerByUsbcNumber(String usbcNumber) {
		
		EntityManager entityManager = BowlingJpaController.getEntityManager();
		
		Query bowlerQuery = entityManager.createQuery("from Bowler b where b.usbcNumber = :usbcNum");
		Bowler bowler = (Bowler) bowlerQuery.setParameter("usbcNum", usbcNumber).getSingleResult();
		
		return bowler;
		
	}
	
	/**
	 * Retrieves all bowlers currently persisted
	 * 
	 * @return a List of {@code org.goodbooze.bowler.jpa.model.Bowler}
	 */
	public List<Bowler> getAllBowlers() {
		
		EntityManager entityManager = BowlingJpaController.getEntityManager();
		
		Query bowlerQuery = entityManager.createQuery("from Bowler b");
		List<Bowler> resultList = bowlerQuery.getResultList();
		
		return resultList;
		
	}
	
	/**
	 * Retrieves all bowlers currently persisted using named query
	 * 
	 * @return a List of {@code org.goodbooze.bowler.jpa.model.Bowler}
	 */
	public List<Bowler> getAllBowlersUsingNamedQuery() {
		
		EntityManager entityManager = BowlingJpaController.getEntityManager();
		
		Query bowlerQuery = entityManager.createNamedQuery("Bowler.findAll");
		List<Bowler> resultList = bowlerQuery.getResultList();
		
		return resultList;
		
	}

}
