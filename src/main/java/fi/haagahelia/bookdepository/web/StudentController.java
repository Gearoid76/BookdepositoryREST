package fi.haagahelia.databasetest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.haagahelia.databasetest.domain.Student;
import fi.haagahelia.databasetest.domain.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository repository; 
	
	@Autowired
	private fi.haagahelia.databasetest.domain.DepartmentRepository drepository;
	
	
	@RequestMapping ("/student")         								  
	public String student(Model model) {								 
		model.addAttribute("students",repository.findAll());
		return "student";          					

	}
	
	//Add new student (department onwards)
	 @RequestMapping(value = "/add")
	    public String addStudent(Model model){
	    	model.addAttribute("student", new Student());
	    	model.addAttribute("departments", drepository.findAll());
	        return "addstudent";
	    }     
	    
	    // Save new student
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Student student){
	        repository.save(student);
	        return "redirect:studentlist";
	    }    

	    // Delete student
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
	    	repository.delete(studentId);
	        return "redirect:../studentlist";
	    }     
	@RequestMapping(value = "/edit/{id}")
	public String addStudent(@PathVariable("id") Long studentId, Model model) {
		model.addAttribute("student", repository.findOne(studentId));
		model.addAttribute("departments",drepository.findAll());
		return "editstudent"; // should this be Student? not editstudent
	}
		
			
}
	

	

