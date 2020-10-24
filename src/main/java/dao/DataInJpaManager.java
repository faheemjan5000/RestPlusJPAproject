package dao;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exceptions.ItemAlreadyExistException;
import exceptions.ItemNotFoundException;
import model.Person;

public class DataInJpaManager implements DataManager{

	
	private final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("versionTwoJerseyRest");
	private final EntityManager entityManager = entityManagerFactory.createEntityManager();
	protected static final Logger LOGGER = Logger.getLogger(DataInJpaManager.class.getName());
	
	
	public Person getPerson(int key) {
		Person person = null;
		LOGGER.log(Level.INFO, "getPerson in database is called");
		try {
			person = entityManager.find(Person.class, key);
		} catch (NullPointerException e) {
			LOGGER.log(Level.SEVERE, "data is not exist!",e);
			throw e;
		}
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() throws ItemNotFoundException {
		LOGGER.log(Level.INFO, "getAllData method in database is called.");
		List<Person> allItems = new ArrayList<>();
		entityManager.getTransaction().begin();
		allItems = entityManager.createQuery("SELECT p FROM Person p").getResultList();
		entityManager.getTransaction().commit();
		
		return allItems;
	}
	
	public void createPerson(Person newPerson) throws ItemAlreadyExistException {
		LOGGER.log(Level.INFO, "createPerson() method in database is called.");
		entityManager.getTransaction().begin();
		entityManager.persist(newPerson);
		entityManager.getTransaction().commit();
		
	}
	
	public void removePerson(int id) {
		LOGGER.log(Level.INFO, "removePerson() method in database is called.");
		Person person = entityManager.find(Person.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(person);
		entityManager.getTransaction().commit();
		
	}
	public void updatePerson(Person person) {
		LOGGER.log(Level.INFO, "updatePerson() method in database is called");
		entityManager.getTransaction().begin();
		entityManager.merge(person);
		entityManager.getTransaction().commit();
	}
	

	
	
}
