package homework.siw.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Indirizzo {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String via;
	private int nCivico;
	private String comune;
	private int cap;
	private String provincia;
	
	public Indirizzo() {}
	public Indirizzo(String via, int nCivico,  String comune, int cap, String provincia) {
		this.via = via;
		this.nCivico = nCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getnCivico() {
		return nCivico;
	}
	public void setnCivico(int nCivico) {
		this.nCivico = nCivico;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cap, comune, nCivico, provincia, via);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indirizzo other = (Indirizzo) obj;
		return cap == other.cap && Objects.equals(comune, other.comune) && nCivico == other.nCivico
				&& Objects.equals(provincia, other.provincia) && Objects.equals(via, other.via);
	}
	@Override
	public String toString() {
		return "Indirizzo [via=" + via + ", nCivico=" + nCivico + ", comune=" + comune + ", cap=" + cap + ", provincia="
				+ provincia + "]";
	}
	
	
}
