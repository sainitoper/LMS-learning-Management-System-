package com.example.OnlineLearningManegementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineLearningManegementSystem.Entity.Instrctor;
import com.example.OnlineLearningManegementSystem.Repositary.InstrctorRepo;

@Service
public class InstrctorService {

    @Autowired
    private InstrctorRepo instrctorRepo;

    // Add or Update Instructor
    public Instrctor saveInstrctor(Instrctor instrctor) {
        return instrctorRepo.save(instrctor);
    }

    // Get all instructors
    public List<Instrctor> getAllInstrctors() {
        return instrctorRepo.findAll();
    }

    // Get instructor by ID
    public Instrctor getInstrctorById(Long id) {
        Optional<Instrctor> optional = instrctorRepo.findById(id);
        return optional.orElse(null);
    }

    // Delete instructor by ID
    public void deleteInstrctorById(Long id) {
        instrctorRepo.deleteById(id);
    }

    // Update bio or email (example update method)
    public Instrctor updateInstrctorDetails(Long id, String email, String bio) {
        Optional<Instrctor> optional = instrctorRepo.findById(id);
        if (optional.isPresent()) {
            Instrctor instrctor = optional.get();
            instrctor.setEmail(email);
            instrctor.setBio(bio);
            return instrctorRepo.save(instrctor);
        }
        return null;
    }
}
