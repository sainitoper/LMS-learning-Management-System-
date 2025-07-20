package com.example.OnlineLearningManegementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineLearningManegementSystem.Entity.Student;
import com.example.OnlineLearningManegementSystem.Repositary.StudentRepo;
@Service
public class StudentServices {
	@Autowired 
	private StudentRepo studentRepo;
	
	public void createStudent(Student student)
	{
		studentRepo.save(student);
	}

	public List<Student> getAll()
	{
		return studentRepo.findAll();
	}
	
	public Student getByid(long id)
	{
		return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
		
	
	public void update(Student studentupdate,long id)
	{
		Student student = studentRepo.findById(id). orElseThrow(()->new RuntimeException("Student not found by id"+id));
		student.setName(studentupdate.getName());
		student.setEmail(studentupdate.getEmail());
		student.setPassword(studentupdate.getPassword());
		student.setEnrollments(studentupdate.getEnrollments());
		studentRepo.save(student);
	}
	public void delete(long id)
	{
		studentRepo.deleteById(id);
	}
	}
	

