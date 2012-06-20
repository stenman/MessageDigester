package com.messagedigester;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageDigestMainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public MessageDigestMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 600, 300);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 564, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInputTextTo = new JLabel("Input plain text");
		lblInputTextTo.setBounds(10, 11, 81, 14);
		contentPane.add(lblInputTextTo);
		
		JRadioButton rdbtnToSha = new JRadioButton("To SHA-1");
		rdbtnToSha.setBounds(10, 55, 71, 23);
		contentPane.add(rdbtnToSha);
		
		JRadioButton rdbtnToMd = new JRadioButton("To MD5");
		rdbtnToMd.setBounds(86, 55, 71, 23);
		contentPane.add(rdbtnToMd);
		
		JButton btnConvert = new JButton("Convert!");
		btnConvert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnConvert.setBounds(10, 85, 89, 23);
		contentPane.add(btnConvert);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 160, 564, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cipher text");
		lblNewLabel.setBounds(10, 141, 71, 14);
		contentPane.add(lblNewLabel);
	
	}
}
