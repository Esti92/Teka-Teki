package codigo;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Acertijo> partidas = new ArrayList<Acertijo>();

	
	public Jugador(String pNombre){
		this.nombre = pNombre;
//		partidas = GestorJugadores.getGestorJugadores().;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public void anadirPartida(Partida pPartida){
//		partidas.anadirPartida(pPartida);
	}
	
	public boolean tienePartidaPendiente(){
//		return partidas.hayPartidasSinAcabar();
	}
	
	public void retomarPartida(){
//		partidas.retomarPartida();
	}
	
	private int getPuntuacion(){
//		return partidas.getMejorPuntuacion();
	}*/
	
	/*public int compareTo(Jugador pJugador){
		if(pJugador.getPuntuacion()>this.getPuntuacion()){
			return 1;
		}else{
			if(pJugador.getPuntuacion()<this.getPuntuacion()){
				return -1;
			}else{return 0;}
		}
	}*/
	
	//public String codificar(){
//		return "j/"+nombre+"/"+partidas.codificar()+"jj/";
	//}
	
/*/*/
	
	/*public String infoRank(){
		String s = this.nombre + "   " + getPuntuacion();
		return s;
	}*/
	
	public String toString(){
		return nombre;
	}
	//pruebas
	
	public void setPuntos(int pPuntos){
//		partidas.setPuntos(pPuntos);
	}	

}
