/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.auditor;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.as.springbook.domain.AuditComponent;

/**
 * @author komatsu
 *
 */
public class AuditEntityListener {
	
	 private static final Logger log = LoggerFactory
	   .getLogger(AuditEntityListener.class);

	 @PrePersist
	 public void prePersist(AuditComponent e) {

	  e.setCreatedBy("Jack Bauer");
	  e.setCreatedDate(new DateTime());

	 }

	 @PreUpdate
	 public void preUpdate(AuditComponent e) {
	  e.setLastModifiedBy("modi fy");
	  e.setLastModifiedDate(new DateTime());
	 }
}
