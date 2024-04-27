package com.student.crud.com.student.crud.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.crud.com.student.crud.app.entity.Student;
import com.student.crud.com.student.crud.app.service.StudentService;
@RestController
public class StudentController {

	@Autowired
	StudentService service;
	//create
	@PostMapping("/add") //api end point - / check
	public String  addStudent(@RequestBody  Student st)
	{
		System.out.println(" student data recieved from client  : "+st);
		service.addStudent(st);
		return "student data added successfully";
	}
	//get
	@GetMapping("/get")
	public Student getStudent(@RequestParam("roll") int roll)
	{
		Student st=service.getStudent(roll);
		return st;
	}
	//get all data
	@GetMapping("/getAll")
	public  List  getAllStudents()
	{
		List<Student> stList=service.getAllStudnets();
		return stList;
	}
	//update
	@PutMapping("/update") //api end point - / check
	public String  updateStudent(@RequestBody Student st)
	{
		
		service.updateStudent(st);
		return "student data updated successfully";
	}
	
	//delete
	@DeleteMapping("/delete")
	public String deleteStudent(@RequestParam("roll") int roll)
	{
		   service.deleteStudent(roll);
		            return "Student record is deleted";
	}
	
}
