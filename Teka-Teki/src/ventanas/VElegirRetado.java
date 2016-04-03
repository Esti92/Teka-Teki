package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.ActionEvent;

import codigo.Conexion;

public class VElegirRetado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static Connection con;
	private String user;
	private JFrame vtp;
	
	private JTextField txtNivel, txtAcertijo;

	/**
	 * Create the frame.
	 * @param anterior 
	 * @throws SQLException 
	 */
	public VElegirRetado(JFrame _vtp, String _user) throws SQLException {
		user = _user;
		vtp = _vtp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel txtTitulo = new JLabel();
		txtTitulo.setText("Selecciona el juagor a retar");
		txtTitulo.setBounds(114, 10, 250, 30);
		contentPane.add(txtTitulo);
		//Buscamos de la tabla de jugadores posibles a cual va a retar excepto a si mismo
		table = new JTable();
		table.setBounds(114, 211, 190, 111);
		
		String[] cabecera1 = {"Jugador"};
		tablaRetadores(cabecera1, "select nombre from jugador where nombre != '"+user+"'");
		
		txtNivel = new JTextField();
		txtNivel.setText("Coloca el Nivel (1-3)");
		txtNivel.setBounds(80, 170, 120, 30);
		contentPane.add(txtNivel);
		
		txtNivel.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				txtNivel.setText("");
			}
		});
		txtAcertijo = new JTextField();
		txtAcertijo.setText("Coloca el Acertijo (1-3)");
		txtAcertijo.setBounds(220, 170, 130, 30);
		contentPane.add(txtAcertijo);
		
		txtAcertijo.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				txtAcertijo.setText("");
			}
		});
		
		JButton atrasb = new JButton("ATRAS");
		atrasb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Cargar siguiente ventana	
				setVisible(false);
				vtp.setVisible(true);
			}
		});
		atrasb.setBounds(150, 210, 100, 30);
		contentPane.add(atrasb);
		
		JButton retarb = new JButton("RETAR");
		retarb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Tomamos la Fila seleccionada y vamos a elejir reto
				int row = table.getSelectedRow();
				String retado = null;
				try{
				retado = table.getValueAt(row, 0).toString();
				String consulta = "INSERT INTO `retos`(`jugretado`, `jugretador`, `acertijo`, `estado`, `nivel`)"+
						"VALUES ('"+retado+"','"+user+"',"+Integer.parseInt(txtAcertijo.getText().toString())+", 0 ,"+Integer.parseInt(txtNivel.getText().toString())+")";
						Conexion.conectar();
						st = Conexion.conexion();
						int exito = Conexion.consultaActualiza(st, consulta);
						if (exito != -1)
							JOptionPane.showMessageDialog(null,"Se ha enviado el reto B|");
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Seleccione el jugador a retar");
				}
			}
		});
		retarb.setBounds(150, 245, 100, 30);
		contentPane.add(retarb);
		
		JButton retosb = new JButton("VER RETOS");
		retosb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Consultamos la tabla para ver los retos pendientes
				VSelectReto retos = new VSelectReto(user, vtp);
				retos.setVisible(true);
			}
		});
		retosb.setBounds(150, 280, 100, 30);
		contentPane.add(retosb);
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
