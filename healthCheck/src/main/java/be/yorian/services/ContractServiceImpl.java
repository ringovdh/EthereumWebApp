package be.yorian.services;

import java.math.BigInteger;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import be.yorian.contract.HealthCheck;
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
			contract.setContractaddress(server.deployNewContract(dossier));
			contract.setDossierstatus(Integer.toString(dossier.hashCode()));
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

}
