package be.yorian.services;

import org.springframework.security.core.Authentication;

import be.yorian.domain.Patient;

public interface PatientService {

	Patient findPatient(String referentie);
	
	void savePatient(Patient patient);

	Patient findPatientByUserName(Authentication user);
}
