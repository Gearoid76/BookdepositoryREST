package fi.haagahelia.bookdepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookdepository.domain.Book;
import fi.haagahelia.bookdepository.domain.BookRepository;
import fi.haagahelia.bookdepository.domain.Category;
import fi.haagahelia.bookdepository.domain.CategoryRepository;
import fi.haagahelia.bookdepository.domain.User;
import fi.haagahelia.bookdepository.domain.UserRepository;


@SpringBootApplication
public class DatabasetestApplication {
	private static final Logger log= LoggerFactory.getLogger(DatabasetestApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(DatabasetestApplication.class, args);
	}


	@Bean 
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return(args) -> {
									//local variable 
			log.info("save Categories");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Non-fiction"));

			brepository.save(new Book("For whom the bell tolls", "Ernest Hemingway","1940", "454667","4,56", crepository.findByName("Horror").get(0)));
			brepository.save(new Book("The adventures of Tom Sawyer","Mark Twain","1876","342255", "1.25",  crepository.findByName("Horror").get(0) ));
			brepository.save(new Book("The Running man", "Stephen King","1982", "234465", "30.78",crepository.findByName("Horror").get(0)));
			brepository.save(new Book("To the lighthouse", "Virginia Woolf","1927","45654", "4.78",  crepository.findByName("Horror").get(0)));
			brepository.save(new Book("The great Gatsby", "F.Scott Fitzgerald","1925","45654", "4.78", crepository.findByName("Horror").get(0)));
			brepository.save(new Book("1984", "George Orwell","1949","459454", "12.78", crepository.findByName("Horror").get(0)));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$04$hHrU55FK94bBl3L7jyVkKuINEeqSXjaBh37aPfksLpWU7yXin68ii", "USER");
			User user2 = new User("admin", "$2a$04$fkSSBoKFIb0P4aKQh4ve9ewarDc8ZTSHnXdfFhM60Cb9huM6WY96a", "ADMIN");//passwordadmin
			urepository.save(user1);
			urepository.save(user2);
			
			
			//urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			//urepository.save(new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
											// comparing code lecturer as urepository.save(user1); and two
			log.info("return all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}
}
				// right clicked to add the 0,1 (originally 0) and added department = null
				//adding "department" would just ask to verify another String.

		

