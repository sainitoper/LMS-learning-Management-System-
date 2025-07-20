package com.example.OnlineLearningManegementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineLearningManegementSystem.Entity.Lesson;
import com.example.OnlineLearningManegementSystem.Repositary.LessonRepo;

@Service
public class LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    // Create Lesson
    public Lesson createLesson(Lesson lesson) {
        return lessonRepo.save(lesson);
    }

    // Get all Lessons
    public List<Lesson> getAllLessons() {
        return lessonRepo.findAll();
    }

    // Get Lesson by ID
    public Lesson getLessonById(Long id) {
        return lessonRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
    }

    // Update Lesson
    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        Lesson lesson = getLessonById(id);
        lesson.setTitle(lessonDetails.getTitle());
        lesson.setContent(lessonDetails.getContent());
        lesson.setDuration(lessonDetails.getDuration());
        lesson.setCourse(lessonDetails.getCourse());
        return lessonRepo.save(lesson);
    }

    // Delete Lesson
    public void deleteLesson(Long id) {
        if (!lessonRepo.existsById(id)) {
            throw new RuntimeException("Lesson not found with id: " + id);
        }
        lessonRepo.deleteById(id);
    }
}
