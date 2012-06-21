package com.messagedigester;

public enum DigestAlgorithmEnum 
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
	
	X
	{
		public String toString()
		{
			return "SHA-512";
		}
	},
	
	None
}
