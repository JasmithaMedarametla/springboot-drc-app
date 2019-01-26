package com.wiu.drc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiu.drc.entity.Student;
import com.wiu.drc.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	
	private StudentService studentService;
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	@GetMapping("/students")
	public List<Student> findAll()
	{
		return studentService.findAll();
	}
	@GetMapping("/students/{theStudentId}")
	public Student findById(@PathVariable int theStudentId)
	{
		Student theStudent=studentService.findById(theStudentId);
		if(theStudent==null)
			throw new RuntimeException("Student Not Found");
		else
		return theStudent;
	}
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student theStudent)
	{
		theStudent.setId(0);
		studentService.save(theStudent);
		return theStudent;
	}
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent)
	{
		studentService.save(theStudent);
		return theStudent;
	}
	
	@DeleteMapping("/students/{theStudentId}")
	public String deleteById(@PathVariable int theStudentId)
	{
		Student theStudent=studentService.findById(theStudentId);
		if(theStudent==null)
			throw new RuntimeException("Student Not Found");
		else
		 studentService.deleteById(theStudentId);
		
		return  "Deleted the Student!";
		 
	}
}
