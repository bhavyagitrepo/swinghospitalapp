package package1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3694505973077742300L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
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
	public Frame2() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Book Your Appointment ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame3 frm3 = new Frame3();
				frm3.setVisible(true);

			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setBounds(342, 134, 286, 56);
		contentPane.add(btnNewButton);

		JButton btnViewAvailableDoctors = new JButton("View Available Doctors ");
		btnViewAvailableDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame5 frm5 = new Frame5();
				frm5.setVisible(true);
			}
		});
		btnViewAvailableDoctors.setBorder(null);
		btnViewAvailableDoctors.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnViewAvailableDoctors.setBackground(new Color(102, 205, 170));
		btnViewAvailableDoctors.setBounds(342, 253, 286, 56);
		contentPane.add(btnViewAvailableDoctors);

		JButton btnKnowAboutYour = new JButton("Know About Your Ailment");
		btnKnowAboutYour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame6 frm6 = new Frame6();
				frm6.setVisible(true);
			}
		});
		btnKnowAboutYour.setBorder(null);
		btnKnowAboutYour.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnKnowAboutYour.setBackground(new Color(102, 205, 170));
		btnKnowAboutYour.setBounds(342, 386, 286, 56);
		contentPane.add(btnKnowAboutYour);

		JButton btnPolicyOfSwing = new JButton("Back To Main Menu");
		btnPolicyOfSwing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame1 frm1 = new Frame1();
				frm1.setVisible(true);
			}
		});
		btnPolicyOfSwing.setBorder(null);
		btnPolicyOfSwing.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnPolicyOfSwing.setBackground(new Color(102, 205, 170));
		btnPolicyOfSwing.setBounds(15, 524, 286, 56);
		contentPane.add(btnPolicyOfSwing);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogout.setBorder(null);
		btnLogout.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnLogout.setBackground(new Color(102, 205, 170));
		btnLogout.setBounds(694, 524, 286, 56);
		contentPane.add(btnLogout);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\doctor6.jpg"));
		lblNewLabel_1.setForeground(new Color(102, 205, 170));
		lblNewLabel_1.setBackground(new Color(102, 205, 170));
		lblNewLabel_1.setBounds(0, 0, 206, 604);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\doctor6.jpg"));
		lblNewLabel_2.setBounds(766, 0, 228, 575);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\doctor6.jpg"));
		lblNewLabel_3.setBounds(0, 524, 567, 286);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\doctor6.jpg"));
		lblNewLabel_4.setBounds(553, 524, 639, 324);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Welcome to Swing ENT");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 40));
		lblNewLabel.setBounds(247, 26, 530, 66);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\doctor6.jpg"));
		lblNewLabel_5.setBounds(205, 0, 564, 526);
		contentPane.add(lblNewLabel_5);
	}
}
