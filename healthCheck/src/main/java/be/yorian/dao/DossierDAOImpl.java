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
	public Dossier findDossier(int dossier_id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Dossier d LEFT JOIN fetch d.verstrekkers WHERE d.dossier_id = :dossier_id");
		query.setParameter("dossier_id", dossier_id);

		return (Dossier) query.uniqueResult();
	}

	@Override
	public void saveDossier(Dossier dossier) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(dossier);
		
	}
	
	

}
	