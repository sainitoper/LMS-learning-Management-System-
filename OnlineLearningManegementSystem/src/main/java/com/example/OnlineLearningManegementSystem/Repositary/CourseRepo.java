package com.example.OnlineLearningManegementSystem.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineLearningManegementSystem.Entity.Course;
@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

}
