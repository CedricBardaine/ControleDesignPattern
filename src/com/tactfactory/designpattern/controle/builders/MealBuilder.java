package com.tactfactory.designpattern.controle.builders;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Meal;
import com.tactfactory.designpattern.controle.entities.food.Accompaniment;
import com.tactfactory.designpattern.controle.entities.food.Drink;
import com.tactfactory.designpattern.controle.entities.food.Sandwich;

public class MealBuilder {
	
	private Meal theMeal = new Meal() ; 
	/**
	 * values : "none" ; "each" ; "petit" ; "moyen" ; "grand"
	 */
	private String mealSize = "none"; 
	
	public MealBuilder prepareMaxiBestOf() {
//		this.theMeal.addItem(new Sand)
		this.mealSize = "grand" ; 
		return this ; 
	}
	public MealBuilder prepareBestOf() {
		this.mealSize = "petit" ; 
		return this ; 
	}
	
	public MealBuilder addItem(Item newItem) {
		if ( this.mealSize == "each" ) 
			this.theMeal.addItem(newItem) ; 
		else {
			for (Item anItem : theMeal.getItems()) {
				if ( anItem.getClass() == newItem.getClass() )
					System.err.println("THE MEAL ALREADY HAS A "+newItem.getClass().toString());
			}
		}
		return this ; 
	}

	public Meal build() {
		for (Item anItem : theMeal.getItems()) {
			if(anItem.getClass() == Drink.class) 
				((Drink) anItem).setSize(this.mealSize) ; 
			if(anItem.getClass() == Sandwich.class)
				((Accompaniment) anItem).setSize(this.mealSize) ; 
				
			
		}
		// fore Drink setSize this.size
		// fore Sandwich setSize.this.size 
		// fore Accompaniement etc
		return this.theMeal ; 
	}

}
