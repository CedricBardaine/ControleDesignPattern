package com.tactfactory.designpattern.controle.entities.food;

import com.tactfactory.designpattern.controle.builders.MealBuilder;

public class Accompaniment_potatoes extends Accompaniment{
	public Accompaniment_potatoes(String newSize) {
		setName("Potatoes");
		
		switch (newSize) {
		case "petit":
			setSize(newSize) ; 
			setPrice((float) 1.80);
			break;	
		case "moyen":
			setSize(newSize) ; 
			setPrice((float) 2.50);
			break;	
		case "grand":
			setSize(newSize) ; 
			setPrice((float) 3.10);
			break;

		default:
			// XXX SEP : change it to an Exception
			System.err.println("wrong new size !!");
			break;
		}
	}
	
	/**
	 * Should not be used, only for class checking (in {@link MealBuilder}) 
	 */
	public Accompaniment_potatoes() {}
}
