package com.as.springbook.domain;

import java.io.Serializable;
import java.util.Date;

public interface Inventory extends Serializable {

	 /**
     * <p>Availability is concerned with whether the inventory exists on the group of libraries. A inventory could be marked as
     * unavailable but still be considered 'active' where you have the book left on the search but not actually rent
     * it. This defaults to true</p>
     * 
     */
    public Boolean isAvailable();

    /**
     * Convenience that passes through to isAvailable
     * @see isAvailable()
     */
    public Boolean getAvailable();
  

}
