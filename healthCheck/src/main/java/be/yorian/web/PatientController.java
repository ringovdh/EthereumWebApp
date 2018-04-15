package be.yorian.web;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.web3j.crypto.CipherException;

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
	public ModelAndView showPatient(Authentication user) {
		Patient patient = null;
		ModelAndView modelAndView = new ModelAndView(PATIENT_VIEW);
		try {
			patient = patientService.findPatientByUserName(user);
		} catch (Exception e) {
			modelAndView.addObject("error", "Er ging iets mis met het ophalen van de patient");
		}
		modelAndView.addObject("patient", patient);

		return modelAndView;
	}

	@RequestMapping(value = "/bewaren", method = RequestMethod.POST)
	public String bewaren(@ModelAttribute("patient") Patient patientModel, RedirectAttributes ra) throws Exception {

		Patient patient = patientService.findPatientByID(patientModel.getId());
		
		patient.getDossier().setHuisarts(patientModel.getDossier().getHuisarts());
		
		try {
			Contract contract = contractService.handleContract(patient);
	        ra.addFlashAttribute("contract", contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		patientService.savePatient(patient);
		
		return "redirect:/contract";
	}

}
