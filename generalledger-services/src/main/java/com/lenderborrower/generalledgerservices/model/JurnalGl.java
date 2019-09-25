package com.lenderborrower.generalledgerservices.model;

import java.sql.Date;

public class JurnalGl extends BaseModel  {
	private Integer id;
	private Double jumlah;
	private Date tanggal;
	private Integer tipeJurnal;
	private Integer idAkun;
	private String nomorTransaksi;
	private Integer idMember;
	
	public JurnalGl(Integer id, java.sql.Date createdAt, java.sql.Date updatedAt, Double jumlah,
			Date tanggal, Integer tipeJurnal, Integer idAkun, String nomorTransaksi, Integer idMember) {
		super(id, createdAt, updatedAt);
		this.jumlah = jumlah;
		this.tanggal = tanggal;
		this.tipeJurnal = tipeJurnal;
		this.idAkun = idAkun;
		this.nomorTransaksi = nomorTransaksi;
		this.idMember = idMember;
	}

	public Integer getId() {
		return id;
	}

	public Double getJumlah() {
		return jumlah;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public Integer getTipeJurnal() {
		return tipeJurnal;
	}

	
	public String getNomorTransaksi() {
		return nomorTransaksi;
	}

	public Integer getIdMember() {
		return idMember;
	}

	public Integer getIdAkun() {
		return idAkun;
	}
	
	

}