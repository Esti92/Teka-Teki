package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import codigo.GestorJugadores;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		contentPane.add(btnRegistrar, "cell 3 5,grow");
		
		lblTerminos = new JLabel("Terminos y Condiciones");
		lblTerminos.setForeground(Color.BLUE);
		contentPane.add(lblTerminos, "cell 3 4");
//	}

	
	
	
	
	
		btnRegistrar.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			/*
			 * TO-DO:	Comprobar campos no nulos
			 * 			Llamar al método: registrarse (user, password, confirmedPass, email) 
			 */
			String user = txtNombre.getText();
			String pass = txtPassword.getText();
			
			String email = txtCorreo.getText();
			Boolean continua = true;
			btnRegistrar.setEnabled(false);
			
			// Cargando

			
			//JTextComponent txtNombreId;
			// Vacio la información residual
			/*txtNombreId.setText("");
			JTextComponent txtPassId;
			txtPassId.setText("");
			AbstractButton cargandoNombreId;
			cargandoNombreId.setIcon(null);
			AbstractButton cargandoPassId;
			cargandoPassId.setIcon(null);
			JTextComponent lblInformacion;
			lblInformacion.setText("");
			AbstractButton cargando;
			cargando.setIcon(null);*/
			
			// Campo usuario vacio
			if(!(user.equals("") || user.equals("Nombre de usuario"))){
				if ((pass.equals("Password") || pass.equals(""))){
					// Si las contraseñas no coinciden, no continua y le dice error.
					JOptionPane.showMessageDialog(null,"Estan vacias.");

					continua = false;
					btnRegistrar.setEnabled(true);
				}else{
					if (email.equals("") || email.equals("E-mail")){
						JOptionPane.showMessageDialog(null,"El campo de email está vacio.");

						continua = false;
						btnRegistrar.setEnabled(true);
					}
				}
			}else{
				// Nombre de usuario de registro vacio
				JOptionPane.showMessageDialog(null,"Verifica que el campo nombre de Registro no este vacío.");

				continua = false;
				btnRegistrar.setEnabled(true);
			}
			
			if (continua){
				try {
					int resultado = GestorJugadores.getGestorJugadores().Registrarse(user, pass, email);
					if (resultado==0){
						// todo ha ido bien
						JOptionPane.showMessageDialog(null,"Muy bien "+user+", has sido registrado como Jugador");
//						Thread.sleep(200);
						VMenu vL = new VMenu(null, user);
						vL.setLocationRelativeTo(null);
						vL.setVisible(true);
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null,"¡Vaya! "+user+" parece que ya estás registrado.");
//						Thread.sleep(200);

					}
					btnRegistrar.setEnabled(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
//				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	});
}}
