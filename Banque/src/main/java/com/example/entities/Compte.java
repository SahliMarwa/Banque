package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_CPT", discriminatorType=DiscriminatorType.STRING, length=2)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
 @Type(name="CC",value=Courant.class),
 @Type(name="CE", value=Epargne.class)
})
public abstract class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String code;
	private Date date;
	private double Solde;
	@ManyToOne
	private Client client;
	@ManyToOne
	@JoinColumn(name="CODE_Emp")
	private Employe employe;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operation;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getSolde() {
		return Solde;
	}
	public void setSolde(double solde) {
		Solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Collection<Operation> getOperation() {
		return operation;
	}
	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}
	public Compte(String code, Date date, double solde, Client client, Employe employe,
			Collection<Operation> operation) {
		super();
		this.code = code;
		this.date = date;
		Solde = solde;
		this.client = client;
		this.employe = employe;
		this.operation = operation;
	}
	
	public Compte()
	{}
	
	
	
	

}
