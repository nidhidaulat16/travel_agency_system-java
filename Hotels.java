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
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Hotels {

	private JFrame frame;
	private JTextField login_idtf2;
	private JTextField ttlamttf;
	private JTextField hcardnotf;
	private JTextField hvaliditytf;
	private JTextField hcvvtf;
	private String location;
	private String hotel_name;
	private JTextField checkintf;
	int total=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotels window = new Hotels();
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
	public Hotels() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 22));
		frame.setBounds(0, 0, 1184, 753);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel hotelslb = new JLabel("HOTELS");
		hotelslb.setBounds(347, 10, 233, 34);
		frame.getContentPane().add(hotelslb);
		hotelslb.setFont(new Font("Verdana", Font.BOLD, 40));
		
		JLabel login_idlb2 = new JLabel("Enter Login-ID:");
		login_idlb2.setBounds(10, 23, 159, 21);
		frame.getContentPane().add(login_idlb2);
		login_idlb2.setFont(new Font("Verdana", Font.BOLD, 18));
		
		login_idtf2 = new JTextField();
		login_idtf2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login_idtf2.setColumns(10);
		login_idtf2.setBounds(170, 23, 49, 29);
		frame.getContentPane().add(login_idtf2);
		
		JButton backHomebt = new JButton("BACK");
		backHomebt.setForeground(Color.WHITE);
		backHomebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		backHomebt.setFont(new Font("Times New Roman", Font.BOLD, 19));
		backHomebt.setBackground(Color.DARK_GRAY);
		backHomebt.setBounds(716, 10, 104, 34);
		frame.getContentPane().add(backHomebt);
		
		JButton logoutbt = new JButton("LOGOUT");
		logoutbt.setForeground(Color.WHITE);
		logoutbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame,"Logout from Bluetick Travels?","Hotels",JOptionPane.YES_NO_OPTION)==(JOptionPane.YES_NO_OPTION)) {Loginpage.main(null);}
				
			}
			
		});
		logoutbt.setFont(new Font("Times New Roman", Font.BOLD, 17));
		logoutbt.setBackground(Color.DARK_GRAY);
		logoutbt.setBounds(830, 10, 126, 34);
		frame.getContentPane().add(logoutbt);
		
		JLabel threestarlb = new JLabel("THREE STAR HOTELS");
		threestarlb.setForeground(Color.BLACK);
		threestarlb.setFont(new Font("Times New Roman", Font.BOLD, 22));
		threestarlb.setBounds(150, 195, 259, 25);
		frame.getContentPane().add(threestarlb);
		
		JLabel fivestarlb = new JLabel("FIVE STAR HOTELS");
		fivestarlb.setForeground(Color.BLACK);
		fivestarlb.setFont(new Font("Times New Roman", Font.BOLD, 22));
		fivestarlb.setBounds(419, 196, 218, 23);
		frame.getContentPane().add(fivestarlb);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(138, 195, 2, 291);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(401, 195, 8, 291);
		frame.getContentPane().add(separator_1);
		
		JRadioButton mumbai2 = new JRadioButton("THE OBEROI MUMBAI ");
		mumbai2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		mumbai2.setBounds(406, 239, 246, 23);
		frame.getContentPane().add(mumbai2);
		
		JRadioButton delhi1 = new JRadioButton("HOTEL AURA ");
		delhi1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		delhi1.setBounds(150, 333, 160, 23);
		frame.getContentPane().add(delhi1);
		
		JRadioButton delhi2 = new JRadioButton("THE IMPERIAL");
		delhi2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		delhi2.setBounds(407, 333, 189, 23);
		frame.getContentPane().add(delhi2);
		
		JRadioButton jaipur1 = new JRadioButton("THE PEARL PALACE");
		jaipur1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		jaipur1.setBounds(145, 413, 233, 23);
		frame.getContentPane().add(jaipur1);
		
		JRadioButton jaipur2 = new JRadioButton("HILTON JAIPUR ");
		jaipur2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		jaipur2.setBounds(409, 413, 189, 23);
		frame.getContentPane().add(jaipur2);
		
		JLabel lblNewLabel = new JLabel("FREE WIFI");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(160, 268, 95, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAirportShuttle = new JLabel("AIRPORT SHUTTLE");
		lblAirportShuttle.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAirportShuttle.setBounds(150, 292, 133, 14);
		frame.getContentPane().add(lblAirportShuttle);
		
		JLabel lblSwimmingPool = new JLabel("SWIMMING POOL");
		lblSwimmingPool.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSwimmingPool.setBounds(436, 268, 122, 14);
		frame.getContentPane().add(lblSwimmingPool);
		
		JLabel lblSpaAnd = new JLabel("24/7 SPA AND GYM");
		lblSpaAnd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSpaAnd.setBounds(436, 291, 133, 14);
		frame.getContentPane().add(lblSpaAnd);
		
		JLabel lblAirportShuttle_1 = new JLabel("FITNESS CENTRE");
		lblAirportShuttle_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAirportShuttle_1.setBounds(150, 362, 122, 14);
		frame.getContentPane().add(lblAirportShuttle_1);
		
		JLabel lblLaundry = new JLabel("SPA FACILITY");
		lblLaundry.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLaundry.setBounds(150, 378, 95, 14);
		frame.getContentPane().add(lblLaundry);
		
		JLabel lblSwimmingPoolSauna = new JLabel("SWIMMING POOL, SAUNA");
		lblSwimmingPoolSauna.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSwimmingPoolSauna.setBounds(436, 362, 169, 14);
		frame.getContentPane().add(lblSwimmingPoolSauna);
		
		JLabel lblSquash = new JLabel("SQUASH");
		lblSquash.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSquash.setBounds(436, 378, 95, 14);
		frame.getContentPane().add(lblSquash);
		
		JLabel lblLivePerformances = new JLabel("LIVE PERFORMANCES");
		lblLivePerformances.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLivePerformances.setBounds(150, 466, 147, 14);
		frame.getContentPane().add(lblLivePerformances);
		
		JLabel lblMassageAndBeauty = new JLabel("MASSAGE AND BEAUTY SERVICES");
		lblMassageAndBeauty.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMassageAndBeauty.setBounds(150, 442, 216, 14);
		frame.getContentPane().add(lblMassageAndBeauty);
		
		JLabel lblSightseeingFacilities = new JLabel("SIGHT-SEEING FACILITIES");
		lblSightseeingFacilities.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSightseeingFacilities.setBounds(419, 442, 176, 14);
		frame.getContentPane().add(lblSightseeingFacilities);
		
		JLabel lblFreeWifi = new JLabel("FREE WIFI");
		lblFreeWifi.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblFreeWifi.setBounds(429, 466, 80, 14);
		frame.getContentPane().add(lblFreeWifi);
		
		JLabel checkinlb = new JLabel("CHECK-IN DATE");
		checkinlb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		checkinlb.setBounds(22, 515, 160, 25);
		frame.getContentPane().add(checkinlb);
		
		JLabel lblPaymentDetails = new JLabel("PAYMENT DETAILS :");
		lblPaymentDetails.setFont(new Font("Verdana", Font.BOLD, 22));
		lblPaymentDetails.setBounds(326, 496, 270, 21);
		frame.getContentPane().add(lblPaymentDetails);
		
		JLabel hcardnolb = new JLabel("CARD NO.");
		hcardnolb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hcardnolb.setBounds(359, 534, 95, 25);
		frame.getContentPane().add(hcardnolb);
		
		JLabel hvaliditylb = new JLabel("VALIDITY");
		hvaliditylb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hvaliditylb.setBounds(351, 569, 103, 21);
		frame.getContentPane().add(hvaliditylb);
		
		JLabel hcvvlb = new JLabel("CVV");
		hcvvlb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hcvvlb.setBounds(379, 612, 51, 20);
		frame.getContentPane().add(hcvvlb);
		
		hcardnotf = new JTextField();
		hcardnotf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hcardnotf.setColumns(10);
		hcardnotf.setBounds(464, 534, 162, 25);
		frame.getContentPane().add(hcardnotf);
		
		hvaliditytf = new JTextField();
		hvaliditytf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hvaliditytf.setColumns(10);
		hvaliditytf.setBounds(463, 569, 133, 23);
		frame.getContentPane().add(hvaliditytf);
		
		hcvvtf = new JTextField();
		hcvvtf.setText("");
		hcvvtf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hcvvtf.setColumns(10);
		hcvvtf.setBounds(463, 610, 133, 25);
		frame.getContentPane().add(hcvvtf);
		
		JLabel mum1fare = new JLabel("Rs. 4000");
		mum1fare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		mum1fare.setBounds(321, 268, 73, 25);
		frame.getContentPane().add(mum1fare);
		
		JLabel del1fare = new JLabel("Rs. 1500");
		del1fare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		del1fare.setBounds(321, 359, 73, 17);
		frame.getContentPane().add(del1fare);
		
		JLabel jai1fare = new JLabel("Rs. 2500");
		jai1fare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		jai1fare.setBounds(321, 462, 73, 19);
		frame.getContentPane().add(jai1fare);
		
		JLabel mum2fare = new JLabel("Rs. 10,000");
		mum2fare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		mum2fare.setBounds(571, 268, 95, 25);
		frame.getContentPane().add(mum2fare);
		
		JLabel del2fare = new JLabel("Rs. 7500");
		del2fare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		del2fare.setBounds(586, 375, 80, 17);
		frame.getContentPane().add(del2fare);
		
		JLabel jai2fare = new JLabel("Rs. 4500");
		jai2fare.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		jai2fare.setBounds(586, 459, 80, 25);
		frame.getContentPane().add(jai2fare);
		
		checkintf = new JTextField();
		checkintf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		checkintf.setBounds(22, 559, 147, 25);
		frame.getContentPane().add(checkintf);
		checkintf.setColumns(10);
		
		JLabel dateformat = new JLabel("(Format: YYYY-MM-DD)");
		dateformat.setForeground(new Color(0, 0, 128));
		dateformat.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		dateformat.setBounds(10, 535, 209, 23);
		frame.getContentPane().add(dateformat);
		
		JLabel staylb = new JLabel("WHERE ARE YOU PLANNING TO STAY?");
		staylb.setBounds(86, 86, 540, 30);
		frame.getContentPane().add(staylb);
		staylb.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		JLabel fareslb = new JLabel("(FARES FOR ONE NIGHT AND FACILITIES PROVIDED)");
		fareslb.setBounds(138, 145, 395, 24);
		frame.getContentPane().add(fareslb);
		fareslb.setForeground(new Color(0, 0, 128));
		fareslb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		
		
		
		JRadioButton mumbairb = new JRadioButton("MUMBAI");
		mumbairb.setBounds(10, 239, 111, 23);
		frame.getContentPane().add(mumbairb);
		mumbairb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JRadioButton delhirb = new JRadioButton("DELHI");
		delhirb.setBounds(10, 333, 111, 23);
		frame.getContentPane().add(delhirb);
		delhirb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JRadioButton jaipurrb = new JRadioButton("JAIPUR");
		jaipurrb.setBounds(10, 413, 111, 23);
		frame.getContentPane().add(jaipurrb);
		jaipurrb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JRadioButton mumbai1 = new JRadioButton("ORIENTAL RESIDENCY ");
		mumbai1.setBounds(144, 239, 251, 23);
		frame.getContentPane().add(mumbai1);
		mumbai1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		

		
		jaipurrb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jaipurrb.isSelected())
					mumbairb.setSelected(false);
				    delhirb.setSelected(false); 
				    location="Jaipur";
			}
		});
		
		delhirb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(delhirb.isSelected())
					mumbairb.setSelected(false);
				    jaipurrb.setSelected(false); 
				    location="Delhi";
			}
		});
		
		mumbairb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mumbairb.isSelected())
					delhirb.setSelected(false);
				    jaipurrb.setSelected(false); 
				    location="Mumbai";
			}
		});
		
		jaipur2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jaipur2.isSelected())
					jaipur1.setSelected(false);
					delhirb.setSelected(false);
					mumbairb.setSelected(false);
					delhi1.setSelected(false);
					delhi2.setSelected(false);
					mumbai1.setSelected(false);
					mumbai2.setSelected(false);
					hotel_name="HILTON JAIPUR";
			}
		});
		
		jaipur1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jaipur1.isSelected())
					jaipur2.setSelected(false);
					mumbairb.setSelected(false);
					delhirb.setSelected(false);
					delhi1.setSelected(false);
					delhi2.setSelected(false);
					mumbai1.setSelected(false);
					mumbai2.setSelected(false);
					hotel_name="THE PEARL PALACE";
			}
		});
		delhi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(delhi2.isSelected())
					delhi1.setSelected(false);
					mumbairb.setSelected(false);
					jaipurrb.setSelected(false);
					mumbai1.setSelected(false);
					mumbai2.setSelected(false);
					jaipur1.setSelected(false);
					jaipur2.setSelected(false);
					hotel_name="THE IMPERIAL";
			}
		});
		
		mumbai2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mumbai2.isSelected())
					mumbai1.setSelected(false);
					delhirb.setSelected(false);
					jaipurrb.setSelected(false);
					delhi1.setSelected(false);
					delhi2.setSelected(false);
					jaipur1.setSelected(false);
					jaipur2.setSelected(false);
					hotel_name="THE OBEROI MUMBAI";
			}
		});
		
		delhi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(delhi1.isSelected())
					delhi2.setSelected(false);
					mumbairb.setSelected(false);
					jaipurrb.setSelected(false);
					mumbai1.setSelected(false);
					mumbai2.setSelected(false);
					jaipur1.setSelected(false);
					jaipur2.setSelected(false);
					hotel_name="HOTEL AURA";
			}
		});
		

		mumbai1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mumbai1.isSelected())
					mumbai2.setSelected(false);
					delhirb.setSelected(false);
					jaipurrb.setSelected(false);
					delhi1.setSelected(false);
					delhi2.setSelected(false);
					jaipur1.setSelected(false);
					jaipur2.setSelected(false);
					hotel_name="ORIENTAL RESIDENCY";
			}
		});
		
		JLabel locationlb = new JLabel("LOCATION");
		locationlb.setBounds(6, 193, 122, 28);
		frame.getContentPane().add(locationlb);
		locationlb.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		
		JLabel hoteloptlb = new JLabel("Hotels, Fares & Specials");
		hoteloptlb.setBounds(184, 117, 276, 32);
		frame.getContentPane().add(hoteloptlb);
		hoteloptlb.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		
		JTextArea billtextArea = new JTextArea();
		billtextArea.setFont(new Font("Times New Roman", Font.BOLD, 17));
		billtextArea.setBackground(Color.WHITE);
		billtextArea.setBounds(690, 196, 300, 388);
		frame.getContentPane().add(billtextArea);
		
		JButton printbt2 = new JButton("PRINT BILL");
		printbt2.setForeground(Color.WHITE);
		printbt2.setBounds(727, 588, 201, 44);
		frame.getContentPane().add(printbt2);
		printbt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					String loginid = login_idtf2.getText();
					
					
					String sql = "select * from person where login_id ='"+loginid+"'";
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
					PreparedStatement s = conn.prepareStatement(sql);
					ResultSet rs = s.executeQuery();
					rs.next();
					String Firstname = rs.getString(2);
					String Middlename = rs.getString(3);
					String Lastname = rs.getString(4);
					String Phoneno = rs.getString(1);
					
					String sql1 = "select * from hotels where login_id='"+loginid+"'";
					Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
					PreparedStatement s1 = conn1.prepareStatement(sql1);
					ResultSet rs1 = s1.executeQuery();
					rs1.next();
					loginid=rs1.getString("login_id");
					String city = rs1.getString(2);
					String hotel_name = rs1.getString(3);
					String checkin = rs1.getString(4);
					String hamount = rs1.getString(8);
						billtextArea.append("Bluetick Travels:\n"
							+"\nName : "+Firstname+" " +Middlename+" "+Lastname
							+"\nContact number :  "+Phoneno
							+"\n\nStaying in: "+hotel_name
							+"\nCity : "+city
							+"\n\nChecking in on :  "+checkin
							+"\n\nTotal Amount  :  Rs."+hamount+"\n(Inclusion of all taxes)\n\nHappy Stay!");
					
					
					
			}
				catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		printbt2.setFont(new Font("Verdana", Font.BOLD, 20));
		printbt2.setBackground(Color.DARK_GRAY);
		
		ttlamttf = new JTextField();
		ttlamttf.setBounds(830, 125, 103, 21);
		frame.getContentPane().add(ttlamttf);
		ttlamttf.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ttlamttf.setColumns(10);
		
		
		JButton totalamtbt = new JButton("CONFIRM BOOKING");
		totalamtbt.setForeground(Color.WHITE);
		totalamtbt.setBounds(716, 87, 252, 33);
		frame.getContentPane().add(totalamtbt);
		totalamtbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
					if(mumbairb.isSelected())
					  {
					      if(mumbai1.isSelected())
					      {  
					       total=total+50+4000;
					       ttlamttf.setText(Integer.toString(total));
					      }
					 
					      else if(mumbai2.isSelected())
					      {  
					       total=total+50+10000;
					       ttlamttf.setText(Integer.toString(total));
					      }
					  }

					else if(delhirb.isSelected())
					  {
					      if(delhi1.isSelected())
					      {  
					       total=total+50+1500;
					       ttlamttf.setText(Integer.toString(total));
					      }
					 
					      else if(delhi2.isSelected())
					      {  
					       total=total+50+7500;
					       ttlamttf.setText(Integer.toString(total));
					      }
					  }
					else if(jaipurrb.isSelected())
					  {
					      if(jaipur1.isSelected())
					      {  
					       total=total+50+2500;
					       ttlamttf.setText(Integer.toString(total));
					      }
					 
					      else if(jaipur2.isSelected())
					      {  
					       total=total+50+4500;
					       ttlamttf.setText(Integer.toString(total));
					      }
					  }
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency", "root", "nidhid1601");
					String sql="Insert into hotels(location,hotel_name,checkin_date,hcard_no,hcvv,hvalidity,hamount,login_id)values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1,location);
					ps.setString(2,hotel_name);
					ps.setString(3,checkintf.getText());
					ps.setString(4,hcardnotf.getText());
					ps.setString(5,hcvvtf.getText());
					ps.setString(6,hvaliditytf.getText());
					ps.setString(7,ttlamttf.getText());
					ps.setString(8,login_idtf2.getText());
					ps.executeUpdate();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				
				}
			}
		});
		totalamtbt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		totalamtbt.setBackground(Color.DARK_GRAY);
		
		JLabel lbtotal2 = new JLabel("Total amt:");
		lbtotal2.setBounds(716, 129, 106, 20);
		frame.getContentPane().add(lbtotal2);
		lbtotal2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
	
		JLabel billdetails = new JLabel("BILL DETAILS :");
		billdetails.setBounds(716, 167, 182, 29);
		frame.getContentPane().add(billdetails);
		billdetails.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JButton reset = new JButton("RESET");
		reset.setForeground(Color.WHITE);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mumbairb.setSelected(false);
				delhirb.setSelected(false);
				jaipurrb.setSelected(false);
				
				mumbai1.setSelected(false);
				mumbai2.setSelected(false);
				
				delhi1.setSelected(false);
				delhi2.setSelected(false);
				
				jaipur1.setSelected(false);
				jaipur2.setSelected(false);
				
				checkintf.setText(null);
				hcardnotf.setText(null);
				hvaliditytf.setText(null);
				hcvvtf.setText(null);
				
				
			}
		});
		reset.setFont(new Font("Times New Roman", Font.BOLD, 28));
		reset.setBackground(Color.DARK_GRAY);
		reset.setBounds(92, 602, 127, 35);
		frame.getContentPane().add(reset);
		
		JLabel resetlbwarn = new JLabel("(You can reset only before confirming booking!)");
		resetlbwarn.setForeground(new Color(0, 0, 128));
		resetlbwarn.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		resetlbwarn.setBounds(10, 640, 327, 20);
		frame.getContentPane().add(resetlbwarn);
		
		JLabel wallpaper5 = new JLabel("");
		wallpaper5.setIcon(new ImageIcon("C:\\Users\\Nevil\\Downloads\\NIDHI - SE-sem3 2020\\sem3 mini project\\Pictures\\picHOTELS.jpg"));
		wallpaper5.setBounds(6, 0, 1012, 707);
		frame.getContentPane().add(wallpaper5);
		
		

		
		
	}
}
