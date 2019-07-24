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
public class AdayDokuman {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="aday_id", nullable = false)
	private Aday aday;
	
	@Column(name = "dokuman_ismi", nullable = false)
	private String dokumanIsmi;
	
	@Column(name = "lokasyon", nullable = false)
	private String lokasyon;

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

	public String getDokumanIsmi() {
		return dokumanIsmi;
	}

	public void setDokumanIsmi(String dokumanIsmi) {
		this.dokumanIsmi = dokumanIsmi;
	}

	public String getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(String lokasyon) {
		this.lokasyon = lokasyon;
	}

	@Override
	public String toString() {
		return String.format("AdayDokuman id: %s, aday: %s, dokumanIsmi: %s, lokasyon: %s", 
				id, aday, dokumanIsmi, lokasyon);
	}
	
}
