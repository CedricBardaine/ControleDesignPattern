package com.tactfactory.designpattern.controle.entities.packs;

import com.tactfactory.designpattern.controle.entities.Packing;

public class PaperCup implements Packing{

	@Override
	public String pack() {
		return "paper cup"; 
	}

}
