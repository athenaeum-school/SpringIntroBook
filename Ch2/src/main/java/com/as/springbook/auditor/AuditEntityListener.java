/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.auditor;


import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.as.springbook.domain.AuditBaseComponent;


/**
 * @author komatsu
 *
 */
public class AuditEntityListener {
	
	 private static final Logger log = LoggerFactory.getLogger(AuditEntityListener.class);

	 @PrePersist
	 public void prePersist(AuditBaseComponent abc) {

		 abc.setCreatedBy("Jack Bauer");
		 abc.setCreatedDate(new Date());

	 }

	 @PreUpdate
	 public void preUpdate(AuditBaseComponent abc) {

		 abc.setLastModifiedBy("Modi fy");
		 abc.setLastModifiedDate(new Date());
		 
	 }
}
