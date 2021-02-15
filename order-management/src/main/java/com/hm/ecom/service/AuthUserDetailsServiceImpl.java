/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.hm.ecom.service;

import com.google.gson.Gson;
import com.hm.ecom.api.APIStatus;
import com.hm.ecom.core.ApplicationException;
import com.hm.ecom.model.AuthUser;
import com.hm.ecom.model.UserToken;
import com.hm.ecom.repository.UserTokenRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Quy Duong
 */
@Service
public class AuthUserDetailsServiceImpl implements CustomUserAuthService {
    
    Gson gson = new Gson();
    
    @Autowired
    private UserTokenRepository userTokenRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userId) {
        // Not implement
    	return new User(userId,"foo",new ArrayList<>());
        
    }
    
    
    @Override
    public AuthUser loadUserByAccessToken(String token) {
        UserToken session = userTokenRepository.findBytoken(token);
        if (session != null){
            if (session.getSessionData() != null && !"".equals(session.getSessionData())){
                AuthUser authUser = gson.fromJson(session.getSessionData(), AuthUser.class);
                return authUser;
            }else{
                throw new ApplicationException(APIStatus.ERR_SESSION_DATA_INVALID);
            }
        }else{
            throw new ApplicationException(APIStatus.ERR_SESSION_NOT_FOUND);
        }
    }
}
