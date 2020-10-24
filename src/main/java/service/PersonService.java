package service;

import java.util.List;

import dao.DataInMemManager;
import dao.DataManager;
import exceptions.ItemAlreadyExistException;
import exceptions.ItemNotFoundException;
import model.Person;

public class PersonService {
private DataManager dataManager = new DataInMemManager();
	
public List<Person> getAllPersons() throws ItemNotFoundException {
	return dataManager.getAllPersons();
}

	
	public Person getPerson(int id) {
		return dataManager.getPerson(id);
	}
	
	public void createPerson(Person person) throws ItemAlreadyExistException{
		dataManager.createPerson(person);
	}
	
	public void updatePerson(Person person) {
		dataManager.updatePerson(person);
	}
	
	public void removePerson(int id) {
		dataManager.removePerson(id);
	}
}
