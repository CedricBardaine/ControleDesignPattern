package com.tactfactory.designpattern.controle.entities.food;

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
}
