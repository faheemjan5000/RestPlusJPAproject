package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Person;

public class DataInMemManager implements DataManager {

	private List<Person> persons;
	
	public DataInMemManager() {
		
        persons = new ArrayList<>();
		
        Person person = new Person();
        person.setId(711);
        person.setName("sebastian");
        
        Person pperson = new Person();
        pperson.setId(811);
        pperson.setName("francesco");
        
        persons.add(person);
        persons.add(pperson);
	}
//1
public List<Person> getAllPersons(){
		
		return persons;
	}
//2
public Person getPerson(int id) {
	return findPerson(id);
}
	
	public Person findPerson(int id)
	{
         for (Person person : persons) {
			
			if(person.getId() == id) {
				return person;
			}
		}
		return null;
	}
	
	@Override
	public void createPerson(Person person) {
		persons.add(person);
		
	}
	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removePerson(int id) {
		Person temp = findPerson(id);
		 if(temp!=null) {
			 persons.remove(temp);
		 }
	}
	
	
	
}
