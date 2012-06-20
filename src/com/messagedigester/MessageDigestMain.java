package com.messagedigester;

import javax.swing.JFrame;

public class MessageDigestMain extends JFrame
{
	public static void main(String[] args)
	{
		MessageDigestMainMenu frame = new MessageDigestMainMenu();
		frame.setVisible(true);
		
//		MessageDigester mdr = new MessageDigester();
//		UserDialog ud = new UserDialog();
//		
//		while(true)
//		{
//			String answer = ud.QuestionAnswer("Cleartext to SHA-1 MD: ");
//			System.out.println(mdr.DigestMessage(answer.getBytes())+"\n");
//		}
	}


}
