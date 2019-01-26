package com.wiu.drc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiu.drc.dao.StudentDAO;
import com.wiu.drc.entity.Student;
@Service
public class StudentServiceImpl implements StudentService{


	private StudentDAO studentDAO;
	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO)
	{
		this.studentDAO=studentDAO;
	}
	
	public List<Student> findAll() {
		
		return studentDAO.findAll();
	}
	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Student> result=studentDAO.findById(theId);
		Student theStudent=null;
		if(result.isPresent())
		{
		theStudent=result.get();
		}
		else {
			throw new RuntimeException("Student with this Id is not found!");
		}
		return theStudent;
	}
	@Override

	public void save(Student theStudent) {
		studentDAO.save(theStudent);
		
	}
	@Override

	public void deleteById(int theId) {
	studentDAO.deleteById(theId);
		
	}

}
