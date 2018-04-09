package fi.haagahelia.bookdepository.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bookdepository.domain.Book;
import fi.haagahelia.bookdepository.domain.BookRepository;
import fi.haagahelia.bookdepository.domain.CategoryRepository;



@Controller
public class BookController {
	@Autowired
	private BookRepository brepository; // throwing an error changing from brepository to repos..
	
	@Autowired
	private CategoryRepository crepository;
	
	  @RequestMapping(value="/login")
			public String login() {
				return "login";
	}
	
	@RequestMapping ("/booklist")
	public String book(Model model) {
		model.addAttribute("books",brepository.findAll());
		return "booklist";
		}
	// RESTful service to get all services for books 
    @RequestMapping(value="/books")
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) brepository.findAll(); // found repository or brepository 
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {	
    	return brepository.findOne(bookId);
    	} 
    // Add new Book
   @PreAuthorize("hasAuthority('ROLE_ADMIN')") // problem got to configure put in ROLE 
    @RequestMapping(value = "/add")
    public String addBook(Model model){          // testing testing to see if it worked System.out.println("hello");
    	model.addAttribute("book", new Book());
    	model.addAttribute("category", crepository.findAll());
        return "/addbook";
    }
    
	
	// Saving new book 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		brepository.save(book);
		return "redirect:booklist";
		} 
	     
	    
 // Delete book 
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	brepository.delete(bookId);
	        return "redirect:../booklist";
	    }	  
}

//  Notes 
// had problems with the preauthorize function it wasnt working 
// also mistyped ADMIN was should of been to be ROLE_ADMIN
