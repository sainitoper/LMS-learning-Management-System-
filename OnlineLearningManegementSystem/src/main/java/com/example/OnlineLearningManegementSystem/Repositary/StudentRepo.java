package com.example.OnlineLearningManegementSystem.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineLearningManegementSystem.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
