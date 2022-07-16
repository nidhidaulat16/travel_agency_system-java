package travelagency;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class Homepage {

	private JFrame frame;
	private JTextField login_idtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(0, 0, 1229, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel homepagelb = new JLabel("HOME PAGE");
		homepagelb.setForeground(Color.WHITE);
		homepagelb.setFont(new Font("Verdana", Font.BOLD, 44));
		homepagelb.setBounds(158, 20, 294, 36);
		frame.getContentPane().add(homepagelb);
		
		JButton flightsbt = new JButton("");
		flightsbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flights.main(null);
			}
		});
		flightsbt.setForeground(Color.WHITE);
		flightsbt.setBackground(Color.WHITE);
		flightsbt.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\flightbt.PNG"));
		flightsbt.setFont(new Font("Times New Roman", Font.BOLD, 22));
		flightsbt.setBounds(193, 179, 165, 116);
		frame.getContentPane().add(flightsbt);
		
		JTextArea infota = new JTextArea();
		infota.setFont(new Font("Times New Roman", Font.BOLD, 17));
		infota.setBounds(512, 451, 357, 206);
		frame.getContentPane().add(infota);
		
		JButton showbt = new JButton("SHOW");
		showbt.setForeground(Color.WHITE);
		showbt.setBackground(Color.DARK_GRAY);
		showbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				String loginid = login_idtf.getText();
				
				
					String sql = "select * from person where login_id ='"+loginid+"'";
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
					PreparedStatement s = conn.prepareStatement(sql);
					ResultSet rs = s.executeQuery();
					rs.next();
					String Firstname = rs.getString(2);
					String Middlename = rs.getString(3);
					String Lastname = rs.getString(4);
					String Phoneno = rs.getString(1);
					String emailid = rs.getString(5);
					String address = rs.getString(6);				
					infota.append(
							"\nName : "+Firstname+" " +Middlename+" "+Lastname						
							+"\n\nContact number :  "+Phoneno
							+"\n\nEmail ID :  "+emailid
							+"\n\nAddress :  "+address
							);				
			}
				catch (ClassNotFoundException | SQLException e1) {
				
					e1.printStackTrace();
				}}
		});
		showbt.setFont(new Font("Times New Roman", Font.BOLD, 21));
		showbt.setBounds(879, 467, 115, 36);
		frame.getContentPane().add(showbt);
		
		
		
		JLabel textlb = new JLabel("Book your Tickets here!");
		textlb.setForeground(Color.WHITE);
		textlb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 26));
		textlb.setBounds(30, 122, 357, 36);
		frame.getContentPane().add(textlb);
		
		JButton hotelbt = new JButton("New button");
		hotelbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotels.main(null);
			}
		});
		hotelbt.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\hotelbt.PNG"));
		hotelbt.setBounds(183, 363, 179, 162);
		frame.getContentPane().add(hotelbt);
		
		JLabel FLIGHTSLB = new JLabel("FLIGHTS");
		FLIGHTSLB.setForeground(Color.WHITE);
		FLIGHTSLB.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		FLIGHTSLB.setBounds(30, 210, 153, 45);
		frame.getContentPane().add(FLIGHTSLB);
		
		JLabel lblNewLabel = new JLabel("HOTELS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 32));
		lblNewLabel.setBounds(20, 422, 153, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton hidebt = new JButton("HIDE");
		hidebt.setForeground(Color.WHITE);
		hidebt.setBackground(Color.DARK_GRAY);
		hidebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infota.setText(null);
			}
		});
		hidebt.setFont(new Font("Times New Roman", Font.BOLD, 21));
		hidebt.setBounds(879, 513, 114, 39);
		frame.getContentPane().add(hidebt);
		
		JLabel accinfolb = new JLabel("MY ACCOUNT INFO");
		accinfolb.setForeground(Color.WHITE);
		accinfolb.setFont(new Font("Verdana", Font.BOLD, 35));
		accinfolb.setBounds(512, 335, 381, 47);
		frame.getContentPane().add(accinfolb);
		
		JLabel loginidlb = new JLabel("Enter LOGIN-ID:");
		loginidlb.setForeground(Color.WHITE);
		loginidlb.setFont(new Font("Verdana", Font.BOLD, 24));
		loginidlb.setBounds(512, 392, 241, 39);
		frame.getContentPane().add(loginidlb);
		
		login_idtf = new JTextField();
		login_idtf.setFont(new Font("Verdana", Font.BOLD, 20));
		login_idtf.setBounds(780, 395, 48, 36);
		frame.getContentPane().add(login_idtf);
		login_idtf.setColumns(10);
		
		JButton logoutbt = new JButton("LOGOUT");
		logoutbt.setBackground(Color.DARK_GRAY);
		logoutbt.setForeground(Color.WHITE);
		logoutbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame,"Logout from Bluetick Travels?","Homepage",JOptionPane.YES_NO_OPTION)==(JOptionPane.YES_NO_OPTION)) {Loginpage.main(null);}
				
			}
			
		});
		logoutbt.setFont(new Font("Times New Roman", Font.BOLD, 24));
		logoutbt.setBounds(837, 13, 157, 43);
		frame.getContentPane().add(logoutbt);
		
		JLabel wallpaper3 = new JLabel("");
		wallpaper3.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\picHOME.jpg"));
		wallpaper3.setBounds(-294, 0, 1322, 739);
		frame.getContentPane().add(wallpaper3);
}	
}
