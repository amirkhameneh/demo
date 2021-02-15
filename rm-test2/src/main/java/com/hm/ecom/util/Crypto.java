package com.hm.ecom.util;
import java.util.Base64;    
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;   
import javax.crypto.SecretKey;  
import javax.crypto.SecretKeyFactory;  
import java.security.spec.KeySpec; 
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec; 
public class Crypto {
	//static Cipher cipher;
    public static String encrypt(String plainText, String key)
            throws Exception {
    	Cipher cipher;
    	SecretKey secretKey;
    	SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");

    	// InvalidKeyException
    	KeySpec spec = new DESKeySpec("1$24#4545!gdg1AA".getBytes(), 0);

    	// InvalidKeySpecException
    	 secretKey = factory.generateSecret(spec);
    	 cipher = Cipher.getInstance("DES");
        byte[] plainTextByte = plainText.getBytes();
        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText, String key)
            throws Exception {
    	 
    	Cipher cipher;
    	SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");

        // InvalidKeyException
        KeySpec spec = new DESKeySpec("aK9eX48w".getBytes(), 0);

        // InvalidKeySpecException
        SecretKey secretKey = factory.generateSecret(spec);

            /*
              Cipher Info
              Algorithm : for the encryption of electronic data
              mode of operation : to avoid repeated blocks encrypt to the same values.
              padding: ensuring messages are the proper length necessary for certain ciphers 
              mode/padding are not used with stream cyphers.  
             */
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  


        
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey,
                new IvParameterSpec(new byte[8]));
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}
