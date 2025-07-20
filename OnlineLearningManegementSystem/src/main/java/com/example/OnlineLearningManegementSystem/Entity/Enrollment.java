package com.example.OnlineLearningManegementSystem.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="enrollment")
public class Enrollment {
	@Id
private long id;
public long getId() {
	return id;
}

public LocalDate getEnrolmentDate() {
	return enrolmentDate;
}

public Double getProgess() {
	return progess;
}

public Course getCourse() {
	return course;
}

public Student getStudent() {
	return student;
}

public void setId(long id) {
	this.id = id;
}

public void setEnrolmentDate(LocalDate enrolmentDate) {
	this.enrolmentDate = enrolmentDate;
}

public void setProgess(Double progess) {
	this.progess = progess;
}

public void setCourse(Course course) {
	this.course = course;
}

public void setStudent(Student student) {
	this.student = student;
}

@Override
public String toString() {
	return "Enrollment [id=" + id + ", enrolmentDate=" + enrolmentDate + ", progess=" + progess + ", course=" + course
			+ ", student=" + student + "]";
}

public Enrollment() {
	super();
}

private LocalDate enrolmentDate;
private Double progess;

@ManyToOne
@JoinColumn(name="course_id")
private Course course;

@ManyToOne
@JoinColumn(name="student_id")
private Student student;
}
