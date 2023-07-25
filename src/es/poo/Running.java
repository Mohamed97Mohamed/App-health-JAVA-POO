package es.poo;

public class Running extends Actividad {

	private String Ritmo;
	private int Elevacion;//metros
	private int NumPasos;
	private double Cadencia;
	
	//GETTERS
	public String getRitmo() {
		return Ritmo;
	}
	public int getElevacion() {
		return Elevacion;
	}
	public int getNumPasos() {
		return NumPasos;
	}
	public double getCadencia() {
		return Cadencia;
	}
	
	//SETTERS
	public void setRitmo(String ritmo) {
		Ritmo = ritmo;
	}
	public void setElevacion(int elevacion) {
		Elevacion = elevacion;
	}
	public void setNumPasos(int numPasos) {
		NumPasos = numPasos;
	}
	public void setCadencia(double cadencia) {
		Cadencia = cadencia;
	}
	
	
	public Running(String fecha1, String fecha2, String duracion, int distance, int FcMax, int FcMin, double FcMedia,
			double KcalCons) {
		super(fecha1, fecha2, duracion, distance, FcMax, FcMin, FcMedia, KcalCons);
	}
	
	/**
	 * Devuelve el string para la generacion de los infromes
	 * @return string para los datos de cualquier objeto Running
	 */
	
	public String dameCadena() {
		
		String SoLong = null;
		
		SoLong = "Tipo de actividad: Running\n";
		SoLong = SoLong + "Inicio de Actividad: " + getFechaInicio() + "\n";
		SoLong = SoLong + "Fin de Actividad: " + getFechaFin() + "\n";
		SoLong = SoLong + "Duracion: " + getDuracion() + "\n";
		SoLong = SoLong + "Distancia recorrida: " + getDistancia() + "\n";
		SoLong = SoLong + "Kilocalorias consumidas: " + getKcalConsum() + "\n";
		SoLong = SoLong + "Pulsaciones maxima: " + getFcMax() + "\n";
		SoLong = SoLong + "Pulsaciones minima:" + getFcMin() + "\n";
		SoLong = SoLong + "Media de pulsaciones: " + getFcMed() + "\n";
		SoLong = SoLong +  "Tiempo para recorrer un kilometro: " + getRitmo() + "\n";
		SoLong = SoLong +  "Elevacion: " + getElevacion() + "\n";
		SoLong = SoLong +  "Pasos: " + getNumPasos() + "\n";
		SoLong = SoLong +  "Pasos por minuto: " + getCadencia() + "\n";
		
		return SoLong;
	}
}
