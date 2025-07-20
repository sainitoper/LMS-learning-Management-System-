package com.example.OnlineLearningManegementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.OnlineLearningManegementSystem.Entity.Lesson;
import com.example.OnlineLearningManegementSystem.Service.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // Create Lesson
    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    // Get all Lessons
    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    // Get Lesson by ID
    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    // Update Lesson
    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson lessonDetails) {
        return lessonService.updateLesson(id, lessonDetails);
    }

    // Delete Lesson
    @DeleteMapping("/{id}")
    public String deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return "Lesson with ID " + id + " deleted successfully.";
    }
}
