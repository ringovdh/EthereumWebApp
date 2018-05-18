package be.yorian.forms;

import java.util.List;

import be.yorian.domain.Verstrekker;

public class AddVerstrekkerForm {
	
	private String verstrekker_id;
	private int dossier_id;
	private List<Verstrekker> verstrekkers;
	
	
	
	public AddVerstrekkerForm() {
		
	}
	
	
	
	
	public String getVerstrekker_id() {
		return verstrekker_id;
	}
	public void setVerstrekker_id(String verstrekker_id) {
		this.verstrekker_id = verstrekker_id;
	}
	
	
	
	
	public int getDossier_id() {
		return dossier_id;
	}
	public void setDossier_id(int dossier_id) {
		this.dossier_id = dossier_id;
	}




	public List<Verstrekker> getVerstrekkers() {
		return verstrekkers;
	}

	public void setVerstrekkers(List<Verstrekker> verstrekkers) {
		this.verstrekkers = verstrekkers;
	}
	
}
