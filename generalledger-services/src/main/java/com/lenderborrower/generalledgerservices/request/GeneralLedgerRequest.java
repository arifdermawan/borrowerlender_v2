package com.lenderborrower.generalledgerservices.request;

import java.sql.Date;

public class GeneralLedgerRequest {
	private Double jumlah;
	private Integer tipeJurnal;
	private Integer idAkun;
	private String nomorTransaksi;
	private Integer idMember;
	public Double getJumlah() {
		return jumlah;
	}
	public void setJumlah(Double jumlah) {
		this.jumlah = jumlah;
	}
	public Integer getTipeJurnal() {
		return tipeJurnal;
	}
	public void setTipeJurnal(Integer tipeJurnal) {
		this.tipeJurnal = tipeJurnal;
	}
	
	public String getNomorTransaksi() {
		return nomorTransaksi;
	}
	public void setNomorTransaksi(String nomorTransaksi) {
		this.nomorTransaksi = nomorTransaksi;
	}
	public Integer getIdMember() {
		return idMember;
	}
	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}
	public Integer getIdAkun() {
		return idAkun;
	}
	public void setIdAkun(Integer idAkun) {
		this.idAkun = idAkun;
	}
	
	
	
}
