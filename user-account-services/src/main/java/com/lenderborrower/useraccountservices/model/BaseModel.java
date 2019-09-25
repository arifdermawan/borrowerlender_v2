package com.lenderborrower.useraccountservices.model;

import java.sql.Date;

public class BaseModel {
	
	private Integer id;
	private Date createdAt; 
	private Date updatedAt;
	
	public BaseModel(Integer id, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Integer getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
}
