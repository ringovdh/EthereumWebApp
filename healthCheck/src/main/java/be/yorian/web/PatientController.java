package be.yorian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.yorian.domain.Dossier;
import be.yorian.domain.Patient;
import be.yorian.services.PatientService;


@Controller
@RequestMapping("/patient")
public class PatientController {

	private static final String PATIENT_VIEW = "patient/patient";

	@Autowired
	private PatientService patientService;


	@RequestMapping(method = RequestMethod.GET)
	ModelAndView showPatient(Authentication user) {
		
		Patient patient = patientService.findPatientByUserName(user);
		ModelAndView modelAndView = new ModelAndView(PATIENT_VIEW);
		try {
			
		} catch (Exception e) {
			modelAndView.addObject("error", "Er ging iets mis met het ophalen van de patient");
		}
		Dossier dossier = patient.getDossier();
		modelAndView.addObject("patient", patient);

		return modelAndView;
	}

	
	
	public String submit(@ModelAttribute("patient") Patient patient, BindingResult result, ModelMap model){
		if (result.hasErrors()) {
	        return "error";
	    }
		
	    return "patientView";
	}


}
