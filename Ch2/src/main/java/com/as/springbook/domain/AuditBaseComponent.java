/**
 * 
 */
package com.as.springbook.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.DateTime;

import com.as.springbook.auditor.AuditEntityListener;

/**
 * @author komatsu
 *
 */
@MappedSuperclass
@EntityListeners(value = { AuditEntityListener.class })
public class AuditBaseComponent extends BaseComponent {

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	public String getCreatedBy() {
		return this.createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
