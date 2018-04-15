package be.yorian.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contract_id;
	
	private String dossierstatus;
	
	private String contractaddress;
	
	private String transactieaddress;
	
	
	public Contract() {
		
	}


	
	
	public int getID() {
		return contract_id;
	}

	public void setID(int contract_id) {
		this.contract_id = contract_id;
	}


	
	
	public String getDossierstatus() {
		return dossierstatus;
	}

	public void setDossierstatus(String dossierstatus) {
		this.dossierstatus = dossierstatus;
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
