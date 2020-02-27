package com.tactfactory.designpattern.controle.entities;

import com.tactfactory.designpattern.controle.exceptions.InvalidSizeItem;

public interface Item {
  public String name();

  public Packing packing();

//  public float price() throws InvalidSizeItem;
  public float price() ;
}
