package com.tactfactory.designpattern.controle.entities.toy;

import com.tactfactory.designpattern.controle.entities.Packing;
import com.tactfactory.designpattern.controle.entities.packs.CardboardCase;
import com.tactfactory.designpattern.controle.entities.toy.attributes.Color;
import com.tactfactory.designpattern.controle.entities.toy.attributes.Gender;

public class ToyMale implements Toy {
	private Packing pack = new CardboardCase() ; 

	@Override
	public String name() {
		return "a nice blue car !";
	}

	@Override
	public Packing packing() {
		return this.pack ; 
	}

	@Override
	public float price() {
		return 0;
	}

	@Override
	public Gender getGender() { return Gender.MALE ; }

	@Override 
	public Color getColor() { return Color.BLUE ; }


}
