package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
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
		
		
		JButton Ac1 = new JButton();
		ImageIcon iconoAc1 = new ImageIcon("");
		Ac1.setIcon(iconoAc1);
		panel.add(Ac1, "cell 2 2");
		
		JButton Ac2 = new JButton();
		ImageIcon iconoAc2 = new ImageIcon("");
		Ac2.setIcon(iconoAc2);
		panel.add(Ac2, "cell 2 2");
		
		JButton Ac3 = new JButton();
		ImageIcon iconoAc3 = new ImageIcon("");
		Ac3.setIcon(iconoAc3);
		panel.add(Ac3, "cell 2 2");
		
		JButton Ac4 = new JButton();
		ImageIcon iconoAc4 = new ImageIcon("");
		Ac4.setIcon(iconoAc4);
		panel.add(Ac4, "cell 2 2");
		
		JButton Ac5 = new JButton();
		ImageIcon iconoAc5 = new ImageIcon("");
		Ac5.setIcon(iconoAc5);
		panel.add(Ac5, "cell 2 2");
		
		JButton Ac6 = new JButton();
		ImageIcon iconoAc6 = new ImageIcon("");
		Ac6.setIcon(iconoAc6);
		panel.add(Ac6, "cell 2 2");
		
		JButton Ac7 = new JButton();
		ImageIcon iconoAc7 = new ImageIcon("");
		Ac7.setIcon(iconoAc7);
		panel.add(Ac7, "cell 2 2");
		
		JButton Ac8 = new JButton();
		ImageIcon iconoAc8 = new ImageIcon("");
		Ac8.setIcon(iconoAc8);
		panel.add(Ac8, "cell 2 2");
		
		JButton Ac9 = new JButton();
		ImageIcon iconoAc9 = new ImageIcon("");
		Ac9.setIcon(iconoAc9);
		panel.add(Ac9, "cell 2 2");
		
		
		
		/*
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
		*/
		JButton btnNewButton1 = new JButton("VOLVER");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton1, BorderLayout.SOUTH);
	}

}
