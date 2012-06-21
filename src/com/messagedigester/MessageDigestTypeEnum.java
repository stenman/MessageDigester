package com.messagedigester;

public enum MessageDigestTypeEnum 
{
	SHA1
	{
		public String toString()
		{
			return "SHA-1";
		}
	},
	
	MD5
	{
		public String toString()
		{
			return "MD5";
		}
	},
	
	None
}
