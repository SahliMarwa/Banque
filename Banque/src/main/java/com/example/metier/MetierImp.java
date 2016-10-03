package com.example.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Repositories.IClientRepository;
import com.example.Repositories.ICompteRepository;
import com.example.Repositories.IEmployeRepository;
import com.example.Repositories.IGroupeRepository;
import com.example.Repositories.IOperationRepository;
import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.Employe;
import com.example.entities.Operation;
import com.example.entities.Retrait;
import com.example.entities.Versement;
@Service
public class MetierImp implements Metier {
	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IEmployeRepository employeRepository;
	@Autowired
	private IGroupeRepository groupeRepository;
	@Autowired
	private IOperationRepository operationRepository;
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}

	@Override
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> listEmploye() {
		return employeRepository.findAll();
	}

	@Override
	public Compte saveCompte(Compte compte) {
		return compteRepository.save(compte);
	}

	@Override
	public Compte getCompte(String code) {
		 Compte cp=compteRepository.findOne(code);
		  if(cp==null)throw new RuntimeException("Comptee Inexistant!");
		return cp;
	}

	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cpt=compteRepository.findOne(code);
		  Operation op=new Versement();
		  op.setDateOperation(new Date());
		  op.setMontant(montant);
		  op.setEmploye(employeRepository.findOne(codeEmp));
		  operationRepository.save(op);
		  cpt.setSolde(cpt.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cpt=compteRepository.findOne(code);
		  if(cpt.getSolde()<montant)throw new RuntimeException("Solde insuffisant");
		  Operation op=new Retrait();
		  op.setDateOperation(new Date());
		  op.setMontant(montant);
		  op.setEmploye(employeRepository.findOne(codeEmp));
		  operationRepository.save(op);
		  cpt.setSolde(cpt.getSolde()-montant);
		  return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpt1, String cpt2, double montant, Long codeEmp) {
		 retirer(cpt1, montant, codeEmp);
		 verser(cpt2, montant, codeEmp);
		return true;
	}

	@Override
   public PageOperation getOperations(String codeCompte, int page, int size) {
		  Page<Operation> operations=operationRepository.getOperations(codeCompte, new PageRequest(page, size));;
		  PageOperation pageOp= new PageOperation();
		  pageOp.setOperations(operations.getContent());
		  pageOp.setNombreOperation(operations.getNumberOfElements());
		  pageOp.setTotalPages(operations.getTotalPages());
		  pageOp.setTotalOperation((int)operations.getTotalElements());
		  return pageOp;
	}

}
