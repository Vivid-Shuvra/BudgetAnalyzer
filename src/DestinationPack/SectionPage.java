package DestinationPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SectionPage extends JFrame {

	private JLabel lab, promptLab, imgLab, lab2, bgLab;
	private JTextArea ta;
	private Container con;
	private Font f, font, f2, font2;
	private Cursor cursor;
	private ImageIcon icon, icon2, imgicon;
	private JButton adminButton, userButton;
	
	SectionPage()
	{
		con =  this.getContentPane();
		con.setLayout(null);
		cursor = new Cursor(Cursor.HAND_CURSOR); 
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		icon2 = new ImageIcon(getClass().getResource("budget.jpg"));
		
		imgicon = new ImageIcon(getClass().getResource("backimage.jpg"));
		
		imgLab = new JLabel(icon2);  // setting image on JLabel..
		imgLab.setBounds(650, 30, 170, 170);
		con.add(imgLab);
		
		
		f = new Font("Arial", Font.BOLD, 10);
		font = new Font("Arial", Font.BOLD, 16);
		f2 = new Font("Algerian", Font.BOLD, 25);
		font2 = new Font("Arial", Font.BOLD, 18);
		
		
		promptLab = new JLabel("Budget Analyzer");
		promptLab.setBounds(320, 10, 250, 80);
		promptLab.setForeground(Color.black);
		promptLab.setFont(f2);
		con.add(promptLab);
		
		
		userButton = new JButton("User Section");
		userButton.setBounds(100, 150, 150, 40);
		userButton.setFont(font);
		userButton.setBackground(Color.cyan);
		userButton.setCursor(cursor);
		con.add(userButton);
		
		adminButton = new JButton("Admin Section");
		adminButton.setBounds(100, 300, 150, 40);
		adminButton.setFont(font);
		adminButton.setBackground(Color.cyan);
		adminButton.setCursor(cursor);
		con.add(adminButton);
		
		lab = new JLabel("(Only administration has the access to the section)");
		lab.setBounds(50, 350, 400, 30);
		lab.setForeground(Color.black);
		lab.setFont(f);
		con.add(lab);
		
		lab2 = new JLabel("Prepare Budget , Prolong Economy...");
		lab2.setBounds(260, 80, 400, 50);
		lab2.setForeground(Color.black);
		lab2.setFont(new Font("Blackadder ITC", Font.BOLD, 24));
		con.add(lab2);
		
		bgLab = new JLabel(imgicon);
		bgLab.setBounds(0, 0, 850, 600);
		con.add(bgLab);
		
		
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				
				JOptionPane.showMessageDialog(null, "You are welcome", "User section", JOptionPane.INFORMATION_MESSAGE);
				
				userSection1 frame = new userSection1();
				frame.setVisible(true);
				frame.setBounds(100, 20, 900, 700);
			}
		});
		
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent ae) {
				
				JOptionPane.showMessageDialog(null, "You are welcome", "Login section", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				Log_in frame = new Log_in();
				frame.setVisible(true);
			}
		});
		
		
	}
			
		
	public static void main(String[] args) {
		
		SectionPage frame = new SectionPage();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(20, 50, 850, 600);
		frame.setTitle("Budget Analyzer");

	}

}
