/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

/**
 * @author komatsu
 *
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.envers.NotAudited;
import org.joda.time.DateTime;

@Entity
@Table(name = "user")
public class User extends BaseComponent {

	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	/*
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Book.class, mappedBy="createdBy")
	private List<Book> booksCreated;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Book.class, mappedBy="lastModifiedBy")
	private List<Book> booksModified;
	*/
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_detail",
	           joinColumns = @JoinColumn(name = "user_id"), 
	           inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public User() {
		super();
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}