package TP;

import java.util.ArrayList;

public class Terminal extends Dispositivo {
	private String dispositivo;
	private String nombreSO;
	private String versionSO;
	private Hub interfaz;
	private ArrayList<IP> direcciones;
	private IP defaultGateway;
	
	public Terminal(String Disp, String NSO, String VSO, Hub inter, ArrayList<IP> direc, IP DG){
		dispositivo = Disp;
		nombreSO = NSO;
		versionSO = VSO;
		interfaz = inter;
		direcciones = direc;
		defaultgateway = DG;
	}
	
	public void EnvioPaquete(Paquete P) {
		if (direcciones.contains(P.IPdest)){
			ObtenerTerminal(IPdest); 
		} else {
			CrearPaqueteRuteo(P, defaultGateway);
		}
	}
	public void ReciboPaquete(Paquete P) {
		if (direcciones.contains(P.IPdest)){
			if (P.tipo == "WHO") {
				Terminal T = new Terminal(dispositivo, nombreSO, versionSO, interfaz, direcciones, defaultGateway);
				CrearPaquete("SendMessage", T);
			} else if (P.tipo == "ICMPRequest") {
					Terminal T = new Terminal(dispositivo, nombreSO, versionSO, interfaz, direcciones, defaultGateway);
					CrearPaquete("ICMPResponse", T);
			} else if (P.tipo == "ICMPResponse") {
					System.out.println("Recibido ICMP desde equipo_origen [timestamp]");
			} else if (P.tipo == "SendMessage") {
				//Deberia imprimir el mensaje dentro del paquete otra variable?
			}
		}
	}
}
