package be.yorian.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.yorian.domain.Patient;

@Transactional(value = "txName")
@Repository
public class PatientDAOImpl implements PatientDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Patient findPatientByUserID(int userID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Patient p LEFT JOIN fetch p.dossier WHERE userID = :userID ");
		query.setParameter("userID", userID);
		
		return (Patient) query.uniqueResult();
	}

	@Override
	public void savePatient(Patient patient) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(patient);
	}

	@Override
	public Patient findPatientByID(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Patient WHERE id = :id");
		query.setParameter("id", id);
		
		return (Patient) query.uniqueResult();
	}

	@Override
	public Patient findPatientByRRN(String rijksregisternr) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Patient WHERE rijksregisternr = :rijksregisternr");
		query.setParameter("rijksregisternr", rijksregisternr);
		
		return (Patient) query.uniqueResult();
	}

	@Override
	public Patient findPatientByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Patient p LEFT JOIN fetch p.dossier WHERE p.userName = :userName ");
		query.setParameter("userName", userName);			
		
		return (Patient) query.uniqueResult();
	}

}
	