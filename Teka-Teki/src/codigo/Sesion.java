package codigo;

public class Sesion {
	private static Sesion miSesion = new Sesion();
	Jugador jugador;
	int nivel;

	public static Sesion getSesion(){
		return miSesion;
	}
	
	public void iniciarSesion(Jugador pjugador, int pNivel){
		jugador = pjugador;
		nivel=pNivel;
	}
}
