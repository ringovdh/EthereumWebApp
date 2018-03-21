package be.yorian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.yorian.domain.Assessment;
import be.yorian.services.AssessmentService;


@Controller
@RequestMapping("/assessment")
public class AssessmentController {

	private static final String ASSESSMENT_VIEW = "assessment/assessment";

	@Autowired
	private AssessmentService assessmentService;


	@RequestMapping(method = RequestMethod.GET)
	ModelAndView showAssessments(int owner_id, int group_id, int author_id) {
		
		
		Assessment assessment = null;
		ModelAndView modelAndView = new ModelAndView(ASSESSMENT_VIEW);
		
		try {
			
		} catch (Exception e) {
			modelAndView.addObject("error", "Er ging iets mis met het ophalen van de student");
		}
		
		try {
			assessment = assessmentService.findAssessment(owner_id, group_id, author_id);
		} catch (Exception e) {
			modelAndView.addObject("error", "Er ging iets mis met het ophalen van de assessment");
		}
		
		if (assessment == null) {
			assessment = new Assessment(owner_id, group_id, author_id);
		}

		modelAndView.addObject("assessment", assessment);

		return modelAndView;

	}

	@RequestMapping(value = "/handleAssessments", params = "cancel", method = RequestMethod.POST)
	public String cancelAssessments() {
		return "redirect:/student";
	}

	@RequestMapping(value = "/handleAssessments", params = "save", method = RequestMethod.POST)
	public String saveAssessments(@ModelAttribute Assessment assessment) {
		assessment.setStatus(Assessment.ASSESSMENT_SUBMITTED);
		assessmentService.saveAssessment(assessment);
		return "redirect:/student";
	}

	@RequestMapping(value = "/handleAssessments", params = "close", method = RequestMethod.POST)
	public String saveAndCloseAssessments(@ModelAttribute Assessment assessment) {
		assessment.setStatus(Assessment.ASSESSMENT_COMPLETE);
		assessmentService.saveAssessment(assessment);
		return "redirect:/student";
	}

}
