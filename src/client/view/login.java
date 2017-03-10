package client.view;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import client.app.exceptions.*;
import client.commander.BGCommander;

public class login {

	private JPanel panel;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private BGCommander command;
	private UserInterface ui;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public login(UserInterface parent) {
		command = BGCommander.getBGCommander();
		ui=parent;
		panel = new JPanel();
	}

	/**
	 * Initialize the contents of the panel.
	 */
	private void initialize() {
		panel.setBounds(100, 100, 450, 300);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 67, 88, 27);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 105, 88, 27);
		panel.add(lblNewLabel_1);

		textFieldUN = new JTextField();
		textFieldUN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUN.setBounds(161, 72, 153, 22);
		panel.add(textFieldUN);
		textFieldUN.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(161, 110, 152, 22);
		panel.add(passwordField);

		JLabel lblprompt = new JLabel("Enter username and password");
		lblprompt.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblprompt.setBounds(71, 22, 250, 34);
		panel.add(lblprompt);

		JButton btnlogin = new JButton("Log in");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=textFieldUN.getText();
				String Password=passwordField.getText();
				try{
					command.login(Username, Password);
					panel.removeAll();
					JLabel lblNewLabel = new JLabel("Username: "+Username);
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					lblNewLabel.setBounds(71, 67, 153, 27);
					panel.add(lblNewLabel);
					JLabel lblprompt1 = new JLabel("Log in successfully");
					lblprompt1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					lblprompt1.setBounds(119, 22, 223, 34);
					panel.add(lblprompt1);

					JButton btnlogout = new JButton("Log out");
					btnlogout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							command.logout();
							panel.removeAll();
							initialize();
						}
					});
					btnlogout.setForeground(Color.BLUE);
					btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnlogout.setBounds(161, 176, 153, 27);
					panel.add(btnlogout);
					panel.repaint();
					//panel.add(new test());
					panel.validate();
					//panel.add(ui);
					ui.refreshMyEvents();
				}catch(ElementNotFoundException elem){
					lblprompt.setText("Unrecognized username or password O.o? ");
				}
				catch(UserLoggedInException uex){
					System.out.println( uex.getMsg());
				}
			}
		});
		btnlogin.setForeground(Color.BLUE);
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnlogin.setBounds(161, 176, 153, 27);
		panel.add(btnlogin);
	}

	public JPanel returnPanel(){
		initialize();
		return panel;
	}

}
