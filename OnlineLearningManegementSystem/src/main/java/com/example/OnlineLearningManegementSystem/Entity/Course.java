package com.example.OnlineLearningManegementSystem.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="course")
public class Course {
    @Id
	private long id;
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public Instrctor getInstrctor() {
		return instrctor;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public void setInstrctor(Instrctor instrctor) {
		this.instrctor = instrctor;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	private String title;
	private String description;
	private LocalDate createDate;
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", createDate=" + createDate
				+ ", instrctor=" + instrctor + "]";
	}

	public Course() {
		
	}

	@ManyToOne
	@JoinColumn(name="instrctor_id")
	private Instrctor instrctor;
	
	@OneToMany(mappedBy = "course" , cascade = CascadeType.ALL)
	private Set<Enrollment> enrollments = new HashSet<>();
	
	@OneToMany(mappedBy = "course" , cascade = CascadeType.ALL)
	private List<Lesson> lessons = new ArrayList<>();
	
}
