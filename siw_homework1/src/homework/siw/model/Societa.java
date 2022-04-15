package homework.siw.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Societa {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = true)
	public String name;
	@Column(nullable = false)
	private String ragioneSociale;
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private Indirizzo indirizzoSede;
	@Column(nullable = false)
	private int nTelefono;
	
	public Societa() {}
	
	public Societa(String name, String ragioneSociale, Indirizzo indirizzoSede, int nTelefono) {
		this.name = name;
		this.ragioneSociale = ragioneSociale;
		this.indirizzoSede = indirizzoSede;
		this.nTelefono = nTelefono;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Indirizzo getIndirizzoSede() {
		return indirizzoSede;
	}

	public void setIndirizzoSede(Indirizzo indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}

	public int getnTelefono() {
		return nTelefono;
	}

	public void setnTelefono(int nTelefono) {
		this.nTelefono = nTelefono;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, indirizzoSede, nTelefono, name, ragioneSociale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Societa other = (Societa) obj;
		return id == other.id && Objects.equals(indirizzoSede, other.indirizzoSede) && nTelefono == other.nTelefono
				&& Objects.equals(name, other.name) && Objects.equals(ragioneSociale, other.ragioneSociale);
	}

	@Override
	public String toString() {
		return "Societa [id=" + id + ", name=" + name + ", ragioneSociale=" + ragioneSociale + ", indirizzoSede="
				+ indirizzoSede + ", nTelefono=" + nTelefono + "]";
	}
	
	
	
}
