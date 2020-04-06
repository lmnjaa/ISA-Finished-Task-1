package app.kolokvijum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import app.kolokvijum.model.Cas;
import app.kolokvijum.model.Zadatak;

public class ZadatakDTO {
	
	private Long id;
	private String oblast, tekst;
	private LocalDateTime pocetak, kraj;
	
	
	private List<CasDTO> casovi = new ArrayList<CasDTO>();
	
	public ZadatakDTO(Long id, String oblast, String tekst, LocalDateTime pocetak, LocalDateTime kraj) {
		super();
		this.id = id;
		this.oblast = oblast;
		this.tekst = tekst;
		this.pocetak = pocetak;
		this.kraj = kraj;
	}
	public ZadatakDTO() {
		super();
	}
	public ZadatakDTO(Long id, String oblast) {
		super();
		this.id = id;
		this.oblast = oblast;
	}
	
	public ZadatakDTO(Zadatak zadatak) {
		super();
		this.id = zadatak.getId();
		this.oblast = zadatak.getOblast();
		this.tekst = zadatak.getTekst();
		this.pocetak = zadatak.getPocetak();
		this.kraj = zadatak.getKraj();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOblast() {
		return oblast;
	}
	public void setOblast(String oblast) {
		this.oblast = oblast;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public LocalDateTime getPocetak() {
		return pocetak;
	}
	public void setPocetak(LocalDateTime pocetak) {
		this.pocetak = pocetak;
	}
	public LocalDateTime getKraj() {
		return kraj;
	}
	public void setKraj(LocalDateTime kraj) {
		this.kraj = kraj;
	}
	public List<CasDTO> getCasovi() {
		return casovi;
	}
	public void setCasovi(List<CasDTO> casovi) {
		this.casovi = casovi;
	}

}
