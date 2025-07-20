package com.example.OnlineLearningManegementSystem.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="instector")
public class Instrctor {
	@Id
	private long id;
	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getBio() {
		return bio;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public Instrctor() {
		
	}


	private String name;
	private String email;
	private String bio;
	
	
	@OneToMany(mappedBy ="instrctor" , cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	@Override
	public String toString() {
		return "Instrctor [id=" + id + ", name=" + name + ", email=" + email + ", bio=" + bio + "]";
	}

}
