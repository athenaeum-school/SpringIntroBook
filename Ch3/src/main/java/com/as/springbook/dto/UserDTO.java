/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.dto;

/**
 * @author komatsu
 *
 */
public class UserDTO {
    private String userName;

    private String password;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}
