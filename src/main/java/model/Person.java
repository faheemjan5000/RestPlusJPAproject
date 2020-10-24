package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.xml.bind.annotation.*;



@Entity
@Table
//@XmlRootElement
public class Person {
	
	@Id
	private int id;
	private String name;


	/*public Person(int id,String name) {
		this.name= name;
		this.id=id;
	}*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	
	

}
