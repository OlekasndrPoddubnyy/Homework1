package homework.siw.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Docente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false, unique=true)
	private String numberIVA;
	@Column(nullable = false)
	private Date birthDate;
	@Column(nullable= false)
	private String birthPlace;
	/*
	 * Se visualizzo un professore mi interesseranno sicuramente i suoi corsi, 
	 * in cascata carico solamente perche cosi posso cambiare un professore per un corso senza eliminarlo.
	 */
	@OneToMany(mappedBy = "docente", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@OrderBy("name desc")
	private List<Corso> corsi;
	
	public Docente() {}
	
	public Docente(String name, String lastname, String numberIVA, Date birthDate, String birthPlace, List<Corso> corsi) {
		this.name = name;
		this.lastname = lastname;
		this.numberIVA = numberIVA;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.corsi = new LinkedList<>(corsi);
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNumberIVA() {
		return numberIVA;
	}

	public void setNumberIVA(String numberIVA) {
		this.numberIVA = numberIVA;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, birthPlace, corsi, lastname, name, numberIVA);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(birthPlace, other.birthPlace)
				&& Objects.equals(corsi, other.corsi) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(name, other.name) && Objects.equals(numberIVA, other.numberIVA);
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", name=" + name + ", lastname=" + lastname + ", numberIVA=" + numberIVA
				+ ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + ", corsi=" + corsi + "]";
	}
	
	
}
