package be.yorian.services;

import be.yorian.domain.Assessment;

public interface AssessmentService {

	Assessment findAssessment(int owner_id, int group_id, int author_id);
	
	void saveAssessment(Assessment assessment);
}
