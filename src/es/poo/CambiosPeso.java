package es.poo;

public class CambiosPeso implements IMostrable {
	private String Fecha;
	private double Peso;//Kg
	private double IMC;
	

	//GETTERS
	public String getFecha() {
		return Fecha;
	}
	public double getPeso() {
		return Peso;
	}
	public double getIMC() {
		return IMC;
	}
	
	//SETTERS
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	public void setIMC(double iMC) {
		IMC = iMC;
	}
	
	public CambiosPeso(double peso, String fecha) {
		this.Peso = peso;
		this.Fecha = fecha;
	}
	
	/**
	 * Devuelve el string para la generacion de los informes
	 * @return string para los datos de cualquier objeto CambiosPeso
	 */
	
	public String dameCadena() {
		
		String SoLong = null;
		
		SoLong = "Peso: " + getPeso() + "\n";
		SoLong = SoLong + "Fecha: " + getFecha() + "\n";
		SoLong = SoLong + "IMC: " + getIMC() + "\n";
		
		return SoLong;
	}
}
