package be.yorian.dao;

import be.yorian.domain.Patient;

public interface PatientDAO{

	public Patient findPatientByUserID(int userID);

	public void savePatient(Patient patient);

	public Patient findPatientByID(int id);
}
