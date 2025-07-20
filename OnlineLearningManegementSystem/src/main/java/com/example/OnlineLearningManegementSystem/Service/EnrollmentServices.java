package com.example.OnlineLearningManegementSystem.Service;

import com.example.OnlineLearningManegementSystem.Entity.Enrollment;
import com.example.OnlineLearningManegementSystem.Repositary.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServices {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    // Save new enrollment
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepo.save(enrollment);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    // Get enrollment by ID
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepo.findById(id);
    }

    // Update enrollment
    public Enrollment updateEnrollment(Long id, Enrollment updatedEnrollment) {
        return enrollmentRepo.findById(id).map(existing -> {
            existing.setCourse(updatedEnrollment.getCourse());
            existing.setStudent(updatedEnrollment.getStudent());
            existing.setEnrolmentDate(updatedEnrollment.getEnrolmentDate());
            existing.setProgess(updatedEnrollment.getProgess());
            return enrollmentRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Enrollment not found with ID: " + id));
    }

    // Delete enrollment by ID
    public void deleteEnrollment(Long id) {
        enrollmentRepo.deleteById(id);
    }
}
