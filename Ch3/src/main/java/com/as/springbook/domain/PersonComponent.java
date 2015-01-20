/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author komatsu
 * @category abstract base class for the humanoid type
 */

@MappedSuperclass
public abstract class PersonComponent extends BaseComponent {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")	
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="user_name")
	private String userName;
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
