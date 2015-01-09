/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Set;

public interface Rental extends Serializable{
	
	/**
	 * Checkout is limited to the act of renting.
	 * Method can be extended to the inter-library
	 * book shares for extensibility. 
	 * Default behaviour adds records to the rental table.
	 */
	public void Checkout(Set<InventoryImpl> inventory);
	
	/**
	 * Bringback simply means returning the book to the library
	 * which also means the subtraction of inventory
	 * elements in the rental.
	 */
	public void Bringback(Set<InventoryImpl> inventory);
	
	/**
	 * Get the inventory object.
	 * @return Inventory
	 */
	public Set<InventoryImpl> getInventory();
	public void setInventory(Set<InventoryImpl> inventory);
	
	/**
	 * Get the client object.
	 * @return Client
	 */
	public Client getClient();
	public void setClient(ClientImpl client);
	
	/**
	 * Get the library object.
	 * @return Library
	 */
	public LibraryImpl getLibrary();
	public void setLibrary(LibraryImpl library);
}
