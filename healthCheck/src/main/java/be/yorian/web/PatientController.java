package be.yorian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.yorian.domain.Contract;
import be.yorian.domain.Patient;
import be.yorian.services.ContractService;
import be.yorian.services.PatientService;


@Controller
@RequestMapping("/patient")
public class PatientController {

	private static final String PATIENT_VIEW = "patient/patient";

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ContractService contractService;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPatient(Authentication user) throws Exception {
		
		Patient patient = patientService.findPatientByUserName(user);
		boolean check = contractService.compareDossier(patient.getDossier());
		
		ModelAndView modelAndView = new ModelAndView(PATIENT_VIEW);
		modelAndView.addObject("patient", patient);
		modelAndView.addObject("check", check);
		
		return modelAndView;
	}

	@RequestMapping(value = "/bewaren", method = RequestMethod.POST)
	public String bewaren(@ModelAttribute("patient") Patient patientModel, RedirectAttributes ra) throws Exception {

		Patient patient = patientService.findPatientByID(patientModel.getId());
		
		patient.getDossier().setHuisarts(patientModel.getDossier().getHuisarts());
		
		Contract contract = contractService.handleContract(patient);
	    ra.addFlashAttribute("contract", contract);
		
		patientService.savePatient(patient);
		
		return "redirect:/contract";
	}

}
