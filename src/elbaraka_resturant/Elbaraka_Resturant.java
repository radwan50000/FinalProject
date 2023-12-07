package elbaraka_resturant;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Elbaraka_Resturant {
	public static Connection connection;
	public static String[] users;
	public static String[] passwords;
	public static int[] users_id;
	public static int numOfUsers;
	
    public static void main(String[] args) {
        //Start of Window Code
        JFrame si = new JFrame("Elbaraka Sign In");
        si.setSize(1280,720);
        si.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        si.setResizable(false);
        ImageIcon iconImage = new ImageIcon("icon.jpg");
        si.setIconImage(iconImage.getImage());
        si.getContentPane().setBackground(new Color(199,0,57));
        si.setLayout(null);
        //End Of Window Code
        
        //Start of left side => Logo Code
        JLabel logoLabel = new JLabel();
        ImageIcon logoImage = new ImageIcon("logo.png");
        logoLabel.setIcon(logoImage);
        si.add(logoLabel);
        logoLabel.setVerticalAlignment(JLabel.CENTER);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        logoLabel.setBounds(0,-30,640,720);
        
        //Start of elbraraka text label
        JLabel elbaraka = new JLabel();
        elbaraka.setText("El Baraka Restaurant");
        elbaraka.setForeground(new Color(250,202,11));
        elbaraka.setFont(new Font("MonoLisa",Font.BOLD,23));
        elbaraka.setBounds(210,640,300,30);
        //End of elbraraka text label
        //End Of Logo Code
        
        //Start of right side Creating username and password field
        JPanel rightSide = new JPanel();
        rightSide.setBackground(new Color(250,202,11));
        rightSide.setBounds(640,0,640,720);
        
        //End of right side Creating username and password field
        
        //Start adding of --------------USERS and PASSWORD Labels
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("MonoLisa",Font.PLAIN,19));
        userLabel.setBounds(700,120,100,20);
        rightSide.add(userLabel);
        rightSide.setComponentZOrder(userLabel, 0);
        //----------PASSWORD
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("MonoLisa",Font.PLAIN,19));
        passwordLabel.setBounds(700,220,100,20);
        rightSide.add(passwordLabel);
        rightSide.setComponentZOrder(passwordLabel, 0);
        
        //End adding of user and password Labels
        
        //Start of user and password icons
        
        //Start of user Icon
        ImageIcon userIconImage = new ImageIcon("usernameImage.png");
        JLabel userIcon = new JLabel();
        userIcon.setIcon(userIconImage);
        userIcon.setBounds(670,105,50,50);
        //End of user Icon
        
        //Start of password Icon
        ImageIcon passwordIconImage = new ImageIcon("passwordImage.png");
        JLabel passwordIcon = new JLabel();
        passwordIcon.setIcon(passwordIconImage);
        passwordIcon.setBounds(670,208,50,50);
        //End of password Icon
        
        //End of user and password icons
        
        
        //Start of alert message
        
        JLabel alertLabel = new JLabel("username or password is wrong !");
        alertLabel.setBounds(700,400,300,25);
        alertLabel.setForeground(new Color(255,0,0));
        alertLabel.setFont(new Font("MonoLisa",Font.PLAIN,20));
        alertLabel.setVisible(false);
        rightSide.add(alertLabel);
        
        //End of alert message
        
        //Start of Text Field & Password
        JTextField usernameField = new JTextField();
        usernameField.setBounds(700,150,250,30);
        usernameField.setBackground(new Color(223, 230, 233));
        usernameField.setFont(new Font("MonoLisa",Font.PLAIN,19));

        rightSide.add(usernameField);
        //-------------PASSWORD
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(700,250,250,30);
        passwordField.setBackground(new Color(223,230,233));
        passwordField.setFont(new Font("MonoLisa",Font.PLAIN,19));
        rightSide.add(passwordField);
        //End of Text Field & Password
        
        //Start adding Sign In -------BUTTON
        JButton signButton = new JButton("Sign In");
        rightSide.add(signButton);
        signButton.setBounds(740,340,150,25);
        signButton.setFocusable(false);
        signButton.setFont(new Font("MonoLisa",Font.BOLD,14));
        
        signButton.addActionListener(new ActionListener() {
        
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/elbaraka";
				
				//Start Get the number of users to book place in memory (For Array)====================================
				try {
					connection = DriverManager.getConnection(url,"root","");
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM users;");
					
					while(resultSet.next()) {
						numOfUsers = resultSet.getInt("count");
						users = new String[numOfUsers];
						passwords = new String[numOfUsers];
						users_id = new int[numOfUsers];
					}
					
				}catch(Exception f) {
					System.out.println(f.getMessage());
				}
				//End Get the number of users to book place in memory (For Array)=============================
				
				//Start Enter Data to the arrays=========================================
				try {
					connection = DriverManager.getConnection(url,"root","");
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
					
					int i = 0;
					while(resultSet.next()) {
						users[i] = resultSet.getString("name");
						passwords[i] = resultSet.getString("pass");
						users_id[i] = resultSet.getInt("id");
						i = i + 1;
					}
					
				}catch(Exception f) {
					System.out.println(f.getMessage());
				}
				//End Enter Data to the arrays and check if inputs data is correct=================
				
				if(e.getSource() == signButton) {
					String unArchivedPassword = new String(passwordField.getPassword());
					String username = new String(usernameField.getText());
					for(int i = 0;i<numOfUsers;i++) {
						if((username.equals(users[i])) && (unArchivedPassword.equals(passwords[i]))) {
							menuPage.main(new String[0]);
							si.setVisible(false);
							alertLabel.setVisible(false);
							si.dispose();
						}
					}
					
					alertLabel.setVisible(true);
				}
				
			}
        	
        });
        //End adding Sign In Button
        

        //adding to frame
        //Logo Name
        si.add(elbaraka);
        //Text Field
        si.add(passwordField);
        si.add(usernameField);
        //Labels
        si.add(userLabel);
        si.add(passwordLabel);
        si.add(alertLabel);
        //Butons
        si.add(signButton);
        //Icons
        si.add(userIcon);
        si.add(passwordIcon);
        //Panels
        si.getContentPane().add(rightSide);
        si.setVisible(true);
        
    }
    
}

// color => 199,0,57