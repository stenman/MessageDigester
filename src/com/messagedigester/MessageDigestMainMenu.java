package com.messagedigester;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageDigestMainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlainText;
	private JTextField textFieldCipherText;
	private MessageDigestTypeEnum messageDigestTypeEnum = MessageDigestTypeEnum.SHA1;
	
	public MessageDigestMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 600, 300);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textFieldPlainText = new JTextField();
		textFieldPlainText.setBounds(10, 28, 564, 20);
		contentPane.add(textFieldPlainText);
		textFieldPlainText.setColumns(10);
		
		JLabel labelPlainText = new JLabel("Input plain text");
		labelPlainText.setBounds(10, 11, 109, 14);
		contentPane.add(labelPlainText);
		
		JRadioButton radioButtonToSHA1 = new JRadioButton("To SHA-1");
		radioButtonToSHA1.setBounds(10, 55, 82, 23);
		contentPane.add(radioButtonToSHA1);
		radioButtonToSHA1.setActionCommand("SHA1");
		radioButtonToSHA1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				messageDigestTypeEnum = MessageDigestTypeEnum.SHA1;
			}
		});
		
		JRadioButton radioButtonToMD5 = new JRadioButton("To MD5");
		radioButtonToMD5.setBounds(94, 55, 82, 23);
		radioButtonToSHA1.setSelected(true);
		contentPane.add(radioButtonToMD5);
		radioButtonToMD5.setActionCommand("MD5");
		radioButtonToMD5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				messageDigestTypeEnum = MessageDigestTypeEnum.MD5;
			}
		});
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(radioButtonToSHA1);
		radioButtonGroup.add(radioButtonToMD5);
		
		JButton buttonConvert = new JButton("Convert!");
		buttonConvert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(messageDigestTypeEnum == MessageDigestTypeEnum.SHA1) 
				{
					String plainText = textFieldPlainText.getText();
					MessageDigester md = new MessageDigester();
					String cipherText = md.DigestMessage(plainText.getBytes());
					textFieldCipherText.setText(cipherText);
				}
				else if(messageDigestTypeEnum == MessageDigestTypeEnum.MD5) 
				{
					textFieldCipherText.setText("MD5 cryptography not implemented yet!");
				}
				else if(messageDigestTypeEnum == MessageDigestTypeEnum.None) 
				{
					textFieldCipherText.setText("You have to choose a cryptocraphic hash funcion first!");
				}
			}
		});
		buttonConvert.setBounds(10, 85, 89, 23);
		contentPane.add(buttonConvert);
		
		textFieldCipherText = new JTextField();
		textFieldCipherText.setBounds(10, 160, 564, 20);
		contentPane.add(textFieldCipherText);
		textFieldCipherText.setColumns(10);
		textFieldCipherText.setEditable(false);
		
		JLabel labelCiphertext = new JLabel("Cipher text");
		labelCiphertext.setBounds(10, 141, 109, 14);
		contentPane.add(labelCiphertext);
	}
}	
