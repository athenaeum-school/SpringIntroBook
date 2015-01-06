package com.as.springbook.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookImpl implements Book {

	@OneToMany(fetch=FetchType.LAZY, mappedBy="book")
	private Set<Inventory> inventories = new HashSet<Inventory>();
	
	public BookImpl() {
		// TODO Auto-generated constructor stub
	}

}
