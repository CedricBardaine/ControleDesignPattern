package com.tactfactory.designpattern.controle.entities.food;

import java.text.DecimalFormat;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Packing;
import com.tactfactory.designpattern.controle.exceptions.InvalidSizeItem;

public abstract class Sandwich implements Item {
	private String name ; 
	private float price ; 
//	private String size ;
	
	
	@Override
	public String name() {
		return this.name ; 
	}
	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return null;
	}
//	/**
//	 * @deprecated was based on the fact it could have a size. But no.
//	 * @return the price with on the ratio of its size. 
//	 */
//	@Override
//	public float price() throws InvalidSizeItem {
//		float ret ; 
//		
//		switch (size) {
//		case "petit":
//			ret = (float) (this.price * 0.9) ; 
//			break;
//		case "moyen":
//			ret = this.price ; 
//			break;
//		case "grand":
//			ret = (float) (this.price * 1.1) ;
//			break;
//
//		default:
//			throw new InvalidSizeItem("wrong size!") ; 
//		}
//		
//		return Float.valueOf((new DecimalFormat("#.##")).format(ret)) ; 
//	}
	@Override
	public float price()  {
		return this.price ; 
	}
	
	// getters and setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
//	public String getSize() { return size; }
//	public void setSize(String size) { this.size = size; }
	
	
	
	
	
}
