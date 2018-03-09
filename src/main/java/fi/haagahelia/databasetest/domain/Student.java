package fi.haagahelia.databasetest.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;  
	private String firstName, lastName , email;
	
	@ManyToOne
	@JoinColumn (name = "departmentid") 
	private Department department;
	
	//Should this be private department?
	//private List<Department> departments; // Imported Department 

	public Student() {}
	
	public Student(String firstName, String lastName, String email, Department department) {
		super();		
	//	this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
	}
	
	public long  getId() { 
		return id;
	}
	public void setId(long id) { 
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString(){ 
		if (this.department != null)
		return "Student [id=" + id + ",firstName=" + firstName + ",lastName=" + lastName+ ", email=" + email + " department =" + this.getDepartment() + "]";
		  	else
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	

	}

}
