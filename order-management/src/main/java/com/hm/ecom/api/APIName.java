package com.hm.ecom.api;

public class APIName {

    // version
    public static final String VERSION = "api/v1/{company_id}";

    // charset
    public static final String CHARSET = "application/json;charset=utf-8";

    // action user
    public static final String LOGIN = VERSION + "user/login";
    public static final String LOGOUT = VERSION + "user/logout";

    // SSO
    public static final String OAUTH_LOGIN = VERSION + "oauth/login";
    public static final String OAUTH_IMPLICIT_LOGIN = VERSION + "oauth/implicit/login";
    public static final String CHECK_API_KEY = VERSION + "oauth";

    // product api links
    public static final String PRODUCTS = VERSION + "/products";
    public static final String FILTERS =  "/filters";
    public static final String PRODUCT_DETAIL =  "/productdetail";    
    public static final String PRODUCT_LIST =  "/productlist";
    public static final String PRODUCTS_BY_CATEGORY = "/category";
    public static final String PRODUCT_BY_ID = "/detail/{product_id}";
    public static final String PRODUCT_BY_IDS = "/list";
    public static final String PRODUCTS_FILTER_LIST = "/filter";
    public static final String PRODUCT_DETAILS = "/productdetails/{product_id}";
    public static final String PRODUCT_ATTRIBUTES = VERSION + "/productattributes";
    public static final String PRODUCT_CREATE = "/create";
    public static final String PRODUCTS_DELETE = "/delete";
    public static final String PRODUCTS_UPDATE = "/update";

    // category api links
    public static final String CATEGORIES = VERSION + "/categories";
    public static final String CATEGORIES_ID = VERSION + "/categories/{id}";

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

    //review api link
    public static final String REVIEWS = VERSION + "/reviews";
    public static final String REVIEWS_BY_PRODUCT_ID = "/{id}";
    public static final String REVIEWS_ADD = "/add";

    //Orders
    public static final String ORDERS = VERSION + "/orders";
    public static final String ORDER_CREATE = "/create";
    public static final String ORDERS_BY_COMPANY = "/listOrder";
    public static final String ORDERS_DETAIL_BY_COMPANY = "detail/{order_id}";
    public static final String CHANGE_STATUS_ORDERS_BY_COMPANY = "/delete/{order_id}/{status}";

    //Card
    public static final String CARDS = VERSION + "/cart";
    public static final String GET_PREORDER_ID = "/getlastcart";
    public static final String GET_NEW_CART = "/getnewcart";
    public static final String ADD_TO_CART = "/addtocart";
    public static final String DELETE_ITEM = "/deleteitem";
    public static final String GET_CART = "/getcart";  

   // Pay
    public static final String PAY = VERSION + "/pay";
    public static final String ZARRIN_TOKEN = "/zarrintoken";
    public static final String ZARRIN_VERIFY = "/zarrinverify";
  
    
    // auth APIs
    public static final String AUTH_API = VERSION + "/auth";
    public static final String SESSION_DATA = "/session/data";
    public static final String USER_LOGOUT = "/logout";
    public static final String ADMIN_LOGIN_API = "/admin/login";
    
    // Categories APIs
    public static final String CATEGORIES_API = VERSION + "/categories";
    public static final String CATEGORIES_ADD = "/create";
    public static final String CATEGORIES_UPDATE = "/update";
    public static final String CATEGORIES_DELETE = "/delete";
    public static final String CATEGORIES_DETAIL = "/detail/{category_id}";
    public static final String CATEGORIES_LIST = "/list";
    
    
    // Upload file API
    public static final String UPLOAD_API = VERSION + "/upload";
    public static final String UPLOAD_FILE = "/file";
}
