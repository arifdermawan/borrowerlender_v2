package com.lenderborrower.useraccountservices.model;


public class Account extends BaseModel{
	private String kodeAkun; 
	private Integer isActive; 
	private Integer idMember;
	


	public Account(Integer id, java.sql.Date createdAt, java.sql.Date updatedAt, String kodeAkun, Integer isActive,
		Integer idMember) {
		super(id, createdAt, updatedAt);
		this.kodeAkun = kodeAkun;
		this.isActive = isActive;
		this.idMember = idMember;
	}
	
	public String getKodeAkun() {
		return kodeAkun;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public Integer getIdMember() {
		return idMember;
	}
	
	
}
