package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class VMenu extends JFrame {

	private JPanel contentPane;
	private JFrame anterior = this;
	private String user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMenu frame = new VMenu(null, null);
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
	public VMenu(JFrame vtn, String _user) {
		user = _user;
		setTitle("MENU DEL JUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 195, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[51.00][162.00]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1,alignx center,growy");
		panel.setLayout(new MigLayout("", "[]", "[][][][]"));
		
		JButton btnJugar = new JButton("Jugar");
		panel.add(btnJugar, "cell 0 0,alignx center");
		
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				setVisible(false);
				VNivel pS = new VNivel(anterior, user);
				pS.setLocationRelativeTo(null);
				pS.setVisible(true);
			}
		});
		
		JButton btnRetar = new JButton("Retar");
		panel.add(btnRetar, "cell 0 1,alignx center");
		
		btnRetar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				setVisible(false);
				VElegirRetado pS;
				try {
					pS = new VElegirRetado(anterior, user);
					pS.setLocationRelativeTo(null);
					pS.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnPuntuacion = new JButton("Puntuacion");
		panel.add(btnPuntuacion, "cell 0 2,alignx center");
		
		btnPuntuacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				setVisible(false);
				PuntuacionClass pS;
				try {
					pS = new PuntuacionClass(anterior);
					pS.setLocationRelativeTo(null);
					pS.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
	}

}
