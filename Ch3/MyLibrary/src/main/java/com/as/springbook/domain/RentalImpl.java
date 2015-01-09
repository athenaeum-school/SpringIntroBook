/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rental")
public class RentalImpl extends AuditComponent implements Rental{

	@OneToMany(mappedBy="rental", cascade=CascadeType.ALL)
	private Set<InventoryImpl> inventories;
	
	@ManyToOne
	@JoinColumn(name="library_id")
	private LibraryImpl library;

	@ManyToOne
	@JoinColumn(name="client_id")
	private ClientImpl client;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private StaffImpl staff;
	
	@Override
	public Client getClient() {
		return this.client;
	}

	@Override
	public void setClient(ClientImpl client) {
		this.client = client;
	}

	@Override
	public LibraryImpl getLibrary() {
		return this.library;
	}

	@Override
	public void setLibrary(LibraryImpl library) {
		this.library = library;
	}

	@Override
	public Set<InventoryImpl> getInventory() {
		return this.inventories;
	}

	@Override
	public void setInventory(Set<InventoryImpl> inventory) {
		this.inventories = inventory;
	}

	@Override
	public void Checkout(Set<InventoryImpl> inventory) {
		
	}

	@Override
	public void Bringback(Set<InventoryImpl> inventory) {
		
	}

}
