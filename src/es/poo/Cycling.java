package es.poo;

public class Cycling extends Actividad {

	private int Cadencia;//pedaladas pm
	
	//GETTERS
	public int getCadencia() {
		return Cadencia;
	}
	
	//SETTERS
	public void setCadencia(int cadencia) {
		Cadencia = cadencia;
	}

	public Cycling(String fecha1, String fecha2, String duracion, int distance, int FcMax, int FcMin, double FcMedia,
			double KcalCons) {
		super(fecha1, fecha2, duracion, distance, FcMax, FcMin, FcMedia, KcalCons);
	}
	
	/**
	 * Devuelve el string para la generacion de los informes
	 * @return string para los datos de cualquier objeto Cycling
	 */
	
	public String dameCadena() {
		
		String SoLong = null;
		
		SoLong = "Tipo de actividad: Cycling\n";
		SoLong = SoLong + "Inicio de Actividad: " + getFechaInicio() + "\n";
		SoLong = SoLong + "Fin de Actividad: " + getFechaFin() + "\n";
		SoLong = SoLong + "Duracion: " + getDuracion() + "\n";
		SoLong = SoLong + "Distancia recorrida: " + getDistancia() + "\n";
		SoLong = SoLong + "Kilocalorias consumidas: " + getKcalConsum() + "\n";
		SoLong = SoLong + "Pulsaciones maxima: " + getFcMax() + "\n";
		SoLong = SoLong + "Pulsaciones minima:" + getFcMin() + "\n";
		SoLong = SoLong + "Media de pulsaciones: " + getFcMed() + "\n";
		SoLong = SoLong + "Pedaladas por minuto: " + getCadencia() + "\n";
		
		return SoLong;
	}
}
