package es.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad implements IMostrable {
	private String FechaInicio;
	private String FechaFin;
	private String Duracion;
	private int Distancia;//Debe ser en metros
	private double KcalConsum;
	private int FcMax;//ppm
	private int FcMin;
	private double FcMed;
	
	//GETTERS
	public String getFechaInicio() {
		return FechaInicio;
	}
	public String getFechaFin() {
		return FechaFin;
	}
	public String getDuracion() {
		return Duracion;
	}
	public int getDistancia() {
		return Distancia;
	}
	public double getKcalConsum() {
		return KcalConsum;
	}
	public int getFcMax() {
		return FcMax;
	}
	public double getFcMed() {
		return FcMed;
	}
	public int getFcMin() {
		return FcMin;
	}
	
	//SETTERS
	public boolean setFechaInicio(String fechaInicio) {
		if(this.isValidDateH(fechaInicio)) {
			FechaInicio = fechaInicio;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean setFechaFin(String fechaFin) throws ParseException {
		if(this.isValidDateH(fechaFin)) {
			FechaFin = fechaFin;
			return true;
		}
		else {
			return false;
		}
	}
	public void setDuracion(String duracion) {
		Duracion = duracion;
	}
	public void setDistancia(int distancia) {
		Distancia = distancia;
	}
	public void setKcalConsum(double kcalConsum) {
		KcalConsum = kcalConsum;
	}
	public void setFcMax(int fcMax) {
		FcMax = fcMax;
	}
	public void setFcMed(double fcMed) {
		FcMed = fcMed;
	}
	public void setFcMin(int fcMin) {
		FcMin = fcMin;
	}
	
	public Actividad() {
		
	}
	
	public Actividad(String fecha1, String fecha2, String duracion, int distance, int FcMax, int FcMin, double FcMedia, double KcalCons) {
		this.FechaInicio = fecha1;
		this.FechaFin = fecha2;
		this.Duracion = duracion;
		this.Distancia = distance;
		this.FcMax = FcMax;
		this.FcMin = FcMin;
		this.FcMed = FcMedia;
		this.KcalConsum = KcalCons;
	}
	
	/**
	 * Devuelve el string para la generacion de los informes
	 * @return string para los datos de cualquier objeto Actividad
	 */
	
	public String dameCadena() {
		
		String SoLong = null;
		
		SoLong = "Tipo de actividad: Generica\n";
		SoLong = SoLong + "Inicio de Actividad: " + getFechaInicio() + "\n";
		SoLong = SoLong + "Fin de Actividad: " + getFechaFin() + "\n";
		SoLong = SoLong + "Duracion: " + getDuracion() + "\n";
		SoLong = SoLong + "Distancia recorrida: " + getDistancia() + "\n";
		SoLong = SoLong + "Kilocalorias consumidas: " + getKcalConsum() + "\n";
		SoLong = SoLong + "Pulsaciones maxima: " + getFcMax() + "\n";
		SoLong = SoLong + "Pulsaciones minima:" + getFcMin() + "\n";
		SoLong = SoLong + "Media de pulsaciones: " + getFcMed() + "\n";
		
		return SoLong;
	}
	
	

	/**Valida cualquier fecha introducida con el formato dd/MM/yyyy HH:mm:ss
	 * 
	 * @param inDate = string con la fecha introducida
	 * @return si la fecha es válida o no
	 */
	
	private boolean isValidDateH(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setLenient(false);
		Date FechaIntroducida = new Date();
		try {
		  FechaIntroducida = dateFormat.parse(inDate.trim());
		} 
		catch (ParseException e) {
		  return false;
		}
		Date now = new Date();
		
		if(now.compareTo(FechaIntroducida) >= 0)
			return true;
		else
			return false;
	}
	
	
	/**Calcula la diferencia entre fechas
	 * 
	 * @param fecha1 : fecha de inicio
	 * @param fecha2 : fecha de finalización
	 * @return : string con el formato HH:mm:ss de la duración
	 * @throws ParseException : si no coincide el formato
	 */
	
	public void calcularDuracion(String fecha1, String fecha2) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setLenient(false);
		Date FechaInicio = new Date();
		FechaInicio = dateFormat.parse(fecha1.trim());
		
		Date FechaFinal = new Date();
		FechaFinal = dateFormat.parse(fecha2.trim());
		
		long time = FechaFinal.getTime() - FechaInicio.getTime();
		int seconds = (int)(time/1000)%60;
		int minutes = (int)(time/(1000*60)%60);
		long hours = (int)(time/(1000*60*60));
		
		String duracion = hours + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
		
		
		this.Duracion = duracion;
	}
	
	/**Calcula las calorias consumida
	 * 
	 * @param Usuario : Usuario necesario para saber su sexo
	 * @param FcMedia : Media de pulsaciones
	 * @param duracion : duracion de la actividad
	 * @param Active : intensidad de actividad del usuario
	 * @return : Devuelve las kcal consumidas con la actividad
	 * @throws ParseException : si al pasar la duracion a minutos no coincide el formato
	 */
	
	public void calcularCaloriasConsumidas(Persona Usuario, double FcMedia, String duracion, String Active) throws ParseException {
		
		double kcalCons = 0;
		int timeActiv = E.calcularEnMinutos(duracion);
		
		if(Active.equals("Actividad Generica")) {
			if(Usuario.getSexo().equals("Varon")) {
				kcalCons = ((Usuario.getEdad() * 0.2017) - (Usuario.getPeso() * 0.09036) + (FcMedia * 0.6309) - 55.0969) * (timeActiv / 4.184);
			}
			else if(Usuario.getSexo().equals("Mujer")){
				kcalCons = ((Usuario.getEdad() * 0.074) - (Usuario.getPeso() * 0.05741) + (FcMedia * 0.4472) - 20.4022) * (timeActiv / 4.184);
			}
		}
		else if(Active.equals("Cycling")) {
			if(Usuario.getSexo().equals("Varon")) {
				kcalCons = ((Usuario.getEdad() * 0.2017) - (Usuario.getPeso() * 0.09036) + (FcMedia * 0.6309) - 55.0969) * (timeActiv / 4.184);
			}
			else if(Usuario.getSexo().equals("Mujer")){
				kcalCons = ((Usuario.getEdad() * 0.074) - (Usuario.getPeso() * 0.05741) + (FcMedia * 0.4472) - 20.4022) * (timeActiv / 4.184);
			}
			kcalCons = kcalCons * 1.2;
		}
		else if(Active.equals("Running")) {
			if(Usuario.getSexo().equals("Varon")) {
				kcalCons = ((Usuario.getEdad() * 0.2017) - (Usuario.getPeso() * 0.09036) + (FcMedia * 0.6309) - 55.0969) * (timeActiv / 4.184);
			}
			else if(Usuario.getSexo().equals("Mujer")){
				kcalCons = ((Usuario.getEdad() * 0.074) - (Usuario.getPeso() * 0.05741) + (FcMedia * 0.4472) - 20.4022) * (timeActiv / 4.184);
			}
			kcalCons = kcalCons * 1.3;
		}
		else if(Active.equals("Swimming")) {
			if(Usuario.getSexo().equals("Varon")) {
				kcalCons = ((Usuario.getEdad() * 0.2017) - (Usuario.getPeso() * 0.09036) + (FcMedia * 0.6309) - 55.0969) * (timeActiv / 4.184);
			}
			else if(Usuario.getSexo().equals("Mujer")){
				kcalCons = ((Usuario.getEdad() * 0.074) - (Usuario.getPeso() * 0.05741) + (FcMedia * 0.4472) - 20.4022) * (timeActiv / 4.184);
			}
			kcalCons = kcalCons * 1.1;
		}
		kcalCons = kcalCons * (-1);
		this.KcalConsum = kcalCons;
	}
	
}
