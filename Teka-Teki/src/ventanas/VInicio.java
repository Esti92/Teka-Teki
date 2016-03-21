package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class VInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lblRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInicio frame = new VInicio();
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
	public VInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[37.00][31.00][39.00][14.00][][21.00][219.00,grow][80.00][][][29.00]", "[][][][35.00][35.00][35.00]"));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\YERAY\\git\\Teka-Teki\\Teka-Teki\\logo2.PNG"));
		contentPane.add(lblNewLabel_1, "cell 6 0");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\YERAY\\git\\Teka-Teki\\Teka-Teki\\user.png"));
		contentPane.add(lblNewLabel, "cell 5 1");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 6 1,grow");
		textField.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\YERAY\\git\\Teka-Teki\\Teka-Teki\\pass.png"));
		contentPane.add(label, "cell 5 2,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 6 2,grow");
		
		btnNewButton = new JButton("INICIAR SESI\u00D3N");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnNewButton, "cell 6 3,grow");
		
		lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setForeground(Color.BLUE);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblRegistrarse, "cell 6 5,alignx center");
	}

}
