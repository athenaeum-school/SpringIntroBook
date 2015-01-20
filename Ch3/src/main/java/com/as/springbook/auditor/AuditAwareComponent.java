/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.as.springbook.domain.Rental;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author komatsu
 *
 */
@Component
public class AuditAwareComponent implements AuditorAware<String> {

	/**
	 * @return string logged-in username
	 */
	public String getCurrentAuditor() {
		
		/**
		 *  If the spring security module is adopted,
		 *  the following sequence may be used to
		 *  record the auditor name.
		 *  Security is out of scope.
		 */
		
		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String currentUser = null;
		
		if (authentication != null) {
			currentUser = authentication.getName();
		} else {
			currentUser = "guest";
		}*/
		
		String currentUser = "auditor";
		
		return currentUser;
	}

}