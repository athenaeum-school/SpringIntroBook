/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import org.joda.time.DateTime;

@Entity
@Table(name="inventory")
public class InventoryImpl extends BaseComponent implements Inventory {

	@ManyToOne
	@JoinColumn(name="book_id")
	private BookImpl book;
	
	@ManyToOne
	@JoinColumn(name="rental_id")
	private RentalImpl rental;
	
	@ManyToOne
	@JoinColumn(name="library_id")
	private LibraryImpl library;
	
	@Column(name="return_date")
	private DateTime return_date;
	
	@Column(name="rental_date")
	private DateTime rental_date;
	
	public InventoryImpl() {
		super();
	}

    public InventoryImpl(final BookImpl book) {
        super();

        this.book = book;
    }

	@Override
	public Boolean isAvailable() {
		return true;
	}

	@Override
	public DateTime getReturnDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReturnDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DateTime getRentalDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRentalDate() {
		// TODO Auto-generated method stub
		
	}


}
