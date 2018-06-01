package TP;

public class Hub extends Dispositivo {

	private ArrayList<Dispositivo> puertos;
	private static int cantPuertos;		
	public Hub(int cant){
		cantPuertos = cant;
	}
}
