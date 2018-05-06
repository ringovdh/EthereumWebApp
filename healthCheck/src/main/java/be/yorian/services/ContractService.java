package be.yorian.services;

import org.springframework.security.core.Authentication;

import be.yorian.domain.Contract;
import be.yorian.domain.Dossier;
import be.yorian.domain.Patient;

public interface ContractService {
	
	Contract handleContract(Patient patient) throws Exception;

	Contract findContractByUserId(Authentication user);

	boolean compareDossier(Dossier dossier) throws Exception;

}
