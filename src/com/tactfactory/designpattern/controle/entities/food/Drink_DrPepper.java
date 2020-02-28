package com.tactfactory.designpattern.controle.entities.food;

import com.tactfactory.designpattern.controle.entities.Packing;

/**
 * This class represents a Dr Pepper drink. 
 * "Dr Pepper, a drink of intellectuals reserved for elected." _ O. R.
 * @author cedri
 * @version 1.0
 */
public class Drink_DrPepper extends Drink { 

	public Drink_DrPepper(String newSize) {
		setName("Coca Cola");
		
		switch (newSize) {
		case "petit":
			setSize(newSize) ; 
			setPrice((float) 2.8);
			break;	
		case "moyen":
			setSize(newSize) ; 
			setPrice((float) 3.4);
			break;	
		case "grand":
			setSize(newSize) ; 
			setPrice((float) 3.8);
			break;

		default:
			// XXX SEP : change it to an Exception
			System.err.println("wrong new size !!");
			break;
		}
	}
}
