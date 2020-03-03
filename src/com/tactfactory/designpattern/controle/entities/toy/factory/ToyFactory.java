package com.tactfactory.designpattern.controle.entities.toy.factory;

import com.tactfactory.designpattern.controle.entities.toy.Toy;
import com.tactfactory.designpattern.controle.entities.toy.ToyFemale;
import com.tactfactory.designpattern.controle.entities.toy.ToyMale;
import com.tactfactory.designpattern.controle.entities.toy.attributes.* ;

public class ToyFactory {
	
	public Toy create(Gender newGender) {
		Toy ret = null ; 
		
		switch (newGender) {
		case MALE:
			ret = new ToyMale() ;
			break;
			
		case FEMALE:
			ret = new ToyFemale() ;
			break;
			
		default:
			break;
		}
		
		return ret ; 
	}
}
