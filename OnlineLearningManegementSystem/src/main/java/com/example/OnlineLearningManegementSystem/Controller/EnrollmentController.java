package com.example.OnlineLearningManegementSystem.Controller;

import com.example.OnlineLearningManegementSystem.Entity.Enrollment;
import com.example.OnlineLearningManegementSystem.Service.EnrollmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentServices enrollmentServices;

    // Create new enrollment
    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentServices.saveEnrollment(enrollment);
    }

    // Get all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentServices.getAllEnrollments();
    }

    // Get enrollment by ID
    @GetMapping("/{id}")
    public Optional<Enrollment> getEnrollmentById(@PathVariable Long id) {
        return enrollmentServices.getEnrollmentById(id);
    }

    // Update enrollment
    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return enrollmentServices.updateEnrollment(id, enrollment);
    }

    // Delete enrollment
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentServices.deleteEnrollment(id);
        return "Enrollment with ID " + id + " deleted successfully.";
    }
}
