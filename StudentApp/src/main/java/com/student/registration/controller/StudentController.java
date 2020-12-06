package com.student.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.registration.dto.StudentDto;
import com.student.registration.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/hello")
	public String helloMessage() {

		return "Hello";
	}

	@PostMapping(path = "/create/student", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) {

		try {
			StudentDto stDto = studentService.createStudent(studentDto);

			return new ResponseEntity<>(stDto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "/allStudents", produces = "application/json")
	public ResponseEntity<?> getAllStudents() {
		try {

			return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
		@GetMapping(path = "/getStudent/{studentId}",produces = "application/json")
		public ResponseEntity<?> getStudentId(@PathVariable int studentId){
			
			try {
				Optional<StudentDto> studentData=studentService.fetchStudent(studentId);
				
				if(studentData.isPresent()) {
					return new ResponseEntity<>(studentData.get(),HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			catch(Exception e) {
				return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		
	}
		@DeleteMapping(path = "/deleteStudent/{studentId}",produces = "application/json")
		public ResponseEntity<?> deleteMessage(@PathVariable int studentId){
			try {			
				String message=studentService.deleteStudent(studentId);
				if (message!="") {
					return new ResponseEntity<>(message, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

}