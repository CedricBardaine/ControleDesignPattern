package com.tactfactory.designpattern.controle.builders;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Meal;
import com.tactfactory.designpattern.controle.entities.food.Accompaniment;
import com.tactfactory.designpattern.controle.entities.food.Accompaniment_fries;
import com.tactfactory.designpattern.controle.entities.food.Accompaniment_potatoes;
import com.tactfactory.designpattern.controle.entities.food.Drink;
import com.tactfactory.designpattern.controle.entities.food.Drink_CocaCola;
import com.tactfactory.designpattern.controle.entities.food.Drink_DrPepper;
import com.tactfactory.designpattern.controle.entities.food.Sandwich;
import com.tactfactory.designpattern.controle.entities.food.Sandwich_BigMac;
import com.tactfactory.designpattern.controle.entities.food.Sandwich_RoyalDeluxe;
import com.tactfactory.designpattern.controle.views.MenuSelection;

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
		boolean theMealContainsASandwich = false ;  
		boolean theMealContainsADrink = checkIfItContainsInterface(Drink.class) ; 
		boolean theMealContainsAAccompaniment = checkIfItContainsInterface(Accompaniment.class) ; 
		
		// Must check all the subclass in the henceforward
		if ( checkIfItContainsInterface( new Sandwich_RoyalDeluxe() ) 
				|| checkIfItContainsInterface(new Sandwich_BigMac() ) )
			theMealContainsASandwich = true ;
		
		if ( checkIfItContainsInterface( new Drink_CocaCola() ) 
				|| checkIfItContainsInterface(new Drink_DrPepper() ) )
			theMealContainsADrink = true ;
		
		if ( checkIfItContainsInterface( new Accompaniment_fries() ) 
				|| checkIfItContainsInterface(new Accompaniment_potatoes() ) )
			theMealContainsAAccompaniment = true ;
		
		boolean newItemIsASandwich = newItem instanceof Sandwich ; 
		boolean newItemIsADrink = newItem instanceof Drink ;
		boolean newItemIsAAccompaniment = newItem instanceof Accompaniment ;
		
		boolean isInAlready = false ; 
		
//		System.err.println("" + theMealContainsASandwich +" "+ theMealContainsADrink +" "+ theMealContainsAAccompaniment 
//				+" "+ newItemIsASandwich +" "+ newItemIsADrink +" "+ newItemIsAAccompaniment);
		
		// add directly if it's from the DetailsSelection menu. 
		if ( this.mealSize == "each" || this.theMeal.getItems().size() == 0 ) 
			this.theMeal.addItem(newItem) ; 
		
		// ensure to not add more than 1 Item of each category 
		else {
			if (theMealContainsASandwich && newItemIsASandwich
					|| theMealContainsADrink && newItemIsADrink
					|| theMealContainsAAccompaniment && newItemIsAAccompaniment)
				isInAlready = true ; 

			if (isInAlready)
				System.out.println("- ! votre menu contient deja un produit de ce genre" );
			else 
				this.theMeal.addItem(newItem) ; 
		}
		
		return this ; 
	}
	
	
	public boolean checkIfItContainsInterface(Object itfceToCheck) {
		boolean contains = false ; 
		
		for (Item anItem : theMeal.getItems()) {
			if (anItem.getClass().isAssignableFrom(itfceToCheck.getClass()) ) 
				contains = true ; 
		}
		return contains ; 
	}
	
	/**
	 * Can be used in {@link MenuSelection} to inform the user about he didn't make a correct menu. 
	 * @return true if the meal contains all kind of items (the menu is correct). 
	 */
	public boolean containsAllItems() {
		boolean theMealContainsASandwich = false ;  
		boolean theMealContainsADrink = false ;
		boolean theMealContainsAAccompaniment = false ;
		boolean ret = false ; 

		if ( checkIfItContainsInterface(new Sandwich_RoyalDeluxe()) 
				|| checkIfItContainsInterface(new Sandwich_BigMac() ) )
			theMealContainsASandwich = true ;

		if ( checkIfItContainsInterface( new Drink_CocaCola() ) 
				|| checkIfItContainsInterface(new Drink_DrPepper() ) )
			theMealContainsADrink = true ;

		if ( checkIfItContainsInterface( new Accompaniment_fries() ) 
				|| checkIfItContainsInterface(new Accompaniment_potatoes() ) )
			theMealContainsAAccompaniment = true ;

		if (theMealContainsASandwich && theMealContainsADrink && theMealContainsAAccompaniment)
			ret = true ;
		else 
			ret = false ;
		
		return ret ;
	}

	/**
	 * Shrunk version of containsAllItems() 
	 * @return true if the meal contains all kind of items (the menu is correct). 
	 */
	public boolean containsAllItems2() {
		return (
				(checkIfItContainsInterface(new Sandwich_RoyalDeluxe())
						|| checkIfItContainsInterface(new Sandwich_BigMac()))
				&& (checkIfItContainsInterface(new Drink_CocaCola())
						|| checkIfItContainsInterface(new Drink_DrPepper()))
				&& (checkIfItContainsInterface(new Accompaniment_fries())
						|| checkIfItContainsInterface(new Accompaniment_potatoes()))
				);
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
	
	// FIXME ONLY FOR DEBUGGING DELETE IT AFTER 
	public Meal getTheMeal() { return theMeal; }
	
	public void setMealSize(String mealSize) { this.mealSize = mealSize; }
	public String getMealSize() { return mealSize; }
	
	public String getList() {
		String ret = "" ;
		for (Item unItem : theMeal.getItems()) {
			
			ret = unItem.name() + "\r" ; 
		}
		return ret ; 
	}

}
