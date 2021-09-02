package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;


public class BudgetInfo extends JFrame {
	
	private JLabel lab,lab1, bgLab;
	private JButton btn;
	private Container con;
	private JTable table;
	private Font f,font;
	private ImageIcon icon,imgicon;
	private DefaultTableModel model; 
	private JScrollPane scroll;
	private Cursor cursor;
	
	private String[] cols = {"Year", "Amount(in crore)", "Revenue", "Expenditure", "Access", "Comment"};
	private String[] r = new String[6];
	
	BudgetInfo()
	{
		con = this.getContentPane();
		con.setLayout(null);

		imgicon = new ImageIcon(getClass().getResource("backimage.jpg"));
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		f = new Font("Arial", Font.BOLD, 13);
		font = new Font("Algerian", Font.BOLD, 20);
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		lab = new JLabel("Budget Information");
		lab.setBounds(180, 10, 300, 50);
		lab.setFont(font);
		con.add(lab);
		
		lab1 = new JLabel("Load Your Information: ");
		lab1.setBounds(80, 60, 200, 50);
		lab1.setFont(f);
		con.add(lab1);
		
		btn = new JButton("Load");
		btn.setBounds(300, 70, 100, 30);
		btn.setCursor(cursor);
		con.add(btn);
		
		
		table = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(cols);
		table.setModel(model);
		table.setFont(f);
		table.setSelectionBackground(Color.cyan);
		table.setBackground(Color.white);
		table.setRowHeight(30);
		
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 120, 540, 300);
		con.add(scroll);
		
		bgLab = new JLabel(imgicon);
		bgLab.setBounds(0, 0, 600, 480);
		con.add(bgLab);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				
					userList();
					show_user1();
			}
	
		});
	}

	public ArrayList <User> userList(){
		ArrayList <User> usersList= new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/data1";
		String user = "student";
		String password = "student";
		
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			String query1 = "SELECT * FROM budgetdata";
			Statement myStmt = myConn.createStatement();
			Resultset rs = (Resultset) myStmt.executeQuery(query1);
			User user1;
			
			while(((ResultSet) rs).next()) {
				user1 = new User ( ((ResultSet) rs).getString("year"),((ResultSet) rs).getString("amount"), ((ResultSet) rs).getString("revenue"), ((ResultSet) rs).getString("expenditure")
						,((ResultSet) rs).getString("access"), ((ResultSet) rs).getString("comment"));
				usersList.add(user1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return usersList;
	}
	
	public void show_user1() {
		ArrayList <User> list = userList();
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		Object [] row = new Object[7];	
		
		for (int i = 0; i < list.size(); i++) {
			
			row[0] = list.get(i).getyear();
			row[1] = list.get(i).getamount();
			row[2] = list.get(i).getrevenue();
			row[3] = list.get(i).getexpenditure();
			row[4] = list.get(i).getaccess();
			row[5] = list.get(i).getcomment();
			
			
			model.addRow(row);
		}
	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudgetInfo frame = new BudgetInfo();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setBounds(100, 80, 600, 480);
					frame.setTitle("Budget Analyzer");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
