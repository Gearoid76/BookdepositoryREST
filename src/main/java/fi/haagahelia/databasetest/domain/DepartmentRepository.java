package fi.haagahelia.databasetest.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long>
{
	
	  List<Department>findByName(String Department);  
	//Enabling ignoring case 
	  List<Student>findByLastNameIgnoreCase(String Department);
		

}
