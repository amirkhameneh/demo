package com.hm.ecom.util;

public class Token {

  public static Long getDomain(String token) throws Exception {
		  return Long.valueOf(Crypto.decrypt(token.substring(7), "********").substring(0,1 ));

	  }
  
  public static Long getCenter(String token) throws Exception {
	   return Long.valueOf(Crypto.decrypt(token.substring(7), "********").substring(0,1 ));

 }
  
  public static Long getUser(String token) throws Exception {
	   return Long.valueOf(Crypto.decrypt(token.substring(7), "********").substring(1,2 ));	  
  }
  
}
