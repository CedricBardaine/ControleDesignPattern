package com.tactfactory.designpattern.controle.entities.food;

import java.text.DecimalFormat;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Packing;
import com.tactfactory.designpattern.controle.entities.packs.PaperCup;
import com.tactfactory.designpattern.controle.exceptions.InvalidSizeItem;

public abstract class Drink implements Item {
	private String name ;
	private float price ;
	private String size ;
	private Packing pack = new PaperCup() ; 


	@Override
	public String name() {
		return this.name ; 
	}
	
	@Override
	public Packing packing() {
		return this.pack ; 
	}
	
	@Override
	public float price()  {
		return this.price ; 
	}

	// getters and setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	public String getSize() { return size; }
	public void setSize(String size) { 
		if (size == "petit" || size == "moyen" || size == "grand")
			this.size = size; 
		else 
			System.err.println("wrong new size !!");
	}
	public void setPack(Packing pack) { this.pack = pack; }





}
