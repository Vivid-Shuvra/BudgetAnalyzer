package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.protocol.Resultset;

public class LoanInfo extends JFrame{
	
	private JLabel lab,lab1, lab2,lab3, lab4, lab5, bgLab;
	private JButton btn;
	private Container con;
	private JTable table;
	private Font f,font;
	private ImageIcon icon, imgicon;
	private DefaultTableModel model; 
	private JScrollPane scroll;
	private Cursor cursor;
	private JTextField tf;

	private String[] r = new String[11];
	private String[] cols = {"Loan Type","Institute Name", "Institute Description ", "Country Name", "Purpose", "Contact No", "Amount", "Deadline", "Comment", "Date"};
	
	LoanInfo()
	{
		con = this.getContentPane();
		con.setLayout(null);

		imgicon = new ImageIcon(getClass().getResource("backgroundimg.jpg"));
		
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		f = new Font("Arial", Font.BOLD, 13);
		font = new Font("Algerian", Font.BOLD, 20);
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		lab = new JLabel("Loan/debt Information");
		lab.setBounds(350, 10, 320, 50);
		lab.setFont(font);
		con.add(lab);
		
		lab1 = new JLabel("Load Your Information: ");
		lab1.setBounds(50, 60, 200, 50);
		lab1.setFont(f);
		con.add(lab1);
		
		btn = new JButton("Load");
		btn.setBounds(230, 70, 100, 30);
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
		scroll.setBounds(20, 120, 860, 370);
		con.add(scroll);
		
		lab3 = new JLabel("search");
		lab3.setBounds(730, 70, 50, 30);
		con.add(lab3);
		
		lab4 = new JLabel("Total loan/debts:");
		lab4.setBounds(50, 500, 100, 40);
		lab4.setForeground(Color.blue);
		con.add(lab4);
		
		lab5 = new JLabel(" ");
		lab5.setBounds(200, 500, 300, 40);
		lab5.setForeground(Color.blue);
		con.add(lab5);
		
		tf = new JTextField();
		tf.setBounds(550, 70, 150, 30);
		con.add(tf);
		
		bgLab = new JLabel(imgicon);
		bgLab.setBounds(0, 0, 900, 580);
		con.add(bgLab);
		
		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				
				DefaultTableModel tab = (DefaultTableModel)table.getModel();
				String search = tf.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tab);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
		});
	
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				
					loanList();
					show_loan();
					
					double total = 0;
					for(int i = 0; i < table.getRowCount(); i++) {
						int amount = Integer.parseInt((String) table.getValueAt(i, 6));
						total  += amount;
					}
					
					lab5.setText(String.valueOf(total));
				}
			
		});
	}
	
	public ArrayList <Loan> loanList(){
		ArrayList <Loan> loansList= new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/data1";
		String user = "student";
		String password = "student";
		
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			String query1 = "SELECT * FROM loandata";
			Statement myStmt = myConn.createStatement();
			Resultset rs = (Resultset) myStmt.executeQuery(query1);
			Loan loan1 ;
			
			while(((ResultSet) rs).next()) {
				loan1 = new Loan ( ((ResultSet) rs).getString("type"), ((ResultSet) rs).getString("company_name"), ((ResultSet) rs).getString("company_des"),       
						((ResultSet) rs).getString("country_name"), ((ResultSet) rs).getString("purpose"), ((ResultSet) rs).getString("amount"), ((ResultSet) rs).getString("deadline"),
						((ResultSet) rs).getString("contact_no"),((ResultSet) rs).getString("comment"), ((ResultSet) rs).getString("date"));
				loansList.add(loan1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return loansList;
	}
	
	public void show_loan() {
		ArrayList <Loan> list = loanList();
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		Object [] row = new Object[11];	
		
		for (int i = 0; i < list.size(); i++) {
			
			row[0] = list.get(i).gettype();
			row[1] = list.get(i).getcompany_name();
			row[2] = list.get(i).getcompany_des();
			row[3] = list.get(i).getcountry_name();
			row[4] = list.get(i).getpurpose();
			row[5] = list.get(i).getamount();
			row[6] = list.get(i).getdeadline();
			row[7] = list.get(i).getcontact_no();
			row[8] = list.get(i).getcomment();
			row[9] = list.get(i).getdate();
			
			model.addRow(row);
			
		}
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanInfo frame = new LoanInfo ();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setBounds(100, 80, 900, 580);
					frame.setTitle("Budget Analyzer/Loan Information");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
