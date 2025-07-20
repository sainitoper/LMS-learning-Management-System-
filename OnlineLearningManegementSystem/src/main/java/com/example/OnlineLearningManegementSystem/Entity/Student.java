package com.example.OnlineLearningManegementSystem.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="student")
public class Student {
	@Id
private long id;
public Student() {
	
}

private String name;
public long getId() {
	return id;
}

public String getName() {
	return name;
}

public String getEmail() {
	return email;
}

public String getPassword() {
	return password;
}

public Set<Enrollment> getEnrollments() {
	return enrollments;
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

public void setPassword(String password) {
	this.password = password;
}

public void setEnrollments(Set<Enrollment> enrollments) {
	this.enrollments = enrollments;
}

private String email;
private String password;

@OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
private Set<Enrollment> enrollments = new HashSet<>();
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
}


}
