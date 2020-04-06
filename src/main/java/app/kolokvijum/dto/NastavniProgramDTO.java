package app.kolokvijum.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import app.kolokvijum.model.Cas;
import app.kolokvijum.model.NastavniProgram;
import app.kolokvijum.model.Predmet;

public class NastavniProgramDTO {
	
	private Long id;
	private String naziv;
	private String opis;
	

	private List<CasDTO> casovi = new ArrayList<CasDTO>();
	private List<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
	
	public NastavniProgramDTO(Long id, String naziv, String opis, List<CasDTO> casovi, List<PredmetDTO> predmeti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.casovi = casovi;
		this.predmeti = predmeti;
	}
	
	public NastavniProgramDTO() {
		super();
	}
	
	public NastavniProgramDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	
	public NastavniProgramDTO(NastavniProgram nastavniProgram) {
		super();
		this.id = nastavniProgram.getId();
		this.naziv = nastavniProgram.getNaziv();
		this.opis = nastavniProgram.getOpis();
		
		for(Cas c : nastavniProgram.getCasovi()) {
			casovi.add(new CasDTO(c.getId(), c.getTema()));
		}
		
		for(Predmet p : nastavniProgram.getPredmeti()) {
			predmeti.add(new PredmetDTO(p.getId(), p.getNaziv()));
		}
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<CasDTO> getCasovi() {
		return casovi;
	}

	public void setCasovi(List<CasDTO> casovi) {
		this.casovi = casovi;
	}

	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}
	
	

}
