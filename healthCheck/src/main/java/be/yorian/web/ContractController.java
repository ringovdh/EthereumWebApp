package be.yorian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.yorian.domain.Contract;
import be.yorian.services.ContractService;

@Controller
@RequestMapping("/contract")
public class ContractController {
	
	private static final String CONTRACT_VIEW = "contract/contract";
	
	@Autowired
	private ContractService contractService;


	@RequestMapping(method = RequestMethod.GET)
	public String mijnContract(Authentication user, Model model) {
		
		Contract contract = contractService.findContractByUserId(user);
		model.addAttribute("contractaddress", contract.getContractaddress());
        model.addAttribute("transactionaddress", contract.getTransactieaddress());

		return CONTRACT_VIEW;
	}
	
	@RequestMapping(value = "/bewaren", method = RequestMethod.POST)
	public String showContract(@ModelAttribute("contract") Contract contract,
            Model model) {
		
        model.addAttribute("contractaddress", contract.getContractaddress());
        model.addAttribute("transactionaddress", contract.getTransactieaddress());

		return CONTRACT_VIEW;
	}

}
