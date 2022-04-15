package homework.siw.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

@Entity
public class Corso {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Date dateOfStart;
	@Column(nullable = false)
	private int durationMonth;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Docente docente;
	/*
	 * Per docente aggiungo solo la strategia di cascade nel caricamento sul DB,
	 * per allievi adotto la politica di cascade uguale al docente e rimango con la 
	 * politica di fetch di base perche presumo che non mi interessano spesso i partecimanti del corso
	 */
	@ManyToMany(mappedBy = "corsi", cascade = {CascadeType.PERSIST})
	@OrderBy("lastname desc")
	private List<Allievo> allievi;
	
	public Corso() {}
	public Corso(String name, Date dateOfStart, int durationMonth, Docente docente, List<Allievo> allievi) {
		this.name = name;
		this.dateOfStart = dateOfStart;
		this.durationMonth = durationMonth;
		this.docente = docente;
		this.allievi = new LinkedList<>(allievi);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public int getDurationMonth() {
		return durationMonth;
	}
	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public List<Allievo> getAllievi() {
		return allievi;
	}
	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(allievi, dateOfStart, docente, durationMonth, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(allievi, other.allievi) && Objects.equals(dateOfStart, other.dateOfStart)
				&& Objects.equals(docente, other.docente) && durationMonth == other.durationMonth && id == other.id
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Corso [id=" + id + ", name=" + name + ", dateOfStart=" + dateOfStart + ", durationMonth="
				+ durationMonth + ", docente=" + docente + ", allievi=" + allievi + "]";
	}
	
	
}
