package be.yorian.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dossier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dossierID;
	
	private String dossierstatus;
	
	private String huisarts;

	private String contractaddress;
	
	private String transactieaddress;
	
	
	
	public Dossier() {
		
	}



	public int getDossierID() {
		return dossierID;
	}

	public void setDossierID(int dossierID) {
		this.dossierID = dossierID;
	}



	public String getDossierstatus() {
		return dossierstatus;
	}

	public void setDossierstatus(String dossierstatus) {
		this.dossierstatus = dossierstatus;
	}



	public String getHuisarts() {
		return huisarts;
	}

	public void setHuisarts(String huisarts) {
		this.huisarts = huisarts;
	}



	public String getContractaddress() {
		return contractaddress;
	}

	public void setContractaddress(String contractaddress) {
		this.contractaddress = contractaddress;
	}



	public String getTransactieaddress() {
		return transactieaddress;
	}

	public void setTransactieaddress(String transactieaddress) {
		this.transactieaddress = transactieaddress;
	}
	
}
