package com.nefleex.loginvalidationapp.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//JFrame for this is made by the SWING GUI and customized by Mika Knuuttila.
//TO-DO: Add functionality for Login button on line 234.


public class LoginDisplayer extends JFrame {

	private JPanel contentPane;
	JTextField logUserField;
	JTextField logPwField;
	
	private String LogUserFieldContent = "";
	private String LogPwFieldContent =  "";
	
	//Instantiating an object of the class AccountCreation
	AccountCreation window = new AccountCreation();
	
	private String theUsername = window.getusernamefieldcontent();
	private String thePassword = window.getpasswordfieldcontent();
	
	//Method to save user input from fields on LoginDisplayer
	public void saveFieldsLD() {
	LogUserFieldContent = logUserField.getText();
	LogPwFieldContent = logPwField.getText();
	}
	
	//Establish reference point for mouse clicked on titlePanel
	static Point compareCoords;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDisplayer frame = new LoginDisplayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	});
	}

	//Create the frame.
	public LoginDisplayer() {
		
		//Deletes java's default title bar, close x button and minimize button.
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		//Creates title bar which is later customized and made draggable.
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(12,133,230));
		titlePanel.setBounds(0, 0, 397, 26);
		contentPane.add(titlePanel);
		
		
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
	                Point currrentCoords = e.getLocationOnScreen();
	                setLocation(currrentCoords.x - compareCoords.x, currrentCoords.y - compareCoords.y);
	            }
	        });
	        //Code making titlepanel draggable stops here.
	        
	        
	        
	    //Labaling log in form.    
		JLabel lblLogInForm = new JLabel("Log in Form");
		lblLogInForm.setForeground(new Color(255, 255, 255));
		lblLogInForm.setFont(new Font("Consolas", Font.BOLD, 16));
		titlePanel.add(lblLogInForm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(423, 0, 27, 26);
		contentPane.add(panel_2);
		panel_2.setBackground(new Color(12,133,230));
		
		//Custom exit button.
		JLabel LabelXCloseButton = new JLabel("x");
		LabelXCloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			});
		LabelXCloseButton.setFont(new Font("MoolBoran", Font.BOLD, 24));
		
		//Positioning elements.
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelXCloseButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(LabelXCloseButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		
		//Panel for minimize label "-"
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(12,133,230));
		panel_3.setBounds(396, 0, 27, 26);
		contentPane.add(panel_3);
		
		//Creating Minimizing button by a label "-".
		JLabel LabelMinimizeButton = new JLabel("-");
		LabelMinimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
		});
		LabelMinimizeButton.setFont(new Font("MoolBoran", Font.BOLD, 24));
		
		//Positioning elements.
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelMinimizeButton)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(LabelMinimizeButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		//Lower panel.
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(12,133,230));
		panel_4.setBounds(0, 26, 450, 274);
		contentPane.add(panel_4);
		
		//Labeling " ".
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		
		//Labeling " ".
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 16));
		
		//New text field for user input
		logUserField = new JTextField();
		logUserField.setForeground(new Color(0, 0, 0));
		logUserField.setBackground(new Color(255, 255, 255));
		logUserField.setColumns(10);
		
		//Creating a new password field to hide user input.
		logPwField = new JTextField();
		logPwField.setForeground(new Color(0, 0, 0));
		logPwField.setBackground(new Color(255, 255, 255));
		logPwField.setColumns(10);
		
		//Login button: if username and password given in AccountCreation match, button will show message "Login successfull!", otherwise shows message "login failed".
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveFieldsLD();
				if(LogUserFieldContent.equals(theUsername) && LogPwFieldContent.equals(thePassword)){
					JOptionPane.showMessageDialog(null, "Login successful");
					} else if (!LogUserFieldContent.equals(theUsername) || !LogPwFieldContent.equals(thePassword)) {
						JOptionPane.showMessageDialog(null, "Login failed");
					}
				}
			}
		);
		
		
		
		  btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//TO-DO to be determined. Add here where you want to proceed from clicking btnLogin.
			}
		});
		
		
		//Labels on lower panel. (panel_4)
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		JLabel lblClick = new JLabel("Click");
		
		//Labeling the lower panel with "HERE" and making in a clickable element which closes current JFrame and creates a new AccountCreation JFrame
		JLabel lblHere = new JLabel("HERE");
		lblHere.setForeground(new Color(255, 255, 255));
		lblHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AccountCreation ac = new AccountCreation();
				ac.setVisible(true); 
				ac.setLocationRelativeTo(null); 
				ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		//Positioning elements.
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(150)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDontHaveAn)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblClick)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHere))
						.addComponent(lblNewLabel)
						.addComponent(logPwField, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(logUserField)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel)
					.addGap(4)
					.addComponent(logUserField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(logPwField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnLogin)
					.addGap(18)
					.addComponent(lblDontHaveAn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClick)
						.addComponent(lblHere))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
	}
}
