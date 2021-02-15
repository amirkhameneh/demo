package com.hm.ecom.api;

public class APIName {

    // version
    public static final String VERSION = "api/v1";
    
    // charset
    public static final String CHARSET = "application/json;charset=utf-8";

    // aggragation
    public static final String AGGREGATION = VERSION + "/aggregation";
    public static final String MEDIAN =  "/getmedian";    
    // monitoring
    public static final String MONITORING = VERSION + "/monitoring";
    public static final String REQUESTS =  "/getrequests";     
    public static final String REQUEST_DETAIL =  "/getrequestdetail";
    //public static final String LOGOUT = VERSION + "user/logout";    
    
    // action user
    public static final String LOGIN = VERSION + "user/login";
    public static final String LOGOUT = VERSION + "user/logout";

    // SSO
    public static final String OAUTH_LOGIN = VERSION + "oauth/login";
    public static final String OAUTH_IMPLICIT_LOGIN = VERSION + "oauth/implicit/login";
    public static final String CHECK_API_KEY = VERSION + "oauth";





    //company api link
    public static final String COMPANIES = VERSION + "/companies";
    public static final String COMPANIES_SEARCH_BY_ID = COMPANIES + "/{id}";

    //user api link
    public static final String USERS = VERSION + "/users";
    public static final String USER_REGISTER = "/register";
    public static final String USER_LIST = "/list";
    public static final String USERS_LOGIN = "/login";
    public static final String USERS_LOGOUT = "/logout";
    public static final String USER_DETAILS = "/detail/{userId}";
    public static final String UPDATE_USER = "/update";
    public static final String DELETE_USER = "/delete";
    public static final String CHANGE_PASSWORD_USER = "/changePassword";




  
    
    // auth APIs
    public static final String AUTH_API = VERSION + "/auth";
    public static final String SESSION_DATA = "/session/data";
    public static final String USER_LOGOUT = "/logout";
    public static final String ADMIN_LOGIN_API = "/admin/login";
    

}
