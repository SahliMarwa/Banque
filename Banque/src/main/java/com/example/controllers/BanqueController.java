package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.Employe;
import com.example.metier.Metier;

@RestController
public class BanqueController {
	@Autowired
	 private Metier clientMetier;
	    @RequestMapping(value="/client", method=RequestMethod.POST)
	 public Client saveClient(@RequestBody Client client) {
	  return clientMetier.saveClient(client);
	 }
	    @RequestMapping(value="/clients", method=RequestMethod.GET)
	 public List<Client> listClient() {
	  return clientMetier.listClient();
	 }
	    @RequestMapping(value="/employe", method=RequestMethod.POST)
	 public Employe saveEmploye(@RequestBody Employe employe) {
	  return clientMetier.saveEmploye(employe);
	 }
	    @RequestMapping(value="/employes", method=RequestMethod.GET)
	 public List<Employe> listEmploye() {
	  return clientMetier.listEmploye();
	 }
	    @RequestMapping(value="/saveCompte", method=RequestMethod.POST)
	 public Compte saveCompte(@RequestBody Compte compte) {
	  return clientMetier.saveCompte(compte);
	 }
	    @RequestMapping(value="/getCompte/{code}", method=RequestMethod.GET)
	 public Compte getCompte(@PathVariable("code") String code) {
	  return clientMetier.getCompte(code);
	 }

}
