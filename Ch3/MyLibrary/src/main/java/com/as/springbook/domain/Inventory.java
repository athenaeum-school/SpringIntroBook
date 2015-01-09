/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;

public interface Inventory extends Serializable{
	
	 /**
     * <p>Availability is concerned with whether the inventory exists on the group of libraries. A inventory could be marked as
     * unavailable but still be considered 'active' where you have the book left on the search but not actually rent
     * it. This defaults to true</p>
     * 
     */
    public Boolean isAvailable();
    
	 /**
     * <p>Return Date is the current date adding duration 
     * as well as the staff's manual input.
     * This defaults to one week after the rental date.</p>
     * 
     */
    public DateTime getReturnDate();
    
    public void setReturnDate();
    
    public DateTime getRentalDate();
    
    public void setRentalDate();

}
