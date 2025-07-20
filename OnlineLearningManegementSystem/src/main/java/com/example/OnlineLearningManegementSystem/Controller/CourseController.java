package com.example.OnlineLearningManegementSystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OnlineLearningManegementSystem.Entity.Course;
import com.example.OnlineLearningManegementSystem.Service.CourseServices;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    // ✅ Create a course (requires instructor ID)
    @PostMapping("/instructor/{instructorId}")
    public ResponseEntity<Course> createCourse(@RequestBody Course course, @PathVariable("instructorId") Long instructorId) {
        Course created = courseServices.createCourse(course, instructorId);
        return ResponseEntity.ok(created);
    }

    // ✅ Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseServices.getAll();
    }

    // ✅ Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseServices.getByid(id);
        return ResponseEntity.ok(course);
    }

    // ✅ Update course
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        courseServices.update(id, course);
        return ResponseEntity.ok("Course updated successfully.");
    }

    // ✅ Delete course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseServices.delete(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }
}
