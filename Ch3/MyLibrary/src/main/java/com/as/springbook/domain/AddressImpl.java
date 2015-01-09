/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.util.Set;

import javax.persistence.Column;
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
@Table(name="address")
public class AddressImpl extends BaseComponent implements Address {

	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="street")
	private String street;
	
	@Column(name="town")
	private String town;
	
	@Column(name="city")
	private String city;
	
	@Column(name="prefecture")
	private String prefecture;
	
	@OneToMany(targetEntity=ClientImpl.class, mappedBy="address")
	private Set<ClientImpl> clients;
	
	@OneToMany(targetEntity=LibraryImpl.class, mappedBy="address")
	private Set<LibraryImpl> libraries;
	
	@OneToMany(targetEntity=StaffImpl.class, mappedBy="address")
	private Set<StaffImpl> staffs;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStreet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStreet(String street) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPostalCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPostalCode(String postalCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTown(String town) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getPrefecture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPrefecture(String prefecture) {
		// TODO Auto-generated method stub
		
	}

}
