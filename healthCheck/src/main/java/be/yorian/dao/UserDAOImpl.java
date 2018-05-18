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
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Patient findUserByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Patient p LEFT JOIN fetch p.dossier WHERE username = :userName ");
		query.setParameter("userName", userName);
		Object uniqueResult = query.uniqueResult();
		return (Patient) uniqueResult;
	}



}
	