package com.example.TodoList.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "USERS")
public class UserModel  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true, updatable = false)
	private String email;
	
	 @Column(nullable = false)
	private String password;
	
	@CreationTimestamp
	@Column(updatable= false)
	private Timestamp createdAt;
	
	@UpdateTimestamp
	private Timestamp updatedAt;
	
public UserModel() {
		
	}
	
	public UserModel (String email, String password) {
		this.email=email;
		this.password=password;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}


