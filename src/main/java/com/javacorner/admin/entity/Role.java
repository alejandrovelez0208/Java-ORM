package com.javacorner.admin.entity;

import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roles_id", nullable = false, length = 45)
	private Long roleId;

	@Basic
	@Column(name = "name", nullable = false, length = 45, unique = true)
	private String name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(name, other.name) && Objects.equals(roleId, other.roleId);
	}

	public Role() {
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + "]";
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
