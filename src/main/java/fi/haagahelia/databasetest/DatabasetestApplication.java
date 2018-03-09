package fi.haagahelia.databasetest;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.databasetest.domain.Department;
import fi.haagahelia.databasetest.domain.DepartmentRepository;
import fi.haagahelia.databasetest.domain.Student;
import fi.haagahelia.databasetest.domain.StudentRepository;

@SpringBootApplication
public class DatabasetestApplication {
	private static final Logger log= LoggerFactory.getLogger(DatabasetestApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(DatabasetestApplication.class, args);
	}


	@Bean 
	public CommandLineRunner demo(StudentRepository srepository,DepartmentRepository drepository){
		return(args) -> {
									//local variable 
			log.info("save students");
			drepository.save(new Department("IT"));
			drepository.save(new Department("Business"));
			drepository.save(new Department("law"));

			srepository.save(new Student( "juha", "hinkula", "juha.hinkula@email.com",drepository.findByName("IT").get(0))); 
			srepository.save(new Student( "Mike", "Mars", "mars@mars.com",drepository.findByName("IT").get(0)));	       

			log.info("return all students");
			for (Student student : srepository.findAll()) {
				log.info(student.toString());
			}
		
		};
	}
}
				// right clicked to add the 0,1 (originally 0) and added department = null
				//adding "department" would just ask to verify another String.

		

