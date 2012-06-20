package com.messagedigester;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigester 
{
	static final String HEXES = "0123456789ABCDEF";

	public String DigestMessage(byte[] messageToDigest) 
	{
	    MessageDigest md = null;
	    try 
	    {
	    	md = MessageDigest.getInstance("SHA-1");
	    }
	    catch(NoSuchAlgorithmException e) 
	    {
	        e.printStackTrace();
	    } 
		return GetHex(md.digest(messageToDigest));
	}
	
	private String GetHex(byte [] raw) 
	{
		if ( raw == null ) {
	      return null;
	    }
		
	    final StringBuilder hex = new StringBuilder(2 * raw.length);
	    
	    for ( final byte b : raw ) {
	      hex.append(HEXES.charAt((b & 0xF0) >> 4))
	         .append(HEXES.charAt((b & 0x0F)));
	    }
	    return hex.toString();
	}

}
