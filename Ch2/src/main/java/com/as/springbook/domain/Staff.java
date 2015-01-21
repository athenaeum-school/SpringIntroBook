/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author komatsu
 *
 */

@Entity
@Table(name="staff")
public class Staff extends PersonComponent {

	@ManyToOne
	@JoinColumn(name="address_id") 
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Library.class, mappedBy="staff")
	private List<Library> libraries;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Rental.class, mappedBy="staff")
	//@OrderColumn(name="rental_index")
	private List<Rental> rentals;
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
