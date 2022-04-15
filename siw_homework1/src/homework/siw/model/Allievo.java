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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

@Entity
public class Allievo {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private Date birthDate;
	@Column(nullable= false)
	private String birthPlace;
	@Column(nullable= false, unique = true)
	private int matricola;
	@Column(nullable= false)
	private String email;
	/*
	 * La strategia di cascade solo nel persist (per corsi e società), invece la strategia di fetch passo a EAGER
	 * perche molto probabilmente vorrei sapere i corsi a cui partecipa ogni allivo
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@OrderBy("name desc")
	private List<Corso> corsi;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "societa_id")
	private Societa societa;
	
	public Allievo() {}
	
	public Allievo(String name, String lastname, Date birthDate, String birthPlace, int matricola, String email, List<Corso> corsi, Societa societa) {
		this.name = name;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.matricola = matricola;
		this.email = email;
		this.corsi = new LinkedList<>(corsi);
		this.societa = societa;
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

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, birthPlace, corsi, email, id, lastname, matricola, name, societa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allievo other = (Allievo) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(birthPlace, other.birthPlace)
				&& Objects.equals(corsi, other.corsi) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(lastname, other.lastname) && matricola == other.matricola
				&& Objects.equals(name, other.name) && Objects.equals(societa, other.societa);
	}

	@Override
	public String toString() {
		return "Allievo [id=" + id + ", name=" + name + ", lastname=" + lastname + ", birthDate=" + birthDate
				+ ", birthPlace=" + birthPlace + ", matricola=" + matricola + ", email=" + email + ", corsi=" + corsi
				+ ", societa=" + societa + "]";
	}
	
	
}
