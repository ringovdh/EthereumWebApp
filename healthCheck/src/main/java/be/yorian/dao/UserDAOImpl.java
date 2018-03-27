package be.yorian.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.yorian.domain.User;

@Transactional(value = "txName")
@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM User WHERE username = :userName");
		query.setParameter("userName", userName);
		User result = (User) query.uniqueResult();
		return result;
	}



}
	