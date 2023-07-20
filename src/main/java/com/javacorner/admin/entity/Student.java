package com.javacorner.admin.entity;

import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false, length = 45)
	private Long studentId;

	@Basic
	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@Basic
	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;

	@Basic
	@Column(name = "level", nullable = false, length = 64)
	private String level;

	@ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
	private Set<Course> courses = new HashSet<>();

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	private User user;

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, level, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(level, other.level) && Objects.equals(studentId, other.studentId);
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", level="
				+ level + "]";
	}

	public Student(String firstName, String lastName, String level, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.level = level;
		this.user = user;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
