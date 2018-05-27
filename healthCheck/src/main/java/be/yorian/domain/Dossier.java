package be.yorian.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
	
	@Column(name = "patientID")
    private String patient_id;
    
    @Column
    private String patient;
    
    @Transient
    private List<Item>items = new ArrayList<>();
	
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

	

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	
	
	
	public String getPatient() {
		return patient;
	}

	public void setPatient(String naam) {
		this.patient = naam;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}



	@Override
	public String toString() {
		String status = "";
		String verstekkerIDs = getIDsFromVerstrekkers();
		String itemIDs = getIDsFromItems();
		if(this.getContract()==null){
			status = "Dossier [verstrekkers=" + verstekkerIDs + ", items=" + itemIDs + "]"; 
		} else{
			status = "Dossier [verstrekkers=" + verstekkerIDs + ", contract=" + contract.getID() + ", items=" + itemIDs + "]";
		}
		System.out.println("Status String= " + status);
		return status;
	}



	private String getIDsFromVerstrekkers() {
		String verstrekkerIDs="";
		List<String> tempList = new ArrayList<String>();
		for (Verstrekker verstrekker : verstrekkers) {
			tempList.add(verstrekker.getRizivNr());
		}
		Collections.sort(tempList);
		for (String rizivNr : tempList) {
			verstrekkerIDs += rizivNr + ", ";
		}
		
		return verstrekkerIDs;
	}
	
	private String getIDsFromItems() {
		String itemIDs="";
		List<Integer> tempList = new ArrayList<Integer>();
		for (Item item : items) {
			tempList.add(item.getItem_id());
		}
		Collections.sort(tempList);
		for (int item_id : tempList) {
			itemIDs += item_id + ", ";
		}
		
		return itemIDs;
	}
	
	
	
}
