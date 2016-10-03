package com.example.metier;

import java.util.List;

import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.Employe;

public interface Metier {
	 public Client saveClient(Client client);
	 public List<Client> listClient();
	 
	 public Employe saveEmploye(Employe employe);
	 public List<Employe> listEmploye();
	 
	 public Compte saveCompte(Compte compte);
	 public Compte getCompte(String code);
	 
	 public boolean verser(String code, double montant,Long codeEmp);
	 public boolean retirer(String code, double montant,Long codeEmp);
	 public boolean virement(String cpt1,String cpt2,double montant, Long codeEmp);
	 public PageOperation getOperations(String codeCompte,int page, int size);

}
