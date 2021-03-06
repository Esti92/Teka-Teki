package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class VNivel extends JFrame {

	private JPanel contentPane;
	int nivel = 0;
	private String user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VNivel frame = new VNivel(null, null);
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
	public VNivel(JFrame vtn, String _user) {
		user = _user;
		setTitle("NIVELES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 195, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[51.00][162.00]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1,alignx center,growy");
		panel.setLayout(new MigLayout("", "[]", "[][][][]"));
		
		JButton btnNivelBajo = new JButton("Nivel bajo (1)");
		panel.add(btnNivelBajo, "cell 0 0,alignx center");
		
		btnNivelBajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana
				nivel = 1;
				setVisible(false);
				VJuego pS = new VJuego(vtn, nivel, user);
				pS.setLocationRelativeTo(null);
				pS.setVisible(true);
			}
		});
		
		JButton btnNivelMedio = new JButton("Nivel Medio (2)");
		panel.add(btnNivelMedio, "cell 0 1,alignx center");
		
		btnNivelMedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				nivel = 2;
				setVisible(false);
				VJuego pS = new VJuego(vtn, nivel, user);
				pS.setLocationRelativeTo(null);
				pS.setVisible(true);
			}
		});
		
		JButton btnNivelDificil = new JButton("Nivel Dificil (3)");
		panel.add(btnNivelDificil, "cell 0 2,alignx center");
		
		btnNivelDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana
				nivel = 3;
				setVisible(false);
				VJuego pS = new VJuego(vtn, nivel, user);
				pS.setLocationRelativeTo(null);
				pS.setVisible(true);
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		panel.add(btnAtras, "cell 0 3,alignx center");
		
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				setVisible(false);
				vtn.setVisible(true);
			}
		});
		
	}
}
