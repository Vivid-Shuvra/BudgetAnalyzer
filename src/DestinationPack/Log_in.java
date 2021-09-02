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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Log_in extends JFrame {

	private JLabel userLabel,passLabel, promptLabel, messageLabel, bgLab;
	private JButton submitButton, clearButton;
	private JTextField tf;
	private JPasswordField pf;
	private ImageIcon icon, imgIcon;
	private Container con;
	private Font f, font;
	private Cursor cursor;
	
	Log_in()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 50, 700, 500);
		this.setTitle("Log_in: Hello! User");
		
		initComponents();
	}
	
	public void initComponents()
	{
		con =  this.getContentPane();
		con.setLayout(null);
		
		icon = new ImageIcon(getClass().getResource("budget.png"));
		this.setIconImage(icon.getImage());
		
		imgIcon = new ImageIcon(getClass().getResource("login.jpg"));
		
		f = new Font("Arial",Font.BOLD, 16);
		font = new Font("Arial", Font.BOLD + Font.ITALIC, 40);
		cursor = new Cursor(Cursor.HAND_CURSOR); 
		
		promptLabel = new JLabel("Welcome!!");
		promptLabel.setBounds(400, 30, 200, 100);
		promptLabel.setFont(font);
		promptLabel.setForeground(Color.cyan);
		con.add(promptLabel);
		
		messageLabel = new JLabel("You have to log in to enter to the next segment");
		messageLabel.setBounds(240, 100, 400, 50);
		messageLabel.setFont(f);
		messageLabel.setForeground(Color.BLACK);
		con.add(messageLabel);
		
		userLabel = new JLabel("User name: ");
		userLabel.setBounds(120, 200, 150, 50);
		userLabel.setFont(f);
		userLabel.setForeground(Color.BLACK);
		con.add(userLabel);
		
		tf = new JTextField();
		tf.setBounds(250, 200, 230, 50);
		tf.setFont(f);
		con.add(tf);
		
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(120, 280, 150, 50);
		passLabel.setFont(f);
		passLabel.setForeground(Color.black);
		con.add(passLabel);
		
		pf = new JPasswordField();
		pf.setBounds(250, 280, 230, 50);
		pf.setFont(f);
		con.add(pf);
		
		submitButton = new JButton("submit");
		submitButton.setBounds(250, 350, 100, 50);
		submitButton.setFont(f);
		submitButton.setCursor(cursor);
		con.add(submitButton);
		
		clearButton = new JButton("clear");
		clearButton.setBounds(380, 350, 100, 50);
		clearButton.setFont(f);
		clearButton.setCursor(cursor);
		con.add(clearButton);
		
		bgLab = new JLabel(imgIcon);
		bgLab.setBounds(0, 0, 850, 600);
		con.add(bgLab);
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				
				tf.setText("");
				pf.setText("");
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = tf.getText();
				String password = pf.getText();
				
				if(username.equals("admin") && password.equals("123")){
					JOptionPane.showMessageDialog(null, "You are welcome", "Home Page", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Invalid Info", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
	}



	public static void main(String[] args) {
		
		Log_in frame = new Log_in();
		frame.setVisible(true);
	}
}
