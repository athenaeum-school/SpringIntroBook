/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Set;

public interface Library extends Serializable {

	public String getName();
	public void setName(String name);
	
	public AddressImpl getAddress();
	public void setAddress(AddressImpl address);
	
	public Set<InventoryImpl> getInventories();
	public void setInventories(Set<InventoryImpl> inventories);
	
	public StaffImpl getStaff();
	public void setStaff(StaffImpl staff);
	
}
