package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.protocol.Resultset;

public class MainMenu extends JFrame implements ActionListener {

	private Container con;
	private JTabbedPane tp;
	private JTable table1, table2; 
	private DefaultTableModel model1, model2;
	private JScrollPane scroll, scroll1, scroll2, scroll3;
	private Font f, font;
	private JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14, lab15, lab16, imgLab, imgLab2, imgLab3, imgLab4, imgLab5;
	private BoxLayout box;
	private JTextField tf1,tf2,tf3, tf4, tf5,tf6, tf7, tf8;
	private JTextArea ta1, ta2;
	private ImageIcon icon,imgicon, imgicon2;
	private Cursor cursor;
	private JButton logOutButton, showBudget, showIncome, showTax, showLoan, sur_def, prev_info, resetbtn, btn1, btn2, btn3, btn4, EnterButton, ClearButton;
	private JPanel revPan, expPan, surPan, defPan;
	
	private String[] cols = {"Type", "Item", "Amount(in crore)", "Percentage"};
	
	MainMenu()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.setBounds(100, 50, 900, 700);
		this.setTitle("Budget Analyzer/Menu");
		
		con = getContentPane();
		con.setLayout(null);
		
		cursor = new Cursor(Cursor.HAND_CURSOR); 
		
		imgicon2 = new ImageIcon(getClass().getResource("backgroundimg.jpg"));
		imgicon = new ImageIcon(getClass().getResource("smbgimg.jpg"));
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		font = new Font("Arial", Font.BOLD, 15);
		f = new Font("Arial", Font.BOLD, 25);
		
		showBudget = new JButton("Show Budget");
		showBudget.setBounds(20, 580, 120, 30);
		showBudget.setCursor(cursor);
		con.add(showBudget);
		
		showIncome = new JButton("Show IncomeTax");
		showIncome.setBounds(160, 580, 140, 30);
		showIncome.setCursor(cursor);
		con.add(showIncome);
		
		showTax = new JButton("Show OtherTax");
		showTax.setBounds(320, 580, 140, 30);
		showTax.setCursor(cursor);
		con.add(showTax);
		
		showLoan = new JButton("Loan Info");
		showLoan.setBounds(480, 580, 100, 30);
		showLoan.setCursor(cursor);
		con.add(showLoan);
		
		sur_def= new JButton("Surplus/Deficit");
		sur_def.setBounds(600, 580, 120, 30);
		sur_def.setCursor(cursor);
		con.add(sur_def);
		
		prev_info= new JButton("Prev.Info");
		prev_info.setBounds(740, 580, 90, 30);
		prev_info.setCursor(cursor);
		con.add(prev_info);
		
		logOutButton = new JButton("Log Out");
		logOutButton.setBounds(720, 10, 110, 40);
		logOutButton.setFont(font);
		logOutButton.setCursor(cursor);
		con.add(logOutButton);
		
		resetbtn = new JButton("Reset");
		resetbtn.setBounds(720, 70, 110, 40);
		resetbtn.setFont(font);
		resetbtn.setCursor(cursor);
		con.add(resetbtn);
		
		lab11 = new JLabel("Enter Budget:");
		lab11.setBounds(20, 5, 100, 40);
		lab11.setForeground(Color.white);
		con.add(lab11);
		
		tf7 = new JTextField(" /-");
		tf7.setBounds(130, 7, 150, 30);
		tf7.setHorizontalAlignment(JTextField.RIGHT);
		con.add(tf7);
		
		lab12 = new JLabel("Enter Year:");
		lab12.setBounds(20, 45, 100, 40);
		lab12.setForeground(Color.white);
		con.add(lab12);
		
		tf8 = new JTextField();
		tf8.setBounds(130, 47, 150, 30);
		tf8.setHorizontalAlignment(JTextField.RIGHT);
		con.add(tf8);
		
		EnterButton = new JButton("Enter");
		EnterButton.setBounds(290, 47, 80, 30);
		EnterButton.setCursor(cursor);
		con.add(EnterButton);
		
		ClearButton = new JButton("Clear");
		ClearButton.setBounds(290, 7, 80, 30);
		ClearButton.setCursor(cursor);
		con.add(ClearButton);
		
		
		tp = new JTabbedPane();
		tp.setBounds(20, 100, 810, 450);
		con.add(tp);
		
		imgLab2 = new JLabel(imgicon2);
		imgLab2.setBounds(0, 0, 810, 450);
		
		imgLab3 = new JLabel(imgicon2);
		imgLab3.setBounds(0, 0, 810, 450);
		
		imgLab4 = new JLabel(imgicon2);
		imgLab4.setBounds(0, 0, 810, 450);
		
		imgLab5 = new JLabel(imgicon2);
		imgLab5.setBounds(0, 0, 810, 450);
		
		
		revPan = new JPanel();
		revPan.setLayout(null);
		expPan = new JPanel();
		expPan.setLayout(null);
		surPan = new JPanel();	
		surPan.setLayout(null);
		defPan = new JPanel();
		defPan.setLayout(null);
		
		tp.addTab("Revenue", revPan);
		tp.addTab("Expenditure", expPan);
		tp.addTab("Surplus", surPan);
		tp.addTab("Deficit", defPan);
		
		// Revenue part
		
		
		lab1 = new JLabel("Revenue");
		lab1.setBounds(50, 5, 200, 80 );
		lab1.setForeground(Color.BLUE);
		lab1.setFont(f);
		revPan.add(lab1);
		
		btn1 = new JButton("Enter Data");
		btn1.setFont(font);
		btn1.setBounds(50, 80, 200, 40);
		btn1.setCursor(cursor);
		revPan.add(btn1);
		
		btn2 = new JButton("Show Data");
		btn2.setFont(font);
		btn2.setBounds(50, 250, 200, 40);
		btn2.setCursor(cursor);
		revPan.add(btn2);
		
		lab13 = new JLabel("Total Revenue: ");
		lab13.setBounds(20, 330, 150, 50);
		lab13.setForeground(Color.BLUE);
		lab13.setFont(font);
		revPan.add(lab13);
		
		lab14 = new JLabel(" ");
		lab14.setBounds(190, 330, 100, 50);
		lab14.setForeground(Color.BLUE);
		lab14.setFont(font);
		revPan.add(lab14);
		
		
		// Expenditure Part
		
		
		lab2 = new JLabel("Expenditure");
		lab2.setBounds(50, 5, 200, 80 );
		lab2.setForeground(Color.BLUE);
		lab2.setFont(f);
		expPan.add(lab2);
		
		btn3 = new JButton("Enter Data");
		btn3.setFont(font);
		btn3.setBounds(50, 80, 200, 40);
		btn3.setCursor(cursor);
		expPan.add(btn3);
		
		btn4 = new JButton("Show Data");
		btn4.setFont(font);
		btn4.setBounds(50, 250, 200, 40);
		btn4.setCursor(cursor);
		expPan.add(btn4);
		
		lab15 = new JLabel("Total Expenditure: ");
		lab15.setBounds(20, 330, 150, 50);
		lab15.setForeground(Color.BLUE);
		lab15.setFont(font);
		expPan.add(lab15);
		
		lab16 = new JLabel(" ");
		lab16.setBounds(190, 330, 100, 50);
		lab16.setForeground(Color.BLUE);
		lab16.setFont(font);
		expPan.add(lab16);
		
		
		// Surplus Part
		
		
		lab5 = new JLabel("Surplus");
		lab5.setBounds(30, 1, 150, 50);
	    lab5.setFont(f);
		lab5.setForeground(Color.BLUE);
				
		lab6 = new JLabel("Previous Information:");
		lab6.setBounds(30, 40, 200, 50);
		lab6.setForeground(Color.BLUE);
				
		ta1 = new JTextArea();
				
		scroll = new JScrollPane(ta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(220, 40, 400, 160);
				
		lab7 = new JLabel("At Present:");
		lab7.setBounds(30, 200, 100, 50);
		lab7.setForeground(Color.BLUE);
				
		lab8 = new JLabel("Revenue:");
		lab8.setBounds(120, 210, 80, 50);
		lab8.setForeground(Color.BLUE);
				
		lab9 = new JLabel("Expenditure:");
		lab9.setBounds(120, 260, 80, 50);
		lab9.setForeground(Color.BLUE);
				
		lab10 = new JLabel("Surplus Amount:");
		lab10.setBounds(120, 310, 120, 50);
		lab10.setForeground(Color.BLUE);
				
		tf1 = new JTextField("");
		tf1.setBounds(220, 210, 200, 50);
		tf1.setFont(font);
		tf1.setHorizontalAlignment(JTextField.RIGHT);
		
				
		tf2 = new JTextField("");
		tf2.setBounds(220, 260, 200, 50);
		tf2.setFont(font);
		tf2.setHorizontalAlignment(JTextField.RIGHT);
		
		tf3 = new JTextField("");
		tf3.setBounds(220, 310, 200, 50);
		tf3.setFont(font);
		tf3.setHorizontalAlignment(JTextField.RIGHT);
		
				
		surPan.add(lab5);
		surPan.add(lab6);
		surPan.add(scroll);
		surPan.add(lab7);
		surPan.add(lab8);
		surPan.add(tf1);
		surPan.add(lab9);		
		surPan.add(tf2);
		surPan.add(lab10);
		surPan.add(tf3);
		
				
				
		// Deficit part
				
				
		lab5 = new JLabel("Deficit");
		lab5.setBounds(30, 1, 150, 50);
		lab5.setFont(f);
		lab5.setForeground(Color.BLUE);
				
		lab6 = new JLabel("Previous Information:");
		lab6.setBounds(30, 40, 200, 50);
		lab6.setForeground(Color.BLUE);
				
		ta2 = new JTextArea();
				
	    scroll1 = new JScrollPane(ta2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(220, 40, 400, 160);
				
		lab7 = new JLabel("At Present:");
		lab7.setBounds(30, 200, 100, 50);
		lab7.setForeground(Color.BLUE);
				
		lab8 = new JLabel("Revenue:");
		lab8.setBounds(120, 210, 80, 50);
		lab8.setForeground(Color.BLUE);
				
		lab9 = new JLabel("Expenditure:");
		lab9.setBounds(120, 260, 80, 50);
		lab9.setForeground(Color.BLUE);
				
		lab10 = new JLabel("Deficit Amount:");
		lab10.setBounds(120, 310, 120, 50);
		lab10.setForeground(Color.BLUE);
				
		tf4 = new JTextField("");
		tf4.setBounds(220, 210, 200, 50);
		tf4.setFont(font);
		tf4.setHorizontalAlignment(JTextField.RIGHT);
				
		tf5 = new JTextField("");
		tf5.setBounds(220, 260, 200, 50);
		tf5.setFont(font);
		tf5.setHorizontalAlignment(JTextField.RIGHT);
				
		tf6 = new JTextField("");
		tf6.setBounds(220, 310, 200, 50);
		tf6.setFont(font);
		tf6.setHorizontalAlignment(JTextField.RIGHT);
		
		
				
		defPan.add(lab5);
		defPan.add(lab6);
		defPan.add(scroll1);
		defPan.add(lab7);
		defPan.add(lab8);
		defPan.add(tf4);
		defPan.add(lab9);
		defPan.add(tf5);
		defPan.add(lab10);
		defPan.add(tf6);
		
		revPan.add(imgLab2);
		expPan.add(imgLab3);
		surPan.add(imgLab4);
		defPan.add(imgLab5);
		
		
		imgLab = new JLabel(imgicon);
		imgLab.setBounds(0, 0, 900, 700);
		con.add(imgLab);
				
				
		logOutButton.addActionListener(this);
		EnterButton.addActionListener(this);
	    ClearButton.addActionListener(this);
		showBudget.addActionListener(this);
		showIncome.addActionListener(this);
		showTax.addActionListener(this);
		showLoan.addActionListener(this);
		sur_def.addActionListener(this);
		prev_info.addActionListener(this);
		resetbtn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		
	}
	
	public ArrayList <Revenue> revenueList(){
		ArrayList <Revenue> revenuesList= new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/data1";
		String user = "student";
		String password = "student";
		
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			String query1 = "SELECT * FROM revdata";
			Statement myStmt = myConn.createStatement();
			Resultset rs = (Resultset) myStmt.executeQuery(query1);
			Revenue revenue1 ;
			
			while(((ResultSet) rs).next()) {
				revenue1 = new Revenue( ((ResultSet) rs).getString("type"), ((ResultSet) rs).getString("item"), ((ResultSet) rs).getString("amount"), ((ResultSet) rs).getString("percentage") );
				revenuesList.add(revenue1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return revenuesList;
	}
	
	public void show_revenue() {
		ArrayList <Revenue> list = revenueList();
		DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
		Object [] row = new Object[5];	
		
		for (int i = 0; i < list.size(); i++) {
			
			row[0] = list.get(i).gettype();
			row[1] = list.get(i).getitem();
			row[2] = list.get(i).getamount();
			row[3] = list.get(i).getpercentage();
			
			model1.addRow(row);
			
		}
		
}
	
	public ArrayList <Expenditure> expenditureList(){
		ArrayList <Expenditure> expendituresList= new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/data1";
		String user = "student";
		String password = "student";
		
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			String query1 = "SELECT * FROM expdata";
			Statement myStmt = myConn.createStatement();
			Resultset rs = (Resultset) myStmt.executeQuery(query1);
			Expenditure expenditure1 ;
			
			while(((ResultSet) rs).next()) {
				expenditure1 = new Expenditure( ((ResultSet) rs).getString("type"), ((ResultSet) rs).getString("item"), ((ResultSet) rs).getString("amount"), ((ResultSet) rs).getString("percentage") );
				expendituresList.add(expenditure1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return expendituresList;
	}
	
	public void show_expenditure() {
		ArrayList <Expenditure> list = expenditureList();
		DefaultTableModel model1 = (DefaultTableModel) table2.getModel();
		Object [] row = new Object[5];	
		
		for (int i = 0; i < list.size(); i++) {
			
			row[0] = list.get(i).gettype();
			row[1] = list.get(i).getitem();
			row[2] = list.get(i).getamount();
			row[3] = list.get(i).getpercentage();
			
			model1.addRow(row);
			
		}
		
}		
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		 if(ae.getSource() == logOutButton)
		{
			dispose();
			SectionPage frame = new SectionPage();
			frame.setVisible(true);
			frame.setBounds(20, 50, 900, 650);
			frame.setTitle("Budget Analyzer");
		}
		 
		 else if(ae.getSource() == resetbtn) {
			 
			 int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to reset", "Reset Database", JOptionPane.YES_NO_OPTION);
			 
			 if (YesOrNo == 0) {
			 try {
				 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "student","student");
	
			     Statement stmt1 = conn.createStatement();
				 String sql1 = "delete from revdata";
				 stmt1.executeUpdate(sql1);
				 
				 Statement stmt2 = conn.createStatement();
				 String sql2 = "delete from expdata";
				 stmt2.executeUpdate(sql2);
				
				 
				 
				 JOptionPane.showMessageDialog(null, "Success");
			     
			 }catch(Exception exc) {
				 exc.printStackTrace();
			 } 
		 }	 
			 
		 }
		 
		 else if ((ae.getSource() == btn1))
		 {
			  DataHandle1 frame = new DataHandle1();
			 frame.setVisible(true);
			 frame.setBounds(100, 20, 800, 700);
			 frame.setTitle("Budget Analyzer/Revenues");
			 
		 }
		 
		 else if(ae.getSource() == btn2) {
			 
			 table1 = new JTable();
				
				model1 = new DefaultTableModel();
				model1.setColumnIdentifiers(cols);
				table1.setModel(model1);
				table1.setFont(font);
				table1.setSelectionBackground(Color.cyan);
				table1.setBackground(Color.white);
				table1.setRowHeight(30);
				
				scroll2 = new JScrollPane(table1);
				scroll2.setBounds(310, 80, 440, 300);
				revPan.add(scroll2);
				
					revenueList();
					show_revenue();
					
					double total = 0;
					for(int i = 0; i < table1.getRowCount(); i++) {
						int amount = Integer.parseInt((String) table1.getValueAt(i, 2));
						total  += amount;
					}
					
					lab14.setText(String.valueOf(total));
					
		 }
		 
		 else if(ae.getSource() == btn4) {
			 table2 = new JTable();
				
				model2 = new DefaultTableModel();
				model2.setColumnIdentifiers(cols);
				table2.setModel(model2);
				table2.setFont(font);
				table2.setSelectionBackground(Color.cyan);
				table2.setBackground(Color.white);
				table2.setRowHeight(30);
				
				scroll3 = new JScrollPane(table2);
				scroll3.setBounds(310, 80, 440, 300);
				expPan.add(scroll3);
				
					expenditureList();
					show_expenditure();
					
					double total1 = 0;
					for(int i = 0; i < table2.getRowCount(); i++) {
						int amount1 = Integer.parseInt((String) table2.getValueAt(i, 2));
						total1  += amount1;
					}
					
					lab16.setText(String.valueOf(total1));
				
		 }
		 
		 else if(ae.getSource() == sur_def) {
			 
			 	String revVal = lab14.getText();
				tf1.setText(revVal);
				tf4.setText(revVal);
				
				String expVal = lab16.getText();
				tf2.setText(expVal);
				tf5.setText(expVal);
				
				double r_val = Double.parseDouble((String) lab14.getText());
				double e_val = Double.parseDouble((String) lab16.getText());
				
				if(r_val > e_val) {
					
					double sur_val = (r_val - e_val);
					tf3.setText(String.valueOf(sur_val));
					tf6.setText("Surplus Time");
				}
				
				else if(r_val < e_val) {
					double def_val = (e_val - r_val);
					tf6.setText(String.valueOf(def_val));
					tf3.setText("Deficit Time");
				}
			 
		 }
		 
		 else if (ae.getSource() == prev_info) {
			 
			  
			 	String url = "jdbc:mysql://localhost:3306/data1";
				String user = "student";
				String password = "student";
				
				try {
					Connection myConn = DriverManager.getConnection(url, user, password);
					String sql1 = "SELECT * FROM budgetdata where comment = 'Surplus'";
					String sql2 = "SELECT * FROM budgetdata where comment = 'Deficit'";
					PreparedStatement myStmt1 = myConn.prepareStatement(sql1);
					Resultset rs1 = (Resultset) myStmt1.executeQuery();
					
					
					String yr = "year";
					String ac = "access";
					String rv = "revenue";
					String ex = "expenditure";
					String cm = "comment";
					
					if(((ResultSet) rs1).next()) {
						
						ta1.append(((ResultSet) rs1).getString("year")+"\t"+
						 ((ResultSet) rs1).getString("access")+"\t"+
						((ResultSet) rs1).getString("comment")+"\n");
						
				} else {
					JOptionPane.showMessageDialog(null, "Nothing to show");
				}
					
					PreparedStatement myStmt2 = myConn.prepareStatement(sql2);
					Resultset rs2 = (Resultset) myStmt2.executeQuery();
					
					if(((ResultSet) rs2).next()) {
						
						ta2.append(((ResultSet) rs2).getString("year")+"\t"+
						 ((ResultSet) rs2).getString("access")+"\t"+
						((ResultSet) rs2).getString("comment")+"\n");
						
				} else {
					JOptionPane.showMessageDialog(null, "Nothing to show");
				}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			 }
		  
		 
		 
		 else if ((ae.getSource() == btn3))
		 {
			  DataHandle2 frame = new DataHandle2();
			  frame.setVisible(true);
			  frame.setBounds(100, 20, 800, 700);
			  frame.setTitle("Budget Analyzer/Expenditures");
			 
		 }
		 
		 else if(ae.getSource() == showBudget) {
			 
			 BudgetInfo frame = new BudgetInfo();
			 frame.setVisible(true);
			 frame.setBounds(100, 80, 600, 480);
			 frame.setTitle("Budget Analyzer/Budget Info");
		 }
		 
		 else if(ae.getSource() == showIncome) {
			 
			 IncomeTaxInfo frame = new IncomeTaxInfo();
			 frame.setVisible(true);
			 frame.setBounds(100, 80, 700, 580);
			 frame.setTitle("Budget Analyzer/Income Tax Info");
		 }
		 
		 else if(ae.getSource() == showTax) {
			 
			 OtherTaxInfo frame = new OtherTaxInfo();
			 frame.setVisible(true);
			 frame.setBounds(100, 80, 700, 580);
			 frame.setTitle("Budget Analyzer/ Taxes Info");
		 }
		 
		 else if(ae.getSource() == showLoan) {
			 
			 LoanInfo frame = new LoanInfo();
			 frame.setVisible(true);
			 frame.setBounds(100, 80, 900, 580);
			 frame.setTitle("Budget Analyzer/Loan Info");
		 }
		 
		 else if (ae.getSource() == EnterButton)
		 {
			 String year = tf8.getText();
			 String amount = tf7.getText();
			 String revenue = lab14.getText();
			 String expenditure = lab16.getText();
			 
			 double r_val = Double.parseDouble((String) lab14.getText());
			 double e_val = Double.parseDouble((String) lab16.getText());
				
			 double a_val = Math.abs(r_val - e_val);
			 String access = String.valueOf(a_val) ;
			 
			 String comment = "Surplus";
			 
			 if(e_val > r_val) {
				 comment = "Deficit";
			 }
			 
			 try {
				 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "student","student");
			     String sql = "insert into budgetdata" + "(year, amount, revenue, expenditure, access, comment)" + "values(?, ?, ?, ?, ?, ?)";
			     PreparedStatement stmt= conn.prepareStatement(sql);
			     
			     stmt.setString(1, year);
				 stmt.setString(2, amount);
				 stmt.setString(3, revenue);
				 stmt.setString(4, expenditure);
				 stmt.setString(5, access);
				 stmt.setString(6, comment);
				 
				 stmt.executeUpdate();
				 
				 JOptionPane.showMessageDialog(null, "Success");
			     
			 }catch(Exception exc) {
				 exc.printStackTrace();
			 } 
			
			
		 }
		 
		 else if (ae.getSource() == ClearButton)
		 {
			 tf7.setText(" ");
			 tf8.setText(" ");
		 }
	}



	public static void main(String[] args) {
		MainMenu frame = new MainMenu();
		frame.setVisible(true); 

	}
	
}
