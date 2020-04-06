package app.kolokvijum.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "predmet")
public class Predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Type(type = "text")
	private String naziv;

	@Column
	@Type(type = "text")
	private String skracenica;

	@OneToMany(mappedBy="cas")
	private List<Cas> casovi = new ArrayList<>();

	@ManyToOne
	private NastavniProgram nastavniProgram;

	public Predmet() {
		super();
	}

	public Predmet(Long id, String naziv, String skracenica) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skracenica = skracenica;
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



	public List<Cas> getCasovi() {
		return casovi;
	}

	public void setCasovi(List<Cas> casovi) {
		this.casovi = casovi;
	}

	public NastavniProgram getNastavniProgram() {
		return nastavniProgram;
	}

	public void setNastavniProgram(NastavniProgram nastavniProgram) {
		this.nastavniProgram = nastavniProgram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casovi == null) ? 0 : casovi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((skracenica == null) ? 0 : skracenica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predmet other = (Predmet) obj;
		if (casovi == null) {
			if (other.casovi != null)
				return false;
		} else if (!casovi.equals(other.casovi))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (skracenica == null) {
			if (other.skracenica != null)
				return false;
		} else if (!skracenica.equals(other.skracenica))
			return false;
		return true;
	}

}
