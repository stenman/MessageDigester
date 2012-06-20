package com.messagedigestertest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.messagedigester.MessageDigester;

public class MessageDigesterTest {

	 @Test
	 public void digestMessageTest() 
	 {
		 //Arrange
		 MessageDigester mdr = new MessageDigester();
		 byte[] messageToDigest = "test".getBytes();
		 String expected = "A94A8FE5CCB19BA61C4C0873D391E987982FBBD3";
		
		 //Act
		 String actual = mdr.DigestMessage(messageToDigest);
		
		 //Assert
		 assertEquals(expected, actual);
	 }
}
