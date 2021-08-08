package package1;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Frame1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6251550232877292669L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextArea emailId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
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
	public Frame1() {
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(-14, -47, 1015, 734);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl1 = new JLabel("Email Id");
		lbl1.setForeground(new Color(0, 0, 128));
		lbl1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lbl1.setBounds(466, 252, 107, 39);
		panel.add(lbl1);

		JLabel lbl3 = new JLabel("Password");
		lbl3.setForeground(new Color(0, 0, 128));
		lbl3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lbl3.setBounds(466, 353, 107, 39);
		panel.add(lbl3);

		passwordField = new JPasswordField();
		passwordField.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 128), new Color(0, 0, 128)));
		passwordField.setAutoscrolls(false);
		passwordField.setFocusTraversalKeysEnabled(false);
		passwordField.setBackground(new Color(248, 248, 255));
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		passwordField.setBounds(625, 356, 317, 33);
		panel.add(passwordField);

		JButton btn1 = new JButton("Sign Up");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame4 frm4 = new Frame4();
				frm4.setVisible(true);
			}
		});
		btn1.setBackground(new Color(248, 248, 255));
		btn1.setForeground(new Color(0, 0, 128));
		btn1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btn1.setBounds(656, 512, 115, 29);
		panel.add(btn1);

		emailId = new JTextArea();
		emailId.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 128), new Color(0, 0, 128)));
		emailId.setSelectionColor(new Color(245, 255, 250));
		emailId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		emailId.setBounds(625, 258, 317, 30);
		panel.add(emailId);

		JLabel lbl2 = new JLabel("Swing ENT Hospital");
		lbl2.setForeground(new Color(0, 0, 139));
		lbl2.setFont(new Font("Algerian", Font.PLAIN, 45));
		lbl2.setBackground(new Color(248, 248, 255));
		lbl2.setBounds(450, 71, 529, 83);
		panel.add(lbl2);

		JButton btn2 = new JButton("Sign In");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
					@SuppressWarnings("deprecation")
					String password = passwordField.getText();
					String email = emailId.getText();

					Statement stm = con.createStatement();

					String sql = "select * from accounts where emailId='" + email + "' and passwordField='"
							+ password + "'";
					ResultSet rs = stm.executeQuery(sql);

					if (rs.next()) {
						Frame2 frm2 = new Frame2();
						frm2.setVisible(true);
						dispose();

					} else {

						JOptionPane.showMessageDialog(null, "Invalid credentials");
						emailId.setText("");
						passwordField.setText("");
					}

				} catch (Exception e) {
				}
			}
		});
		btn2.setForeground(new Color(0, 0, 128));
		btn2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btn2.setBackground(new Color(248, 248, 255));
		btn2.setBounds(466, 512, 115, 29);
		panel.add(btn2);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(0, 0, 128));
		btnCancel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnCancel.setBackground(new Color(248, 248, 255));
		btnCancel.setBounds(841, 513, 115, 29);
		panel.add(btnCancel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\doctor1.jpg"));
		lblNewLabel.setBounds(-54, 44, 1054, 654);
		panel.add(lblNewLabel);
	}
}
