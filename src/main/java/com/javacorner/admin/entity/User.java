package com.javacorner.admin.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, length = 45)
	private Long userId;

	@Basic
	@Column(name = "email", nullable = false, length = 45, unique = true)
	private String email;

	@Basic
	@Column(name = "password", nullable = false, length = 45)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	@OneToOne(mappedBy = "user")
	private Student student;

	@OneToOne(mappedBy = "user")
	private Instructor instructor;

	@Override
	public int hashCode() {
		return Objects.hash(email, password, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + "]";
	}

	public void assignRoleToUser(Role role) {
		this.roles.add(role);
		role.getUsers().add(this);
	}

	public void removeRoleFromUser(Role role) {
		this.roles.add(role);
		role.getUsers().add(this);

	}

	public User() {
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
