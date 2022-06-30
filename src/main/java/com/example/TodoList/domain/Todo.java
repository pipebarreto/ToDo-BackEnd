package com.example.TodoList.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "TO_DO")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	private String keyword;
	
	private Long OwnerId;
	
	private StatusName status;
	
	@CreationTimestamp
	@Column(updatable= false)
	private Timestamp createdAt;
	
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	public Todo() {
		
	}
	
	public Todo (String name, String description, String keyword, StatusName status) {
		this.name=name;
		this.description=description;
		this.keyword=keyword;
		this.status=status;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public StatusName getStatus() {
		return status;
	}

	public void setStatus(StatusName status) {
		this.status = status;
	}

	public Long getOwnerId() {
		return OwnerId;
	}

	public void setOwnerId(Long ownerId) {
		this.OwnerId = ownerId;
	}
	
	
	
}