package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class VRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private JLabel lblTerminos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistro frame = new VRegistro(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param anterior 
	 */
	public VRegistro(JFrame anterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][228.00,grow][25.00][31.00][]", "[][35.00][35.00][35.00][35.00][35.00]"));
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.LIGHT_GRAY);
		txtNombre.setText("Nombre de usuario");
		contentPane.add(txtNombre, "cell 3 1,grow");
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(Color.LIGHT_GRAY);
		txtCorreo.setText("E-mail");
		contentPane.add(txtCorreo, "cell 3 2,grow");
		txtCorreo.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setText("Password");
		contentPane.add(txtPassword, "cell 3 3,grow");
		txtPassword.setColumns(10);
		
		JLabel lblClicandoEncrear = new JLabel("Clicando en \"Crear mi cuenta\" aceptas los");
		contentPane.add(lblClicandoEncrear, "flowx,cell 3 4");
		
		JButton btnRegistrar = new JButton("Crear mi cuenta");
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		contentPane.add(btnRegistrar, "cell 3 5,grow");
		
		lblTerminos = new JLabel("Terminos y Condiciones");
		lblTerminos.setForeground(Color.BLUE);
		contentPane.add(lblTerminos, "cell 3 4");
	}

}
