package com.tactfactory.designpattern.controle.entities.food;

public class Accompaniment_fries extends Accompaniment{
	public Accompaniment_fries(String newSize) {
		setName("Fries");
		
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
}
