package be.yorian.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.yorian.domain.Assessment;

@Transactional(value = "txName")
@Repository
public class AssessmentDAOImpl implements AssessmentDAO{

	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public Assessment findAssessment(int owner_id, int group_id, int author_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Assessment WHERE studentId = :ownerId AND authorId = :authorId AND groupId = :groupId");
		query.setParameter("ownerId", owner_id);
		query.setParameter("authorId", author_id);
		query.setParameter("groupId", group_id);
		Assessment result = (Assessment) query.uniqueResult();
		
		return result;
	}



	@Override
	public void saveAssessment(Assessment assessment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(assessment);
	}

}
