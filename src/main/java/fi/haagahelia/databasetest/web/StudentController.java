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
	
	
	
//	public void doSomething() {
//  List<student> students = repository.findByLastname["Edwards");	
	
	@RequestMapping ("/student")         								  
	public String student(Model model) {								 
		model.addAttribute("students",repository.findAll());
		return "studentlist";          					

	}
	
	//Add new student (department onwards)
	@RequestMapping(value ="/add")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student(0, null, null, null, null)); 
		model.addAttribute("departments", repository.findAll());   // Added Departments here!
		return "addstudent";
	}
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String save(Student student){
		repository.save(student);  
		return "redirect:student";			//in CRUD have /Student from student to
	}
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id")Long studentId, Model model) {
		repository.delete(studentId);
		return "redirect:../student";
	}
	@RequestMapping(value = "/edit/{id}")
	public String addStudent(@PathVariable("id") Long studentId, Model model) {
		model.addAttribute("student", repository.findOne(studentId));
		model.addAttribute("departments",repository.findAll());
		return "editstudent"; // should this be Student? not editstudent
	}
		
			
}
	

	

