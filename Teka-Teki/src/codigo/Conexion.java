package codigo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Conexion {

	/**********************************************/
	/*  	CONEXION CON LA BASE DE DATOS		  */
	/**********************************************/
	
	private static Connection conexion = null; 
	private static Statement statement;
	private static String  usuario = "Xesantos013";
	private static String password = "51JWFLEA77";
	private static String bd = "Xesantos013_TEKA-TEKI";
	private static String server = "jdbc:mysql://galan.ehu.eus/"+bd;
	
	/*******************************************************/
	/* METODO PARA CONECTARSE AL DRIVER Y PODER USAR MYSQL */
	/*******************************************************/
	
	public static void conectar(){
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Open connection
		try{
			conexion= DriverManager.getConnection(server,usuario,password);
			conexion.setAutoCommit(true);
			statement=conexion.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***********************************************************/
	/* METODO PARA ESTABLECER LA CONEXION CON LA BASE DE DATOS */
	/***********************************************************/

	public static Statement conexion() {
        Statement st = null;
        try {
            st = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: Conexión incorrecta.");
            e.printStackTrace();
        }
        return st;
    }
 
	/*************************************************************************
     * Método para realizar consultas del tipo: SELECT * FROM tabla WHERE..."*
     *************************************************************************/
     
	public static ResultSet consultaDatos(Statement st, String cadena) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }
	
	/*****************************************************************************************************************
     * Método para realizar consultas de actualización, creación o eliminación (DROP,INSERT INTO, ALTER...,NO SELECT * 
     *****************************************************************************************************************/
    
    public static int consultaActualiza(Statement st, String cadena) {
        int rs = -1;
        try {
            rs = st.executeUpdate(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("Clave repetida, saldrá ventana de avisto");
            //e.printStackTrace();
            lanzarMensajeVariasLíneas();
            
        }
        return rs;//si devuelve -1 mal si devuelve otro valor bien
    }
    
    /*********************************
     * Método para cerrar la consula *
     *********************************/
    static void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.print("Error: No es posible cerrar la consulta.");
            }
        }
    }
    
    /***********************************
     * Método para cerrar la conexión. *
     ***********************************/
    public static void cerrar(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                System.out.print("Error: No es posible cerrar la conexión.");
            }
        }
    }
    
    public static void lanzarMensajeVariasLíneas(){
		  //Propiedad del sistema para salto de línea:
		  String nl = System.getProperty("line.separator");
		  //Lanzamos el mensaje:
/*		  JOptionPane.showMessageDialog(null, "Error"
		    + nl + "Código ya inscrito");*/
		 }
        
}
