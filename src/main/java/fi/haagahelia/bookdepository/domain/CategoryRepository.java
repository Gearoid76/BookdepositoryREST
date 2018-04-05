package fi.haagahelia.bookdepository.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository <Category, Long> {
	
	
	List<Category>findByName(String title);  //Category
	
	//Enabling Category case 
	  List<Category>findByNameIgnoreCase(@Param("name")String title); 
	  
	//REST side of the previous two shown below 
		
		
		//RESTEnabling ignoring case 
		//List<Book>findByAuthorIgnoreCase(@Param("author")String author);
		
		//RESTEnabling ORDER BY for a query
		//List<Book> findByAuthorOrderByTitleAsc(@Param("author")String author);
	}		





