package be.yorian.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Dossier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dossier_id")
    private int dossier_id;
	
	@ManyToMany(mappedBy = "dossiers")
	private Set<Verstrekker> verstrekkers = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contractID")
	private Contract contract;
	
	@Column
    private String patient;
	
	public Dossier() {
		
	}

	
	
	public int getDossier_id() {
		return dossier_id;
	}

	public void setDossier_id(int dossier_id) {
		this.dossier_id = dossier_id;
	}



	public Set<Verstrekker> getVerstrekkers() {
		return verstrekkers;
	}

	public void setVerstrekkers(Set<Verstrekker> verstrekkers) {
		this.verstrekkers = verstrekkers;
	}



	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}



	@Override
	public String toString() {
		String status = "";
		String verstekkerIDs = getIDsFromVerstrekkers();
		if(this.getContract()==null){
			status = "Dossier [verstrekkers=" + verstekkerIDs + "]"; 
		} else{
			status = "Dossier [verstrekkers=" + verstekkerIDs + ", contract=" + contract.getID() + "]";
		}
		System.out.println("Status= " + status);
		return status;
	}



	private String getIDsFromVerstrekkers() {
		String verstrekkerIDs="";
		
		for (Verstrekker verstrekker : verstrekkers) {
			verstrekkerIDs += verstrekker.getRizivNr() + "' ";
		}
		return verstrekkerIDs;
	}
	
	
	
}
