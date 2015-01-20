/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.dto;

import java.util.Date;
import java.util.Set;

import com.as.springbook.domain.Inventory;;

/**
 * @author komatsu
 *
 */
public class BookDTO {

	private Long id;
	private String title;
	private String firstName;
	private String lastName;
	private Date publishedYear;
	private Set<Inventory> inventory;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFirstName(String firstName) {
		return this.firstName;
	}
	
	public void setFirstName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getPublishedYear() {
		return this.publishedYear;
	}
	
	public void setPublishedYear(Date publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public void setInventory(Set<Inventory> inventory){
		this.inventory = inventory;
	}
}
