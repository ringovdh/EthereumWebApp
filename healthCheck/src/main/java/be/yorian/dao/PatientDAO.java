package be.yorian.dao;

import be.yorian.domain.Patient;

public interface PatientDAO{

	public Patient findPatientByUserID(int userID);

	public void savePatient(Patient patient);

	public Patient findPatientByID(int id);

	public Patient findPatientByRRN(String rijksregisternr);

	public Patient findPatientByUserName(String name);
}
