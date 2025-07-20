package com.example.OnlineLearningManegementSystem.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OnlineLearningManegementSystem.Entity.Instrctor;
import com.example.OnlineLearningManegementSystem.Service.InstrctorService;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstrctorService instrctorService;

    // ✅ Add new instructor
    @PostMapping
    public ResponseEntity<Instrctor> createInstructor(@RequestBody Instrctor instrctor) {
        Instrctor saved = instrctorService.saveInstrctor(instrctor);
        return ResponseEntity.ok(saved);
    }

    // ✅ Get all instructors
    @GetMapping
    public List<Instrctor> getAllInstructors() {
        return instrctorService.getAllInstrctors();
    }

    // ✅ Get instructor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Instrctor> getInstructorById(@PathVariable Long id) {
        Instrctor instrctor = instrctorService.getInstrctorById(id);
        if (instrctor != null) {
            return ResponseEntity.ok(instrctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Delete instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id) {
        instrctorService.deleteInstrctorById(id);
        return ResponseEntity.ok("Instructor deleted successfully.");
    }

    // ✅ Update instructor's email and bio
    @PutMapping("/{id}")
    public ResponseEntity<Instrctor> updateInstructorDetails(@PathVariable Long id,
                                                             @RequestParam String email,
                                                             @RequestParam String bio) {
        Instrctor updated = instrctorService.updateInstrctorDetails(id, email, bio);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
