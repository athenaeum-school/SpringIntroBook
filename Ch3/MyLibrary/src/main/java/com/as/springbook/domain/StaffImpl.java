/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="staff")
public class StaffImpl extends PersonComponent implements Staff, Serializable{

	@ManyToOne
	@JoinColumn(name="address_id") 
	private AddressImpl address;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=LibraryImpl.class, mappedBy="staff")
	private Set<LibraryImpl> libraries;
}
