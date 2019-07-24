package com.mtakil.sap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SinavSonucu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="aday_id", nullable = false)
	private Aday aday;
	
	@Column(name = "sinav_adi", nullable = false)
	private String sinavAdi;
	
	@Column(name = "sinav_yili", nullable = false)
	private Integer sinavYili;
	
	@Column(name = "sinav_puani", nullable = false)
	private Integer sinavPuani;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aday getAday() {
		return aday;
	}

	public void setAday(Aday aday) {
		this.aday = aday;
	}

	public String getSinavAdi() {
		return sinavAdi;
	}

	public void setSinavAdi(String sinavAdi) {
		this.sinavAdi = sinavAdi;
	}

	public Integer getSinavYili() {
		return sinavYili;
	}

	public void setSinavYili(Integer sinavYili) {
		this.sinavYili = sinavYili;
	}

	public Integer getSinavPuani() {
		return sinavPuani;
	}

	public void setSinavPuani(Integer sinavPuani) {
		this.sinavPuani = sinavPuani;
	}

	@Override
	public String toString() {
		return String.format("SinavSonucu id: %s, aday: %s, sinavAdi: %s, sinavYili: %d, sinavPuani: %d", 
				id, aday, sinavAdi, sinavYili, sinavPuani);
	}
	
}
