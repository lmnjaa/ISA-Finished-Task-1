package app.kolokvijum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Table(name = "zadatak")
@Entity
public class Zadatak {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	@Type(type = "text")
	private String oblast;
	
	@Column
	@Type(type = "text")
	private String tekst;
	
	@Column(nullable = false)
	private LocalDateTime pocetak;
	
	@Column(nullable = false)
	private LocalDateTime kraj;
	
	@ManyToOne
	private Zadatak cas;

	public Zadatak() {
		super();
	}

	public Zadatak(Long id, String oblast, String tekst, LocalDateTime pocetak, LocalDateTime kraj) {
		super();
		this.id = id;
		this.oblast = oblast;
		this.tekst = tekst;
		this.pocetak = pocetak;
		this.kraj = kraj;
	}
	
	

	

	public Zadatak getCas() {
		return cas;
	}

	public void setCas(Zadatak cas) {
		this.cas = cas;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kraj == null) ? 0 : kraj.hashCode());
		result = prime * result + ((oblast == null) ? 0 : oblast.hashCode());
		result = prime * result + ((pocetak == null) ? 0 : pocetak.hashCode());
		result = prime * result + ((tekst == null) ? 0 : tekst.hashCode());
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
		Zadatak other = (Zadatak) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kraj == null) {
			if (other.kraj != null)
				return false;
		} else if (!kraj.equals(other.kraj))
			return false;
		if (oblast == null) {
			if (other.oblast != null)
				return false;
		} else if (!oblast.equals(other.oblast))
			return false;
		if (pocetak == null) {
			if (other.pocetak != null)
				return false;
		} else if (!pocetak.equals(other.pocetak))
			return false;
		if (tekst == null) {
			if (other.tekst != null)
				return false;
		} else if (!tekst.equals(other.tekst))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zadatak [id=" + id + ", oblast=" + oblast + ", tekst=" + tekst + ", pocetak=" + pocetak + ", kraj="
				+ kraj + "]";
	}
	
	

}
