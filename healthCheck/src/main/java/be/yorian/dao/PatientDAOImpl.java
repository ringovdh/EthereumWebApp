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
		Patient result = (Patient) query.uniqueResult();
		return result;
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
		Patient result = (Patient) query.uniqueResult();
		return result;
	}

}
	