package com.wiu.drc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiu.drc.entity.Student;

public interface StudentDAO extends JpaRepository<Student,Integer> {

	
	
}
