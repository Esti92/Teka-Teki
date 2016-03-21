package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VJuego extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VJuego frame = new VJuego();
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
	public VJuego() {
		setTitle("EMPIEZA A JUGAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("acertijo1");
		panel.add(lblNewLabel, "cell 2 2");
		
		JLabel lblNewLabel_2 = new JLabel("acertijo2");
		panel.add(lblNewLabel_2, "cell 6 2");
		
		JLabel lblNewLabel_1 = new JLabel("acertijo3");
		panel.add(lblNewLabel_1, "cell 10 2");
		
		JLabel lblNewLabel_3 = new JLabel("acertijo4");
		panel.add(lblNewLabel_3, "cell 2 4");
		
		JLabel lblNewLabel_5 = new JLabel("acertijo5");
		panel.add(lblNewLabel_5, "cell 6 4");
		
		JLabel lblNewLabel_7 = new JLabel("acertijo6");
		panel.add(lblNewLabel_7, "cell 10 4");
		
		JLabel lblNewLabel_4 = new JLabel("acertijo7");
		panel.add(lblNewLabel_4, "cell 2 6");
		
		JLabel lblNewLabel_6 = new JLabel("acertijo8");
		panel.add(lblNewLabel_6, "cell 6 6");
		
		JLabel lblNewLabel_8 = new JLabel("acertijo9");
		panel.add(lblNewLabel_8, "cell 10 6");
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
