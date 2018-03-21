package be.yorian.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.yorian.dao.AssessmentDAO;
import be.yorian.domain.Assessment;

@Service
public class AssessmentServiceImpl implements AssessmentService{

	@Autowired
	private AssessmentDAO assessmentDAO;
	
	@Override
	public Assessment findAssessment(int owner_id, int group_id, int author_id) {
		return assessmentDAO.findAssessment(owner_id, group_id, author_id);
	}

	@Override
	public void saveAssessment(Assessment assessment) {
		assessmentDAO.saveAssessment(assessment);
		
	}

}
