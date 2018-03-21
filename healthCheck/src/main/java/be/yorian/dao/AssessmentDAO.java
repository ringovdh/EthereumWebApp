package be.yorian.dao;

import be.yorian.domain.Assessment;

public interface AssessmentDAO{

	public Assessment findAssessment(int owner_id, int group_id, int author_id);

	public void saveAssessment(Assessment assessment);
}
