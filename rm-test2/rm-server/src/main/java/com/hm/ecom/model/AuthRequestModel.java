/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.hm.ecom.model;



/**
 *
 * @author Quy Duong
 */

public class AuthRequestModel {
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isKeepMeLogin() {
		return keepMeLogin;
	}
	public void setKeepMeLogin(boolean keepMeLogin) {
		this.keepMeLogin = keepMeLogin;
	}
	public String username;
    public String password;
    public boolean keepMeLogin;
}
