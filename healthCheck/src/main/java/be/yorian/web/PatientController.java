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
import be.yorian.domain.Dossier;
import be.yorian.domain.Patient;
import be.yorian.services.ContractService;
import be.yorian.services.DossierService;
import be.yorian.services.PatientService;


@Controller
@RequestMapping("/patient")
public class PatientController {

	private static final String PATIENT_VIEW = "patient/patient";

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DossierService dossierService;
	
	@Autowired
	private ContractService contractService;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPatient(Authentication user) throws Exception {
		
		boolean check = false;
		Patient patient = patientService.findPatientByUserName(user);
		Dossier dossier = dossierService.findDossierById(patient.getDossier().getDossier_id());
		if(dossier.getContract() != null){
			check = contractService.compareDossier(dossier);
		}
		ModelAndView modelAndView = new ModelAndView(PATIENT_VIEW);
		modelAndView.addObject("patient", patient);
		modelAndView.addObject("check", check);
		modelAndView.addObject("dossier", dossier);
		return modelAndView;
	}

	@RequestMapping(value = "/bewaren", method = RequestMethod.POST)
	public String bewaren(@ModelAttribute("dossier") Dossier dossierModel, RedirectAttributes ra) throws Exception {


		Dossier dossier = dossierService.findDossierById(dossierModel.getDossier_id());
		Contract contract = contractService.handleContract(dossier);
	    ra.addFlashAttribute("contract", contract);
		
		return "redirect:/contract";
	}

}
