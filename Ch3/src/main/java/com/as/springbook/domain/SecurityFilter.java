/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.domain;

import com.as.springbook.dto.UserDTO;

/**
 * @author komatsu
 *
 */
public class SecurityFilter {

	    private static ThreadLocal<UserDTO> threadLocal = new ThreadLocal<UserDTO>();

	    public void permissionCheck(String userName, String password) {
	        threadLocal.set(new UserDTO(userName, password));
	    }

	    public void unsetPermission() {
	        threadLocal.set(null);
	    }

	    public UserDTO getLocalThreadUserInformation() {
	        return threadLocal.get();
	    }

}
