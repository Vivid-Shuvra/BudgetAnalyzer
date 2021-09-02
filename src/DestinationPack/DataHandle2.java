package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataHandle2 extends JFrame implements ActionListener{
	
	private Container con;
	private Font font, f;
	private JLabel lab1, lab2, lab3, lab4, lab5, lab6, bgLab;
	private JTextField tf1, tf2, tf3, tf4, tf5;
	private JButton addbtn, updatebtn, deletebtn, clearbtn, savebtn, passbtn; 
	private JScrollPane scroll;
	private Cursor cursor;
	private ImageIcon icon, imgicon;
	private JTable table;
	private DefaultTableModel model; 
	
	private String[] columns = { "Type", "Items", "Amount(in crore)", "Percentage" };
	private String[] rows = new String[4];
	
	DataHandle2()
	{
		con =  this.getContentPane();
		con.setLayout(null);
		
		imgicon = new ImageIcon(getClass().getResource("smbgimg.jpg"));
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		font = new Font("Arial", Font.BOLD, 20);
		f = new Font("Arial", Font.BOLD, 13);
		cursor = new Cursor(Cursor.HAND_CURSOR); 
		
		lab1 = new JLabel("Add Expenditure Information Here..");
		lab1.setBounds(50, 10, 350, 50);
		lab1.setForeground(Color.orange);
		lab1.setFont(font);  
		con.add(lab1);
		
		lab2 = new JLabel("Type:");
		lab2.setBounds(50, 50, 100, 50);
		lab2.setForeground(Color.white);
		lab2.setFont(f);
		con.add(lab2);
		
		lab5 = new JLabel("Item:");
		lab5.setBounds(50, 100, 100, 50);
		lab5.setForeground(Color.white);
		lab5.setFont(f);
		con.add(lab5);
		
		lab3 = new JLabel("Amount(in crore):");
		lab3.setBounds(50, 150, 120, 50);
		lab3.setForeground(Color.white);
		lab3.setFont(f);
		con.add(lab3);
		
		lab4 = new JLabel("Percentage:");
		lab4.setBounds(50, 200, 100, 50);
		lab4.setForeground(Color.white);
		lab4.setFont(f);
		con.add(lab4);
		
		
		tf1 = new JTextField("");
		tf1.setBounds(200, 50, 150, 40);
		con.add(tf1);
		
		tf2 = new JTextField("");
		tf2.setBounds(200, 100, 150, 40);
		con.add(tf2);
		
		tf3 = new JTextField("");
		tf3.setBounds(200, 150, 150, 40);
		tf3.setHorizontalAlignment(JTextField.RIGHT);
		con.add(tf3);
		
		tf4 = new JTextField("%");
		tf4.setBounds(200, 200, 150, 40);
		tf4.setHorizontalAlignment(JTextField.RIGHT);
		con.add(tf4);
		
		addbtn = new JButton("Add");
		addbtn.setBounds(450, 40, 100, 30);
		addbtn.setCursor(cursor);
		con.add(addbtn);
		
		updatebtn = new JButton("Update");
		updatebtn.setBounds(450, 80, 100, 30);
		updatebtn.setCursor(cursor);
		con.add(updatebtn);
		
		deletebtn = new JButton("Delete");
		deletebtn.setBounds(450, 120, 100, 30);
		deletebtn.setCursor(cursor);
		con.add(deletebtn);
		
		clearbtn = new JButton("Clear");
		clearbtn.setBounds(450, 160, 100, 30);
		clearbtn.setCursor(cursor);
		con.add(clearbtn);
		
		savebtn = new JButton("Save");
		savebtn.setBounds(450, 200, 100, 30);
		savebtn.setCursor(cursor);
		con.add(savebtn);
		
		table = new JTable();
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setFont(f);
		table.setSelectionBackground(Color.cyan);
		table.setBackground(Color.white);
		table.setRowHeight(30);
		
		scroll = new JScrollPane(table);
		scroll.setBounds(40, 260, 700, 380);
		con.add(scroll);
		
		bgLab = new JLabel(imgicon);
		bgLab.setBounds(0, 0, 800, 700);
		con.add(bgLab);
		
		addbtn.addActionListener(this);
		clearbtn.addActionListener(this);
		deletebtn.addActionListener(this);
		updatebtn.addActionListener(this);
		savebtn.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent me)
			{
				int number = table.getSelectedRow();
				
				String t_Name = model.getValueAt(number, 0).toString();
				String i_Name = model.getValueAt(number, 1).toString();
				String a_Number = model.getValueAt(number, 2).toString();
				String p_Number = model.getValueAt(number, 3).toString();
				
				tf1.setText(t_Name);
				tf2.setText(i_Name);
				tf3.setText(a_Number);
				tf4.setText(p_Number);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addbtn)
		{
			rows[0] = tf1.getText();
			rows[1] = tf2.getText();
			rows[2] = tf3.getText();
			rows[3] = tf4.getText();
			
			model.addRow(rows);

		}
		
		else if(e.getSource() == clearbtn)
		{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("%");
		}
		
		else if(e.getSource() == deletebtn)
		{
			int rowNumber = table.getSelectedRow();
			
			if(rowNumber >= 0)
			{
				model.removeRow(rowNumber);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Nothing Selected");
			}
		}
		
		else if(e.getSource() == updatebtn)
		{
			int rowNumber = table.getSelectedRow();
			
			if(rowNumber >= 0) 
			{
			String t_name = tf1.getText();
			String i_name = tf2.getText();
			String a_num = tf3.getText();
			String p_num = tf4.getText();
			
			model.setValueAt(t_name, rowNumber,0);
			model.setValueAt(i_name, rowNumber, 1);
			model.setValueAt(a_num, rowNumber, 2);
			model.setValueAt(p_num, rowNumber, 3);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Nothing Selected");
			}
			
		}
		
		else if(e.getSource() == savebtn)
		{
			int number = table.getSelectedRow();
			
			String t_Name = model.getValueAt(number, 0).toString();
			String i_Name = model.getValueAt(number, 1).toString();
			String a_Number = model.getValueAt(number, 2).toString();
			String p_Number = model.getValueAt(number, 3).toString();
			
			String type= t_Name;
			String item = i_Name;
			String amount = a_Number;
			String percentage = p_Number; 
			 
			 try {
				 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "student","student");
			     String sql = "insert into expdata" + "(type, item, amount, percentage)" + "values(?, ?, ?,?)";
			     PreparedStatement stmt= conn.prepareStatement(sql);
			     
			     stmt.setString(1, type);
			     stmt.setString(2, item);
			     stmt.setString(3, amount);
				 stmt.setString(4, percentage);
				 
				 stmt.executeUpdate();
				 
				 JOptionPane.showMessageDialog(null, "Success");
			     
			 }catch(Exception exc) {
				 exc.printStackTrace();
			 }
			
		}
	}

	public static void main(String[] args) {
		DataHandle2 frame = new DataHandle2();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 20, 800, 700);
		frame.setTitle("Budget Analyzer");

	}

}
