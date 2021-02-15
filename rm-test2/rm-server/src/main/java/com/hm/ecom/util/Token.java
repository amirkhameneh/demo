package com.hm.ecom.util;

public class Token {

  public static Long getDomain(String token) throws Exception {
		  return Long.valueOf(Crypto.decrypt(token.substring(7), "1$24#4545!gdg1AA").substring(0,15 ));

	  }
  
  public static Long getCenter(String token) throws Exception {
	   return Long.valueOf(Crypto.decrypt(token.substring(7), "1$24#4545!gdg1AA").substring(15,30 ));

 }
  
  public static Long getUser(String token) throws Exception {
	   return Long.valueOf(Crypto.decrypt(token.substring(7), "1$24#4545!gdg1AA").substring(45,60 ));	  
  }
  
}
