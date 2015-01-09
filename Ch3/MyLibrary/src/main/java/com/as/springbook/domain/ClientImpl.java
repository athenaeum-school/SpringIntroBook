/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class ClientImpl extends PersonComponent implements Client {
	
	@Column(name="active")
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private AddressImpl address;
	
	public ClientImpl() {
		super();
	}

	@Override
	public Boolean isActive() {
		return this.active;
	}

	@Override
	public void setActive(Boolean Active) {
		this.active = active;
	}

}
