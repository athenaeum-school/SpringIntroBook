/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Base component serves as the abstract base class for
 * all the entity classes. It contains the most basic
 * entities, i.e., Id and version.
 * @author komatsu
 *
 */

@MappedSuperclass
public abstract class BaseComponent implements RootComponent{

	/**
	 * ID entity
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	protected Long id;
	
	/**
	 * Version entity
	 */
	@Version
	@Column(name = "version")
	protected int version;

	/**
	 * Get the Id from each entity class
	 * @return each entity's id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the id for each entity class
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}	

	/**
	 * Get the version for each entity class
	 * @return int version
	 */
	public int getVersion() {
		return this.version;
	}

	/**
	 * Set the version for each entity class
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	} 
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
}

