package be.yorian.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import be.yorian.dao.PatientDAO;
import be.yorian.domain.Patient;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDAO patientDAO;


	@Override
	public void savePatient(Patient patient) {
		patientDAO.savePatient(patient);
		
	}

	@Override
	public Patient findPatientByUserName(Authentication loggedInUser) {

		Patient patient = patientDAO.findPatientByUserName(loggedInUser.getName());
		
		return patient;
	}

	@Override
	public Patient findPatientByID(int id) {
		
		Patient patient = patientDAO.findPatientByID(id);
		
		return patient;
	}

	@Override
	public Patient findPatientByRRN(String rijksregisternr) {
		
		Patient patient = patientDAO.findPatientByRRN(rijksregisternr);
		
		return patient;
	}

}
