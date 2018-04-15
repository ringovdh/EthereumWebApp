package be.yorian.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import be.yorian.dao.PatientDAO;
import be.yorian.dao.UserDAO;
import be.yorian.domain.Patient;
import be.yorian.domain.User;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private UserDAO userDAO;


	@Override
	public void savePatient(Patient patient) {
		patientDAO.savePatient(patient);
		
	}

	@Override
	public Patient findPatientByUserName(Authentication loggedInUser) {

		User user = userDAO.findUserByUserName(loggedInUser.getName());
		Patient patient = patientDAO.findPatientByUserID(user.getUserID());
		
		return patient;
	}

	@Override
	public Patient findPatientByID(int id) {
		
		Patient patient = patientDAO.findPatientByID(id);
		
		return patient;
	}

}
