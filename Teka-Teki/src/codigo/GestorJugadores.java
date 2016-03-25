package codigo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Iterator;

import codigo.Conexion;
import codigo.Jugador;


public class GestorJugadores {
	

	private ArrayList<Jugador> jugadores;
	private static GestorJugadores miGestor=new GestorJugadores();
	
	
	private GestorJugadores(){
		jugadores=new ArrayList<Jugador>();
	}
	
	
	public static GestorJugadores getGestorJugadores(){
		return miGestor;
	}
	
	public ArrayList<Jugador> getJugadores(){
		return jugadores;
	}
	
	public void obtenerListaJugadores() throws SQLException{
		if(jugadores.isEmpty()==false){
			jugadores.clear();
		}
		ResultSet rs = null;
		  String cadena = "SELECT * FROM jugador";
		  Statement st = Conexion.conexion();
		  rs = Conexion.consultaDatos(st, cadena);
		  Conexion.cerrar(st);
		  
		  int i=0;
		  Jugador j=null;
		  while(rs.next()){
			  j.setNombre(rs.getString("Nombre"));
			  jugadores.set(i,j);
			  i=i+1;
		  }
	}
	
	public void obtenerListaJugadoresMenosUsuario(String nombre) throws SQLException{
		  this.obtenerListaJugadores();
		  Iterator<Jugador> it=jugadores.iterator();
		  Jugador j1=null;
		  boolean salir=false;
		  while(it.hasNext()&&salir){
			  j1=it.next();
			  if(j1.getNombre().equals(nombre)){
				  jugadores.remove(j1);
				  salir=true;
			  }
		  }
	}
	
	public Jugador getJugadorRetado(String nombre){
		try {
			obtenerListaJugadores();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Jugador> itr=jugadores.iterator();
		Jugador j= null;
		boolean salir=false;
		while(itr.hasNext()&&salir==false){
			j=itr.next();
			if(j.getNombre()==nombre){
				salir=true;
			}
		}
		return j;

		
	}
	
	
	/*
	 * Identificar usuario, verifica si existe el usuario y si existe, verifica su password
	 * @pre		Ninguna
	 * @post	Devuelve un valor dependiendo de si el usuario existe o si la contraseña es correcta.
	 * @return	0 si todo ha ido bien / 1 si ha habido algún error
	 * @throws	SQLException
	 */
	public int Identificarse (String user, String password) throws SQLException{	
		if (GestorJugadores.getGestorJugadores().existeUser(user)){
			System.out.println("Existe usuario, comprobando password");
			if (verificarPassword(user, password)){
				System.out.println("Password correcta.");
				// TO-DO: Cargar objeto de usuario con todos sus datos!?
				return 0;
			}else{
				return -1;
			}
		}else{
			return 1;
		}
	}

	
	/*
	 * Comprobar si existe el usuario en la Base de Datos
	 * @pre		Ninguna
	 * @post	Devuelve true si encuentra el usuario en la base de datos
	 * @return	True si existe / False si no existe
	 * @throws	SQLException
	 */
	public Boolean existeUser (String user) throws SQLException{
		ResultSet rs = null;
		int resultado = 0;
		String cadena = "SELECT nombre FROM jugador WHERE nombre='"+user+"';";
			
		Conexion.conectar();
		Statement st = Conexion.conexion();
		rs = Conexion.consultaDatos(st, cadena);
		
		if (rs.next()){
			Conexion.cerrar(st);
			return true;
		}

		Conexion.cerrar(st);
		return false;
	}
	
	
	/*
	 * Comprobar si la contraseña del usuario es correcta en la Base de Datos
	 * @pre		Previamente se comprueba si el usuario existe
	 * @post	Si encuentra ese usuario con esa password devuelve true.
	 * @return	True si correcta / False si incorrecta
	 * @throws	SQLException
	 */
	public Boolean verificarPassword (String user, String password) throws SQLException{
		ResultSet rs = null;
		int resultado = 0;
		String cadena = "SELECT nombre FROM jugador WHERE nombre='"+user+"' and password='"+password+"';";
		
		Conexion.conectar();
		Statement st = Conexion.conexion();
		rs = Conexion.consultaDatos(st, cadena);
		
		if (rs != null){
			Conexion.cerrar(st);
			return true;
		}

		Conexion.cerrar(st);
		return false;
	}

	/*
	 * Registrar usuario en la base de datos
	 * @pre		Ninguna
	 * @post	
	 * @return	
	 * @throws	SQLException
	 */
	public int Registrarse(String user, String pass, String email) throws SQLException{
		if (!GestorJugadores.getGestorJugadores().existeUser(user)){
			String cadena = "INSERT INTO jugador VALUES ('"+user+"', '"+pass+"', '"+email+"', '0');";
			Conexion.conectar();
			Statement st = Conexion.conexion();
			Conexion.consultaActualiza(st, cadena);
			return 0;
		}else{
			return 1;
		}
		
	}
	
	public void obtenerAcertijo(String user) throws SQLException{
		if(jugadores.isEmpty()==false){
			jugadores.clear();
		}
		ResultSet rs = null;
		  String cadena = "SELECT * FROM resueltos WHERE jugador="+user;
		  Statement st = Conexion.conexion();
		  rs = Conexion.consultaDatos(st, cadena);
		  Conexion.cerrar(st);
		  
		  int i=0;
		  Jugador j=null;
		  while(rs.next()){
			  j.setNombre(rs.getString("Nombre"));
			  jugadores.set(i,j);
			  i=i+1;
		  }
	}
	
}
