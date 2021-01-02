package codage;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cryptage {

	public Cryptage() {;}
	
	public static String crypter(String password,String key){
		try
		{
		Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
		Cipher cipher=Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE,clef);
		return new String(cipher.doFinal(password.getBytes()));
		}
		catch (Exception e)
		{
		return null;
		}
		}
	
	public static String decrypter(String password,String key){
		try
		{
		Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
		Cipher cipher=Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE,clef);
		return new String(cipher.doFinal(password.getBytes()));
		}
		catch (Exception e)
		{
		System.out.println(e);
		return null;
		}
		}
	
	 public static String encrypt(String password){
	        String crypte="peace" ;
	        for (int i=0; i<password.length();i++)  {
	            int c=password.charAt(i)^48; 
	            crypte=crypte+(char)c;
	        }
	        return crypte;
	    }
	
	 public String decrypt(String password){
	        String aCrypter="peace";
	        for (int i=0; i<password.length();i++)  {
	            int c=password.charAt(i)^48; 
	            aCrypter=aCrypter+(char)c;
	        }
	        return aCrypter;
	    }
	
	
}
