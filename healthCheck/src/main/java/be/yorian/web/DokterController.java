package be.yorian.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.yorian.domain.Dossier;
import be.yorian.domain.User;
import be.yorian.domain.Verstrekker;
import be.yorian.services.DossierService;
import be.yorian.services.VerstrekkerService;

@Controller
@RequestMapping("/dokter")
public class DokterController {

	private static final String DOKTER_VIEW = "verstrekker/dokter";
	
	@Autowired
	VerstrekkerService verstrekkerService;
	
	@Autowired
	DossierService dossierService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showDokter(Authentication user) throws Exception {

		Verstrekker dokter = verstrekkerService.findVerstrekkerByUserName(user.getName());
		Set<Dossier> dossiers = dokter.getDossiers();
		
		ModelAndView modelAndView = new ModelAndView(DOKTER_VIEW);
		modelAndView.addObject("dokter", dokter);
		modelAndView.addObject("dossiers", dossiers);
		return modelAndView;
	}
	

}
