package com.tactfactory.designpattern.controle.entities.packs;

import com.tactfactory.designpattern.controle.entities.Packing;

public class CardboardBox implements Packing {

	@Override
	public String pack() {
		return "cardboard box" ;
	}

}
