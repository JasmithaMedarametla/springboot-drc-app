package com.wiu.drc.service;

import java.util.List;

import com.wiu.drc.entity.Student;

public interface StudentService {
	public List<Student> findAll();
	public Student findById(int theId);
	public void save(Student theStudent);
	public void deleteById(int theId);
}
