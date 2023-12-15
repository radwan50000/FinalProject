package elbaraka_resturant;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class portalPage {

	public static void main(String[] args) {
		//Start Set up page Setting
		JFrame mainWindow = new JFrame("Portal page");
		mainWindow.setSize(520, 380);
		mainWindow.setResizable(false);
		mainWindow.getContentPane().setBackground(new Color(170,0,0));
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon iconImage = new ImageIcon("icon.jpg");
		mainWindow.setIconImage(iconImage.getImage());
		mainWindow.setLayout(null);
		//End Set up page setting
		
		//Start of Adding JPanel
		JPanel yellowPanel = new JPanel();
		yellowPanel.setBackground(new Color(250,202,11));
		yellowPanel.setBounds(500 / 2,0,520,390);
		
		//End of Adding JPanel
		
		
		//Start of Buttons -------------------------------------- =>>>>>>>>>
		
		//Start of menu button
		
		JButton menuButton = new JButton("قائمة الطلبات");
		menuButton.setBounds(180, 90, 150, 25);
		menuButton.setBorder(null);
		menuButton.setFont(new Font("Monolisa",Font.PLAIN,19));
		menuButton.setFocusable(false);
		
		menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == menuButton) {
					menuPage.main(new String[0]);
					mainWindow.setVisible(false);
					mainWindow.dispose();
				}
				
			}
			
		});
		
		mainWindow.add(menuButton);
		
		//End of menu button
		
		//Start of Query Button
		
		JButton queryButton = new JButton("الاستعلامات");
		queryButton.setBounds(180, 150, 150, 25);
		queryButton.setBorder(null);
		queryButton.setFont(new Font("Monolisa",Font.PLAIN,19));
		queryButton.setFocusable(false);
		mainWindow.add(queryButton);
		
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				query.main(new String[0]);
				mainWindow.setVisible(false);
				mainWindow.dispose();
			}
		});
		
		//End of Query Button
		
		//Start of Relock Button
		
		JButton relockButton = new JButton("اعادة الاغلاق");
		relockButton.setBounds(180, 210, 150, 25);
		relockButton.setBorder(null);
		relockButton.setFont(new Font("Monolisa",Font.PLAIN,19));
		relockButton.setFocusable(false);
		
		relockButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Elbaraka_Resturant.main(new String[0]);
				mainWindow.setVisible(false);
				mainWindow.dispose();
			}
		});
		
		
		mainWindow.add(relockButton);
		
		//End of Relock Button
		
		//End of Buttons ---------------------------------------- =>>>>>>>>>
		mainWindow.add(yellowPanel);
		mainWindow.setVisible(true);

	}

}
