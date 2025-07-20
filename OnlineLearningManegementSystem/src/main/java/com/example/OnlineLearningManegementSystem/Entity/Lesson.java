package com.example.OnlineLearningManegementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="lasson")
public class Lesson {
	@Id
private long id;
public long getId() {
	return id;
}

public String getTitle() {
	return title;
}

public String getContent() {
	return content;
}

public Integer getDuration() {
	return duration;
}

public Course getCourse() {
	return course;
}

public void setId(long id) {
	this.id = id;
}

public void setTitle(String title) {
	this.title = title;
}

public void setContent(String content) {
	this.content = content;
}

public void setDuration(Integer duration) {
	this.duration = duration;
}

public Lesson() {
	
}

@Override
public String toString() {
	return "Lesson [id=" + id + ", title=" + title + ", content=" + content + ", duration=" + duration + ", course="
			+ course + "]";
}

public void setCourse(Course course) {
	this.course = course;
}

private String title;
private String content;
private Integer duration;

@ManyToOne
@JoinColumn(name="course_id")
private Course course;

}
