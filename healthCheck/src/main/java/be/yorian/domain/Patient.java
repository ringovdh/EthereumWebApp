package be.yorian.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Patient")
public class Patient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;
	
	private String referentie;
	
	private String rijksregisternr;
	
	private String naam;
	
	private String voornaam;
	
	private int userID;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dossierID")
	private Dossier dossier;
	
	

	
	public Patient() {
		
	}
	
	public Patient(String naam, String voornaam, String rijksregisternr) {

		this.naam = naam;
		this.voornaam = voornaam;
		this.rijksregisternr = rijksregisternr;
		
	}

	public int getId() {
		return patient_id;
	}
	public void setId(int id) {
		this.patient_id = id;
	}

	public String getReferentie() {
		return referentie;
	}

	public void setReferentie(String referentie) {
		this.referentie = referentie;
	}

	public String getRijksregisternr() {
		return rijksregisternr;
	}

	public void setRijksregisternr(String rijksregisternr) {
		this.rijksregisternr = rijksregisternr;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
}
