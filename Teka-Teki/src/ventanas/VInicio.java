package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.GestorJugadores;
import codigo.Jugador;
import codigo.Sesion;
import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class VInicio extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField txtIntroduceTuNombre;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lblRegistrarse;
	private JFrame anterior = this;

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
		setTitle("TEKA-TEKI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[37.00][31.00][39.00][14.00][][21.00][219.00,grow][80.00][][][29.00]", "[][][][35.00][35.00][35.00]"));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("sources/logo2.PNG"));
		contentPane.add(lblNewLabel_1, "cell 6 0");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("sources/user.PNG"));

		contentPane.add(lblNewLabel, "cell 5 1");
		
		txtIntroduceTuNombre = new JTextField();
		contentPane.add(txtIntroduceTuNombre, "cell 6 1,grow");
		txtIntroduceTuNombre.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("sources/pass.png"));
		contentPane.add(label, "cell 5 2,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 6 2,grow");
		
		btnNewButton = new JButton("INICIAR SESI\u00D3N");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnNewButton, "cell 6 3,grow");
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
		String user = txtIntroduceTuNombre.getText();
		String pass = new String(passwordField.getPassword());
		Boolean continua = true;
		
		
		
		
		// Campo usuario vacio
		if(!(user.equals("") )){
			System.out.println("usuario no vacio");
			if (!pass.equals("")){
				System.out.println("pass no vacio");
			}else{
				System.out.println("pass vacio");
				JOptionPane.showMessageDialog(null,"La contraseña no puede estar vacía en Identificación");
				continua = false;
			}
		}else{
			System.out.println("usuario vacio");
			JOptionPane.showMessageDialog(null,"Revisa el campo nombre de Identificación");
			continua = false;
		}
		

		boolean cargarventana = false;
		if (continua){
		// Si todo ha ido bien, y no hay ninguna X roja.
			try {
				System.out.println(GestorJugadores.getGestorJugadores().Identificarse(user, pass));
				switch (GestorJugadores.getGestorJugadores().Identificarse(user, pass)){
					case -1:
						// password incorrecta
						JOptionPane.showMessageDialog(null, "La contraseña que ha introducido en Identificación es incorrecta");

						break;
					case 0:
						// todo correcto
						//JOptionPane.showMessageDialog(null, "Todo correcto");


						setVisible(false);
						cargarventana = true;								
						break;
					case 1:
						// usuario desconocido

						JOptionPane.showMessageDialog(null,"Este usuario no ha sido registrado aún");
						break;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Algo ha fallado");
			}
		}
		
		if (cargarventana){
			// Cargo la ventana login si todo correcto
			// Creamos elJugador, y iniciamos sesion pasando elJugador y nivel cero porque no juega aun
				Jugador mijugador = new Jugador(user);
				Sesion.getSesion().iniciarSesion(mijugador, 0);
				
			// Carga la ventana
				VMenu vL = new VMenu(null, user);
				vL.setLocationRelativeTo(null);
				vL.setVisible(true);
				
		}

	}});
		
		
		
		
		
		
		lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setForeground(Color.BLUE);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(lblRegistrarse, "cell 6 5,alignx center");
		
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				
				VRegistro pS = new VRegistro(anterior);
				pS.setLocationRelativeTo(null);
				pS.setVisible(true);
				setVisible(false);
			}
		});
	}
}
