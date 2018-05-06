package be.yorian.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import be.yorian.dao.PatientDAO;
import be.yorian.dao.UserDAO;
import be.yorian.domain.Contract;
import be.yorian.domain.Dossier;
import be.yorian.domain.Patient;
import be.yorian.domain.User;
import be.yorian.server.ServerHelper;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Contract handleContract(Patient patient) throws Exception {
		
		ServerHelper server = new ServerHelper();
		Dossier dossier = patient.getDossier();
		Contract contract = dossier.getContract();
		
		if (contract.getContractaddress() == null) {
			contract.setDossierstatus(server.createhash(dossier));
			contract.setContractaddress(server.deployNewContract(dossier));
		}
		else {
			server.updateContract(dossier); 
		}
		
		return contract;
	}
	

	@Override
	public Contract findContractByUserId(Authentication loggedInUser) {
		
		User user = userDAO.findUserByUserName(loggedInUser.getName());
		Patient patient = patientDAO.findPatientByUserID(user.getUserID());
		
		return patient.getDossier().getContract();
	}


	@Override
	public boolean compareDossier(Dossier dossier) throws Exception {
		ServerHelper server = new ServerHelper();
		String dossierHash = server.createhash(dossier);
		String dossierHashFromBlock = server.getDossierStatus(dossier);
		if(dossierHash.equals(dossierHashFromBlock)) {
			return true;
		}
		else{
			return false;
		}
	}

}
