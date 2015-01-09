/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Set;

public interface Book extends Serializable {
	
	/**
	 * @author komatsu
	 * @param Set<InventoryImpl>
	 */
	public Set<InventoryImpl> getInventoryImpl();
	public void setInventoryImpl(Set<InventoryImpl> inventory);
	
	/**
	 * @author komatsu
	 * @param title
	 */
	public String getTitle();
	
	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title);
	
	/**
	 * 
	 * @return String description
	 */
	public String getDescription();
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description);
}
