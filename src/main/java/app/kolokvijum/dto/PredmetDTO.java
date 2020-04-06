package app.kolokvijum.dto;

import java.util.HashSet;
import java.util.Set;

import app.kolokvijum.model.Cas;
import app.kolokvijum.model.NastavniProgram;
import app.kolokvijum.model.Predmet;

public class PredmetDTO {
	
	private Long id;
	private String naziv;
	private String skracenica;
	

	private Set<CasDTO> casovi = new HashSet<CasDTO>();
	private Set<NastavniProgramDTO> nastavniProgrami = new HashSet<NastavniProgramDTO>();
	
	public PredmetDTO(Long id, String naziv, String skracenica) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skracenica = skracenica;
	}
	public PredmetDTO() {
		super();
	}
	public PredmetDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	
	public PredmetDTO(Predmet predmet) {
		super();
		this.id = predmet.getId();
		this.naziv = predmet.getNaziv();
		this.skracenica = predmet.getSkracenica();
		
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getSkracenica() {
		return skracenica;
	}
	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}
	public Set<CasDTO> getCasovi() {
		return casovi;
	}
	public void setCasovi(Set<CasDTO> casovi) {
		this.casovi = casovi;
	}
	public Set<NastavniProgramDTO> getNastavniProgrami() {
		return nastavniProgrami;
	}
	public void setNastavniProgrami(Set<NastavniProgramDTO> nastavniProgrami) {
		this.nastavniProgrami = nastavniProgrami;
	}
	
	

}
