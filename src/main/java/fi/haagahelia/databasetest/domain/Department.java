package fi.haagahelia.databasetest.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department") 
	private List<Student> students;
	private List<Department>departents; // added this 
	
	
	public Department(List<Student> students) {
		super();
		this.students = students;	
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
		//added setters and getters 
	public List<Department> getDepartents() {
		return departents;
	}

	public void setDepartents(List<Department> departents) {
		this.departents = departents;
	}
	
	
	

}
