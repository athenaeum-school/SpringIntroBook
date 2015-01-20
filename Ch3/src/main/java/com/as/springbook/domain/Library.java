/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * @author komatsu
 *
 */
@Entity
@Table(name="library")
public class Library extends BaseComponent {
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Inventory.class, mappedBy="library")
	//@OrderColumn(name="inventory_index")
	private List<Inventory> inventories;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
