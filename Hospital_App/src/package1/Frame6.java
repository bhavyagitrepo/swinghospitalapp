package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Frame6 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2674820112443314431L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame6 frame = new Frame6();
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
	public Frame6() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JTextArea txtrDizzinessDizzinessIs = new JTextArea();
		txtrDizzinessDizzinessIs.setEditable(false);
		txtrDizzinessDizzinessIs.setForeground(new Color(128, 128, 128));
		txtrDizzinessDizzinessIs.setBackground(new Color(0, 0, 128));
		txtrDizzinessDizzinessIs.setText(
				"Dizziness\r\nDizziness is a term used to describe a range of sensations, such as feeling \r\nfaint, woozy, weak or unsteady.Dizziness that creates the false \r\nsense that you or your surroundings are spinning or moving is called vertigo.\r\n\r\nDizziness is one of the more common reasons adults visit their doctors. \r\nFrequent dizzy spells or constant dizziness can significantly affect your life. \r\nBut dizziness rarely signals a life-threatening condition.\r\n\r\nTreatment of dizziness depends on the cause and your symptoms.\r\n It's usually effective, but the problem may recur.\r\n\r\near infection\r\nAn ear infection (sometimes called acute otitis media) is an infection of the \r\nmiddle ear, the air-filled space behind the eardrum that contains the tiny \r\nvibrating bones of the ear. Children are more likely than adults to get\r\n ear infections.\r\n\r\nBecause ear infections often clear up on their own, treatment may begin \r\nwith managing pain and monitoring the problem. Sometimes, \r\nantibiotics are used to clear the infection. Some people are prone to having\r\n multiple ear infections. This can cause hearing problems and other serious \r\ncomplications.\r\n\r\nhearing aid\r\nA hearing aid is a small electronic device that you wear in or behind your ear.\r\n It makes some sounds louder so that a person with hearing loss can listen, \r\ncommunicate, and participate more fully in daily activities. \r\nA hearing aid can help people hear more in both quiet and noisy situations. \r\nHowever, only about one out of five people who would benefit from \r\na hearing aid actually uses one.\r\n\r\nA hearing aid has three basic parts: a microphone, amplifier, \r\nand speaker. The hearing aid receives sound through a microphone, \r\nwhich converts the sound waves to electrical signals and sends \r\nthem to an amplifier. The amplifier increases the power of the \r\nsignals and then sends them to the ear through a speaker.\r\n\r\nhearing loss\r\nA person is said to have hearing loss if they are not able \r\nto hear as well as someone with normal hearing, meaning hearing\r\n thresholds of 20 dB or better in both ears. It can be mild, moderate, \r\nmoderately severe, severe or profound, and can affect one or both ears. \r\nMajor causes of hearing loss include congenital or early onset childhood \r\nhearing loss, chronic middle ear infections, noise-induced hearing loss,\r\n age-related hearing loss, and ototoxic drugs that damage the inner ear.\r\n\r\nsnoring\r\nSnoring is the hoarse or harsh sound that occurs when air flows past relaxed\r\n tissues in your throat, causing the tissues to vibrate as you breathe. \r\nNearly everyone snores now and then, but for some people it\r\n can be a chronic problem. Sometimes it may also indicate a serious \r\nhealth condition. In addition, snoring can be a nuisance to your partner.\r\n\r\nLifestyle changes, such as losing weight, avoiding alcohol close to \r\nbedtime or sleeping on your side, can help stop snoring.\r\n\r\nIn addition, medical devices and surgery are available that may \r\nreduce disruptive snoring. However, these aren't suitable or necessary\r\n for everyone who snores.\r\n\r\nsinus\r\nA sinus is a hollow space in the body. There are many types of sinuses, \r\nbut sinusitis affects the paranasal sinuses, \r\nthe spaces behind the face that lead to the nasal cavity.\r\n\r\nThe lining of these sinuses has the same composition as the lining of the nose. \r\nThe sinuses produce a slimy secretion called mucus. T\r\nhis mucus keeps the nasal passages moist and traps dirt particles and germs.\r\n\r\nSinusitis occurs when mucus builds up, and the sinuses become irritated \r\nand inflamed.\r\n\r\nDoctors often refer to sinusitis as rhinosinusitis because inflammation \r\nof the sinuses nearly always occurs with rhinitis, which is an inflammation \r\nof the nose.");
		txtrDizzinessDizzinessIs.setFont(new Font("Monospaced", Font.PLAIN, 22));
		scrollPane.setViewportView(txtrDizzinessDizzinessIs);

		JButton btnNewButton = new JButton("Back to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame2 frm2 = new Frame2();
				frm2.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 128), new Color(0, 0, 128)));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		scrollPane.setColumnHeaderView(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, BorderLayout.EAST);

	}
}
