package com.example.OnlineLearningManegementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineLearningManegementSystem.Entity.Course;
import com.example.OnlineLearningManegementSystem.Entity.Instrctor;
import com.example.OnlineLearningManegementSystem.Repositary.CourseRepo;
import com.example.OnlineLearningManegementSystem.Repositary.InstrctorRepo;
@Service
public class CourseServices {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private InstrctorRepo instrctorRepo;
	
	
	public Course createCourse(Course course,Long instrctor_id)
	{
	     Instrctor instrctor = instrctorRepo.findById(instrctor_id).
	    		 orElseThrow(()->new RuntimeException("Instrctor not found by id"+instrctor_id));
	     
	     course.setInstrctor(instrctor);
	     return courseRepo.save(course);
	}
	
	public List<Course> getAll()	
	{
		return courseRepo.findAll();
	}
	
	public Course getByid(long id)
	{
		return courseRepo.findById(id).orElseThrow(()->new RuntimeException("Course by id not found"+id));
	}
	
	public void update(long id,Course courseupdate)
	{
		Course course = courseRepo.findById(id).
	    		 orElseThrow(()->new RuntimeException("course not found by id"+id));
		course.setTitle(courseupdate.getTitle());
		course.setDescription(courseupdate.getDescription());
		course.setCreateDate(courseupdate.getCreateDate());
		 courseRepo.save(course);
	}
	
	public void delete(long id)
	{
		if(!courseRepo.existsById(id))
		{
			 throw new RuntimeException("Course not found with id: " + id);
		}
		courseRepo.deleteById(id);
	}

}
