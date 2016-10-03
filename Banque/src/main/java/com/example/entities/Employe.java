package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employe implements Serializable {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long codeEmploye;
	 private String nomEmploye;
	 @OneToMany(mappedBy="employe")
	 private Collection<Groupe> groupes;
	 public Long getCodeEmploye() {
	  return codeEmploye;
	 }
	 public void setCodeEmploye(Long codeEmploye) {
	  this.codeEmploye = codeEmploye;
	 }
	 public String getNomEmploye() {
	  return nomEmploye;
	 }
	 public void setNomEmploye(String nomEmploye) {
	  this.nomEmploye = nomEmploye;
	 }
	 public Collection<Groupe> getGroupes() {
	  return groupes;
	 }
	 public void setGroupes(Collection<Groupe> groupes) {
	  this.groupes = groupes;
	 }
	 public Employe(String nomEmploye) {
	  super();
	  this.nomEmploye = nomEmploye;
	 }
	 public Employe(){}

}
