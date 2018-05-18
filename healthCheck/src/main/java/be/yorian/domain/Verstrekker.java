package be.yorian.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="Verstrekker")
public class Verstrekker{
	
	@Id
	@GeneratedValue
	@Column(name = "verstrekker_id")
	private int verstrekker_id;
	
	@Column
	private String userName;
	
	@Column(name = "rizivnr")
	private String rizivNr;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinTable(
		name = "dossier_verstrekker", 
		joinColumns = { @JoinColumn(name = "verstrekker_id") },
		inverseJoinColumns = { @JoinColumn(name = "dossier_id") })
    private Set<Dossier> dossiers = new HashSet<>();

	@Column
	private String rol;
	
	@Column
	private String naam;
	
	@Column
	private String voornaam;

	
	// -- constructor ----------------------------------------------------- //
	public Verstrekker(){
		
	}

	
	

	// -- getter en setter ------------------------------------------------ //
	public int getVerstrekker_id() {
		return verstrekker_id;
	}

	
	
	public String getUserName() {
		return userName;
	}
	
	
	
	
	public String getRizivNr() {
		return rizivNr;
	}

	public void setRizivNr(String rizivNr) {
		this.rizivNr = rizivNr;
	}



	
	public Set<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(Set<Dossier> dossiers) {
		this.dossiers = dossiers;
	}


	
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}




	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}




	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
}
