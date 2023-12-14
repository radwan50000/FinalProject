package elbaraka_resturant;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class menuPage {

	public static Connection connection;
	//Public Variables of Meals Number And Prices
	public static int mealOneNumber = 0;
	public static int mealTwoNumber = 0;
	public static int mealThreeNumber = 0;
	public static int mealFourNumber = 0;
	public static int mealFiveNumber = 0;
	public static int mealOneTotalPrice = 0;
	public static int mealTwoTotalPrice = 0;
	public static int mealThreeTotalPrice = 0;
	public static int mealFourTotalPrice = 0;
	public static int mealFiveTotalPrice = 0;
	public static int totalPrices = 0;
	//Public Variables of Tables ID's
	public static int customer_id;
	public static int order_id;
	public static int user_id;
	
	public static void main(String[] args) {
		//Test java DBBC======================================================================
		String url = "jdbc:mysql://localhost:3306/elbaraka";
		
		//End Test java DBBC====================================================================
		
		ImageIcon icon = new ImageIcon("icon.jpg");
		
		//start of main JFrame Code__________________________________________________________********************************************
		
		JFrame menu = new JFrame("Elbaraka Menu");
		menu.setSize(1280,720);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setBackground(new Color(228,8,20));
		menu.setIconImage(icon.getImage());
		menu.setResizable(false);
		menu.setLayout(null);
		
		//end of main JFrame Code ____________________________________________________________**********************************************
		
		//Start Receipt Frame Code ________________________________________________________****************************************************
		
		JFrame receipt = new JFrame("Elbaraka Reciept");
		receipt.setSize(1030,530);
		receipt.getContentPane().setBackground(new Color(228,8,20));
		receipt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		receipt.setIconImage(icon.getImage());
		receipt.setResizable(false);
		receipt.setLayout(null);
		
		//Start of Right Yellow Color
		JPanel leftSideReceipt = new JPanel();
		leftSideReceipt.setBackground(new Color(250,202,11));
		leftSideReceipt.setBounds(235, 0, 215, 530);
		
		//End of Right Yellow Color
		
		//Start of meal name_______________________________________________
		
		
		//Start First Meal name
		JLabel mealOneRecieptName = new JLabel();
		mealOneRecieptName.setText("فتة X");
		mealOneRecieptName.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealOneRecieptName.setForeground(Color.white);
		mealOneRecieptName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealOneRecieptName.setBounds(370, 40, 70, 30);
		//End First Meal Name
		
		//Start of Second Meal Name
		JLabel mealTwoRecieptName = new JLabel();
		mealTwoRecieptName.setText("وجبة ستريبس X");
		mealTwoRecieptName.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealTwoRecieptName.setForeground(Color.white);
		mealTwoRecieptName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealTwoRecieptName.setBounds(150, 100, 290, 40);
		//End of Second Meal Name
		
		//Start of Third Meal Name
		JLabel mealThreeRecieptName = new JLabel();
		mealThreeRecieptName.setText("بسمتيو X");
		mealThreeRecieptName.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealThreeRecieptName.setForeground(Color.white);
		mealThreeRecieptName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealThreeRecieptName.setBounds(290, 160, 150, 40);
		//End of Third Meal Name
		
		//Start of Fourth Meal Name
		JLabel mealFourRecieptName = new JLabel();
		mealFourRecieptName.setText("ربع فرخة بروستد X");
		mealFourRecieptName.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealFourRecieptName.setForeground(Color.white);
		mealFourRecieptName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealFourRecieptName.setBounds(190, 220, 250, 40);
		//End of Fourth Meal Name
		
		//Start of Fifth Meal Name
		JLabel mealFiveRecieptName = new JLabel();
		mealFiveRecieptName.setText("وجبة البركة X");
		mealFiveRecieptName.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealFiveRecieptName.setForeground(Color.white);
		mealFiveRecieptName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealFiveRecieptName.setBounds(190, 280, 250, 40);
		//End of Fifth Meal Name

		
		//End of meal name_______________________________________________
		
		//Start of meal number______________________________________________________
		
		//Start of First Meal number  ======================================
		JLabel mealOneRecieptNumber = new JLabel("0");
		mealOneRecieptNumber.setBounds(335, 40, 50, 30);
		mealOneRecieptNumber.setForeground(Color.white);
		mealOneRecieptNumber.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealOneRecieptNumber.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		//End of First Meal Number ======================================
		
		//Start of Second Meal Number =================================================
		
		JLabel mealTwoRecieptNumber = new JLabel("0");
		mealTwoRecieptNumber.setBounds(245, 105, 50, 30);
		mealTwoRecieptNumber.setForeground(Color.white);
		mealTwoRecieptNumber.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealTwoRecieptNumber.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End of Second Meal Number =================================================
		
		//Start of Third Meal Number ==================================================
		
		JLabel mealThreeRecieptNumber = new JLabel("0");
		mealThreeRecieptNumber.setBounds(300,165,50,30);
		mealThreeRecieptNumber.setForeground(Color.white);
		mealThreeRecieptNumber.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealThreeRecieptNumber.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End of Third Meal Number ==================================================
		
		//Start of Fourth Meal Number ===============================================
		
		JLabel mealFourRecieptNumber = new JLabel("0");
		mealFourRecieptNumber.setBounds(220,225,50,30);
		mealFourRecieptNumber.setForeground(Color.white);
		mealFourRecieptNumber.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealFourRecieptNumber.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End of Fourth Meal Number ===============================================
		
		//Start of Fifth Meal Number ==============================================
		
		JLabel mealFiveRecieptNumber = new JLabel("0");
		mealFiveRecieptNumber.setBounds(265,275,50,50);
		mealFiveRecieptNumber.setForeground(Color.white);
		mealFiveRecieptNumber.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealFiveRecieptNumber.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End of Fifth Meal Number ==============================================
		
		//End of meal number______________________________________________________
		
		//Start of Sperating Line==============================================
		
		JLabel speratingRecieptLine = new JLabel();
		speratingRecieptLine.setText("---------------------------------------------------");
		speratingRecieptLine.setBounds(20,330,430,20);
		speratingRecieptLine.setForeground(Color.white);
		speratingRecieptLine.setFont(new Font("MonoLisa",Font.BOLD,25));
		
		//End of Sperating Line================================================
		
		//Start of Total Price Label ----------------------------------------------------
		
		JLabel totalReceiptPriceLabel = new JLabel("الاجمالي");
		totalReceiptPriceLabel.setBounds(150, 355, 290, 40);
		totalReceiptPriceLabel.setForeground(Color.white);
		totalReceiptPriceLabel.setFont(new Font("MonoLisa",Font.BOLD,25));
		totalReceiptPriceLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End of Total Price Label ----------------------------------------------------
		
		//Start of Total Price Number -----------------------------------------------
		
		JLabel totalReceiptPriceNumber = new JLabel("0");
		totalReceiptPriceNumber.setBounds(50, 355, 60, 30);
		totalReceiptPriceNumber.setFont(new Font("MonoLisa",Font.BOLD,25));
		totalReceiptPriceNumber.setForeground(Color.white);
		totalReceiptPriceNumber.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//End of Total Price Number -------------------------------------------------
		
		//Start of Meals Prices -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-|-|-|-|-|-|-|-|-|
		
		//Start of First Meal Price ___________________________________________________
		
		JLabel mealOnePriceReceipt = new JLabel("0");
		mealOnePriceReceipt.setBounds(50, 40, 60, 30);
		mealOnePriceReceipt.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealOnePriceReceipt.setForeground(Color.white);
		mealOnePriceReceipt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//Start of First Meal Price ___________________________________________________
		
		//Start of First Meal Price ___________________________________________________
		
		JLabel mealTwoPriceReceipt = new JLabel("0");
		mealTwoPriceReceipt.setBounds(50, 105, 60, 30);
		mealTwoPriceReceipt.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealTwoPriceReceipt.setForeground(Color.white);
		mealTwoPriceReceipt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//Start of First Meal Price ___________________________________________________
		

		//Start of First Meal Price ___________________________________________________
		
		JLabel mealThreePriceReceipt = new JLabel("0");
		mealThreePriceReceipt.setBounds(50, 165, 60, 30);
		mealThreePriceReceipt.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealThreePriceReceipt.setForeground(Color.white);
		mealThreePriceReceipt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//Start of First Meal Price ___________________________________________________
		
		

		//Start of First Meal Price ___________________________________________________
		
		JLabel mealFourPriceReceipt = new JLabel("0");
		mealFourPriceReceipt.setBounds(50, 225, 60, 30);
		mealFourPriceReceipt.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealFourPriceReceipt.setForeground(Color.white);
		mealFourPriceReceipt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//Start of First Meal Price ___________________________________________________
		
		

		//Start of First Meal Price ___________________________________________________
		
		JLabel mealFivePriceReceipt = new JLabel("0");
		mealFivePriceReceipt.setBounds(50, 285, 60, 30);
		mealFivePriceReceipt.setFont(new Font("MonoLisa",Font.BOLD,25));
		mealFivePriceReceipt.setForeground(Color.white);
		mealFivePriceReceipt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//Start of First Meal Price ___________________________________________________
		
		
		//End of Meals Prices -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-|-|-|-|-|-|-|-|-|
		
		//Start of Enter Data Section***********************************************************
		
		
		//Start of Name Part
		
		//Name Label
		JLabel enterNameLabel = new JLabel("الاسم الكامل");
		enterNameLabel.setBounds(790,30,200,50);
		enterNameLabel.setForeground(Color.white);
		enterNameLabel.setFont(new Font("MonoLisa",Font.BOLD,28));
		enterNameLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//Name Field
		JTextField enterNameField = new JTextField();
		enterNameField.setBounds(740,90,250,30);
		enterNameField.setFont(new Font("MonoLisa",Font.PLAIN,17));
		enterNameField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End oF Name Part
		
		//Start of Phone Part
		
		JLabel enterPhoneLabel = new JLabel("رقم الهاتف");
		enterPhoneLabel.setBounds(790,130,200,50);
		enterPhoneLabel.setForeground(Color.white);
		enterPhoneLabel.setFont(new Font("MonoLisa",Font.BOLD,28));
		enterPhoneLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//Name Field
		JTextField enterPhoneField = new JTextField();
		enterPhoneField.setBounds(740,190,250,30);
		enterPhoneField.setFont(new Font("MonoLisa",Font.PLAIN,17));
		enterPhoneField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End Of Phone Part
		
		//Start of Address Part
		
		JLabel enterAddressLabel = new JLabel("العنوان");
		enterAddressLabel.setBounds(790,240,200,50);
		enterAddressLabel.setForeground(Color.white);
		enterAddressLabel.setFont(new Font("MonoLisa",Font.BOLD,28));
		enterAddressLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//Name Field
		JTextField enterAddressField = new JTextField();
		enterAddressField.setBounds(740,300,250,30);
		enterAddressField.setFont(new Font("MonoLisa",Font.PLAIN,17));
		enterAddressField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//End of Address Part
		
		//Start of Enter Data Section***********************************************************
		
		//Start of Check Button ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		JButton checkButton = new JButton("تحقق");
		checkButton.setBounds(650,190,75,30);
		checkButton.setFont(new Font("MonoLisa",Font.BOLD,19));
		checkButton.setFocusable(false);
		
		JLabel foundLabel = new JLabel("مسجل");
		foundLabel.setBounds(580,190,75,30);
		foundLabel.setForeground(Color.GREEN);
		foundLabel.setFont(new Font("MonoLisa",Font.BOLD,19));
		foundLabel.setVisible(false);
		
		checkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == checkButton) {
					try {
						Connection connection = DriverManager.getConnection(url,"root","");
						Statement statment = connection.createStatement();
						ResultSet result = statment.executeQuery("SELECT * FROM customers WHERE phone = "+enterPhoneField.getText());
						
						while(result.next()) {
							enterNameField.setText(result.getString("full_name"));
							enterAddressField.setText(result.getString("address"));
						}
						
						statment = connection.createStatement();
						result = statment.executeQuery("SELECT COUNT(*) AS count FROM customers WHERE phone ="+enterPhoneField.getText());
						
						while(result.next()) {
							if(result.getInt("count") == 1) {
								foundLabel.setVisible(true);
							}else {
								enterNameField.setText("");
								enterAddressField.setText("");
								foundLabel.setVisible(false);								
							}
						}
						//End Connection With Database---------------------------------------------------
						try {
							connection.close();
						}catch(Exception p) {
							
						}
					}catch(Exception connectError) {
						
					}
					
				}
				
			}
			
		});
		
		
		//End of Check Button ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		//Start of Confirm Button ====================================================
		
		JButton confirmRecieptButton = new JButton("تأكيد");
		confirmRecieptButton.setBounds(915,400,75,30);
		confirmRecieptButton.setFocusable(false);
		confirmRecieptButton.setFont(new Font("MonoLisa",Font.BOLD,19));
		confirmRecieptButton.setForeground(Color.black);
		
		//End of Confirm Button ====================================================
		
		//Start of Cancel Button =============================================
		
		JButton cancelRecieptButton = new JButton("الغاء");
		cancelRecieptButton.setBounds(820,400,75,30);
		cancelRecieptButton.setForeground(Color.black);
		cancelRecieptButton.setFocusable(false);
		cancelRecieptButton.setFont(new Font("MonoLisa",Font.BOLD,19));
		
		
		//End of Cancel Button =============================================
		
		
		
		receipt.add(mealOneRecieptName);
		receipt.add(mealTwoRecieptName);
		receipt.add(mealThreeRecieptName);
		receipt.add(mealFourRecieptName);
		receipt.add(mealFiveRecieptName);
		receipt.add(mealOneRecieptNumber);
		receipt.add(mealTwoRecieptNumber);
		receipt.add(mealThreeRecieptNumber);
		receipt.add(mealFourRecieptNumber);
		receipt.add(mealFiveRecieptNumber);
		receipt.add(mealOnePriceReceipt);
		receipt.add(mealTwoPriceReceipt);
		receipt.add(mealThreePriceReceipt);
		receipt.add(mealFourPriceReceipt);
		receipt.add(mealFivePriceReceipt);
		receipt.add(speratingRecieptLine);
		receipt.add(totalReceiptPriceLabel);
		receipt.add(totalReceiptPriceNumber);
		receipt.add(enterNameLabel);
		receipt.add(enterNameField);
		receipt.add(enterPhoneLabel);
		receipt.add(enterPhoneField);
		receipt.add(enterAddressLabel);
		receipt.add(enterAddressField);
		receipt.add(checkButton);
		receipt.add(confirmRecieptButton);
		receipt.add(cancelRecieptButton);
		receipt.add(foundLabel);
		receipt.add(leftSideReceipt);
		receipt.setVisible(false);
				
		//End of Reciept Menu_________________________________________________________*************************************************************
		
		//Start Code of meals Images_______________________________________
		
		//Start of First meal Image
		
		JLabel mealOneLabel = new JLabel();
		ImageIcon mealOneImage = new ImageIcon("mealOne.png");
		mealOneLabel.setIcon(mealOneImage);
		mealOneLabel.setBounds(1085,0,250,150);
		
		//End of First meal Image
		
		//Start of Second meal Image
		
		JLabel secondMealLabel = new JLabel();
		ImageIcon secondMealImage = new ImageIcon("mealTwo.png");
		secondMealLabel.setIcon(secondMealImage);
		secondMealLabel.setBounds(1085,300,200,150);
		
		//End of Second meal Image
		
		//Start of Third meal Image
		
		JLabel thirdMealLabel = new JLabel();
		ImageIcon thirdMealImage = new ImageIcon("mealThree.png");
		thirdMealLabel.setIcon(thirdMealImage);
		thirdMealLabel.setBounds(630,0,250,150);
		
		//End of Third meal Image
		
		//Start of Fourth meal Image
		
		JLabel fourthMealLabel = new JLabel();
		ImageIcon fourthMealImage = new ImageIcon("mealFour.png");
		fourthMealLabel.setIcon(fourthMealImage);
		fourthMealLabel.setBounds(530,300,250,150);
		
		//End of Fourth meal Image
		
		//Start of Fifth meal Imgae 175
		
		JLabel fifthMealLabel = new JLabel();
		ImageIcon fifthMealImage = new ImageIcon("mealFive.png");
		fifthMealLabel.setIcon(fifthMealImage);
		fifthMealLabel.setBounds(175,0,250,150);
		
		//End of Fifth meal Imgae
		
		//End Code of meals________________________________________________
		
		//Start Code of meals titles_______________________________________
		
		//Start of First Meal Title
		JLabel firstMealTitle = new JLabel();
		firstMealTitle.setText("فتة");
		firstMealTitle.setBounds(1000,5,250,150);
		firstMealTitle.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD+Font.ITALIC,60));
		firstMealTitle.setForeground(new Color(245,178,11));
		//End of First Meal Title
		
		//Start of Second Meal Title
		JLabel secondMealTitle = new JLabel();
		secondMealTitle.setText("وجبة ستريبس");
		secondMealTitle.setBounds(350,5,400,150);
		secondMealTitle.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD+Font.ITALIC,60));
		secondMealTitle.setForeground(new Color(245,178,11));
		//End of Second Meal Title
		
		//Start of Third Meal Title
		JLabel thirdMealTitle = new JLabel();
		thirdMealTitle.setText("بسمتيو");
		thirdMealTitle.setForeground(new Color(245,178,11));
		thirdMealTitle.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD+Font.ITALIC,60));
		thirdMealTitle.setBounds(40,5,400,150);
		//End of Third Meal Title
		
		//Start of Fourth Meal Title
		JLabel fourthMealTitle = new JLabel();
		fourthMealTitle.setText("ربع فرخة بروستد");
		fourthMealTitle.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD+Font.ITALIC,60));
		fourthMealTitle.setForeground(new Color(245,178,11));
		fourthMealTitle.setBounds(720,295,400,150);
		//End of Fourth Meal Title
		
		//Start of Fifth Meal Title
		JLabel fifthMealTitle = new JLabel();
		fifthMealTitle.setText("وجبة البركة");
		fifthMealTitle.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD+Font.ITALIC,60));
		fifthMealTitle.setForeground(new Color(245,178,11));
		fifthMealTitle.setBounds(270,295,400,150);
		//End of Fifth Meal Title
		
		//End Code of meals titles_________________________________________
		
		//Start of Meals Components________________________________________
		
		//Start of First Meal Component
		JLabel firstMealComponent = new JLabel();
		firstMealComponent.setText("(رز بسمتي + صوص من اختيارك + ستربس + علبة كول سلو)");
		firstMealComponent.setForeground(new Color(254,254,254));
		firstMealComponent.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD,20));
		firstMealComponent.setBounds(820,70,600,150);
		//End of First Meal Component
		
		//Start of Second Meal Component
		JLabel secondMealComponent = new JLabel();
		secondMealComponent.setText("(بطاطس + خبز + ثومية + كاتشب)");
		secondMealComponent.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD,20));
		secondMealComponent.setForeground(new Color(254,254,254));
		secondMealComponent.setBounds(520,80,500,150);
		//End of Second Meal Component
		
		//Start of Fourth Meal Component
		JLabel fourthMealComponent = new JLabel();
		fourthMealComponent.setText("( ورك فرخة بروستد + بطاطس + خبز + ثومية صغيرة + كاتشب)");
		fourthMealComponent.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD,20));
		fourthMealComponent.setForeground(new Color(254,254,254));
		fourthMealComponent.setBounds(800,380,500,150);
		//End of Fourth Meal Component
		
		//Start of Fifth Meal Component
		JLabel fifthMealComponent = new JLabel();
		fifthMealComponent.setText("(نص فرخة بروستد + بطاطس + خبز + ثومية + علبة كول سلو + كاتشب)");
		fifthMealComponent.setFont(new Font(Font.SERIF,Font.PLAIN+Font.BOLD,20));
		fifthMealComponent.setForeground(new Color(254,254,254));
		fifthMealComponent.setBounds(200,380,500,150);
		//End of Fifth Meal Component
		
		//End of Meals Components___________________________________________
		
		
		
		//Start of Meals Pieces label______________________________________________
		
		//Start First Meal Piece label
		JLabel firstMealPiece = new JLabel("عدد القطع = 0");
		firstMealPiece.setForeground(new Color(255,255,255));
		firstMealPiece.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		firstMealPiece.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		firstMealPiece.setBounds(1040,200,150,30);
		//End First Meal Piece label
		
		//Start Second Meal Piece label
		JLabel secondMealPiece = new JLabel("عدد القطع = 0");
		secondMealPiece.setForeground(new Color(255,255,255));
		secondMealPiece.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		secondMealPiece.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		secondMealPiece.setBounds(540,200,150,30);
		//End Second Meal Piece label
		
		//Start Third Meal Piece label
		JLabel thirdMealPiece = new JLabel("عدد القطع = 0");
		thirdMealPiece.setForeground(new Color(255,255,255));
		thirdMealPiece.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		thirdMealPiece.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		thirdMealPiece.setBounds(90,150,140,30);
		//End Third Meal Piece label
		
		//Start Fourth Meal Piece label
		JLabel fourthMealPiece = new JLabel("عدد القطع = 0");
		fourthMealPiece.setForeground(new Color(255,255,255));
		fourthMealPiece.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		fourthMealPiece.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		fourthMealPiece.setBounds(1020,500,150,30);
		//End Fourth Meal Piece label
		
		//Start Fifth Meal Piece label
		JLabel fifthMealPiece = new JLabel("عدد القطع = 0");
		fifthMealPiece.setForeground(new Color(255,255,255));
		fifthMealPiece.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		fifthMealPiece.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		fifthMealPiece.setBounds(480,490,150,30);
		//End Fifth Meal Piece label
		
		//End of Meals pieces label______________________________________________
		
		//Start of Meals Price___________________________________________
		
		//Start First meal Price
		JLabel mealOnePrice = new JLabel("السعر = 0");
		mealOnePrice.setForeground(new Color(255,255,255));
		mealOnePrice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealOnePrice.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		mealOnePrice.setBounds(880,200,150,30);
		//End First Meal Price
		
		//Start Second meal Price
		JLabel mealTwoPrice = new JLabel("السعر = 0");
		mealTwoPrice.setForeground(new Color(255,255,255));
		mealTwoPrice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealTwoPrice.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		mealTwoPrice.setBounds(390,200,150,30);
		//End First Meal Price
		
		//Start Third meal Price
		JLabel mealThreePrice = new JLabel("السعر = 0");
		mealThreePrice.setForeground(new Color(255,255,255));
		mealThreePrice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealThreePrice.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		mealThreePrice.setBounds(95,190,130,30);
		//End First Meal Price
		
		//Start Fourth meal Price
		JLabel mealFourPrice = new JLabel("السعر = 0");
		mealFourPrice.setForeground(new Color(255,255,255));
		mealFourPrice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealFourPrice.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		mealFourPrice.setBounds(860,500,150,30);
		//End First Meal Price
		
		//Start Fifth meal Price
		JLabel mealFivePrice = new JLabel("السعر = 0");
		mealFivePrice.setForeground(new Color(255,255,255));
		mealFivePrice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealFivePrice.setFont(new Font("MonoLisa",Font.PLAIN+Font.BOLD,25));
		mealFivePrice.setBounds(330,490,150,30);
		//End First Meal Price
		
		//Start of Price Label
		
		//Start of first meal price label___________________________________________________
		
		JLabel mealOnePricePhrase = new JLabel("(سعر الوجبة 90 جينه)");
		mealOnePricePhrase.setForeground(Color.white);
		mealOnePricePhrase.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealOnePricePhrase.setBounds(1040,250,200,30);
		mealOnePricePhrase.setFont(new Font("MonoLisa",Font.PLAIN,18));
		
		//End of first meal price label
		
		//Start of Second meal price label
		
		JLabel mealTwoPricePhrase = new JLabel("(سعر الوجبة 125 جينه)");
		mealTwoPricePhrase.setForeground(Color.white);
		mealTwoPricePhrase.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealTwoPricePhrase.setBounds(540,250,200,30);
		mealTwoPricePhrase.setFont(new Font("MonoLisa",Font.PLAIN,18));
		
		//End of Second meal price label
		
		
		
		//Start of Third meal price label
		
		JLabel mealThirdPricePhrase = new JLabel("(سعر الوجبة 65 جينه)");
		mealThirdPricePhrase.setForeground(Color.white);
		mealThirdPricePhrase.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealThirdPricePhrase.setBounds(100,230,200,30);
		mealThirdPricePhrase.setFont(new Font("MonoLisa",Font.PLAIN,18));
		
		//End of Third meal price label
		
		//Start of Fourth meal price label
		
		JLabel mealFourPricePhrase = new JLabel("(سعر الوجبة 85 جينه)");
		mealFourPricePhrase.setForeground(Color.white);
		mealFourPricePhrase.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealFourPricePhrase.setBounds(1020,550,200,30);
		mealFourPricePhrase.setFont(new Font("MonoLisa",Font.PLAIN,18));
		
		//End of Fourth meal price label
		
		//Start of Fifth meal price label
		
		JLabel mealFivePricePhrase = new JLabel("(سعر الوجبة 150 جينه)");
		mealFivePricePhrase.setForeground(Color.white);
		mealFivePricePhrase.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mealFivePricePhrase.setBounds(480,540,200,30);
		mealFivePricePhrase.setFont(new Font("MonoLisa",Font.PLAIN,18));
		
		//End of Fifth meal price label___________________________________________________

		
		//End of Price Label
		
		//End of Meals Price___________________________________________
		
		//Start of Order Button_________________________________________
		
		JButton orderButton = new JButton("اطلب");
		orderButton.setFocusable(false);
		orderButton.setFont(new Font("MonoLisa",Font.PLAIN,20));
		orderButton.setBackground(Color.white);
		orderButton.setForeground(Color.black);
		orderButton.setBounds(40,630,100,30);
		
		
		
		//End of Order Button______________________________________________
		
		
		//Start Create Meals Spinner__________________________________________
		
				//Start First Meal Spinner
		
				JSpinner firstMealSpinner = new JSpinner(new SpinnerNumberModel(0,0,50,1));
				firstMealSpinner.getEditor().getComponent(0).setBackground(new Color(255,0,0));
				firstMealSpinner.setBounds(1200,200,40,30);
				
				firstMealSpinner.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						firstMealPiece.setText("عدد القطع = "+firstMealSpinner.getValue());
						int price = (int) firstMealSpinner.getValue();
						price = price * 90;
						mealOnePrice.setText("السعر = "+ price);
						
					}
					
				});
				
				//End First Meal Spinner
				
				//Start Second Meal Spinner
				JSpinner secondMealSpinner = new JSpinner(new SpinnerNumberModel(0,0,50,1));
				secondMealSpinner.getEditor().getComponent(0).setBackground(new Color(255,0,0));
				secondMealSpinner.setBounds(700,200,40,30);
				
				secondMealSpinner.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						secondMealPiece.setText("عدد القطع = "+secondMealSpinner.getValue());
						int price = (int) secondMealSpinner.getValue();
						price = price * 125;
						mealTwoPrice.setText("السعر = "+ price);
						
					}
					
				});
				//End Second Meal Spinner
				
				//Start Third Meal Spinner
				JSpinner thirdMealSpinner = new JSpinner(new SpinnerNumberModel(0,0,50,1));
				thirdMealSpinner.getEditor().getComponent(0).setBackground(new Color(255,0,0));
				thirdMealSpinner.setBounds(260,150,40,30);
				
				thirdMealSpinner.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						thirdMealPiece.setText("عدد القطع = "+thirdMealSpinner.getValue());
						int price = (int) thirdMealSpinner.getValue();
						price = price * 65;
						mealThreePrice.setText("السعر = "+ price);
						
					}
				});
				//End Third Meal Spinner
				
				//Start Fourth Meal Spinner
				JSpinner fourthMealSpinner = new JSpinner(new SpinnerNumberModel(0,0,50,1));
				fourthMealSpinner.getEditor().getComponent(0).setBackground(new Color(255,0,0));
				fourthMealSpinner.setBounds(1180,500,40,30);
				
				fourthMealSpinner.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						fourthMealPiece.setText("عدد القطع = "+fourthMealSpinner.getValue());
						int price = (int) fourthMealSpinner.getValue();
						price = price * 85;
						mealFourPrice.setText("السعر = "+ price);
					}
					
				});
				//End Fourth Meal Spinner
				
				//Start Fifth Meal Spinner
				JSpinner fifthMealSpinner = new JSpinner(new SpinnerNumberModel(0,0,50,1));
				fifthMealSpinner.getEditor().getComponent(0).setBackground(new Color(255,0,0));
				fifthMealSpinner.setBounds(640,490,40,30);
				
				fifthMealSpinner.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						fifthMealPiece.setText("عدد القطع = "+fifthMealSpinner.getValue());
						int price = (int) fifthMealSpinner.getValue();
						price = price * 150;
						mealFivePrice.setText("السعر = "+ price);
					}
				});
				//End Fifth Meal Spinner
				
				
				//End Create Meals Spinner__________________________________________
				
				// Order Button Event Listener
				orderButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == orderButton) {
							//Get The Spinner Values
							mealOneNumber = (int) firstMealSpinner.getValue();
							mealTwoNumber = (int)secondMealSpinner.getValue();
							mealThreeNumber = (int) thirdMealSpinner.getValue();
							mealFourNumber = (int) fourthMealSpinner.getValue();
							mealFiveNumber = (int) fifthMealSpinner.getValue();
							
							mealOneRecieptNumber.setText(mealOneNumber+"");
							mealTwoRecieptNumber.setText(mealTwoNumber+"");
							mealThreeRecieptNumber.setText(mealThreeNumber+"");
							mealFourRecieptNumber.setText(mealFourNumber+"");
							mealFiveRecieptNumber.setText(mealFiveNumber+"");
							//Get the Price Values
							mealOneTotalPrice = mealOneNumber * 90;
							mealTwoTotalPrice = mealTwoNumber * 125;
							mealThreeTotalPrice = mealThreeNumber * 65;
							mealFourTotalPrice = mealFourNumber * 85;
							mealFiveTotalPrice = mealFiveNumber * 150;
							
							mealOnePriceReceipt.setText(mealOneTotalPrice+"");
							mealTwoPriceReceipt.setText(mealTwoTotalPrice+"");
							mealThreePriceReceipt.setText(mealThreeTotalPrice+"");
							mealFourPriceReceipt.setText(mealFourTotalPrice+"");
							mealFivePriceReceipt.setText(mealFiveTotalPrice+"");
							//Get The Total Value
							totalPrices = mealOneTotalPrice + mealTwoTotalPrice + mealThreeTotalPrice + mealFourTotalPrice + mealFiveTotalPrice;
							
							totalReceiptPriceNumber.setText(totalPrices+"");
							if(totalPrices > 0) {
								receipt.setVisible(true);
							}
						}
						
					}
					
				});
				
				//End of Order Button Event Listener
				
				//Start of Confirm Button Event Listener
				
				confirmRecieptButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							Connection connection = DriverManager.getConnection(url,"root","");
							Statement statement = connection.createStatement();
							ResultSet result = statement.executeQuery("SELECT COUNT(*) AS count FROM customers where phone = "+enterPhoneField.getText());
							
							int found = 0; // found ? 1:0;
							while(result.next()) {
								found = result.getInt("count");
							}
							
							//Enter Customer Data to the Database /*\
							
							if(found == 0) {
								if((enterNameField.getText() != "" && enterNameField.getText().length() > 0) && (enterNameField.getText() != "" && enterNameField.getText().length() > 0) && (enterPhoneField.getText() != "" && enterPhoneField.getText().length() > 0)) {
									//Start of customer database data Variables
									String fullName = enterNameField.getText();
									String phone = enterPhoneField.getText();
									String address = enterAddressField.getText();
									//Start of orders database data Variables
									String orderAddress = address;
									int totalPrice = totalPrices;
									//Start of Customer Query
									String query = "INSERT INTO customers (full_name,phone,address) values (?,?,?);";
									try {
										PreparedStatement prepared = connection.prepareStatement(query);
										prepared.setString(1, fullName);
										prepared.setString(2, phone);
										prepared.setString(3, address);
										
										prepared.executeUpdate();
										
										statement = connection.createStatement();
										result = statement.executeQuery("SELECT LAST_INSERT_ID() AS last_id");
										
										while(result.next()) {
											customer_id = result.getInt("last_id");
										}
									}catch(Exception r) {
										
									}
									//Start of Orders Query
									query = "INSERT INTO orders (order_address,total_price,customer_id) VALUES (?,?,?);";
									
									try {
										PreparedStatement prepared = connection.prepareStatement(query);
										prepared.setString(1,orderAddress);
										prepared.setInt(2, totalPrice);
										prepared.setInt(3, customer_id);
										prepared.executeUpdate();
										
										statement = connection.createStatement();
										result = statement.executeQuery("SELECT LAST_INSERT_ID() AS last_id");
										
										while(result.next()) {
											order_id = result.getInt("last_id");
										}
										
									}catch(Exception t) {
										
									}

									
								}
								//Reciept Prices Number
								mealOneNumber = 0;
								mealTwoNumber = 0;
								mealThreeNumber = 0;
								mealFourNumber = 0;
								mealFiveNumber = 0;
								mealOneTotalPrice = 0;
								mealTwoTotalPrice = 0;
								mealThreeTotalPrice = 0;
								mealFourTotalPrice = 0;
								mealFiveTotalPrice = 0;
								//Total Variable ....
								
								//Enter Data Fields
								enterNameField.setText("");
								enterPhoneField.setText("");
								enterAddressField.setText("");
								//Menu Spinners
								firstMealSpinner.setValue(0);
								secondMealSpinner.setValue(0);
								thirdMealSpinner.setValue(0);
								fourthMealSpinner.setValue(0);
								fifthMealSpinner.setValue(0);
								foundLabel.setVisible(false);
								
								receipt.setVisible(false);
							//Enter Data if the number is exist in the database
							}else {
								if((enterNameField.getText() != "" && enterNameField.getText().length() > 0) && (enterNameField.getText() != "" && enterNameField.getText().length() > 0) && (enterPhoneField.getText() != "" && enterPhoneField.getText().length() > 0)) {
									
									//Start of customer database data Variables
									String fullName = enterNameField.getText();
									String phone = enterPhoneField.getText();
									String address = enterAddressField.getText();
									//Start of orders database data Variables
									String orderAddress = address;
									int totalPrice = totalPrices;
									//Start of Customer Query => get customer id
									String query = "SELECT customer_id from customers where phone = "+phone;
									
									statement = connection.createStatement();
									result = statement.executeQuery(query);
									
									while(result.next()) {
										customer_id = result.getInt("customer_id");
									}
									
									//Start of Orders Query => get order id
									query = "INSERT INTO orders (order_address,total_price,customer_id) VALUES (?,?,?);";
									
									try {
										PreparedStatement prepared = connection.prepareStatement(query);
										prepared.setString(1,orderAddress);
										prepared.setInt(2, totalPrice);
										prepared.setInt(3, customer_id);
										prepared.executeUpdate();
										
										statement = connection.createStatement();
										result = statement.executeQuery("SELECT LAST_INSERT_ID() AS last_id");
										
										while(result.next()) {
											order_id = result.getInt("last_id");
										}
										
									}catch(Exception t) {
										
									}
									//Enter Data in Customer_orders
									query = "INSERT INTO customer_orders (customer_id,order_id) values (?,?);";
									try {
										PreparedStatement prepared= connection.prepareStatement(query);
										prepared.setInt(1, customer_id);
										prepared.setInt(2, order_id);
										
										prepared.executeUpdate();
									}catch(Exception q) {
										
									}
								}
								//Reciept Prices Number
								mealOneNumber = 0;
								mealTwoNumber = 0;
								mealThreeNumber = 0;
								mealFourNumber = 0;
								mealFiveNumber = 0;
								mealOneTotalPrice = 0;
								mealTwoTotalPrice = 0;
								mealThreeTotalPrice = 0;
								mealFourTotalPrice = 0;
								mealFiveTotalPrice = 0;
								//Total Variable ....
								
								//Enter Data Fields
								enterNameField.setText("");
								enterPhoneField.setText("");
								enterAddressField.setText("");
								//Menu Spinners
								firstMealSpinner.setValue(0);
								secondMealSpinner.setValue(0);
								thirdMealSpinner.setValue(0);
								fourthMealSpinner.setValue(0);
								fifthMealSpinner.setValue(0);
								foundLabel.setVisible(false);
								
								receipt.setVisible(false);
							}
							
							try {
								connection.close();
							}catch(Exception a) {
								
							}
							
							
							
						}catch(Exception f) {
							
						}
						
						
					}
					
					
				});
				
				//End of Confirm Button Event Listener
		
				
		//Start of Relock Button
		JButton relockButton = new JButton("اعادة الاغلاق");
		relockButton.setFocusable(false);
		relockButton.setFont(new Font("MonoLisa",Font.PLAIN,20));
		relockButton.setBackground(Color.white);
		relockButton.setForeground(Color.black);
		relockButton.setBounds(1090,625,150,30);
		
		relockButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Elbaraka_Resturant.main(new String[0]);
				menu.setVisible(false);
				receipt.setVisible(false);
				receipt.dispose();
				menu.dispose();
			}
		}
			
		);
		
		menu.add(relockButton);
		//End of Relock Button
		
		//Start Cancel Reciept Button ////////////////////////////////////////////////
				
		cancelRecieptButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Reciept Prices Number
				mealOneNumber = 0;
				mealTwoNumber = 0;
				mealThreeNumber = 0;
				mealFourNumber = 0;
				mealFiveNumber = 0;
				mealOneTotalPrice = 0;
				mealTwoTotalPrice = 0;
				mealThreeTotalPrice = 0;
				mealFourTotalPrice = 0;
				mealFiveTotalPrice = 0;
				//Total Variable ....
				
				//Enter Data Fields
				enterNameField.setText("");
				enterPhoneField.setText("");
				enterAddressField.setText("");
				//Menu Spinners
				firstMealSpinner.setValue(0);
				secondMealSpinner.setValue(0);
				thirdMealSpinner.setValue(0);
				fourthMealSpinner.setValue(0);
				fifthMealSpinner.setValue(0);
				foundLabel.setVisible(false);
				
				receipt.setVisible(false);
				
			}
			
			
		});
		
		//End Cancel Reciept Button ////////////////////////////////////////////////
				
		//End of Reciept Menu_________________________________________________________
		
		//Images
		menu.add(mealOneLabel);
		menu.add(secondMealLabel);
		menu.add(thirdMealLabel);
		menu.add(fourthMealLabel);
		menu.add(fifthMealLabel);
		//Titles
		menu.add(firstMealTitle);
		menu.add(secondMealTitle);
		menu.add(thirdMealTitle);
		menu.add(fourthMealTitle);
		menu.add(fifthMealTitle);
		//Components
		menu.add(firstMealComponent);
		menu.add(secondMealComponent);
		menu.add(fourthMealComponent);
		menu.add(fifthMealComponent);
		//Spinners
		menu.add(firstMealSpinner);
		menu.add(secondMealSpinner);
		menu.add(thirdMealSpinner);
		menu.add(fourthMealSpinner);
		menu.add(fifthMealSpinner);
		//Pieces Number
		menu.add(firstMealPiece);
		menu.add(secondMealPiece);
		menu.add(thirdMealPiece);
		menu.add(fourthMealPiece);
		menu.add(fifthMealPiece);
		//Meals Price
		menu.add(mealOnePrice);
		menu.add(mealTwoPrice);
		menu.add(mealThreePrice);
		menu.add(mealFourPrice);
		menu.add(mealFivePrice);
		//Buttons
		menu.add(orderButton);
		//Price Labels
		menu.add(mealOnePricePhrase);
		menu.add(mealTwoPricePhrase);
		menu.add(mealThirdPricePhrase);
		menu.add(mealFourPricePhrase);
		menu.add(mealFivePricePhrase);
		
		menu.setVisible(true);
		
		
	}

}