package be.yorian.services;

import org.springframework.security.core.Authentication;

import be.yorian.domain.Patient;

public interface PatientService {
	
	void savePatient(Patient patient);

	Patient findPatientByUserName(Authentication user);

	Patient findPatientByID(int id);
	
}
