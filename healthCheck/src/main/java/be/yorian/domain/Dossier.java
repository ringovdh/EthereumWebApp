package be.yorian.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Dossier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dossier_id;
	
	private String huisarts;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contractID")
	private Contract contract;
	
	
	public Dossier() {
		
	}

	
	
	public int getDossier_id() {
		return dossier_id;
	}

	public void setDossier_id(int dossier_id) {
		this.dossier_id = dossier_id;
	}



	public String getHuisarts() {
		return huisarts;
	}

	public void setHuisarts(String huisarts) {
		this.huisarts = huisarts;
	}



	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}



	@Override
	public String toString() {
		return "Dossier [huisarts=" + huisarts + ", contract=" + contract.getID() + "]";
	}
	
	
	
}
