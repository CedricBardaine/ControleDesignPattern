package com.tactfactory.designpattern.controle.entities.toy;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Packing;
import com.tactfactory.designpattern.controle.entities.toy.attributes.Color;
import com.tactfactory.designpattern.controle.entities.toy.attributes.Gender;

public interface Toy extends Item {
	Gender getGender() ; 
	Color getColor() ; 
	
//	public String name() ;
//
//	public Packing packing() ;
//
//	public float price() ;
}
