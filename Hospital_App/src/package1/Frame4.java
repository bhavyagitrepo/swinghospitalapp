package package1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frame4 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField emailId;
	private JTextField lastName;
	private JTextField phnNumber;
	private JPasswordField passwordField;
	private static JTextField userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 frame = new Frame4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame4() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New User Registration");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 40));
		lblNewLabel.setBounds(240, 16, 481, 58);
		contentPane.add(lblNewLabel);

		JLabel lbl1 = new JLabel("First Name");
		lbl1.setForeground(new Color(128, 128, 128));
		lbl1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl1.setBounds(15, 175, 149, 41);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("Last Name");
		lbl2.setForeground(new Color(128, 128, 128));
		lbl2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl2.setBounds(521, 175, 149, 41);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("Email ID");
		lbl3.setForeground(new Color(128, 128, 128));
		lbl3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl3.setBounds(15, 291, 98, 41);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("Phone Number");
		lbl4.setForeground(new Color(128, 128, 128));
		lbl4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl4.setBounds(522, 291, 174, 41);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("Password");
		lbl5.setForeground(new Color(128, 128, 128));
		lbl5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl5.setBounds(15, 401, 149, 41);
		contentPane.add(lbl5);

		firstName = new JTextField();
		firstName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		firstName.setBounds(237, 183, 177, 26);
		contentPane.add(firstName);
		firstName.setColumns(10);

		emailId = new JTextField();
		emailId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		emailId.setColumns(10);
		emailId.setBounds(240, 299, 174, 26);
		contentPane.add(emailId);

		lastName = new JTextField();
		lastName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lastName.setColumns(10);
		lastName.setBounds(749, 183, 199, 26);
		contentPane.add(lastName);

		phnNumber = new JTextField();
		phnNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		phnNumber.setColumns(10);
		phnNumber.setBounds(749, 299, 199, 26);
		contentPane.add(phnNumber);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		passwordField.setBounds(237, 409, 177, 26);
		contentPane.add(passwordField);

		JButton registerBtn = new JButton("Register");
		registerBtn.setForeground(new Color(0, 0, 128));
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Fname = firstName.getText();
				String Lname = lastName.getText();
				String Email = emailId.getText();
				String Uname = userName.getText();
				@SuppressWarnings("deprecation")
				String Pwd = passwordField.getText();
				String PhoneNumber = phnNumber.getText();
				String phnRegex = "^[6789]\\d{9}$";
				boolean phnResult = PhoneNumber.matches(phnRegex);
				String mailRegex = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9.-]+$";
				boolean mresult = Email.matches(mailRegex);
				String pwdRegex = "^*.(?=.{8,}).*$";
				boolean presult = Pwd.matches(pwdRegex);

				if (Fname.isEmpty()) {
					JOptionPane.showMessageDialog(null, "First name should not be empty");
				}
				if (Lname.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Last name should not be empty");
				}
				if (!phnResult) {
					JOptionPane.showMessageDialog(null, "Invalid Phone Number");
				}
				if (!mresult) {
					JOptionPane.showMessageDialog(null, "EmailID entered is not valid");
				}
				if (!presult) {
					JOptionPane.showMessageDialog(null, "Password should contain atleast 8 characters ");
				}
				if (Uname == "") {
					JOptionPane.showMessageDialog(null, "User name is mandatory in order to register");
				}
				if ((Fname.isEmpty()) || (Lname.isEmpty()) || !mresult || !presult || !phnResult) {
					JOptionPane.showMessageDialog(null, "Form should be filled appropriately inorder to register!");
				} else {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
								"root", "root");
						Statement sta = connection.createStatement();

						String selectQuery = "select * from accounts where emailId='" + Email + "'";
						ResultSet rs = sta.executeQuery(selectQuery);
						if (rs.next() == true) {
							JOptionPane.showMessageDialog(null, "This Email is already registered");
						} else {
							String query = "INSERT INTO accounts values('" + Fname + "','" + Lname + "','" + PhoneNumber
									+ "','" + Uname + "','" + Email + "','" + Pwd + "')";
							sta.executeUpdate(query);
							JOptionPane.showMessageDialog(registerBtn,
									"Welcome, " + Fname + " Your account is sucessfully created");
							dispose();
							Frame1 frm1  = new Frame1();
							frm1.setVisible(true);
//							String cmd = e.getActionCommand();
//							if (cmd.equals("back")) {
//								dispose();
//							}
						}
						connection.close();
					} catch (Exception exception) {
//						exception.printStackTrace();
					}
				}
			}
		});
		registerBtn.setActionCommand("back");
		registerBtn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		registerBtn.setBounds(137, 506, 186, 41);
		contentPane.add(registerBtn);

		JButton resetBtn = new JButton("Reset");
		resetBtn.setForeground(new Color(0, 0, 128));
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame4 frm4 = new Frame4();
				frm4.setVisible(true);
			}
		});
		resetBtn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		resetBtn.setActionCommand("back");
		resetBtn.setBounds(426, 506, 186, 41);
		contentPane.add(resetBtn);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(128, 128, 128));
		lblUserName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lblUserName.setBounds(521, 401, 119, 41);
		contentPane.add(lblUserName);

		userName = new JTextField();
		userName.setBounds(749, 411, 199, 26);
		contentPane.add(userName);
		userName.setColumns(10);

		JButton btnCancel = new JButton("cancel");
		btnCancel.setForeground(new Color(0, 0, 128));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnCancel.setActionCommand("back");
		btnCancel.setBounds(690, 506, 186, 41);
		contentPane.add(btnCancel);
	}
}
