/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author komatsu
 *
 */

@Entity
@Table(name="address")
public class AddressImpl implements Address {

	private Long Id;
	private String name;
	private String address;
	private String street;
	private String town;
	private String city;
	private String prefecture;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

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
