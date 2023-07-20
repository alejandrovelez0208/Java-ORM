package com.javacorner.admin.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructors")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id", nullable = false)
	private Long instructorId;

	@Basic
	@Column(name = "firts_name", nullable = false, length = 46)
	private String firstName;

	@Basic
	@Column(name = "last_name", nullable = false, length = 46)
	private String lastName;

	@Basic
	@Column(name = "summary", nullable = false, length = 45)
	private String summary;

	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
	private Set<Course> courses = new HashSet<>();

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false )
	private User user;

	@Override
	public int hashCode() {
		return Objects.hash(firstName, instructorId, lastName, summary);
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", summary=" + summary + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(instructorId, other.instructorId)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(summary, other.summary);
	}

	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String summary, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.summary = summary;
		this.user = user;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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
