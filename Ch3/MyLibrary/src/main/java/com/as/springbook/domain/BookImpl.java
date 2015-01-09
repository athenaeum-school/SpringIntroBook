/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class BookImpl extends BaseComponent implements Book {

	@OneToMany(fetch=FetchType.LAZY, targetEntity=InventoryImpl.class, mappedBy="book")
	private Set<InventoryImpl> inventories = new HashSet<InventoryImpl>();
	
	@Column(name="title")
	@NotNull
	@Size(min=2,max=40,message="Title is too long.")
	private String title;
	
	@Column(name="description")
	@Size(max=255)
	private String description;
	
	@Column(name="published_year")
	private Date publishedYear;
	
	@Column(name="rental_duration")
	private Long duration;
	
	public BookImpl() {
		super();
	}
	
	@Override
	public Set<InventoryImpl> getInventoryImpl() {
		return this.inventories;
	}

	@Override
	public void setInventoryImpl(Set<InventoryImpl> inventories) {
		this.inventories = inventories;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

}
