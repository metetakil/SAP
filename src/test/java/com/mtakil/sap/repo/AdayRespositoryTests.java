package com.mtakil.sap.repo;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.mtakil.sap.entity.Aday;
import com.mtakil.sap.entity.AdayDokuman;
import com.mtakil.sap.entity.SinavSonucu;
import com.mtakil.sap.repo.AdayRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class AdayRespositoryTests {

	@Autowired
	private AdayRepository adayRepository;
	
	@Test
	public void testFindById() {
		Optional<Aday> aday = adayRepository.findById(6L);
		assertTrue(aday.isPresent());
		assertTrue(aday.get().getAd().equals("Mete"));	
	}
	
	@Test
	@Transactional
	public void testSave() {
		Aday aday = new Aday();
		aday.setSsmId(88L);
		aday.setTcno("6789");
		aday.setAd("Emel");
		aday.setSoyad("Yilmaz");
		aday.setDogumTarihi(getDate("yyyyMMdd", "19710415"));
		
		AdayDokuman adayDokuman = new AdayDokuman();
		adayDokuman.setAday(aday);
		adayDokuman.setDokumanIsmi("sertifika");
		adayDokuman.setLokasyon("home/emel");
		
		List<AdayDokuman> adayDokumanlari = new ArrayList<AdayDokuman>();
		adayDokumanlari.add(adayDokuman);
		aday.setAdayDokumanlari(adayDokumanlari);
		
		SinavSonucu sinavSonucu = new SinavSonucu();
		sinavSonucu.setAday(aday);
		sinavSonucu.setSinavAdi("YDS");
		sinavSonucu.setSinavPuani(77);
		sinavSonucu.setSinavYili(2018);
		
		List<SinavSonucu> sinavSonuclari = new ArrayList<SinavSonucu>();
		sinavSonuclari.add(sinavSonucu);
		aday.setSinavSonuclari(sinavSonuclari);
		
		Aday savedAday = adayRepository.save(aday);
		assertTrue(savedAday != null);
		assertTrue(savedAday.getId() != null);
		
		Aday adayFound = adayRepository.findByTcno("6789");
		assertTrue(adayFound != null);
		assertTrue(adayFound.getAd().equals("Emel"));
		assertTrue(adayFound.getAdayDokumanlari().size() == 1);
		assertTrue(adayFound.getSinavSonuclari().size() == 1);
		assertTrue(adayFound.getAdayDokumanlari().get(0).getDokumanIsmi().equals("sertifika"));
	}
	
	private Date getDate(String pattern, String dateStr) {
		Date date = null;
		try {
			date = new java.sql.Date(new SimpleDateFormat(pattern).parse(dateStr).getTime());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
