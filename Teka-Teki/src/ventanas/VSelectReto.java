package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import codigo.Conexion;

public class VSelectReto extends JFrame {

	private JPanel contentPane;
	private JFrame vtp;
	private String user;
	private JTable table;
	
	private static ResultSet rs = null;
	private static Statement st = null;
	private static Connection con;

	/**
	 * Create the frame.
	 */
	public VSelectReto(String _user, JFrame _vtp) {
		user = _user;
		vtp = _vtp;
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//Colocamos labels de titulos
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(114,10 ,100,30);
		contentPane.add(lblNivel);
		JLabel lblAc = new JLabel("Acertijo");
		lblAc.setBounds(224,10 ,100,30);
		contentPane.add(lblAc);
		//Buscamos de la tabla de jugadores posibles a cual va a retar excepto a si mismo
		table = new JTable();
		table.setBounds(114, 211, 190, 111);
		
		String[] cabecera2 = {"Nivel", "Acertijo"};
		try {
			tablaRetadores(cabecera2, "select nivel, acertijo from retos where jugretado = '"+user+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void tablaRetadores(String[] cabecera, String Consulta) throws SQLException{
		table = new JTable();
		table.setBounds(71, 38, 252, 116);
		
		
		Conexion.conectar();
		st = Conexion.conexion();
		rs = Conexion.consultaDatos(st ,Consulta);
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
		DefaultTableModel dtm = new DefaultTableModel(filas, cabecera){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table.setModel(dtm);
		contentPane.add(table);
	}

}
