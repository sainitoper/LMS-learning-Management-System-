package com.example.OnlineLearningManegementSystem.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineLearningManegementSystem.Entity.Instrctor;
@Repository
public interface InstrctorRepo extends JpaRepository<Instrctor, Long> {

}
