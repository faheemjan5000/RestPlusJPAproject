package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Person;
public class DataInJdbcManager {

	private Connection conn = null;
	
	public DataInJdbcManager()  {
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Person> getAllPersons(){
		List<Person> persons = new ArrayList<Person>();
		String sql = "select * from person";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				
				persons.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return persons;
	}
	
	
	public Person getPerson(int id){
		Person person = new Person();
		String sql = "select * from person when id="+id;
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return person;
	}
	
	public void createPerson(Person person) {
		String sql = "insert into person values(?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, person.getId());
			st.setString(2, person.getName());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
