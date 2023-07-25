package es.poo;

public class Swimming extends Actividad {
	private int NumLargos;
	private String TipoNatacion;//Piscina o Mar abierto
	

	//GETTERS
	public int getNumLargos() {
		return NumLargos;
	}
	public String getTipoNatacion() {
		return TipoNatacion;
	}
	
	//SETTERS
	public void setNumLargos(int numLargos) {
		NumLargos = numLargos;
	}
	public void setTipoNatacion(String tipoNatacion) {
		TipoNatacion = tipoNatacion;
	}
	
	
	public Swimming(String fecha1, String fecha2, String duracion, int distance, int fcMax, int fcMin, double fcMedia,
			double kcalCons) {
		super(fecha1, fecha2, duracion, distance, fcMax, fcMin, fcMedia, kcalCons);
	}
	
	/**
	 * Devuelve el string para la generacion de los infromes
	 * @return string para los datos de cualquier objeto Swimming
	 */
	
	public String dameCadena() {
		
		String SoLong = null;
		
		SoLong = "Tipo de actividad: Swimming\n";
		SoLong = SoLong + "Inicio de Actividad: " + getFechaInicio() + "\n";
		SoLong = SoLong + "Fin de Actividad: " + getFechaFin() + "\n";
		SoLong = SoLong + "Duracion: " + getDuracion() + "\n";
		SoLong = SoLong + "Distancia recorrida: " + getDistancia() + "\n";
		SoLong = SoLong + "Kilocalorias consumidas: " + getKcalConsum() + "\n";
		SoLong = SoLong + "Pulsaciones maxima: " + getFcMax() + "\n";
		SoLong = SoLong + "Pulsaciones minima:" + getFcMin() + "\n";
		SoLong = SoLong + "Media de pulsaciones: " + getFcMed() + "\n";
		SoLong = SoLong +  "Largos: " + getNumLargos() + "\n";
		SoLong = SoLong +  "Lugar: " + getTipoNatacion() + "\n";
		
		return SoLong;
	}
}
