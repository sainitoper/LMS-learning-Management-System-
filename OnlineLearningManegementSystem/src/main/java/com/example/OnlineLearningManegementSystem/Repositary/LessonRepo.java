package com.example.OnlineLearningManegementSystem.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineLearningManegementSystem.Entity.Lesson;
@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long>{

}
