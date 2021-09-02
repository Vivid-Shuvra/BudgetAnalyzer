package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class SearchIncome extends JFrame {

	private JLabel [] lab = new JLabel[19];
	private JTextField [] tf = new JTextField[15];
	private JLabel bgLab;
	private Font f;
	private JTextArea ta;
	private Container con;
	private ImageIcon icon, imgicon;
	private Cursor cursor;
	private JButton btn;
	
	SearchIncome()
	{
		con =  this.getContentPane();
		con.setLayout(null);

		imgicon = new ImageIcon(getClass().getResource("backimage.jpg"));
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		f = new Font("Arial", Font.BOLD, 17);
		cursor = new Cursor(Cursor.HAND_CURSOR); 
		
		btn = new JButton("search");
		btn.setBounds(390, 100, 80, 30);
		con.add(btn);
		
		lab[0] = new JLabel("Here your information...");
		lab[0].setBounds(180, 50, 250, 40);
		lab[0].setFont(f);
		lab[0].setForeground(Color.BLUE);
		lab[1] = new JLabel("Enter Tax Reg.No:");
		lab[1].setBounds(50, 100, 150, 30);
		lab[2] = new JLabel("Name:");
		lab[2].setBounds(50, 160, 50, 30);
		lab[3] = new JLabel("Age:");
		lab[3].setBounds(50, 200, 50, 30);
		lab[4] = new JLabel("Occupation:");
		lab[4].setBounds(180, 200, 100, 30);
		lab[5] = new JLabel("Zone:");
		lab[5].setBounds(50, 240, 50, 30);
		lab[6] = new JLabel("Contact No:");
		lab[6].setBounds(50, 280, 100, 30);
		lab[7] = new JLabel("Date:");
		lab[7].setBounds(280, 240, 50, 30);
		lab[8] = new JLabel("Income Tax");
		lab[8].setBounds(210, 10, 100, 40);
		lab[8].setFont(f);
		lab[8].setForeground(Color.BLUE);
		lab[9] = new JLabel("Amount:");
		lab[9].setBounds(50, 320, 50, 30);
		
		for(int i = 0; i < 10; i++) {
			
			con.add(lab[i]);
		}
		
		tf[0] = new JTextField();
		tf[0].setBounds(180, 100, 200, 30);
		tf[1] = new JTextField();
		tf[1].setBounds(100, 160, 230, 30);
		tf[2] = new JTextField();
		tf[2].setBounds(100, 200, 50, 30);
		tf[3] = new JTextField();
		tf[3].setBounds(280, 200, 150, 30);
		tf[4] = new JTextField();
		tf[4].setBounds(100, 240, 150, 30);
		tf[5] = new JTextField();
		tf[5].setBounds(130, 280, 150, 30);
		tf[6] = new JTextField();
		tf[6].setBounds(330, 240, 100, 30);
		tf[7] = new JTextField();
		tf[7].setBounds(120, 320, 150, 30);
		
		for(int i = 0; i < 8; i++) {
			
			con.add(tf[i]);
		}
		
		bgLab = new JLabel(imgicon);
		bgLab.setBounds(0, 0, 500, 400);
		con.add(bgLab);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				
				Function f = new Function();
				ResultSet rs = null;
				
					String reg = "reg_no";
					String name = "name";
					String age = "age";
					String occ = "occupation";
					String z = "zone";
					String con = "contact_no";
					String date = "date";
					String amount = "amount";
			
					
			
					rs = f.find(tf[0].getText());
					
					try {
						if(rs.next()) {
							tf[1].setText(((ResultSet) rs).getString("name"));
							tf[2].setText(((ResultSet) rs).getString("age"));
							tf[3].setText(((ResultSet) rs).getString("occupation"));
							tf[4].setText(((ResultSet) rs).getString("zone"));
							tf[5].setText(((ResultSet) rs).getString("contact_no"));
							tf[6].setText(((ResultSet) rs).getString("date"));
							tf[7].setText(((ResultSet) rs).getString("amount"));
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Nothing Found");
					}
				
			}
				catch(Exception e) {
					e.printStackTrace();
				}
		
			}
	
		});
	 	
			
	}
	
	public class Function{
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:mysql://localhost:3306/data1";
		String user = "student";
		String password = "student";
		
		public ResultSet find(String s) {
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement("select * from mydata where reg_no = ?");
				ps.setString(1, s);
				rs = ps.executeQuery();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return rs;
		}
		
	}
		
		
	public static void main(String[] args) {
		
		SearchIncome frame = new SearchIncome();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(400, 100, 500, 400);
		frame.setTitle("Budget Analyzer/Income Tax Info");
	}

}
