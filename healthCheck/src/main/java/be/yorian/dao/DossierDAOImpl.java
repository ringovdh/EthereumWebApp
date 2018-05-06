package be.yorian.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.yorian.domain.Dossier;

@Transactional(value = "txName")
@Repository
public class DossierDAOImpl implements DossierDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Dossier findDossier(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Dossier WHERE id = :id");
		query.setParameter("id", id);
		Dossier result = (Dossier) query.uniqueResult();
		return result;
	}

}
	