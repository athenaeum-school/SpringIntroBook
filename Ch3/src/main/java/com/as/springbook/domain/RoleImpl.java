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
public class RoleImpl extends BaseComponent implements Role {

	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<UserImpl> users = new HashSet<UserImpl>();

	public RoleImpl() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<UserImpl> getAppUsers() {
		return this.users;
	}

	public void setAppUsers(Set<UserImpl> users) {
		this.users = users;
	}	
}
