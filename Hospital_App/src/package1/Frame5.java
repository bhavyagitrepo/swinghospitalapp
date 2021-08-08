package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class Frame5 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 555110962963262051L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame5 frame = new Frame5();
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
	public Frame5() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);

		String data[][] = { { "Dr.Alex", "670", "1 years" }, { "Dr.Bheem", "780", "6 years" },
				{ "Dr.Nobitha", "700", "10 years" }, { "Dr.Shizuka", "700", "11 years" },
				{ "Dr.Sundhari", "700", "9 years" }, { "Dr.Kavitha", "700", "17 years" },
				{ "Dr.Ramu", "1100", "3 years" }, { "Dr.Ravi", "1700", "5 years" },
				{ "Dr.Sulochana", "700", "7 years" } };
		String column[] = { "NAME", "Fee", "Experience" };
		table = new JTable(data, column);
		table.setRowMargin(2);
		table.setRowHeight(25);
		table.setPreferredSize(new Dimension(45, 100));
		table.setMinimumSize(new Dimension(40, 100));
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBounds(new Rectangle(0, 0, 2, 2));
		table.setGridColor(new Color(0, 0, 128));
		table.setMaximumSize(new Dimension(2147483, 100));
		table.setModel(new DefaultTableModel(new Object[][] { { "Dr.Alex", "670", "1 years" },
				{ "Dr.Bheem", "780", "6 years" }, { "Dr.Nobitha", "700", "10 years" },
				{ "Dr.Shizuka", "700", "11 years" }, { "Dr.Sundhari", "700", "9 years" },
				{ "Dr.Kavitha", "700", "17 years" }, { "Dr.Ramu", "1100", "3 years" }, { "Dr.Ravi", "1700", "5 years" },
				{ "Dr.Sulochana", "700", "7 years" }, }, new String[] { "NAME", "Fee", "Experience" }));
		// JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(table.getTableHeader(), BorderLayout.PAGE_START);
		contentPane.add(table, BorderLayout.CENTER);
		table.setBounds(15, 244, 952, -210);

		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame2 frm2 = new Frame2();
				frm2.setVisible(true);

			}
		});
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.setMinimumSize(new Dimension(5, 29));
		btnNewButton.setMaximumSize(new Dimension(5, 29));
		btnNewButton.setPreferredSize(new Dimension(0, 29));
		btnNewButton.setSize(new Dimension(5, 5));
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\890461\\OneDrive - Cognizant\\Desktop\\images\\plain.jpg"));
//		lblNewLabel.setBounds(0, 0, 992, 655);
//		contentPane.add(lblNewLabel);
	}
}
