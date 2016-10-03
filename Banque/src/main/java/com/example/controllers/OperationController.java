package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.metier.Metier;
import com.example.metier.PageOperation;
@RestController
public class OperationController {
	@Autowired
private Metier metier;

	@RequestMapping(value="/versement", method=RequestMethod.PUT)
	public boolean verser(@RequestParam String code,@RequestParam double montant,@RequestParam Long codeEmp) {
		return metier.verser(code, montant, codeEmp);
	}
	@RequestMapping(value="/retrait", method=RequestMethod.PUT)
	public boolean retirer(@RequestParam String code,@RequestParam double montant,@RequestParam Long codeEmp) {
		return metier.retirer(code, montant, codeEmp);
	}
	@RequestMapping(value="/virement", method=RequestMethod.PUT)
	public boolean virement(@RequestParam String cpt1,@RequestParam String cpt2,@RequestParam double montant,@RequestParam Long codeEmp) {
		return metier.virement(cpt1, cpt2, montant, codeEmp);
	}
	@RequestMapping(value="/operations", method=RequestMethod.GET)
	 public PageOperation getOperations(@RequestParam String codeCompte,@RequestParam int page,@RequestParam int size) {
	  return metier.getOperations(codeCompte, page, size);
	 }
	
}
