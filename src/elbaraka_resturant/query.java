package elbaraka_resturant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class query {
	public static int lengthOfData = 0;
	public static Connection connect;
	public static Object[][] data;
	public static JTable table;
	public static DefaultTableModel model;
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/elbaraka";
		
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
		
		String titles[] = {"customer_id","order_id","full_name","phone","order_address","order_date","total_price"};
		//Get Length of Table
		try {
			connect = DriverManager.getConnection(url,"root","");
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("SELECT COUNT(*) AS lengthOfData FROM orders");
			while(result.next()) {
				lengthOfData = result.getInt("lengthOfData") + 1;
			}
		}catch(Exception e) {
			
		}
		//Declare the Table data
		data = new Object[lengthOfData][7];
		//Adding Data To Table
		try {
			connect = DriverManager.getConnection(url,"root","");
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("SELECT c.customer_id ,o.order_id ,full_name ,phone ,order_address ,order_date ,total_price FROM customers c inner join orders o on c.customer_id = o.customer_id order by order_date desc;");
			data[0][0] = "Customer_id";
			data[0][1] = "Order_id";
			data[0][2] = "Full Name";
			data[0][3] = "Phone Number";
			data[0][4] = "Order Address";
			data[0][5] = "Order Date";
			data[0][6] = "Total Price";
			int i = 1;
			while(result.next()) {
				int j = 0;
				data[i][j] = result.getInt("customer_id");
				data[i][++j] = result.getInt("order_id");
				data[i][++j] = result.getString("full_name");
				data[i][++j] = result.getString("phone");
				data[i][++j] = result.getString("order_address");
				data[i][++j] = result.getString("order_date");
				data[i][++j] = result.getInt("total_price");
				i++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		model = new DefaultTableModel(data,titles);
		
		table = new JTable(model);
		table.setBounds(10,70,1250,600);
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
					try {
						connect = DriverManager.getConnection(url,"root","");
						Statement statement = connect.createStatement();
						ResultSet result = statement.executeQuery("SELECT COUNT(*) AS lengthOfData FROM customers c inner join orders o on c.customer_id = o.customer_id where phone = "+phoneField.getText());
						while(result.next()) {
							lengthOfData = result.getInt("lengthOfData") + 1;
						}
					}catch(Exception f) {
						System.out.println(f.getMessage());
					}
					
					data = new Object[lengthOfData][7];
					
					try {
						System.out.println("Search Spec");
						connect = DriverManager.getConnection(url,"root","");
						Statement statement = connect.createStatement();
						ResultSet result = statement.executeQuery("SELECT c.customer_id ,o.order_id ,full_name ,phone ,order_address ,order_date ,total_price FROM customers c inner join orders o on c.customer_id = o.customer_id where phone = "+phoneField.getText()+" order by order_date desc;");
						model.addRow(new Object[]{"Customer_id", "Order_id","Full Name","Phone Number","Order Address","Order Date","Total Price"});
						
						while(result.next()) {
							model.addRow(new Object[]{result.getInt("customer_id"),result.getInt("order_id"),result.getString("full_name"),result.getString("phone"),result.getString("order_address"),result.getString("order_date"),result.getInt("total_price")});
						}
						
						model = new DefaultTableModel(data,titles);
						
						table = new JTable(model);

						window.add(table);
					}catch(Exception g) {
						System.out.println(g.getMessage());
					}
					
				}
				
			}
			
		});
		
		//Start of Reset Button
		JButton resetButton = new JButton("اعادة");
		resetButton.setBounds((1280 - 200 - 40 - 120 - 20 - 120 - 20),20,120,30);
		resetButton.setBorder(null);
		resetButton.setFont(new Font("Monolisa",Font.PLAIN,19));
		resetButton.setFocusable(false);
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.remove(table);
				if(e.getSource() == resetButton) {
					model.setRowCount(0);
					model.setColumnCount(0);

					try {
						Statement statement = connect.createStatement();
						ResultSet result = statement.executeQuery("SELECT COUNT(*) AS lengthOfData FROM orders");
						while(result.next()) {
							lengthOfData = result.getInt("lengthOfData") + 1;
						}
					}catch(Exception f) {
						System.out.println(f.getMessage());
					}
					
					data = new Object[lengthOfData][7];
					
					try {
						System.out.println("Search publ");
						Statement statement = connect.createStatement();
						ResultSet result = statement.executeQuery("SELECT c.customer_id ,o.order_id ,full_name ,phone ,order_address ,order_date ,total_price FROM customers c inner join orders o on c.customer_id = o.customer_id;");
						model.addRow(new Object[]{"Customer_id", "Order_id","Full Name","Phone Number","Order Address","Order Date","Total Price"});
						
						while(result.next()) {
							model.addRow(new Object[]{result.getInt("customer_id"),result.getInt("order_id"),result.getString("full_name"),result.getString("phone"),result.getString("order_address"),result.getString("order_date"),result.getInt("total_price")});
						}
						
						model = new DefaultTableModel();
						
						table = new JTable(model);

						window.add(table);
					}catch(Exception g) {
						System.out.println(g.getMessage());
					}
				}
				
			}
		});
		//End of Reset Button
		
		//End Adding Search Button
		window.add(resetButton);
		window.add(phoneField);
		window.add(searchButton);
		window.add(table);
		window.add(scrollPane);
		
		//End Adding Table Structure
		
		
		window.setVisible(true);
	}

}
