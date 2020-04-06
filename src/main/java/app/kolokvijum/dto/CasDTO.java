package app.kolokvijum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import app.kolokvijum.model.Cas;
import app.kolokvijum.model.NastavniProgram;
import app.kolokvijum.model.Predmet;

public class CasDTO {

	private Long id;
	private String tema;
	private LocalDateTime pocetak;
	private LocalDateTime kraj;

	private List<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
	private List<NastavniProgramDTO> nastavniProgrami = new ArrayList<NastavniProgramDTO>();
	private List<CasDTO> casovi = new ArrayList<CasDTO>();

	public CasDTO() {
		super();
	}

	public CasDTO(Long id, String tema) {
		super();
		this.id = id;
		this.tema = tema;
	}

	public CasDTO(Long id, String tema, LocalDateTime pocetak, LocalDateTime kraj) {
		super();
		this.id = id;
		this.tema = tema;
		this.pocetak = pocetak;
		this.kraj = kraj;
	}

	public CasDTO(Cas cas) {
		super();
		this.id = cas.getId();
		this.tema = cas.getTema();
		this.pocetak = cas.getPocetak();
		this.kraj = cas.getKraj();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
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

	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}

	public List<NastavniProgramDTO> getNastavniProgrami() {
		return nastavniProgrami;
	}

	public void setNastavniProgrami(List<NastavniProgramDTO> nastavniProgrami) {
		this.nastavniProgrami = nastavniProgrami;
	}

	public List<CasDTO> getCasovi() {
		return casovi;
	}

	public void setCasovi(List<CasDTO> casovi) {
		this.casovi = casovi;
	}

	

}
