/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author komatsu
 */
@Entity
@Table(name="address")
public class Address extends BaseComponent {

	/**
    * <p>Address is a collection of fields share by client, 
    * staff, and library. Embedding/Inheriting it is doable, but
    * adds an unnecessary complexity to the schema.</p>
    */
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
	
	@OneToMany(targetEntity=Client.class, mappedBy="address")
	private Set<Client> clients;
	
	@OneToMany(targetEntity=Library.class, mappedBy="address")
	private Set<Library> libraries;
	
	@OneToMany(targetEntity=Staff.class, mappedBy="address")
	private Set<Staff> staffs;

	public String getName() {
		return null;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	public String getStreet() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStreet(String street) {
		// TODO Auto-generated method stub
		
	}

	public String getPostalCode() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPostalCode(String postalCode) {
		// TODO Auto-generated method stub
		
	}

	public String getTown() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTown(String town) {
		// TODO Auto-generated method stub
		
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		
	}

	public Double getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCity(String city) {
		// TODO Auto-generated method stub
		
	}

	public Double getPrefecture() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPrefecture(String prefecture) {
		// TODO Auto-generated method stub
		
	}

}
