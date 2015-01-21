/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * JPA name query
 * @author komatsu
 *
 */


@Entity
@Table(name="client")
public class Client extends PersonComponent {
	
	@Column(name="active")
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Rental.class, mappedBy="client")
	//@OrderColumn(name="rental_index")
	private List<Rental> rentals;
	
	public Client() {
		super();
	}

	public Boolean isActive() {
		return this.active;
	}

	public void setActive(Boolean Active) {
		this.active = active;
	}

}
