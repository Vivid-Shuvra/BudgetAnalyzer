package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class userSection1 extends JFrame implements ActionListener{

	private Container con;
	private JLabel [] lab = new JLabel[35];
	private JTextField [] tf = new JTextField[25];
	private JTextArea ta, ta1, ta2, ta3, ta4;
	private Font f;
	private JLabel bglab;
	private Cursor cursor;
	private JButton btn, btn1, btn2;
	private JRadioButton male, female, male1, female1;
	private JComboBox cbox, cbox1, cbox2, cbox3;
	private JCheckBox checkbox, checkbox1, checkbox2, checkbox3;
	private JTabbedPane newPane;
	private SimpleDateFormat sdf1, sdf2, sdf3;
	private Date date1, date2, date3;
	private JMenuBar menubar;
	private ImageIcon saveIcon, newIcon, searchIcon, icon, bgicon;
	private JMenu incometax, othertax, loanpart, help ;
	private JMenuItem newItem, newItem1, newItem2, openItem, openItem1, openItem2, saveItem, saveItem1, saveItem2, exitItem, searchResult, aboutMe;
	
	private String [] options = {"Dhaka South", "Dhaka North", "Chattogram", "Rajshahi", "Khulna", "Barishal", "Rangpore", "Sylhet", "Mymensingh"};
	private String [] options1 = {"Custom duty", "Suppl' tax", "Import duty", "Export duty", "Excise duty", "Narcotics & Liquore duty", "Vehicle tax", "Land development", "Non judicial"};
	private String [] options2 = {"Foreign Loan", "Internal Debts"};
	
	userSection1()
	{
		con =  this.getContentPane();
		con.setLayout(null);
		
		bgicon = new ImageIcon(getClass().getResource("backgroundimg.jpg"));
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		f = new Font("Arial", Font.BOLD, 17);
		cursor = new Cursor(Cursor.HAND_CURSOR); 
		
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		menubar.setBackground(Color.cyan);
		
		incometax = new JMenu("Income Tax");
		othertax = new JMenu("Other Taxes");
		loanpart = new JMenu("Loan Particiapation");
		help = new JMenu("Help");
		
		menubar.add(incometax);
		menubar.add(othertax);
		menubar.add(loanpart);
		menubar.add(help);
		
		saveIcon = new ImageIcon("src/image/save.png");
		newIcon = new ImageIcon("src/image/new.png");
		searchIcon = new ImageIcon("src/image/search.png");
		
		newItem = new JMenuItem("New");
		newItem.setIcon(newIcon);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		newItem1 = new JMenuItem("New");
		newItem1.setIcon(newIcon);
		newItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		newItem2 = new JMenuItem("New");
		newItem2.setIcon(newIcon);
		newItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		openItem = new JMenuItem("Open File...");
		openItem1 = new JMenuItem("Open File...");
		openItem2 = new JMenuItem("Open File...");
		
		saveItem = new JMenuItem("Save");
		saveItem.setIcon(saveIcon);
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		saveItem1 = new JMenuItem("Save");
		saveItem1.setIcon(saveIcon);
		saveItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		saveItem2 = new JMenuItem("Save");
		saveItem2.setIcon(saveIcon);
		saveItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		exitItem = new JMenuItem("Exit");
		
		searchResult = new JMenuItem("Search here...");
		searchResult.setIcon(searchIcon);
		
		aboutMe = new JMenuItem("About...");
		
		incometax.add(newItem);
		incometax.add(openItem);
		incometax.add(saveItem);
		
		othertax.add(newItem1);
		othertax.add(openItem1);
		othertax.add(saveItem1);
		
		loanpart.add(newItem2);
		loanpart.add(openItem2);
		loanpart.add(saveItem2);
		
		help.add(searchResult);
		help.add(aboutMe);
		help.add(exitItem);
		
	    newPane = new JTabbedPane();
		newPane.setBounds(20, 20, 850, 600);
		con.add(newPane);
		
		bglab = new JLabel(bgicon);
		bglab.setBounds(0, 0, 900, 700);
		con.add(bglab);
	
		newItem.addActionListener(this);
		newItem1.addActionListener(this);
		newItem2.addActionListener(this);
		exitItem.addActionListener(this);
		aboutMe.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if((ae.getSource() == newItem))
		{
			JPanel newPanel = new JPanel();
			newPanel.setLayout(null);
			newPanel.setBackground(Color.LIGHT_GRAY);
			
			lab[0] = new JLabel("Income Tax Form");
			lab[0].setBounds(350, 20, 150, 40);
			lab[0].setFont(f);
			lab[1] = new JLabel("Name of Assessee  :");
			lab[1].setBounds(20, 90, 300, 20);
			lab[2] = new JLabel("Name of  :");
			lab[2].setBounds(20, 130, 150, 20);
			lab[3] = new JLabel("Age :");
			lab[3].setBounds(20, 170, 300, 20);
			lab[4] = new JLabel("Occupation  :");
			lab[4].setBounds(20, 210, 300, 20);
			lab[5] = new JLabel("Gender  :");
			lab[5].setBounds(20, 250, 300, 20);
			lab[6] = new JLabel("Tax Registration No.  :");
			lab[6].setBounds(20, 290, 300, 20);
			lab[7] = new JLabel("Tax Zone  :");
			lab[7].setBounds(20, 340, 300, 20);
			lab[8] = new JLabel("Contact No.  :");
			lab[8].setBounds(20, 390, 300, 20);
			lab[9] = new JLabel("Amount :");
			lab[9].setBounds(20, 440, 300, 20);
			lab[10] = new JLabel("Address :");
			lab[10].setBounds(20, 480, 150, 20);
			lab[32] = new JLabel("Date :");
			lab[32].setBounds(480, 170, 150, 20);
			newPanel.add(lab[32]);
			
			for(int i = 0; i < 11; i++)
			{
				newPanel.add(lab[i]);
			}
			
			
			tf[0] = new JTextField();
			tf[0].setBounds(400, 90, 400, 40);
			tf[1] = new JTextField();
			tf[1].setBounds(400, 130, 400, 40);
			tf[2] = new JTextField();
			tf[2].setBounds(400, 170, 50, 30);
			tf[3] = new JTextField();
			tf[3].setBounds(400, 210, 300, 30);
			tf[4] = new JTextField();
			tf[4].setBounds(400, 290, 400, 30);
			tf[5] = new JTextField();
			tf[5].setBounds(400, 390, 300, 30);
			tf[6] = new JTextField();
			tf[6].setBounds(400, 440, 200, 30);
			tf[6].setHorizontalAlignment(JTextField.RIGHT);
			tf[20] = new JTextField();
			tf[20].setBounds(600, 170, 200, 30);
			newPanel.add(tf[20]);
			
			for(int i = 0; i < 7; i++)
			{
				newPanel.add(tf[i]);
			}
			
			sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			date1 = new Date();
			tf[20].setText(sdf1.format(date1));
			
			male = new JRadioButton("Male");
			male.setBounds(400, 250, 100, 20);
			newPanel.add(male);
			
			female = new JRadioButton("Female");
			female.setBounds(520, 250, 100, 20);
			newPanel.add(female);
			
			cbox = new JComboBox(options);
			cbox.setBounds(400, 340, 150, 40);
			cbox.setForeground(Color.blue);
			cbox.setEditable(true);
			newPanel.add(cbox);
			
			checkbox = new JCheckBox("Father");
			checkbox.setBounds(150, 130, 80, 20);
			newPanel.add(checkbox);
			
			checkbox1 = new JCheckBox("Husband");
			checkbox1.setBounds(240, 130, 80, 20);
			newPanel.add(checkbox1);
			
			ta = new JTextArea();
			ta.setBounds(400, 480, 400, 90);
			newPanel.add(ta);
			
			btn = new JButton("submit");
			btn.setBounds(20, 530, 100, 30);
			btn.setCursor(cursor);
			newPanel.add(btn);
			
			btn.addActionListener(new ActionListener () {

				@Override
				public void actionPerformed(ActionEvent ae) {
					String t1 = tf[0].getText();
					String t2 = tf[1].getText();
					String t3 = tf[2].getText();
					String t4 = tf[3].getText();
					String t5 = tf[4].getText();
					String t6 = tf[5].getText();
					String t7 = tf[6].getText();
					String t8 = tf[20].getText();
					String gen = "Father";
					
					if(checkbox1.isSelected()) {
						 gen = "Husband"; 
					}
					
					String opt = (String) cbox.getSelectedItem();
					String gen1 = "Male";
					
					if(female.isSelected()) {
						gen1 = "Female";
					}
					
					String info = ta.getText();
					
					try {
				
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "student","student");
					String sql = "insert into mydata"+ "(name, father_or_husband, father_name, age, occupation, gender, reg_no, zone, contact_no, amount, address, date)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)" ;
					PreparedStatement stmt= conn.prepareStatement(sql);
					
					stmt.setString(1, t1);
					stmt.setString(2, gen);
					stmt.setString(3, t2);
					stmt.setString(4, t3);
					stmt.setString(5, t4);
					stmt.setString(6, gen1);
					stmt.setString(7, t5);
					stmt.setString(8, opt);
					stmt.setString(9, t6);
					stmt.setString(10, t7);
					stmt.setString(11, info);
					stmt.setString(12, t8);
					
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Success");
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			});
			
			newPane.addTab("New File", newPanel);
		}
		
		if((ae.getSource() == newItem1))
		{
			JPanel newPanel1 = new JPanel();
			newPanel1.setLayout(null);
			newPanel1.setBackground(Color.LIGHT_GRAY);
			
			lab[11] = new JLabel("Tax Form");
			lab[11].setBounds(350, 20, 150, 40);
			lab[11].setFont(f);
			lab[12] = new JLabel("Name of Assessee  :");
			lab[12].setBounds(20, 130, 150, 20);
			lab[13] = new JLabel("Name of  :");
			lab[13].setBounds(20, 170, 300, 20);
			lab[14] = new JLabel("Age :");
			lab[14].setBounds(20, 210, 300, 20);
			lab[15] = new JLabel("Occupation  :");
			lab[15].setBounds(20, 250, 300, 20);
			lab[16] = new JLabel("Gender  :");
			lab[16].setBounds(20, 290, 300, 20);
			lab[17] = new JLabel("Tax Registration No.  :");
			lab[17].setBounds(20, 320, 300, 20);
			lab[18] = new JLabel("Tax Zone  :");
			lab[18].setBounds(20, 360, 300, 20);
			lab[19] = new JLabel("Contact No.  :");
			lab[19].setBounds(20, 410, 300, 20);
			lab[20] = new JLabel("Amount :");
			lab[20].setBounds(20, 450, 300, 20);
			lab[21] = new JLabel("Which tax:");
			lab[21].setBounds(20, 90, 300, 20 );
			lab[22] = new JLabel("Address :");
			lab[22].setBounds(20, 490, 300, 20);
			lab[33] = new JLabel("Date :");
			lab[33].setBounds(480, 210, 150, 20);
			newPanel1.add(lab[33]);
			
			for(int i = 11; i < 23; i++)
			{
				newPanel1.add(lab[i]);
			}
			

			tf[7] = new JTextField();
			tf[7].setBounds(400, 130, 400, 40);
			tf[8] = new JTextField();
			tf[8].setBounds(400, 170, 400, 40);
			tf[9] = new JTextField();
			tf[9].setBounds(400, 210, 50, 30);
			tf[10] = new JTextField();
			tf[10].setBounds(400, 250, 300, 30);
			tf[11] = new JTextField();
			tf[11].setBounds(400, 320, 400, 30);
			tf[12] = new JTextField();
			tf[12].setBounds(400, 410, 300, 30);
			tf[13] = new JTextField();
			tf[13].setBounds(400, 450, 200, 30);
			tf[13].setHorizontalAlignment(JTextField.RIGHT);
			tf[21] = new JTextField();
			tf[21].setBounds(600, 210, 200, 30);
			newPanel1.add(tf[21]);
			
			for(int i = 7; i < 14; i++)
			{
				newPanel1.add(tf[i]);
			}
			
			sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			date2 = new Date();
			tf[21].setText(sdf2.format(date2));
			
			cbox1 = new JComboBox(options1);
			cbox1.setBounds(400, 90, 150, 40);
			cbox1.setForeground(Color.blue);
			cbox1.setEditable(true);
			newPanel1.add(cbox1);
			
			male1 = new JRadioButton("Male");
			male1.setBounds(400, 290, 100, 20);
			newPanel1.add(male1);
			
			female1 = new JRadioButton("Female");
			female1.setBounds(520, 290, 100, 20);
			newPanel1.add(female1);
			
			cbox2 = new JComboBox(options);
			cbox2.setBounds(400, 360, 150, 40);
			cbox2.setForeground(Color.blue);
			cbox2.setEditable(true);
			newPanel1.add(cbox2);
			
			checkbox2 = new JCheckBox("Father");
			checkbox2.setBounds(150, 170, 80, 20);
			newPanel1.add(checkbox2);
			
			checkbox3 = new JCheckBox("Husband");
			checkbox3.setBounds(240, 170, 80, 20);
			newPanel1.add(checkbox3);
			
			btn1 = new JButton("submit");
			btn1.setBounds(20, 540, 100, 30);
			btn1.setCursor(cursor);
			newPanel1.add(btn1);
			
			ta1 = new JTextArea();
			ta1.setBounds(400, 490, 400, 80);
			newPanel1.add(ta1);
			
			btn1.addActionListener(new ActionListener () {

				@Override
				public void actionPerformed(ActionEvent ae) {
					String t1 = tf[7].getText();
					String t2 = tf[8].getText();
					String t3 = tf[9].getText();
					String t4 = tf[10].getText();
					String t5 = tf[11].getText();
					String t6 = tf[12].getText();
					String t7 = tf[13].getText();
					String t8 = tf[21].getText();
					String gen2 = "Father";
					
					if(checkbox3.isSelected()) {
						 gen2 = "Husband"; 
					}
					
					String opt1 = (String) cbox1.getSelectedItem(); 
					
					String opt2 = (String) cbox2.getSelectedItem();
					String gen3 = "Male";
					
					if(female1.isSelected()) {
						gen3 = "Female";
					}
					
					String info1 = ta1.getText();
					
					try {
				
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "student","student");
					String sql = "insert into taxdata"+ "(type, name, father_husband, husband_name, age, occupation, gender, reg_no, zone, contact_no, amount, address, date)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
					PreparedStatement stmt= conn.prepareStatement(sql);
					
					stmt.setString(1, opt1);
					stmt.setString(2, t1);
					stmt.setString(3, gen2);
					stmt.setString(4, t2);
					stmt.setString(5, t3);
					stmt.setString(6, t4);
					stmt.setString(7, gen3);
					stmt.setString(8, t5);
					stmt.setString(9, opt2);
					stmt.setString(10, t6);
					stmt.setString(11, t7);
					stmt.setString(12, info1);
					stmt.setString(13, t8);
					
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Success");
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			});
			
			
			newPane.addTab("New File", newPanel1);
		}
		
		if((ae.getSource() == newItem2))
		{
			JPanel newPanel2 = new JPanel();
			newPanel2.setLayout(null);
			newPanel2.setBackground(Color.LIGHT_GRAY);
			
			lab[22] = new JLabel("Loan Participation Form");
			lab[22].setBounds(350, 20, 200, 40);
			lab[22].setFont(f);
			lab[23] = new JLabel("Company/Bank Name  :");
			lab[23].setBounds(20, 140, 250, 20);
			lab[24] = new JLabel("Company/Bank Description  :");
			lab[24].setBounds(20, 180, 300, 20);
			lab[25] = new JLabel("Country Name :");
			lab[25].setBounds(20, 260, 300, 20);
			lab[26] = new JLabel("Which Purpose:");
			lab[26].setBounds(20, 300, 300, 20);
			lab[27] = new JLabel("Amount  :");
			lab[27].setBounds(20, 340, 300, 20);
			lab[28] = new JLabel("Deadlines/Timeouts  :");
			lab[28].setBounds(20, 380, 300, 20);
			lab[29] = new JLabel("Contact No. :");
			lab[29].setBounds(20, 430, 300, 20);
			lab[30] = new JLabel("Comment(If any):");
			lab[30].setBounds(20, 470, 300, 20);
			lab[31] = new JLabel("Type of Loan:");
			lab[31].setBounds(20, 90, 300, 20 );
			lab[34] = new JLabel("Date :");
			lab[34].setBounds(580, 90, 100, 20);
			newPanel2.add(lab[34]);
			
			for(int i = 22; i < 32; i++)
			{
				newPanel2.add(lab[i]);
			}
			
			cbox3 = new JComboBox(options2);
			cbox3.setBounds(400, 90, 150, 40);
			cbox3.setForeground(Color.blue);
			cbox3.setEditable(true);
			newPanel2.add(cbox3);
			
			tf[14] = new JTextField();
			tf[14].setBounds(400, 140, 300, 30);
			tf[15] = new JTextField();
			tf[15].setBounds(400, 260, 300, 30);
			tf[16] = new JTextField();
			tf[16].setBounds(400, 300, 400, 30);
			tf[17] = new JTextField();
			tf[17].setBounds(400, 380, 300, 30);
			tf[18] = new JTextField();
			tf[18].setBounds(400, 340, 200, 30);
			tf[18].setHorizontalAlignment(JTextField.RIGHT);
			tf[19] = new JTextField();
			tf[19].setBounds(400, 430, 300, 30);
			tf[22] = new JTextField();
			tf[22].setBounds(630, 90, 170, 30);
			newPanel2.add(tf[22]);
			
			for(int i = 14; i < 20; i++)
			{
				newPanel2.add(tf[i]);
			}
			
			sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			date3 = new Date();
			tf[22].setText(sdf3.format(date3));
			
			ta2 = new JTextArea();
			ta2.setBounds(400, 180, 400, 60);
			newPanel2.add(ta2);
			
			ta3 = new JTextArea();
			ta3.setBounds(400, 470, 400, 70);
			newPanel2.add(ta3);
			
			btn2 = new JButton("submit");
			btn2.setBounds(20, 530, 100, 30);
			btn2.setCursor(cursor);
			newPanel2.add(btn2);
			
			btn2.addActionListener(new ActionListener () {

				@Override
				public void actionPerformed(ActionEvent ae) {
					String t1 = tf[14].getText();
					String t2 = tf[15].getText();
					String t3 = tf[16].getText();
					String t4 = tf[18].getText();
					String t5 = tf[17].getText();
					String t6 = tf[19].getText();
					String t7 = tf[22].getText();
					
					String opt1 = (String) cbox3.getSelectedItem(); 
					
					String info1 = ta2.getText();
					String info2 = ta3.getText();
					
					try {
				
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "student","student");
					String sql = "insert into loandata"+ "(type, company_name, company_des, country_name, purpose, amount, deadline, contact_no, comment, date)" + "values(?,?,?,?,?,?,?,?,?,?)" ;
					PreparedStatement stmt= conn.prepareStatement(sql);
					
					stmt.setString(1, opt1);
					stmt.setString(2, t1);
					stmt.setString(3, info1);
					stmt.setString(4, t2);
					stmt.setString(5, t3);
					stmt.setString(6, t4);
					stmt.setString(7, t5);
					stmt.setString(8, t6);
					stmt.setString(9, info2);
					stmt.setString(10, t7);
					
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Success");
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
			});
			
			
			newPane.addTab("New File", newPanel2);
		}
		
		else if(ae.getSource() == aboutMe) {
			
			JPanel newPanel3 = new JPanel();
			newPanel3.setLayout(null);
			newPanel3.setBackground(Color.LIGHT_GRAY);
			
			ta4 = new JTextArea("1. You can use the income tax/other taxes/loan participation option to fill your required form.\n\n"
					+ "2. Please give your actual information to the statements. Any kind of fraud is punishable" 
					+ "\n\n 3. Please press the submit button for fair submission of your information.\n \n"
					+ "4.If you make any fault, please run the program once again. \n\n"
					+ "5. After your submission you can exit from the page by pressing the exit option.");
			ta4.setBounds(0, 0,700,400);
			ta4.setFont(f);
			ta4.setBackground(Color.LIGHT_GRAY);
			ta4.setLineWrap(true);
			ta4.setWrapStyleWord(true);
			newPanel3.add(ta4);
			
			newPane.addTab("About Me", newPanel3);
			
		}
		
		
		else if(ae.getSource() == exitItem)
		{
			int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit", JOptionPane.YES_NO_OPTION);
			
			if(YesOrNo == 0) {
			System.exit(0);}
		}
	}

	
	public static void main(String[] args) {
		userSection1 frame = new userSection1();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 20, 900, 700);
		frame.setTitle("Budget Analyzer/User Section");
	}


	
}
