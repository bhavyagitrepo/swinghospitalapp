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
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class Frame3 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailIdVar;
	private JFormattedTextField todayVar;
	private JComboBox<String> illnessVar;
	private JComboBox<String> doctorVar;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 frame = new Frame3();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Frame3() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("Book Your Appointment");
		lbl1.setForeground(new Color(128, 128, 128));
		lbl1.setFont(new Font("Algerian", Font.PLAIN, 40));
		lbl1.setBounds(184, 22, 519, 43);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("Choose Date of Appointment");
		lbl2.setForeground(new Color(128, 128, 128));
		lbl2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl2.setBounds(196, 77, 282, 35);
		contentPane.add(lbl2);

		JLabel lbl6 = new JLabel("Describe Your Issue");
		lbl6.setForeground(new Color(128, 128, 128));
		lbl6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl6.setBounds(196, 403, 190, 43);
		contentPane.add(lbl6);

		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textArea.setBounds(543, 355, 378, 170);
		contentPane.add(textArea);
		textArea.setToolTipText("Provide additional information if any");

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {

				int Appointment_id = 0;
				String date = todayVar.getText();
				String illness = illnessVar.getSelectedItem().toString();
				String doctor = (String) doctorVar.getSelectedItem();
				String emailId = emailIdVar.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
							"root");

					Statement stm = con.createStatement();
					Statement sta = con.createStatement();
					//Statement st = con.createStatement();

					String sql = "select * from accounts where emailId='" + emailId + "'";
					//String sql1 = "select * from appointments where illness='" + illness + "'";
					ResultSet rs = stm.executeQuery(sql);
					//ResultSet rs1 = st.executeQuery(sql1);

//					if (rs.next() == true /*&& rs1.next() == true*/) {
//						JOptionPane.showMessageDialog(null, "you have already made an appointment with " + doctor
//								+ " reschedule if needed");
					//} 
				 if (rs.next()) {
						JOptionPane.showMessageDialog(null,
								"Your Appointment is scheduled with " + doctor + " on " + date);
						String query = "INSERT INTO appointments values('" + emailId + "','" + date + "','" + illness
								+ "','" + Appointment_id + "')";
						sta.executeUpdate(query);
						dispose();
						Frame2 frm2 = new Frame2();
						frm2.setVisible(true);

					} else {

						JOptionPane.showMessageDialog(null, "This email is not registered!");
						emailIdVar.setText("");
					}

				} catch (Exception e) {
				}
			}
		});
		// btnNewButton.setActionCommand("back");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnNewButton.setBounds(144, 588, 205, 29);
		contentPane.add(btnNewButton);

		illnessVar = new JComboBox();
		illnessVar.addItem("Dizziness");
		illnessVar.addItem("Ear Infection");
		illnessVar.addItem("Hearing Aids");
		illnessVar.addItem("Hearing Loss");
		illnessVar.addItem("Snoring");
		illnessVar.addItem("Sinus");
		illnessVar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		illnessVar.setBounds(674, 148, 247, 26);
		contentPane.add(illnessVar);
		illnessVar.setEditable(true);

		JLabel lbl3 = new JLabel("Illness");
		lbl3.setForeground(new Color(128, 128, 128));
		lbl3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl3.setBounds(196, 144, 282, 35);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("Choose your specialist");
		lbl4.setForeground(new Color(128, 128, 128));
		lbl4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl4.setBounds(196, 213, 282, 35);
		contentPane.add(lbl4);

		doctorVar = new JComboBox();
		doctorVar.addItem("Dr.Alex");
		doctorVar.addItem("Dr.Bheem");
		doctorVar.addItem("Dr.Nobitha");
		doctorVar.addItem("Dr.Shizuka");
		doctorVar.addItem("Dr.Kavitha");
		doctorVar.addItem("Dr.Sundhari");
		doctorVar.addItem("Dr.Ramu");
		doctorVar.addItem("Dr.Ravi");
		doctorVar.addItem("Dr.Sulochana");

		doctorVar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		doctorVar.setBounds(674, 217, 247, 26);
		contentPane.add(doctorVar);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(0, 0, 128));
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnCancel.setActionCommand("back");
		btnCancel.setBounds(439, 588, 205, 29);
		contentPane.add(btnCancel);

		JLabel lbl5 = new JLabel("Enter Your registered Email ");
		lbl5.setForeground(new Color(128, 128, 128));
		lbl5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lbl5.setBounds(196, 280, 282, 35);
		contentPane.add(lbl5);

		emailIdVar = new JTextField();
		emailIdVar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		emailIdVar.setBounds(674, 280, 247, 35);
		contentPane.add(emailIdVar);
		emailIdVar.setColumns(10);

		todayVar = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.LONG));
		todayVar.setValue(new Date());
		contentPane.add(todayVar);
		todayVar.setBounds(674, 81, 247, 26);
		todayVar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JButton btnRescheduel = new JButton("Reschedule");
		btnRescheduel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRescheduel.setForeground(new Color(0, 0, 128));
		btnRescheduel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		btnRescheduel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		btnRescheduel.setActionCommand("back");
		btnRescheduel.setBounds(716, 588, 205, 29);
		contentPane.add(btnRescheduel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
