package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import codigo.Conexion;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.ActionEvent;

public class PuntuacionClass extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static Connection con;
	private JFrame vtp;
	/**
	 * Create the frame.
	 */
	int Puntos;
	
	public PuntuacionClass(JFrame _vtp) throws SQLException {
		vtp = _vtp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(114, 211, 190, -151);
		contentPane.add(table);
		
		JLabel lblPuntuacionDeJugadores = new JLabel("Puntuacion de jugadores");
		lblPuntuacionDeJugadores.setBounds(134, 11, 141, 14);
		contentPane.add(lblPuntuacionDeJugadores);
		
		getPuntuacion();
		modificarTabla();
	}
	
	public void getPuntuacion(){
		try{
		DefaultTableModel tm = (DefaultTableModel)table.getModel();
		Puntos = (int) tm.getValueAt(table.getSelectedRow(), 0);
		System.out.println(String.valueOf(Puntos));
		}
		catch(Exception e){}
	}

	public void modificarTabla() throws SQLException{
		table = new JTable();
		table.setBounds(71, 38, 252, 146);
		String[] cabecera = {"Jugador","Puntuacion"};
		
		Conexion.conectar();
		st = Conexion.conexion();
		rs = Conexion.consultaDatos(st ,"select jugador, sum(puntuacion) from resueltos");
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
			filas[contadorTmp][1] = rs.getString(2);
			contadorTmp++;
		}
		st.close();
		rs.close();
		DefaultTableModel dtm = new DefaultTableModel(filas, cabecera);
		table.setModel(dtm);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("ATRAS");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				setVisible(false);
				vtp.setVisible(true);
			}
		});
		btnNewButton.setBounds(55, 211, 294, 23);
		contentPane.add(btnNewButton);
	}
	
	
}
