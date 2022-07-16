package travelagency;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import travelagency.Homepage;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Createacc {

	private JFrame frame;
	private JTextField fnametf;
	private JTextField mnametf;
	private JTextField lnametf;
	private JTextField usernametf;
	private JTextField emailtf;
	private JTextField mobilenotf;
	private JPasswordField passwordtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createacc window = new Createacc();
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
	public Createacc() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.DARK_GRAY);
		frame.setBackground(new Color(160, 160, 160));
		frame.setBounds(0, 0, 957, 786);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel createacclb = new JLabel("CREATE NEW ACCOUNT");
		createacclb.setForeground(Color.WHITE);
		createacclb.setFont(new Font("Verdana", Font.BOLD, 42));
		createacclb.setBounds(217,17, 557, 36);
		frame.getContentPane().add(createacclb);
		
		JLabel fnamelb = new JLabel("FIRST NAME");
		fnamelb.setForeground(Color.WHITE);
		fnamelb.setFont(new Font("Verdana", Font.BOLD, 32));
		fnamelb.setBounds(50, 114, 240, 25);
		frame.getContentPane().add(fnamelb);
		
		JLabel mnamelb = new JLabel("MIDDLE NAME");
		mnamelb.setForeground(Color.WHITE);
		mnamelb.setFont(new Font("Verdana", Font.BOLD, 32));
		mnamelb.setBounds(347, 108, 297, 36);
		frame.getContentPane().add(mnamelb);
		
		JLabel lnamelb = new JLabel("LAST NAME");
		lnamelb.setForeground(Color.WHITE);
		lnamelb.setFont(new Font("Verdana", Font.BOLD, 32));
		lnamelb.setBounds(683, 107, 220, 38);
		frame.getContentPane().add(lnamelb);
		
		JLabel addresslb = new JLabel("ADDRESS");
		addresslb.setForeground(Color.WHITE);
		addresslb.setFont(new Font("Verdana", Font.BOLD, 32));
		addresslb.setBounds(697, 261, 182, 27);
		frame.getContentPane().add(addresslb);
		
		fnametf = new JTextField();
		fnametf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		fnametf.setBounds(60, 149, 176, 36);
		frame.getContentPane().add(fnametf);
		fnametf.setColumns(10);
		
		mnametf = new JTextField();
		mnametf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		mnametf.setBounds(391, 149, 176, 36);
		frame.getContentPane().add(mnametf);
		mnametf.setColumns(10);
		
		lnametf = new JTextField();
		lnametf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lnametf.setBounds(708, 149, 171, 36);
		frame.getContentPane().add(lnametf);
		lnametf.setColumns(10);
		
		JTextArea addressta = new JTextArea();
		addressta.setBackground(Color.WHITE);
		addressta.setForeground(UIManager.getColor("CheckBox.foreground"));
		addressta.setFont(new Font("Times New Roman", Font.BOLD, 28));
		addressta.setBounds(648, 298, 285, 90);
		frame.getContentPane().add(addressta);
		
		JLabel emaillb = new JLabel("E-MAIL ID");
		emaillb.setForeground(Color.WHITE);
		emaillb.setFont(new Font("Verdana", Font.BOLD, 32));
		emaillb.setBounds(68, 261, 185, 27);
		frame.getContentPane().add(emaillb);
		
		JLabel phonenolb = new JLabel("MOBILE NO.");
		phonenolb.setForeground(Color.WHITE);
		phonenolb.setFont(new Font("Verdana", Font.BOLD, 32));
		phonenolb.setBounds(380, 262, 254, 25);
		frame.getContentPane().add(phonenolb);
		
		JLabel usernamelb = new JLabel("CREATE USERNAME");
		usernamelb.setForeground(Color.WHITE);
		usernamelb.setFont(new Font("Verdana", Font.BOLD, 32));
		usernamelb.setBounds(63, 427, 372, 31);
		frame.getContentPane().add(usernamelb);
		
		JLabel userwarninglb = new JLabel("(6-10 characters)");
		userwarninglb.setForeground(Color.BLACK);
		userwarninglb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		userwarninglb.setBounds(126, 457, 212, 23);
		frame.getContentPane().add(userwarninglb);
		
		usernametf = new JTextField();
		usernametf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		usernametf.setBounds(104, 481, 254, 36);
		frame.getContentPane().add(usernametf);
		usernametf.setColumns(10);
		
		JLabel passwordlb = new JLabel("CREATE PASSWORD");
		passwordlb.setForeground(Color.WHITE);
		passwordlb.setFont(new Font("Verdana", Font.BOLD, 32));
		passwordlb.setBounds(524, 427, 379, 30);
		frame.getContentPane().add(passwordlb);
		
		JLabel passwarninglb = new JLabel("(no special characters)");
		passwarninglb.setForeground(Color.BLACK);
		passwarninglb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		passwarninglb.setBounds(572, 457, 285, 23);
		frame.getContentPane().add(passwarninglb);
		
		emailtf = new JTextField();
		emailtf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		emailtf.setBounds(26, 298, 285, 36);
		frame.getContentPane().add(emailtf);
		emailtf.setColumns(10);
		
		mobilenotf = new JTextField();
		mobilenotf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		mobilenotf.setBounds(373, 298, 220, 36);
		frame.getContentPane().add(mobilenotf);
		mobilenotf.setColumns(10);
		
		JButton createbt = new JButton("CREATE MY ACCOUNT");
		createbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = fnametf.getText();
				String mname = mnametf.getText();
                String lname = lnametf.getText();
                String email_id = emailtf.getText();
                String username = usernametf.getText();
                String phone_no = mobilenotf.getText();
                String address= addressta.getText();
       
                String password=new String(passwordtf.getPassword());
                int login_id=0;
                
				try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
  				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
  				
  				  PreparedStatement ps1 = con.prepareStatement("INSERT INTO travel_account(username,password) VALUES (?,?);");
  				  ps1.setString(1,username);
			      ps1.setString(2,password);
			    
			    
  				  ps1.executeUpdate();
  			
  		          PreparedStatement ps3 =con.prepareStatement("Select login_id,username,password from travel_account where username=? and password=?");
  		          ps3.setString(1,username);
	              ps3.setString(2,password);
	              
	              ResultSet rs=ps3.executeQuery();
	              rs.next();
	              login_id=rs.getInt("login_id");
	              
  		       	PreparedStatement ps2 = con.prepareStatement("INSERT INTO  person VALUES (?,?,?,?,?,?,?)");
  			   
  			      ps2.setString(1,phone_no);
  			      ps2.setString(2,fname);
  			      ps2.setString(3,mname);
  			      ps2.setString(4,lname);
  			      ps2.setString(5,email_id);
  			      ps2.setString(6,address);
  			      ps2.setLong(7,login_id);
   			      ps2.executeUpdate();

                  JOptionPane.showMessageDialog(createbt, "You have successfully created your account.\nPlease login again to continue.");
                 
  				 Loginpage.main(null);
	              
  				 ps1.close();
  				 ps3.close();
  				 ps2.close();
                    
	              
	              con.close();  
                }
                catch(ClassNotFoundException | SQLException eff) {
                	System.out.println(eff);
                }
               
            }

        });
		createbt.setForeground(Color.BLACK);
	createbt.setBackground(Color.LIGHT_GRAY);
		createbt.setFont(new Font("Times New Roman", Font.BOLD, 32));
		createbt.setBounds(270, 582, 428, 55);
		frame.getContentPane().add(createbt);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		passwordtf = new JPasswordField();
		passwordtf.setFont(new Font("Times New Roman", Font.BOLD, 28));
		passwordtf.setBounds(583, 481, 262, 31);
		frame.getContentPane().add(passwordtf);
		
		JButton backLoginbt = new JButton("BACK");
		backLoginbt.setForeground(Color.BLACK);
		backLoginbt.setBackground(Color.LIGHT_GRAY);
		backLoginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginpage.main(null);
			}
		});
		backLoginbt.setFont(new Font("Times New Roman", Font.BOLD, 30));
		backLoginbt.setBounds(26, 24, 123, 37);
		frame.getContentPane().add(backLoginbt);
		
		JLabel wallpaper2 = new JLabel("");
		wallpaper2.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\picCREATEACC.jpg"));
		wallpaper2.setBounds(0, -24, 1025, 752);
		frame.getContentPane().add(wallpaper2);
	}
}