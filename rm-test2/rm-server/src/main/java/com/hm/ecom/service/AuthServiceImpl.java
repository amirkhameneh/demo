/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.hm.ecom.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.hm.ecom.api.APIStatus;
import com.hm.ecom.core.ApplicationException;
import com.hm.ecom.model.AuthUser;
import com.hm.ecom.model.User;
import com.hm.ecom.model.UserToken;
import com.hm.ecom.repository.UserRepository;
import com.hm.ecom.repository.UserTokenRepository;
import com.hm.ecom.util.Constant;
import com.hm.ecom.util.DateUtil;
import com.hm.ecom.util.UniqueID;


@Component
public class AuthServiceImpl implements AuthService{
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private UserTokenRepository userTokenRepository;
    
    @Autowired
    AuthUserFactory authUserFactory;
    
    @Override 
    public UserToken createUserToken (User userLogin/*, boolean keepMeLogin*/){
        try {
        	 Gson gson = new Gson();
            UserToken userToken = new UserToken();
            userToken.setToken(UniqueID.getUUID());
            userToken.setCompanyId(userLogin.getCompanyId());
            userToken.setUserId(userLogin.getUserId());
            Date currentDate = new Date();
            userToken.setLoginDate(DateUtil.convertToUTC(currentDate));
            Date expirationDate = /*keepMeLogin ? new Date(currentDate.getTime() + Constant.DEFAULT_REMEMBER_LOGIN_MILISECONDS) :*/ new Date(currentDate.getTime() + Constant.DEFAULT_SESSION_TIME_OUT);
            userToken.setExpirationDate(DateUtil.convertToUTC(expirationDate));
            AuthUser authUser = authUserFactory.createAuthUser(userLogin);
            // Set authUser to session data...
            userToken.setSessionData(gson.toJson(authUser));
            userTokenRepository.save(userToken);
            return userToken;
        } catch (Exception e) {
            //LOGGER.error("Error create User token ", e);
            throw new ApplicationException(APIStatus.SQL_ERROR);
        }
    }

/*    @Override
    public User getUserByEmailAndCompanyIdAndStatus(String email, Long companyId, int status) {
        return userRepository.findByEmailAndCompanyIdAndStatus(email, companyId, Constant.USER_STATUS.ACTIVE.getStatus());
    }
*/
    @Override
    public User getUserByUserIdAndCompanyId(String userId, Long companyId) {
        return userRepository.findByUserIdAndCompanyId(userId ,companyId/*, Constant.USER_STATUS.ACTIVE.getStatus()*/);
    }
/*
    @Override
    public UserToken getUserTokenById(String id) {
        return userTokenRepository.findOne(id);
    }

    @Override
    public void deleteUserToken(UserToken userToken) {
        userTokenRepository.delete(userToken);
    }
*/    
}
