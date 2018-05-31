package TP;

public class PaqueteRuteo extends Paquete {
	private Paquete p;
	
	public PaqueteRuteo(IP ipOrig, IP ipDest, int ttl,Paquete p1) {
		super(ipOrig , ipDest , ttl);
		p = p1;
	}
	public Paquete getP() {
		return p;
	}

	public void setP(Paquete p) {
		this.p = p;
	}
	public Paquete getSubpaquete() {
		return p;
	}

	
}
