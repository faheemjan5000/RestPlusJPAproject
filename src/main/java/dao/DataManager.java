package dao;

import java.util.List;

import exceptions.ItemAlreadyExistException;
import exceptions.ItemNotFoundException;
import model.Person;

public interface DataManager {

	
	public List<Person> getAllPersons() throws ItemNotFoundException;
	
	public Person getPerson(int id);
	
	public void createPerson(Person person) throws ItemAlreadyExistException;
	
	public void updatePerson(Person person);
	
	public void removePerson(int id);
}
