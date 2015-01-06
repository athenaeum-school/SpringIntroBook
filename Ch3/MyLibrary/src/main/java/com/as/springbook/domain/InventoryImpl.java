package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.envers.Audited;
import org.joda.time.DateTime;

@Entity
@Table(name="inventory")
@Audited
public class InventoryImpl extends BaseComponent implements Inventory, Serializable {

	@OneToMany(mappedBy="inventory")
	private Set<Rental> rentals;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@Column(name="return_date")
	private DateTime return_date;
	
	@Column(name="rental_date")
	private DateTime rental_date;
	
	public InventoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean isAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

}
