package com.lenderborrower.useraccountservices.request;


public class MemberRequest { 
	private Integer id; 
	private String kode;
	private String nik; 
	private String nama; 
	private String phoneNo; 
	private String alamat; 
	private int isActive;
	private int isLender;
	private int isBorrower;
	
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getIsLender() {
		return isLender;
	}
	public void setIsLender(int isLender) {
		this.isLender = isLender;
	}
	public int getIsBorrower() {
		return isBorrower;
	}
	public void setIsBorrower(int isBorrower) {
		this.isBorrower = isBorrower;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
