/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author komatsu
 *
 */

@Entity
@Table(name="role")
public class Role extends BaseComponent {

	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	public Role() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getAppUsers() {
		return this.users;
	}

	public void setAppUsers(Set<User> users) {
		this.users = users;
	}	
}
