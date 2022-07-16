package travelagency;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginpage {
private JFrame frame;
private JTextField usertf;
private JPasswordField passtf;

/**
* Create the application.
*/
public static void main(String[] args) {


EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Loginpage window = new Loginpage();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}});}
public Loginpage() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setForeground(Color.WHITE);
frame.setBounds(0,0, 938, 775);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel bluetick = new JLabel("BLUETICK TRAVELS");
bluetick.setForeground(new Color(0, 0, 205));
bluetick.setVerticalAlignment(SwingConstants.TOP);
bluetick.setFont(new Font("Times New Roman", Font.BOLD, 40));
bluetick.setBounds(248, 20, 424, 56);
frame.getContentPane().add(bluetick);

JLabel logpage = new JLabel("LOGIN PAGE");
logpage.setFont(new Font("Simplified Arabic", Font.BOLD, 42));
logpage.setBounds(377, 140, 253, 43);
frame.getContentPane().add(logpage);

JLabel username = new JLabel("USERNAME");
username.setFont(new Font("Times New Roman", Font.BOLD, 35));
username.setBounds(63, 206, 226, 44);
frame.getContentPane().add(username);

usertf = new JTextField();
usertf.setFont(new Font("Times New Roman", Font.BOLD, 34));
usertf.setBounds(299, 206, 315, 44);
frame.getContentPane().add(usertf);
usertf.setColumns(10);

JLabel password = new JLabel("PASSWORD");
password.setFont(new Font("Times New Roman", Font.BOLD, 35));
password.setBounds(63, 271, 216, 42);
frame.getContentPane().add(password);

passtf = new JPasswordField();
passtf.setFont(new Font("Times New Roman", Font.BOLD, 34));
passtf.setBounds(299, 269, 315, 45);
frame.getContentPane().add(passtf);

JButton loginb = new JButton("LOGIN");
loginb.setBackground(Color.DARK_GRAY);
loginb.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int login_id = 0;
		String username=usertf.getText();
		String password=new String(passtf.getPassword());
		try {			
			
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency",
                    "root", "nidhid1601");

                PreparedStatement p1 = (PreparedStatement) connection
                    .prepareStatement("Select username, password from travel_account where username=? and password=?");
                p1.setString(1, username);
                p1.setString(2, password);
                ResultSet rs = p1.executeQuery();
                if (rs.next()) {
                	PreparedStatement ps3 =connection.prepareStatement("Select login_id,username,password from travel_account where username=? and password=?");
    		      ps3.setString(1,username);
  	              ps3.setString(2,password);
  	              ResultSet rs2=ps3.executeQuery();
  	              rs2.next();
  	              login_id=rs2.getInt("login_id");
            	 
                   JOptionPane.showMessageDialog(loginb, "You have successfully logged in.\n Your LOGIN-ID is "+login_id);
                   Homepage.main(null);
                } else {
                    JOptionPane.showMessageDialog(loginb, "Wrong Username & Password");
                }
            connection.close();
            } 
	catch (Exception e1) {
        e1.printStackTrace();
    }}
}
);
loginb.setForeground(Color.WHITE);
loginb.setFont(new Font("Times New Roman", Font.BOLD, 32));
loginb.setBounds(701, 223, 150, 56);
frame.getContentPane().add(loginb);


JButton creataccb = new JButton("CREATE ACCOUNT");
creataccb.setForeground(Color.WHITE);
creataccb.setBackground(Color.DARK_GRAY);
creataccb.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Createacc.main(null);
	}
});
creataccb.setFont(new Font("Times New Roman", Font.BOLD, 32));
creataccb.setBounds(52, 633, 382, 56);
frame.getContentPane().add(creataccb);

JLabel dontmsglb = new JLabel("Don't have an account?");
dontmsglb.setFont(new Font("Verdana", Font.BOLD, 24));
dontmsglb.setBounds(59, 591, 344, 33);
frame.getContentPane().add(dontmsglb);

JLabel taglinelb = new JLabel("Bookings done faster than messages get seen!!");
taglinelb.setForeground(new Color(106, 90, 205));
taglinelb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
taglinelb.setBounds(190, 76, 590, 33);
frame.getContentPane().add(taglinelb);
JLabel tickpic = new JLabel("New label");
tickpic.setForeground(Color.LIGHT_GRAY);
tickpic.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\blueticklogo.PNG"));
tickpic.setBounds(682, 10, 59, 44);
frame.getContentPane().add(tickpic);
JButton exitbt = new JButton("EXIT");
exitbt.setForeground(Color.WHITE);
exitbt.setBackground(Color.DARK_GRAY);
exitbt.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		frame=new JFrame("EXIT");
		if(JOptionPane.showConfirmDialog(frame,"Do you realy want to exit?","Loginpage",JOptionPane.YES_NO_OPTION)==(JOptionPane.YES_NO_OPTION)) {System.exit(0);;}
	}
});
exitbt.setFont(new Font("Times New Roman", Font.BOLD, 30));
exitbt.setBounds(607, 627, 168, 56);
frame.getContentPane().add(exitbt);
JLabel wallpaper1 = new JLabel("");
wallpaper1.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\picLOGIN.jpg"));
wallpaper1.setBounds(0, 0, 1099, 709);
frame.getContentPane().add(wallpaper1);
}
	}