package travelagency;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.sql.*;
public class Flights {

	private JFrame frame;
	private JTextField deptf;
	private JTextField returntf;
	private JTextField cardnotf;
	private JTextField validitytf;
	private JTextField cvvtf;
	private JTextField login_idtf;
	private JTextField totalamttf;
	private JTextField agetf;
    private String journey_type;
    private String flight_time;
    private String flight_name;
    int total=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flights window = new Flights();
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
	public Flights() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.setBounds(0, 0, 1302, 786);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel datelb = new JLabel("DATE");
		datelb.setFont(new Font("Verdana", Font.BOLD, 22));
		datelb.setBounds(41, 330, 73, 21);
		frame.getContentPane().add(datelb);
		
		JLabel deplb = new JLabel("DEPARTURE");
		deplb.setFont(new Font("Verdana", Font.BOLD, 16));
		deplb.setBounds(15, 388, 125, 24);
		frame.getContentPane().add(deplb);
		
		JLabel returnlb = new JLabel("RETURN");
		returnlb.setFont(new Font("Verdana", Font.BOLD, 18));
		returnlb.setBounds(15, 422, 99, 22);
		frame.getContentPane().add(returnlb);
		
		JLabel journeylb = new JLabel("JOURNEY");
		journeylb.setFont(new Font("Verdana", Font.BOLD, 22));
		journeylb.setBounds(41, 216, 133, 21);
		frame.getContentPane().add(journeylb);
		
		deptf = new JTextField();
		deptf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		deptf.setBounds(143, 388, 125, 28);
		frame.getContentPane().add(deptf);
		deptf.setColumns(10);
		
		returntf = new JTextField();
		returntf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		returntf.setBounds(143, 422, 125, 27);
		frame.getContentPane().add(returntf);
		returntf.setColumns(10);
		
		JLabel dateformatlb = new JLabel("(Format:-YYYY-MM-DD)");
		dateformatlb.setForeground(new Color(0, 0, 139));
		dateformatlb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		dateformatlb.setBounds(15, 358, 231, 21);
		frame.getContentPane().add(dateformatlb);
		
		JLabel location = new JLabel("LOCATION");
		location.setFont(new Font("Verdana", Font.BOLD, 22));
		location.setBounds(41, 75, 169, 28);
		frame.getContentPane().add(location);
		
		
		JButton backHomebt = new JButton("BACK");
		backHomebt.setForeground(Color.WHITE);
		backHomebt.setBackground(Color.DARK_GRAY);
		backHomebt.setBounds(741, 10, 104, 34);
		frame.getContentPane().add(backHomebt);
		backHomebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		backHomebt.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		JLabel flightslb = new JLabel("FLIGHTS");
		flightslb.setBounds(362, -5, 248, 44);
		frame.getContentPane().add(flightslb);
		flightslb.setFont(new Font("Verdana", Font.BOLD, 39));
		
		JLabel login_idlb = new JLabel("Enter Login-ID:");
		login_idlb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login_idlb.setBounds(10, 17, 133, 21);
		frame.getContentPane().add(login_idlb);
		
		login_idtf = new JTextField();
		login_idtf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login_idtf.setBounds(143, 13, 49, 29);
		frame.getContentPane().add(login_idtf);
		login_idtf.setColumns(10);
		
		JButton logoutbt = new JButton("LOGOUT");
		logoutbt.setForeground(Color.WHITE);
		logoutbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame,"Logout from Bluetick Travels?","Flights",JOptionPane.YES_NO_OPTION)==(JOptionPane.YES_NO_OPTION)) {Loginpage.main(null);}
				
			}
			
		});
		logoutbt.setBackground(Color.DARK_GRAY);
		logoutbt.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(logoutbt);
		logoutbt.setBounds(866, 10, 126, 34);
	
		
		JLabel journeyfarelb = new JLabel("(Ticket Fares:-Return=twice(Single))");
		journeyfarelb.setForeground(new Color(0, 0, 128));
		journeyfarelb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		journeyfarelb.setBounds(10, 235, 306, 21);
		frame.getContentPane().add(journeyfarelb);
		
		
		
		JLabel fromlb = new JLabel("FROM");
		fromlb.setBounds(34, 113, 66, 28);
		frame.getContentPane().add(fromlb);
		fromlb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JComboBox fromcomboBox = new JComboBox();
		fromcomboBox.setBackground(Color.WHITE);
		fromcomboBox.setBounds(110, 113, 125, 28);
		
		fromcomboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(fromcomboBox);
		fromcomboBox.setModel(new DefaultComboBoxModel(new String[] {"MUMBAI", "DELHI", "JAIPUR"}));
		
		JLabel tolb = new JLabel("TO");
		tolb.setBounds(41, 151, 57, 28);
		
		frame.getContentPane().add(tolb);
		tolb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JComboBox tocomboBox = new JComboBox();
		tocomboBox.setBackground(Color.WHITE);
		tocomboBox.setBounds(110, 151, 125, 28);
		
		tocomboBox.setModel(new DefaultComboBoxModel(new String[] {"DELHI", "MUMBAI", "JAIPUR"}));
		tocomboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(tocomboBox);
		
		JRadioButton returnrbt = new JRadioButton("RETURN");
		returnrbt.setBounds(142, 262, 116, 21);
		frame.getContentPane().add(returnrbt);
		returnrbt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JRadioButton singlerbt = new JRadioButton("SINGLE");
		singlerbt.setBounds(11, 262, 103, 21);
		frame.getContentPane().add(singlerbt);
		singlerbt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		returnrbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				journey_type="Return";
				if(returnrbt.isSelected())
					singlerbt.setSelected(false);
			}
		});
		
		singlerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				journey_type="Single";
				if(singlerbt.isSelected())
					returnrbt.setSelected(false);
			}
		});
		
		
		
		
		
		agetf = new JTextField();
		agetf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		agetf.setBounds(101, 491, 66, 28);
		frame.getContentPane().add(agetf);
		agetf.setColumns(10);
		
		JLabel age = new JLabel("AGE");
		age.setBounds(34, 493, 57, 21);
		frame.getContentPane().add(age);
		age.setFont(new Font("Verdana", Font.BOLD, 22));
		
		
		JLabel timefflb = new JLabel("TIMINGS, FLIGHTS & FARES");
		timefflb.setBounds(291, 76, 424, 25);
		frame.getContentPane().add(timefflb);
		timefflb.setFont(new Font("Verdana", Font.BOLD, 25));
		
		JRadioButton time2rb = new JRadioButton("15:00:00");
		
		time2rb.setBounds(307, 333, 111, 21);
		frame.getContentPane().add(time2rb);
		time2rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton time1rb = new JRadioButton("9:00:00");
		
		time1rb .setBounds(307, 294, 111, 25);
		frame.getContentPane().add(time1rb);
		time1rb .setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton time3rb = new JRadioButton("21:00:00");
		
		time3rb.setBounds(307, 371, 111, 21);
		frame.getContentPane().add(time3rb);
		time3rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		
		
		
		JSeparator vseparator_2 = new JSeparator();
		vseparator_2.setBackground(Color.BLACK);
		vseparator_2.setForeground(Color.BLACK);
		vseparator_2.setBounds(612, 125, 14, 267);
		frame.getContentPane().add(vseparator_2);
		vseparator_2.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator vseparator_1 = new JSeparator();
		vseparator_1.setForeground(Color.BLACK);
		vseparator_1.setBackground(Color.BLACK);
		vseparator_1.setBounds(436, 125, 2, 267);
		frame.getContentPane().add(vseparator_1);
		vseparator_1.setOrientation(SwingConstants.VERTICAL);
		
		JLabel tablefareslb = new JLabel("(All fares are for Economy class)");
		tablefareslb.setForeground(new Color(0, 0, 128));
		tablefareslb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		tablefareslb.setBounds(335, 100, 346, 21);
		frame.getContentPane().add(tablefareslb);
		
		JLabel paymentlb = new JLabel("PAYMENT DETAILS");
		paymentlb.setFont(new Font("Verdana", Font.BOLD, 24));
		paymentlb.setBounds(377, 421, 270, 21);
		frame.getContentPane().add(paymentlb);
		
		JLabel cardnolb = new JLabel("CARD NO.");
		cardnolb.setFont(new Font("Verdana", Font.BOLD, 18));
		cardnolb.setBounds(377, 459, 113, 23);
		frame.getContentPane().add(cardnolb);
		
		JLabel validitylb = new JLabel("VALIDITY");
		validitylb.setFont(new Font("Verdana", Font.BOLD, 18));
		validitylb.setBounds(387, 492, 103, 21);
		frame.getContentPane().add(validitylb);
		
		JLabel cvvlb = new JLabel("CVV");
		cvvlb.setFont(new Font("Verdana", Font.BOLD, 18));
		cvvlb.setBounds(407, 534, 51, 20);
		frame.getContentPane().add(cvvlb);
		
		cardnotf = new JTextField();
		cardnotf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cardnotf.setBounds(495, 456, 133, 25);
		frame.getContentPane().add(cardnotf);
		cardnotf.setColumns(10);
		
		validitytf = new JTextField();
		validitytf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		validitytf.setBounds(495, 491, 131, 28);
		frame.getContentPane().add(validitytf);
		validitytf.setColumns(10);
		
		cvvtf = new JTextField();
		cvvtf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cvvtf.setText("");
		cvvtf.setBounds(495, 529, 133, 25);
		frame.getContentPane().add(cvvtf);
		cvvtf.setColumns(10);
		
		JLabel validityrlb = new JLabel("(YYYY)");
		validityrlb.setForeground(new Color(0, 0, 128));
		validityrlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		validityrlb.setBounds(397, 510, 75, 17);
		frame.getContentPane().add(validityrlb);
		
		JRadioButton r1_1rb = new JRadioButton("Rs.5500");
		
		r1_1rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r1_1rb.setBounds(462, 296, 103, 21);
		frame.getContentPane().add(r1_1rb);
		
		JRadioButton r1_2rb = new JRadioButton("Rs.7500");
		
		r1_2rb.setBounds(620, 296, 95, 21);
		frame.getContentPane().add(r1_2rb);
		r1_2rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton r2_1rb = new JRadioButton("Rs.5000");
		
		r2_1rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r2_1rb.setBounds(462, 333, 103, 21);
		frame.getContentPane().add(r2_1rb);
		
		JRadioButton r2_2rb = new JRadioButton("Rs.7000");
		
		r2_2rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r2_2rb.setBounds(620, 333, 95, 21);
		frame.getContentPane().add(r2_2rb);
		
		JRadioButton r3_1rb = new JRadioButton("Rs.4500");
		
		r3_1rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r3_1rb.setBounds(462, 371, 103, 21);
		frame.getContentPane().add(r3_1rb);
		
		JRadioButton r3_2rb = new JRadioButton("Rs.6500");
		
		r3_2rb.setBounds(620, 371, 95, 21);
		frame.getContentPane().add(r3_2rb);
		r3_2rb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton flight1rbt = new JRadioButton("AirIndia");
		flight1rbt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		flight1rbt.setBounds(444, 126, 103, 21);
		frame.getContentPane().add(flight1rbt);
		
		JRadioButton flight2rbt = new JRadioButton("Indigo");
		flight2rbt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		flight2rbt.setBounds(620, 124, 103, 25);
		frame.getContentPane().add(flight2rbt);
		
		time1rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(time1rb.isSelected())
				time2rb.setSelected(false);
				time3rb.setSelected(false);
				r2_1rb.setSelected(false);
				r2_2rb.setSelected(false);
				r3_1rb.setSelected(false);
				r3_2rb.setSelected(false);
				flight_time="9:00:00";
			}
		});
		time2rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(time2rb.isSelected())
					time1rb.setSelected(false);
					time3rb.setSelected(false);
					r1_1rb.setSelected(false);
					r1_2rb.setSelected(false);
					r3_1rb.setSelected(false);
					r3_2rb.setSelected(false);
					flight_time="15:00:00";
			}
		});
		time3rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(time3rb.isSelected())
					time1rb.setSelected(false);
					time2rb.setSelected(false);
					r1_1rb.setSelected(false);
					r1_2rb.setSelected(false);
					r2_1rb.setSelected(false);
					r2_2rb.setSelected(false);
					flight_time="21:00:00";
			}
		});
		
		r1_1rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r1_1rb.isSelected())
					flight2rbt.setSelected(false);
				r2_1rb.setSelected(false);
				r3_1rb.setSelected(false);
				r1_2rb.setSelected(false);
				r2_2rb.setSelected(false);
				r3_2rb.setSelected(false);
				time2rb.setSelected(false);
				time3rb.setSelected(false);
			}
		});
		r2_1rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r2_1rb.isSelected())
					flight2rbt.setSelected(false);
					r1_1rb.setSelected(false);
					r3_1rb.setSelected(false);
					r1_2rb.setSelected(false);
					r2_2rb.setSelected(false);
					r3_2rb.setSelected(false);
					time1rb.setSelected(false);
					time3rb.setSelected(false);
			}
		});
		r3_1rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r3_1rb.isSelected())
					flight2rbt.setSelected(false);
					r2_1rb.setSelected(false);
					r1_1rb.setSelected(false);
					r1_2rb.setSelected(false);
					r2_2rb.setSelected(false);
					r3_2rb.setSelected(false);
					time1rb.setSelected(false);
					time2rb.setSelected(false);
			}
		});
		r1_2rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r1_2rb.isSelected())
					flight1rbt.setSelected(false);
					r2_1rb.setSelected(false);
					r3_1rb.setSelected(false);
					r1_1rb.setSelected(false);
					r2_2rb.setSelected(false);
					r3_2rb.setSelected(false);
					time2rb.setSelected(false);
					time3rb.setSelected(false);
			}
		});
		r2_2rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r2_2rb.isSelected())
					flight1rbt.setSelected(false);
					r2_1rb.setSelected(false);
					r3_1rb.setSelected(false);
					r1_2rb.setSelected(false);
					r1_1rb.setSelected(false);
					r3_2rb.setSelected(false);
					time1rb.setSelected(false);
					time3rb.setSelected(false);
			}
		});
		r3_2rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r3_2rb.isSelected())
					flight1rbt.setSelected(false);
					r2_1rb.setSelected(false);
					r3_1rb.setSelected(false);
					r1_2rb.setSelected(false);
					r2_2rb.setSelected(false);
					r1_1rb.setSelected(false);
					time1rb.setSelected(false);
					time2rb.setSelected(false);
			}
		});
		
		JLabel timings = new JLabel("TIMINGS(IST)");
		timings.setFont(new Font("Verdana", Font.BOLD, 17));
		timings.setBounds(291, 125, 145, 25);
		frame.getContentPane().add(timings);
		
		JLabel flight2pic = new JLabel("");
		flight2pic.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\airindia.PNG"));
		flight2pic.setBounds(454, 155, 125, 128);
		frame.getContentPane().add(flight2pic);
		
		JLabel flight3pic = new JLabel("");
		flight3pic.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\indigo.PNG"));
		flight3pic.setBounds(620, 164, 103, 107);
		frame.getContentPane().add(flight3pic);
		
		
		
		flight1rbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flight1rbt.isSelected())
				flight2rbt.setSelected(false);
				r1_2rb.setSelected(false);
				r2_2rb.setSelected(false);
				r3_2rb.setSelected(false);
				flight_name="AirIndia";
			}
		});
		flight2rbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flight2rbt.isSelected())
					flight1rbt.setSelected(false);
				r1_1rb.setSelected(false);
				r2_1rb.setSelected(false);
				r3_1rb.setSelected(false);
				flight_name="Indigo";
			}
		});
		
		
		
		JLabel receiptlb = new JLabel("RECEIPT");
		receiptlb.setBounds(804, 76, 133, 28);
		frame.getContentPane().add(receiptlb);
		receiptlb.setFont(new Font("Verdana", Font.BOLD, 25));
		
		JTextArea ticketArea = new JTextArea();
		ticketArea.setFont(new Font("Times New Roman", Font.BOLD, 17));
		ticketArea.setBounds(741, 122, 267, 444);
		frame.getContentPane().add(ticketArea);

		totalamttf = new JTextField();
		totalamttf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		totalamttf.setBounds(515, 643, 125, 30);
		frame.getContentPane().add(totalamttf);
		totalamttf.setColumns(10);
		
		JButton reset = new JButton("RESET");
		reset.setForeground(Color.WHITE);
		reset.setBounds(101, 582, 127, 35);
		frame.getContentPane().add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deptf.setText(null);
				returntf.setText(null);
				
				cardnotf.setText(null);
				validitytf.setText(null);
				cvvtf.setText(null);
				
				time1rb.setSelected(false);
				time2rb.setSelected(false);
				time3rb.setSelected(false);
				
				r1_1rb.setSelected(false);
				r1_2rb.setSelected(false);
				
				r2_1rb.setSelected(false);
				r2_2rb.setSelected(false);
				
				r3_1rb.setSelected(false);
				r3_2rb.setSelected(false);
				
				singlerbt.setSelected(false);
				returnrbt.setSelected(false);
				
				fromcomboBox.setSelectedItem("Mumbai");
				tocomboBox.setSelectedItem("Delhi");
				
			}
		});
		reset.setBackground(Color.DARK_GRAY);
		reset.setFont(new Font("Times New Roman", Font.BOLD, 28));
		
		JButton totalamtbt = new JButton("CONFIRM BOOKING");
		totalamtbt.setForeground(Color.WHITE);
		totalamtbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(singlerbt.isSelected())
				{
				  if(time1rb.isSelected())
				  {
				      if(r1_1rb.isSelected())
				      {  
				       total=total+50+5500;
				       totalamttf.setText(Integer.toString(total));
				      }
				 
				      else if(r1_2rb.isSelected())
				      {  
				       total=total+50+7500;
				       totalamttf.setText(Integer.toString(total));
				      }
				  }

				 else if(time2rb.isSelected())
				  {
				      if(r2_1rb.isSelected())
				      {  
				       total=total+50+5000;
				       totalamttf.setText(Integer.toString(total));
				      }
				 
				      else if(r2_2rb.isSelected())
				      {  
				       total=total+50+7000;
				       totalamttf.setText(Integer.toString(total));
				      }
				  }
				 else if(time3rb.isSelected())
				  {
				      if(r3_1rb.isSelected())
				      {  
				       total=total+50+4500;
				       totalamttf.setText(Integer.toString(total));
				      }
				 
				      else if(r3_2rb.isSelected())
				      {  
				       total=total+50+6500;
				       totalamttf.setText(Integer.toString(total));
				      }
				  }
				}


				else if(returnrbt.isSelected())
				{
				  if(time1rb.isSelected())
				  {
				      if(r1_1rb.isSelected())
				      {  
				       total=total+50+11000;
				       totalamttf.setText(Integer.toString(total));
				      }
				 
				      else if(r1_2rb.isSelected())
				      {  
				       total=total+50+15000;
				       totalamttf.setText(Integer.toString(total));
				      }
				  }

				 else if(time2rb.isSelected())
				  {
				      if(r2_1rb.isSelected())
				      {  
				       total=total+50+10000;
				       totalamttf.setText(Integer.toString(total));
				      }
				 
				      else if(r2_2rb.isSelected())
				      {  
				       total=total+50+14000;
				       totalamttf.setText(Integer.toString(total));
				      }
				  }
				 else if(time3rb.isSelected())
				  {
				      if(r3_1rb.isSelected())
				      {  
				       total=total+50+9000;
				       totalamttf.setText(Integer.toString(total));
				      }
				 
				      else if(r3_2rb.isSelected())
				      {  
				       total=total+50+13000;
				       totalamttf.setText(Integer.toString(total));
				      }
				  }
				}

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
				String sql="Insert into flights(source_,destination,journey_type,departure_date,return_date,age,flight_time,flight_name,fcard_no,fcvv,fvalidity,famount,login_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				String fromcombo=fromcomboBox.getSelectedItem().toString();
				ps.setString(1,fromcombo);
				String tocombo=tocomboBox.getSelectedItem().toString();
				ps.setString(2,tocombo);
				ps.setString(3,journey_type);
				ps.setString(4,deptf.getText());
				ps.setString(5,returntf.getText());
				ps.setString(6,agetf.getText());
				ps.setString(7,flight_time);
				ps.setString(8,flight_name);
				ps.setString(9,cardnotf.getText());
				ps.setString(10,cvvtf.getText());
				ps.setString(11,validitytf.getText());
				ps.setString(12,totalamttf.getText());
				ps.setString(13,login_idtf.getText());
				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			}
		});
		totalamtbt.setBounds(397, 608, 242, 33);
		frame.getContentPane().add(totalamtbt);
		totalamtbt.setBackground(Color.DARK_GRAY);
		totalamtbt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton printbt = new JButton("PRINT TICKET");
		printbt.setForeground(Color.WHITE);
		printbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
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
						
						String sql1 = "select * from flights where login_id='"+loginid+"'";
						Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
						PreparedStatement s1 = conn1.prepareStatement(sql1);
						ResultSet rs1 = s1.executeQuery();
						rs1.next();
						loginid=rs1.getString("login_id");
						String source = rs1.getString(2);
						String destination = rs1.getString(3);
						String journey_type = rs1.getString(4);
						String departure = rs1.getString(5);
						String returnr = rs1.getString(6);
						String age = rs1.getString(7);
						String ftime = rs1.getString(8);
						String flightname = rs1.getString(9);
						String famount = rs1.getString(13);
 						ticketArea.append("Bluetick Travels:\n"
								+"\nName : "+Firstname+" " +Middlename+" "+Lastname
								+"\nAge : "+age
								+"\nContact number :  "+Phoneno
								+"\n\nTraveling from :  "+source
								+"\nTraveling to :  "+destination
								+"\n\nFlight Name :  "+flightname
								+"\nJourney :  "+journey_type
								+"\nDeparture on :  "+departure
								+"\nReturn on :  "+returnr
								+"\nFlight time :  "+ftime
								+"\n\nTotal Amount  :  Rs."+famount+"\n(Inclusion of all taxes)\n\nHappy Journey!");
 						try {
 							ticketArea.print();
 						} catch (PrinterException e2) {
 							// TODO Auto-generated catch block
 							e2.printStackTrace();
 						}
					}
 catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}		
		});
	
		printbt.setBackground(Color.DARK_GRAY);
		printbt.setFont(new Font("Times New Roman", Font.BOLD, 28));
		printbt.setBounds(741, 582, 257, 35);
		frame.getContentPane().add(printbt);
		
		JLabel lblNewLabel = new JLabel("(You can only reset before confirming booking!)");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(15, 621, 327, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbtotal = new JLabel("Total amt:");
		lbtotal.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lbtotal.setBounds(399, 646, 106, 20);
		frame.getContentPane().add(lbtotal);
		
		JLabel wallpaper4 = new JLabel("");
		wallpaper4.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\picFLIGHTS.jpg"));
		wallpaper4.setBounds(0, 0, 1028, 740);
		frame.getContentPane().add(wallpaper4);
		
		
		
		
		
			}
}
