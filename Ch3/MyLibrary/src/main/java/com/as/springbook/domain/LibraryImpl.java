/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author komatsu
 *
 */
@Entity
@Table(name="library")
public class LibraryImpl extends BaseComponent implements Library {
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private StaffImpl staff;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private AddressImpl address;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=InventoryImpl.class, mappedBy="library")
	private Set<InventoryImpl> inventories;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public AddressImpl getAddress() {
		return this.address;
	}

	@Override
	public void setAddress(AddressImpl address) {
		this.address = address;
	}

	@Override
	public Set<InventoryImpl> getInventories() {
		return this.inventories;
	}

	@Override
	public void setInventories(Set<InventoryImpl> inventories) {
		this.inventories = inventories;
	}

	@Override
	public StaffImpl getStaff() {
		return this.staff;
	}

	@Override
	public void setStaff(StaffImpl staff) {
		this.staff = staff;
	}
	
}
