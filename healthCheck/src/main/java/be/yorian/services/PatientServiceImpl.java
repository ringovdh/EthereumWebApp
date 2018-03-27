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
	public Patient findPatient(String referentie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient findPatientByUserName(Authentication loggedInUser) {

		User user = userDAO.findUserByUserName(loggedInUser.getName());

		return patientDAO.findPatientByUserID(user.getUserID());
	}

}
