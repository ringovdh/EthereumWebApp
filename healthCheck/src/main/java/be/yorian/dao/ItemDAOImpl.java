package be.yorian.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.yorian.domain.Item;

@Transactional(value = "txName")
@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Item findItemByID(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Item WHERE item_id = :id");
		query.setParameter("id", id);
		
		return (Item) query.uniqueResult();
	}

	@Override
	public int saveItem(Item item) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(item);
		currentSession.flush();
		
		return item.getItem_id();
	}

}
