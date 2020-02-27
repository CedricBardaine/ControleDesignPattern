package com.tactfactory.designpattern.controle.builders;

import com.tactfactory.designpattern.controle.entities.Meal;

public class MealBuilder {
	
	private Meal theMeal = new Meal() ; 
	
	public MealBuilder prepareMaxiBestOf() {
		// TODO 
		return this ; 
	}
	public MealBuilder prepareBestOf() {
		// TODO 
		return this ; 
	}

	public Meal build() {
		return this.theMeal ; 
	}

}
