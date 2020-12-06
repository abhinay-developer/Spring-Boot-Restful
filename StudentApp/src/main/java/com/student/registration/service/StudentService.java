package com.student.registration.service;

import java.util.List;
import java.util.Optional;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.registration.dto.StudentDto;
import com.student.registration.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public StudentDto createStudent(StudentDto studentDto)throws Exception{
		
		return studentRepository.save(studentDto);
	}
	
	public   List<StudentDto>  getAllStudents()throws Exception{
		
		return studentRepository.findAll();
	}
	
	public  Optional<StudentDto>  fetchStudent(int id)throws Exception{
		
		return studentRepository.findById(id);
	}
	
	public String deleteStudent(int id) throws Exception {
		String message="            ";
		try {
			studentRepository.deleteById(id);	
			message = "Deleted";
		}
		catch (Exception e) {
			throw new Exception("message not found "+id);
		}
		return message;
	}
}
