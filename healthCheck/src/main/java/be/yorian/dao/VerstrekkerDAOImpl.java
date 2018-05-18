package be.yorian.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.yorian.domain.Verstrekker;

@Transactional(value = "txName")
@Repository
public class VerstrekkerDAOImpl implements VerstrekkerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Verstrekker findVerstrekkerByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Verstrekker v left join fetch v.dossiers WHERE v.userName = :userName ");
		query.setParameter("userName", userName);			
		
		return (Verstrekker) query.uniqueResult();
	}


	@Override
	public List<Verstrekker> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Verstrekker");
		
		return query.list();
	}

}
