package com.tactfactory.designpattern.controle.exceptions;

import com.tactfactory.designpattern.controle.entities.Item;

/**
 * 
 * @author cedri
 * @deprecated was used to verify the size of {@link Item}s but the Interface doesn't permit to easily throw Exceptions.
 *
 */
public class InvalidSizeItem extends Exception{
	public InvalidSizeItem(String errMsg) {
		super(errMsg) ; 
	}
}
