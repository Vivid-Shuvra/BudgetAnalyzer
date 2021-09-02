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

public class OtherTaxInfo extends JFrame implements ActionListener{

	private JLabel lab,lab1, lab2,lab3,lab4,lab5, bgLab;
	private JButton btn, btn2;
	private Container con;
	private JTable table;
	private Font f,font;
	private ImageIcon icon,imgicon;
	private DefaultTableModel model; 
	private JScrollPane scroll;
	private Cursor cursor;
	private JTextField tf;
	
	private String[] r = new String[14];
	private String[] cols = {"Tax Type","Name", "Guardian", "Name Of Guardian", "Age", "Occupation", "Gender", "Tax Reg No", "Tax Zone", "Contact No", "Amount", "Address", "Date"};
	
	OtherTaxInfo()
	{
		con = this.getContentPane();
		con.setLayout(null);

		imgicon = new ImageIcon(getClass().getResource("backgroundimg.jpg"));
		
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		f = new Font("Arial", Font.BOLD, 13);
		font = new Font("Algerian", Font.BOLD, 20);
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		lab = new JLabel("Taxes Information");
		lab.setBounds(180, 10, 320, 50);
		lab.setFont(font);
		con.add(lab);
		
		lab1 = new JLabel("Load Your Information: ");
		lab1.setBounds(30, 60, 200, 50);
		lab1.setFont(f);
		con.add(lab1);
		
		btn = new JButton("Load");
		btn.setBounds(210, 70, 100, 30);
		btn.setCursor(cursor);
		con.add(btn);
		
		btn2 = new JButton("Go to");
		btn2.setBounds(330, 70, 100, 30);
		btn2.setCursor(cursor);
		con.add(btn2);
		
		
		table = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(cols);
		table.setModel(model);
		table.setFont(f);
		table.setSelectionBackground(Color.cyan);
		table.setBackground(Color.white);
		table.setRowHeight(30);
		
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 120, 660, 370);
		con.add(scroll);
		
		lab3 = new JLabel("search");
		lab3.setBounds(620, 70, 50, 30);
		con.add(lab3);
		
		lab4 = new JLabel("Total tax amounts:");
		lab4.setBounds(50, 500, 120, 40);
		lab4.setForeground(Color.blue);
		con.add(lab4);
		
		lab5 = new JLabel(" ");
		lab5.setBounds(200, 500, 300, 40);
		lab5.setForeground(Color.blue);
		con.add(lab5);
		
		tf = new JTextField();
		tf.setBounds(460, 70, 150, 30);
		con.add(tf);
		
		bgLab = new JLabel(imgicon);
		bgLab.setBounds(0, 0, 700, 580);
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
	
		btn.addActionListener(this); 
		btn2.addActionListener(this);
	}
		@Override
		public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource() == btn) {
					taxList();
					show_tax();
					
					double total = 0;
					for(int i = 0; i < table.getRowCount(); i++) {
						int amount = Integer.parseInt((String) table.getValueAt(i, 10));
						total  += amount;
					}
					
					lab5.setText(String.valueOf(total));
				}
				
				else if(ae.getSource() == btn2) {
					SearchTaxes frame = new SearchTaxes();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setBounds(400, 100, 550, 450);
					frame.setTitle("Budget Analyzer/Taxes Info");
				}
			
		
	}
	
	public ArrayList <tax> taxList(){
		ArrayList <tax> taxesList= new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/data1";
		String user = "student";
		String password = "student";
		
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			String query1 = "SELECT * FROM taxdata";
			Statement myStmt = myConn.createStatement();
			Resultset rs = (Resultset) myStmt.executeQuery(query1);
			tax tax1 ;
			
			while(((ResultSet) rs).next()) {
				tax1 = new tax( ((ResultSet) rs).getString("type"), ((ResultSet) rs).getString("name"), ((ResultSet) rs).getString("father_husband"), ((ResultSet) rs).getString("husband_name"), ((ResultSet) rs).getString("age"),
						((ResultSet) rs).getString("occupation"), ((ResultSet) rs).getString("gender"), ((ResultSet) rs).getString("reg_no"), ((ResultSet) rs).getString("zone"),
						((ResultSet) rs).getString("contact_no"), ((ResultSet) rs).getString("amount"),((ResultSet) rs).getString("address"), ((ResultSet) rs).getString("date"));
				taxesList.add(tax1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return taxesList;
	}
	
	public void show_tax() {
		ArrayList <tax> list = taxList();
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		Object [] row = new Object[14];	
		
		for (int i = 0; i < list.size(); i++) {
			
			row[0] = list.get(i).gettype();
			row[1] = list.get(i).getname();
			row[2] = list.get(i).getfather_husband();
			row[3] = list.get(i).getfather_name();
			row[4] = list.get(i).getage();
			row[5] = list.get(i).getoccupation();
			row[6] = list.get(i).getgender();
			row[7] = list.get(i).getreg_no();
			row[8] = list.get(i).getzone();
			row[9] = list.get(i).getcontact_no();
			row[10] = list.get(i).getamount();
			row[11] = list.get(i).getaddress();
			row[12] = list.get(i).getdate();
			
			
			model.addRow(row);
			}
			
		}	
		
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherTaxInfo frame = new OtherTaxInfo ();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setBounds(100, 80, 700, 580);
					frame.setTitle("Budget Analyzer/Taxes Information");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

}
