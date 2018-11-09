package com.nefleex.loginvalidationapp.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//JFrame for this is made by the SWING GUI and customized by Mika Knuuttila.
//TO-DO: Make Text fields accept only alphabetical characters. Add error message if user inputs are not alphabetical characters.
//TO-DO(Optional): add functionalities to lastnamefield and firstnamefields as they are not used in the login information validation process. Line 238

public class AccountCreation extends JFrame {
	
	//Naming elements.
	private JPanel contentPane;
	private JTextField lastnamefield;
	private JTextField firstnamefield;
	JTextField usernamefield;
	JTextField passwordfield;
	
	//Creating variable so SaveFieldsAC(); method can use them.
	static private String lastnamefieldcontent = null;
	static private String firstnamefieldcontent = null;
	static private String usernamefieldcontent = null;
	static private String passwordfieldcontent = null;
	
	//Creating methods for get variables from this class in order to validate equality passwords and usernames.
	public void usernamefieldcontent(String passwordfieldcontent, String usernamefieldcontent) {
		this.usernamefieldcontent = usernamefieldcontent;
		this.passwordfieldcontent = passwordfieldcontent;
	}
	public String getusernamefieldcontent() {
		return this.usernamefieldcontent;
	}
	
	public String getpasswordfieldcontent() {
		return this.passwordfieldcontent;
	} 
	
	//Methods for saving user inputs from fields on AccountCreation JFrame into variables.
	public void saveFieldsAC() {
		lastnamefieldcontent = lastnamefield.getText();
		firstnamefieldcontent = firstnamefield.getText();
		usernamefieldcontent = usernamefield.getText();
		passwordfieldcontent = passwordfield.getText();
		
	}
	
	//Establish reference point for mouse clicked on titlePanel
	static Point compareCoords;
	

	//Create the frame.
	public AccountCreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel titlePanel = new JPanel();
		titlePanel.setForeground(new Color(255, 255, 255));
		titlePanel.setBackground(new Color(12,133,230));
		titlePanel.setBounds(0, 0, 297, 26);
		contentPane.add(titlePanel);
		compareCoords = null;
		
		JLabel lblAccountCreation = new JLabel("Account Creation");
		lblAccountCreation.setForeground(new Color(255, 255, 255));
		lblAccountCreation.setFont(new Font("Consolas", Font.BOLD, 16));
		titlePanel.add(lblAccountCreation);
		
		
		//Make titlepanel draggable by mouse events and listeners.
        compareCoords = null;
        titlePanel.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                compareCoords = null;
            }

            public void mousePressed(MouseEvent e) {
                compareCoords = e.getPoint();
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
            }
        });
        titlePanel.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currentCoords = e.getLocationOnScreen();
                setLocation(currentCoords.x - compareCoords.x, currentCoords.y - compareCoords.y);
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(12,133,230));
		panel_1.setBounds(297, 0, 27, 26);
		contentPane.add(panel_1);
		
		
		//Minimize button "-" in AccountCreation window
		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_1.setFont(new Font("MoolBoran", Font.BOLD, 24));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(label_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		//Panel for "X" exit button.
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(12,133,230));
		panel_2.setBounds(323, 0, 27, 26);
		contentPane.add(panel_2);
		
		//Labeling the panel_2 with X to make it resemble an exit button. If clicked, disposes of the JFrame.
		JLabel label_2 = new JLabel("x");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_2.setFont(new Font("MoolBoran", Font.BOLD, 24));
		
		//Positioning elements.
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 27, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		
		
		//Creating lower panel.
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBackground(new Color(12,133,230));
		panel_3.setBounds(0, 25, 350, 375);
		contentPane.add(panel_3);
		
		
		//Creating labels on lower panel.
		JLabel label_3 = new JLabel("Click");
		
		//Creates label "HERE". If clicked, disposes of current JFrame and creates displays LoginDisplayer JFrame.
		JLabel label_4 = new JLabel("HERE");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginDisplayer newlogin2 = new LoginDisplayer();
				newlogin2.setVisible(true);
			}
		});
		label_4.setForeground(new Color(255, 255, 255));
		
		//Labeling lower panel.
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBackground(new Color(0, 0, 0));
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Consolas", Font.BOLD, 16));
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBackground(new Color(0, 0, 0));
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Consolas", Font.BOLD, 16));
		
		//New textfields. TO-DO: add functionalities to lastnamefield and firstnamefields as they are not used in the login information validation process.
		lastnamefield = new JTextField();
		lastnamefield.setColumns(10);
		lastnamefield.setBackground(new Color(255, 255, 255));

		firstnamefield = new JTextField();
		firstnamefield.setColumns(10);
		firstnamefield.setBackground(new Color(255, 255, 255));
		
		//Creates button Create Account: Checks that text and password fields are not empty.
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBackground(new Color(255, 255, 255));
		btnCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//If all of the fields on AccountCreation have a value - > call for saveFieldsAC(); method
				if(!lastnamefield.getText().isEmpty() && !firstnamefield.getText().isEmpty() && !usernamefield.getText().isEmpty() && !passwordfield.getText().isEmpty()) {
					saveFieldsAC();
					dispose();
					JOptionPane.showMessageDialog(null, "Account Creation Successful! Proceed to Login.");
					LoginDisplayer newlogin = new LoginDisplayer();
					newlogin.setVisible(true);
					//If any of the fields is empty, shows message dialog "Can't leave any fields empty!!!".
					} else if(lastnamefield.getText().isEmpty() || firstnamefield.getText().isEmpty() || usernamefield.getText().isEmpty() || passwordfield.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Can't leave any fields empty!!!");
					}
				
			}});

		
		//Username label on lower panel.
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(new Color(0, 0, 0));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Consolas", Font.BOLD, 16));
		
		//Password label on lower panel.
		JLabel label_9 = new JLabel("Password");
		label_9.setBackground(new Color(0, 0, 0));
		label_9.setForeground(new Color(255, 255, 255));
		label_9.setFont(new Font("Consolas", Font.BOLD, 16));
		
		//Creates field for username user input.
		usernamefield = new JTextField();
		usernamefield.setColumns(10);
		usernamefield.setBackground(new Color(255, 255, 255));
		
		//Creates password field that displays user input's each character as "*".
		passwordfield = new JTextField();
		passwordfield.setColumns(10);
		passwordfield.setBackground(new Color(255, 255, 255));
		
		//Positioning of elements.
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addComponent(lblFirstName))
								.addGap(18))
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCreateAccount, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(usernamefield, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(firstnamefield, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastnamefield, 173, 173, Short.MAX_VALUE)
						.addComponent(passwordfield, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAlreadyHaveAn)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4)))
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
					.addGap(59))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(firstnamefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(lastnamefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernamefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addComponent(btnCreateAccount)
					.addGap(18)
					.addComponent(lblAlreadyHaveAn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_4))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		//Deletes java's default title bar, close x button and minimize button.
		setUndecorated(true);
	}
}
