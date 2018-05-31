package TP;

import java.util.ArrayList;

public class Terminal {
	private String Dispositivo;
	private String NombreSO;
	private String VersionSO;
	private Hub interfaz;
	private ArrayList<IP> Direcciones;
	private IP Defaultgateway;
	
	public Terminal(String Disp, String NSO, String VSO, Hub inter, ArrayList<IP> direc, IP DG){
		Dispositivo = Disp;
		NombreSO = NSO;
		VersionSO = VSO;
		interfaz = inter;
		Direcciones = direc;
		Defaultgateway = DG;
	}
	
	public void EnvioPaquete(Paquete P) {
		if (Direcciones.contains(P.IPdest)){
			ObtenerTerminal(IPdest); 
		} else {
			CrearPaqueteRuteo(P, Defaultgateway);
		}
	}
	public void ReciboPaquete(Paquete P) {
		if (Direcciones.contains(P.IPdest)){
			if (P.tipo == "WHO") {
				Terminal T = new Terminal(Dispositivo, NombreSO, VersionSO, interfaz, Direcciones, Defaultgateway);
				CrearPaquete("SendMessage", T);
			} else if (P.tipo == "ICMPRequest") {
					Terminal T = new Terminal(Dispositivo, NombreSO, VersionSO, interfaz, Direcciones, Defaultgateway);
					CrearPaquete("ICMPResponse", T);
			} else if (P.tipo == "ICMPResponse") {
					System.out.println("Recibido ICMP desde equipo_origen [timestamp]");
			} else if (P.tipo == "SendMessage") {
				//Deberia imprimir el mensaje dentro del paquete otra variable?
			}
		}
	}
}
