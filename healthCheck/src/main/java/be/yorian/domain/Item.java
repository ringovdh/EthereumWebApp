package be.yorian.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
    private int item_id;
	
	@Column
	private String verstrekker;
	
	@Column
	private String omschrijving;
	
	@Column
	private Date  datum;
	
	@Column
	private String medicatie;
	
	@Column
	private String hash;
	
	
	public Item() {
		
	}
	
	public Item(String verstrekker, String omschrijving, Date datum, String medicatie) {
		this.verstrekker = verstrekker;
		this.omschrijving = omschrijving;
		this.datum = datum;
		this.medicatie = medicatie;
	}


	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	

	public String getVerstrekker() {
		return verstrekker;
	}

	public void setVerstrekker(String verstrekker) {
		this.verstrekker = verstrekker;
	}

	
	
	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}


	
	public String getMedicatie() {
		return medicatie;
	}

	public void setMedicatie(String medicatie) {
		this.medicatie = medicatie;
	}


	
	public String getHash() {
		return hash;
	}

	public void setHash() {
		int hashAsInt = toString().hashCode();
		hash = Integer.toString(hashAsInt);
	}


	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", verstrekker=" + verstrekker + ", omschrijving=" + omschrijving
				+ ", datum=" + datum + ", medicatie=" + medicatie + ", hash=" + hash + "]";
	}
	
}
