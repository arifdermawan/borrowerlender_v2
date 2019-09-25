package com.lenderborrower.useraccountservices.model;

import java.sql.Date;

public class Member extends BaseModel { 
	private String kode;
	private String nik; 
	private String nama; 
	private String phoneNo; 
	private String alamat; 
	private int isActive;
	private int isLender;
	private int isBorrower;
	
	public Member(Integer id, String kode, String nik, String nama, String phoneNo, String alamat, int isActive, int isLender,int isBorrower, Date createdAt, Date updatedAt){
		super(id, createdAt, updatedAt);
		this.kode = kode;
		this.nik = nik;
		this.nama = nama;
		this.phoneNo = phoneNo;
		this.alamat = alamat;
		this.isActive = isActive;
		this.isLender = isLender;
		this.isBorrower = isBorrower;
	}

	public String getKode() {
		return kode;
	}

	public String getNik() {
		return nik;
	}

	public String getNama() {
		return nama;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getAlamat() {
		return alamat;
	}

	public int getIsActive() {
		return isActive;
	}

	public int getIsLender() {
		return isLender;
	}

	public int getIsBorrower() {
		return isBorrower;
	}
	
	
}
