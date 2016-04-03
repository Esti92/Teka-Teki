package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import codigo.Conexion;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class VAcertijo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtRespuesta;
	private JPanel panel;
	private JButton atras;
	private JButton resolver;

	private int nivel = 0, imagen = 0;
	private String respuesta = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static Connection con;
	private String user;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */	
	public VAcertijo(JFrame vtp, int _nivel, int _imagen, String _user) throws SQLException {
		nivel = _nivel;
		imagen = _imagen;
		user = _user;
		setTitle("TEKA-TEKI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px,grow]", "[47.00][95.00][38.00,grow][81.00][35.00px,grow]"));
		
		//Realizamos la consulta para saber la respuesta
		Conexion.conectar();
		st = Conexion.conexion();
		rs = Conexion.consultaDatos(st ,"select respuesta from acertijo where nivel = "+String.valueOf(nivel)+" and imagen = "+String.valueOf(imagen));
		Object[][] filas = null;
		int numFilas = 0;
		int numColumnas = rs.getMetaData().getColumnCount();
		while(rs.next()){
			numFilas++;
		}
		filas = new Object[numFilas][numColumnas];
		rs.beforeFirst();
		int contadorTmp = 0;
		
		while(rs.next()){
			filas[contadorTmp][0] = rs.getString(1);
			respuesta = rs.getString(1);
			contadorTmp++;
		}
		st.close();
		rs.close();
		
		System.out.println(respuesta);
		
		//La union de nivel y imagen es el path de la imagen
		String path = "sources/"+String.valueOf(nivel)+String.valueOf(imagen)+".PNG";
		ImageIcon icon = new ImageIcon(path);
		Image conversion = icon.getImage();
		Image tamanio = conversion.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon fin = new ImageIcon(tamanio);
	
		//Cargamos los datos en la ventana
		txtTitulo = new JTextField();
		txtTitulo.setText("¿?");
		contentPane.add(txtTitulo, "cell 0 0,alignx center,aligny center");
		txtTitulo.setColumns(10);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setIcon(fin);
		lblFoto.setSize(50,50);
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
		
		resolver = new JButton("COMPROBAR");
		panel.add(resolver, "cell 1 0,alignx center,aligny center");
		
		resolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Verificamos que la respuesta sea correcta
				String respuestaDada = txtRespuesta.getText().toString();
				if (respuestaDada.equals(respuesta)){
					//Si la respuesta es correcta -> insertamos en resueltos su puntuacion
					int exito;
					String consulta = "INSERT INTO `resueltos`(`jugador`, `acertijo`, `puntuacion`) VALUES ('"+user+"','"+String.valueOf(nivel)+String.valueOf(imagen)+"',10)";
					Conexion.conectar();
					st = Conexion.conexion();
					exito = Conexion.consultaActualiza(st, consulta);
					if (exito != -1)
						JOptionPane.showMessageDialog(null,"Muy bien!! has acertado :D");
				}else{
					//Si no es correcta le decimos que lo vuelva a intentar
					JOptionPane.showMessageDialog(null,"Respuesta incorrecta, Vuelve a intentar :D");
				}
			}
		});
	}
	

}
