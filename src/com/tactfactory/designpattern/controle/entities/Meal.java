package com.tactfactory.designpattern.controle.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Meal {
  private List<Item> items = new ArrayList<Item>();

  public Meal addItem(Item item) {
    items.add(item);
    return this;
  }

  public Meal addItem(Item item, Integer number) {
    for (int i = 0; i < number; i++) {
      items.add(item);
    }

    return this;
  }

  public float getCost() {
    float cost = 0.0f;

    for (Item item : items) {
      cost += item.price();
    }
    return cost;
  }

  public void showItems() {
    for (Item item : items) {
      System.out.print(" Item : " + item.name());
      System.out.print(" , Packing : " + item.packing().pack());
      System.out.println(" , Price : " + item.price());
    }
  }
  public String getShowItems() {
	  String ret = "" ; 
	  for (Item item : items) {
		  ret += " Item : " + item.name() +"\r\n"
				  + " , Packing : " + item.packing().pack() +"\r\n"
				  + " , Price : " + item.price() +"\r\n" ;
	  }
	  return ret ; 
  }
  public String getShowItemsWithTVA() {
	  String ret = "" ; 
	  DecimalFormat df = new DecimalFormat("0.00");
	  
	  for (Item item : items) {
		  float itemPrice = item.price() ; 
		  float itemTVACost = itemPrice*20/100  ; 
		  float itemWithTVA = (float) (Math.round( (itemPrice+itemTVACost) * 100.0) / 100.0); 
				  
		  ret += " Item : " + item.name() +"\r\n"
				  + " , Packing : " + item.packing().pack() +"\r\n"
				  + " , Price : " + itemPrice + " + "+ itemTVACost+" ("+ itemWithTVA +")"  +"\r\n" ;
	  }
	  return ret ; 
  }
  
  public float getTotalPrice() {
	  float ret = 0 ; 
	  
	  for (Item item : items) 
		ret += item.price() ;
	  return ret ; 
  }
  public float getTotalPriceWithTVA() {
	  float ret = 0 ; 
	  
	  for (Item item : items) {
		  ret += item.price() + item.price()*20/100 ;		  
	  }
	  return ret ; 
  }

  public List<Item> getItems() { return items; }
}

