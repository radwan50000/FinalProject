package elbaraka_resturant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class query {
	public static Connection connect;
	public static JTable table;
	public static DefaultTableModel model;
	public static void main(String[] args) {
		//Start of connection
		String url = "jdbc:mysql://localhost:3306/elbaraka";
		try {
			connect = DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			
		}
		//End Of Start Connection
		//Start of Setting up page layout
		JFrame window = new JFrame("Query");
		window.setSize(1280,720);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(new Color(228,8,20));
		ImageIcon iconImage = new ImageIcon("icon.jpg");
		window.setIconImage(iconImage.getImage());
		window.setResizable(false);
		window.setLayout(null);
		//End of Setting up page layout
		
		//Start Adding Table Structure
		
		model = new DefaultTableModel();
		
		model.setColumnCount(7);
		model.addRow(new String[] {"Customer id","Order id","Full Name","Phone Number","Order Address","Order Date","Total Price"});
		
		try {
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("SELECT c.customer_id ,o.order_id ,full_name ,phone ,order_address ,order_date ,total_price FROM customers c inner join orders o on c.customer_id = o.customer_id order by order_date desc;");
			while(result.next()) {
				model.addRow(new String[] {Integer.toString(result.getInt("customer_id")),
						Integer.toString(result.getInt("order_id")),
						result.getString("full_name"),
						result.getString("phone"),
						result.getString("order_address"),
						result.getString("order_date"),
						Integer.toString(result.getInt("total_price"))});
			}
		}catch(Exception f) {
			
		}
		
		table = new JTable(model);
		table.setBounds(0,70,1270,720 - 70 - 20);
		table.setFont(new Font("Monolisa",Font.BOLD,18));
		table.setBackground(new Color(219, 209, 175));
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		//Start of Phone Text Field
		
		JTextField phoneField = new JTextField();
		phoneField.setFont(new Font("Monolisa",Font.BOLD,18));
		phoneField.setBounds((1280 - 200 - 40),20,200,30);
		
		//End of Phone Text Field
		
		//Start Adding Search Button
		JButton searchButton = new JButton("استعلام");
		searchButton.setFont(new Font("Monolisa",Font.BOLD,18));
		searchButton.setFocusable(false);
		searchButton.setBounds((1280 - 200 - 40 - 120 - 20),20,120,30);
		
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(phoneField.getText() != "" && phoneField.getText().length() == 11) {
					model.setRowCount(0);
					model.addRow(new String[] {"Customer id","Order id","Full Name","Phone Number","Order Address","Order Date","Total Price"});
					
					try {
						Statement statement = connect.createStatement();
						ResultSet result = statement.executeQuery("SELECT c.customer_id ,o.order_id ,full_name ,phone ,order_address ,order_date ,total_price FROM customers c inner join orders o on c.customer_id = o.customer_id where phone ="+phoneField.getText()+" order by order_date desc;");
						while(result.next()) {
							model.addRow(new String[] {Integer.toString(result.getInt("customer_id")),
									Integer.toString(result.getInt("order_id")),
									result.getString("full_name"),
									result.getString("phone"),
									result.getString("order_address"),
									result.getString("order_date"),
									Integer.toString(result.getInt("total_price"))});
							
						}
						
					}catch(Exception f) {
						
					}
					
					
				}
				
			}
			
		});
		
		//End Adding Search Button
		
		//Start of Reset Button
		JButton resetButton = new JButton("اعادة");
		resetButton.setBounds((1280 - 200 - 40 - 120 - 20 - 120 - 20),20,120,30);
		resetButton.setBorder(null);
		resetButton.setFont(new Font("Monolisa",Font.BOLD,19));
		resetButton.setFocusable(false);
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == resetButton) {
					model.setRowCount(0);
					model.addRow(new String[] {"Customer id","Order id","Full Name","Phone Number","Order Address","Order Date","Total Price"});
					
					try {
						Statement statement = connect.createStatement();
						ResultSet result = statement.executeQuery("SELECT c.customer_id ,o.order_id ,full_name ,phone ,order_address ,order_date ,total_price FROM customers c inner join orders o on c.customer_id = o.customer_id order by order_date desc;");
						while(result.next()) {
							model.addRow(new String[] {Integer.toString(result.getInt("customer_id")),
									Integer.toString(result.getInt("order_id")),
									result.getString("full_name"),
									result.getString("phone"),
									result.getString("order_address"),
									result.getString("order_date"),
									Integer.toString(result.getInt("total_price"))});
						}
					}catch(Exception f) {
						
					}
				}
				
			}
		});
		//End of Reset Button
		
		//Start of Return to Optional Page
		
		JButton returnButton = new JButton("اغلاق");
		returnButton.setBounds(20,20,120,30);
		returnButton.setBorder(null);
		returnButton.setFont(new Font("Monolisa",Font.BOLD,19));
		returnButton.setFocusable(false);
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == returnButton) {
					portalPage.main(new String[0]);
					window.setVisible(false);
					window.dispose();
				}
				
			}
			
		});
		
		window.add(returnButton);
		//End of Return to Optional Page
		
		window.add(resetButton);
		window.add(phoneField);
		window.add(searchButton);
		window.add(table);
		window.add(scrollPane);
		
		//End Adding Table Structure
		
		
		window.setVisible(true);
	}

}
