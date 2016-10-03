package com.example.entities;

import javax.persistence.Entity;

@Entity
public class Epargne extends Compte {
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	public Epargne () {
		super();
		
	}
}
