package fi.haagahelia.databasetest.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Long>  {

	List <Student> findByLastName(String lastName);
	
	//Enabling ignoring case 
	List<Student>findByLastNameIgnoreCase(String lastName);
	
	//Enabling ORDER BY for a query
	List<Student> findByLastNameOrderByFirstNameAsc(String lastName);
}
	
