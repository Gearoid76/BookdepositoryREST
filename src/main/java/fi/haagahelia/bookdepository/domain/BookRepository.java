package fi.haagahelia.bookdepository.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BookRepository extends CrudRepository <Book,Long> {
	
	
//	List<Book> findByName(String title);
	
	
	//REST side of the previous two shown below 
		List<Book>findByAuthor(@Param("author") String author);
		
		//RESTEnabling ORDER BY query
			List<Book>findByAuthorOrderByTitleAsc(@Param("author") String author);
		
		
		//RESTEnabling ignoring case 
			List<Book>findByTitle(@Param("title") String title);
			
		
		//RESTEnabling ignoring case 
			List<Book>findByTitleIgnoreCase(@Param("title") String title);
		
		}
		


