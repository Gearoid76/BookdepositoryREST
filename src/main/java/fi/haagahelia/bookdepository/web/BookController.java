package fi.haagahelia.bookdepository.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.bookdepository.domain.BookRepository;
import fi.haagahelia.bookdepository.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping ("/booklist")
	public String book(Model model) {
		model.addAttribute("books",repository.findAll());
		return "booklist";
		}
	// adding below the line 
	 @RequestMapping(value={"/", "/home"})
		public String homeSecure() {
			return "home";
		}  
	    
	    @RequestMapping(value="/hello")
		public String helloSecure() {
			return "hello";
		}
	    
	    @RequestMapping(value="/login")
		public String login() {
			return "login";
}
}
