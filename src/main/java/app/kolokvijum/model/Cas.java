package app.kolokvijum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "cas")
public class Cas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Type(type = "text")
	private String tema;

	@Column(nullable = false)
	private LocalDateTime pocetak;

	@Column(nullable = false)
	private LocalDateTime kraj;

	@ManyToOne
	private Predmet predmeti;

	@ManyToOne(optional = false)
    private Cas cas;

	@OneToMany
	private List<Zadatak> zadaci = new ArrayList<>();

	public Cas(Long id, String tema, LocalDateTime pocetak, LocalDateTime kraj) {
		super();
		this.id = id;
		this.tema = tema;
		this.pocetak = pocetak;
		this.kraj = kraj;
	}

	public Cas() {
		super();
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


	public Predmet getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Predmet predmeti) {
		this.predmeti = predmeti;
	}

	

	public Cas getCas() {
		return cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public List<Zadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((predmeti == null) ? 0 : predmeti.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kraj == null) ? 0 : kraj.hashCode());
		result = prime * result + ((pocetak == null) ? 0 : pocetak.hashCode());
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

}
