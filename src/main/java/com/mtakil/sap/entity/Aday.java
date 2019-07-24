package com.mtakil.sap.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Aday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ssm_id", nullable = false)
	private Long ssmId;
	
	@Column(name = "tcno", nullable = false)
	private String tcno;
	
	@Column(name = "ad", nullable = false)
	private String ad;
	
	@Column(name = "soyad", nullable = false)
	private String soyad;
	
	@Column(name = "dogum_tarihi")
	private Date dogumTarihi;
	
	@OneToMany(mappedBy = "aday")
	@JsonIgnoreProperties("aday")
	private List<SinavSonucu> sinavSonuclari;
	
	@OneToMany(mappedBy = "aday")
	@JsonIgnoreProperties("aday")
	private List<AdayDokuman> adayDokumanlari;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSsmId() {
		return ssmId;
	}
	public void setSsmId(Long ssmId) {
		this.ssmId = ssmId;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	public List<SinavSonucu> getSinavSonuclari() {
		return sinavSonuclari;
	}
	public void setSinavSonuclari(List<SinavSonucu> sinavSonuclari) {
		this.sinavSonuclari = sinavSonuclari;
	}
	public List<AdayDokuman> getAdayDokumanlari() {
		return adayDokumanlari;
	}
	public void setAdayDokumanlari(List<AdayDokuman> adayDokumanlari) {
		this.adayDokumanlari = adayDokumanlari;
	}
	
	@Override
	public String toString() {
		return String.format("Aday: id: %s, ssmId: %s, tcno: %s, ad: %s, soyad: %s, dogumTarihi: %s, sinavSonuclari: %s, adayDokumanlari: %s", 
				id, ssmId, tcno, ad, soyad, dogumTarihi, sinavSonuclari, adayDokumanlari);
	}
	
}
