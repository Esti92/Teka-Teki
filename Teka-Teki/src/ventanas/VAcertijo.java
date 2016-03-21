package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAcertijo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtRespuesta;
	private JPanel panel;
	private JButton atras;
	private JButton resolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAcertijo frame = new VAcertijo();
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
	public VAcertijo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px,grow]", "[47.00][95.00][38.00,grow][81.00][35.00px,grow]"));
		
		txtTitulo = new JTextField();
		txtTitulo.setText("titulo");
		contentPane.add(txtTitulo, "cell 0 0,alignx center,aligny center");
		txtTitulo.setColumns(10);
		
		JLabel lblFoto = new JLabel("foto");
		contentPane.add(lblFoto, "cell 0 1,alignx center,aligny center");
		
		JTextPane txtpnDescripcion = new JTextPane();
		txtpnDescripcion.setText("descripcion");
		contentPane.add(txtpnDescripcion, "cell 0 2,alignx center,aligny center");
		
		txtRespuesta = new JTextField();
		txtRespuesta.setText("respuesta");
		contentPane.add(txtRespuesta, "cell 0 3,alignx center,aligny center");
		txtRespuesta.setColumns(10);
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 4,grow");
		panel.setLayout(new MigLayout("", "[182.00][213.00]", "[]"));
		
		atras = new JButton("ATRAS");
		panel.add(atras, "cell 0 0,alignx center,aligny center");
		
		resolver = new JButton("RESOLVER");
		panel.add(resolver, "cell 1 0,alignx center,aligny center");
	}

}
