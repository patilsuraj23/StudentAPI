package com.Student.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Entity.Student;

import com.Student.service.StudentService;

@RestController
@RequestMapping("/students")
public class studentController {

	@Autowired
	private StudentService studentService;

//	 Get all the Students data 
	@GetMapping("/stu")
	public List<Student> getAllstudents() {
		return studentService.getAllStudents();
	}

//	 Get the students data using its id .
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if (student.isPresent()) {
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	Add Students data 
	 @PostMapping("")
	    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
	        Student savedStudent = studentService.saveStudent(student);
	        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	    }
	 
//   Delete the students data using id .
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	        return ResponseEntity.ok().build();
	    }
	    
//	    Update the Students data Using its id .
	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
	        Student updatedStudent = studentService.updateStudent(id, student);
	        if (updatedStudent != null) {
	            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
