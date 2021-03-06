package com.tactfactory.designpattern.controle.entities.food;

import com.tactfactory.designpattern.controle.builders.MealBuilder;
import com.tactfactory.designpattern.controle.entities.Packing;

public class Drink_CocaCola extends Drink {

	public Drink_CocaCola(String newSize) {
		setName("Coca Cola");
		
		switch (newSize) {
		case "petit":
			setSize(newSize) ; 
			setPrice((float) 2.5);
			break;	
		case "moyen":
			setSize(newSize) ; 
			setPrice((float) 3);
			break;	
		case "grand":
			setSize(newSize) ; 
			setPrice((float) 3.2);
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
	public Drink_CocaCola() {}

}
