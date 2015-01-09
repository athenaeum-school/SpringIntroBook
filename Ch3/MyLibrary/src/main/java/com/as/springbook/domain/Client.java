/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.io.Serializable;

/**
 * @author komatsu
 *
 */
public interface Client extends Serializable{
	
	public Boolean isActive();
	public void setActive(Boolean active);
	
}
