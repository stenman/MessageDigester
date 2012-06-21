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
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.DropMode;

public class MessageDigestMainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPlainText;
	private JTextPane textPaneCipherText;
	private DigestAlgorithmEnum digestAlgorithmEnum = DigestAlgorithmEnum.SHA1;
	
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
		radioButtonToSHA1.setSelected(true);
		contentPane.add(radioButtonToSHA1);
		radioButtonToSHA1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				digestAlgorithmEnum = DigestAlgorithmEnum.SHA1;
			}
		});
		
		JRadioButton radioButtonToMD5 = new JRadioButton("To MD5");
		radioButtonToMD5.setBounds(94, 55, 82, 23);
		contentPane.add(radioButtonToMD5);
		radioButtonToMD5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				digestAlgorithmEnum = DigestAlgorithmEnum.MD5;
			}
		});
		
		JRadioButton radioButtonToX = new JRadioButton("To X");
		radioButtonToX.setBounds(178, 55, 82, 23);
		contentPane.add(radioButtonToX);
		radioButtonToX.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				digestAlgorithmEnum = DigestAlgorithmEnum.X;
			}
		});
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(radioButtonToSHA1);
		radioButtonGroup.add(radioButtonToMD5);
		radioButtonGroup.add(radioButtonToX);
		
		JButton buttonConvert = new JButton("Convert!");
		buttonConvert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(digestAlgorithmEnum == DigestAlgorithmEnum.None) 
				{
					textPaneCipherText.setText("You have to choose a cryptocraphic hash funcion first!");
				}
				else
				{
					String plainText = textFieldPlainText.getText();
					MessageDigester md = new MessageDigester();
					String cipherText = md.DigestMessage(plainText.getBytes(), digestAlgorithmEnum);
					textPaneCipherText.setText(cipherText);
				}
			}
		});
		buttonConvert.setBounds(10, 85, 89, 23);
		contentPane.add(buttonConvert);
		
		textPaneCipherText = new JTextPane();
		textPaneCipherText.setFont(new Font("Consolas", Font.PLAIN, 12));
		textPaneCipherText.setEditable(false);
		textPaneCipherText.setBounds(10, 163, 564, 62);
		contentPane.add(textPaneCipherText);
		
		JLabel labelCiphertext = new JLabel("Cipher text");
		labelCiphertext.setBounds(10, 144, 109, 14);
		contentPane.add(labelCiphertext);
	}
}	
