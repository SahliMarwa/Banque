package com.example.entities;

import javax.persistence.Entity;

@Entity
public class Courant extends Compte {
	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	public Courant()
	{
		super();
	}

}
