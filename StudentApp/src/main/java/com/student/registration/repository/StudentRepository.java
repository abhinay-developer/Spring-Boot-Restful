package com.student.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.registration.dto.StudentDto;

@Repository
public interface StudentRepository extends JpaRepository<StudentDto, Integer> {
	
}
