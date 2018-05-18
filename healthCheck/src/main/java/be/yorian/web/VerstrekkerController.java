package be.yorian.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.yorian.domain.Dossier;
import be.yorian.domain.Verstrekker;
import be.yorian.forms.AddVerstrekkerForm;
import be.yorian.services.DossierService;
import be.yorian.services.VerstrekkerService;

@Controller
@RequestMapping("/verstrekker")
public class VerstrekkerController {
	
	private static final String VERSTREKKER_VIEW = "verstrekker/verstrekkers";

	@Autowired
	VerstrekkerService verstrekkerService;
	
	@Autowired
	DossierService dossierService;
	
	
	
	@RequestMapping(value = "/toevoegen", method = RequestMethod.POST)
	public ModelAndView toonVerstrekkers(@ModelAttribute("dossier") Dossier dossierModel) throws Exception {
		
		List<Verstrekker> verstrekkers = verstrekkerService.findAll();
		
		ModelAndView modelAndView = new ModelAndView(VERSTREKKER_VIEW);
		AddVerstrekkerForm form = new AddVerstrekkerForm();
		form.setDossier_id(dossierModel.getDossier_id());
		form.setVerstrekkers(verstrekkers);
		modelAndView.addObject("form", form);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addVerstrekker(@ModelAttribute("form") AddVerstrekkerForm form) throws Exception {
		
		Dossier dossier = dossierService.findDossierById(form.getDossier_id());
		
		
		return "redirect:/patient";
	}
}
