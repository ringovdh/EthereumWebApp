package be.yorian.domain;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient extends User{
	
	private String referentie;
	
	private String rijksregisternr;
	
	private String userName;
//	
//	private String voornaam;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dossierID")
	private Dossier dossier;
	
	

	// -- constructor ----------------------------------------------------- //
	public Patient() {
		
	}
	

	
	
	// -- getter en setter ------------------------------------------------ //
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

	
	
	
	
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	
	
	
//	public String getVoornaam() {
//		return voornaam;
//	}
//
//	public void setVoornaam(String voornaam) {
//		this.voornaam = voornaam;
//	}

	
	
	
	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
}
