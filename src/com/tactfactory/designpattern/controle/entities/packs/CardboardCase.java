package com.tactfactory.designpattern.controle.entities.packs;

import com.tactfactory.designpattern.controle.entities.Packing;

public class CardboardCase implements Packing {

	@Override
	public String pack() {
		return "cardboard case";
	}

}
