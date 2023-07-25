package es.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PersonaPremium extends Persona {
	
	private String FechaAltaPremium;
	private String PremiumRemain;
	
	//GETTERS
	public String getFechaAltaPremium() {
		return FechaAltaPremium;
	}
	
	public String getPremiumRemain() {
		return PremiumRemain;
	}
	//SETTERS
	public void setFechaAltaPremium(String fechaAltaPremium) {
		FechaAltaPremium = fechaAltaPremium;
	}
	public boolean setPassword(String pass) {
		if(this.isValidPass(pass) == true) {
			super.setPassword(pass);
			return true;
		}
		else {
			return false;
		}
	}
	public void setPremiumRemain(String premiumRemain) {
		PremiumRemain = premiumRemain;
	}
	
	/**Validador de contraseña cuando queremos cambiar la contraseña una vez iniciada la sesion y sobreescribe el de
	 * Persona
	 * 
	 * @param password : la contraseña a validar
	 * @return si la contraseña es valida o no
	 */
	
	@Override
	public boolean isValidPass(String password) {
		int i;
		int numbers = 0;
		int capitals = 0;
		int notAlfNum = 0;
	
		for(i = 0 ; i<password.length() ; i++) {
			Character letter = new Character(password.charAt(i)) ;
			String lettToString = Character.toString(letter);
			if(lettToString.matches("[A-Z]")){
				capitals++;
			}
			else if(lettToString.matches("[0-9]")) {
				numbers++;
			}
			else if(lettToString.matches("[a-zA-Z0-9]") == false) {
				notAlfNum++;
			}
		}
		if(capitals >=1 && numbers >= 1 && notAlfNum >=1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public PersonaPremium(String alias, String nombre, String apellido1, String apellido2, String fecha, String sexo, double peso, double altura, double factActiv, ArrayList<Actividad> ActivRealiz, ArrayList<CambiosPeso> CambiosDePeso) throws ParseException {
		super(alias, nombre, apellido1, apellido2, fecha, sexo, peso, altura, factActiv, ActivRealiz, CambiosDePeso);
	}
	
	public PersonaPremium(Persona p) throws ParseException {
		super(p.getAlias(), p.getNombre(), p.getApellido1(), p.getApellido2(), p.getFechaNacimiento(), p.getSexo(), p.getPeso(), p.getAltura(), p.getFactorActividad(), p.getActivRealiz(), p.getCambiosDePeso());
	}
	
	/**Compruebo que la fecha introducida es válida, sin importar si aun no ha pasado ya que se puede introducir una fecha futura para que el premium no comience hasta dicha fecha
	 * 
	 * @param inDate : fecha introducida
	 * @return si la fecha es válida
	 */
	
	public static boolean isValidDatePremium(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		@SuppressWarnings("unused")
		Date FechaIntroducida = new Date();
		try {
		  FechaIntroducida = dateFormat.parse(inDate.trim());
		} 
		catch (ParseException e) {
		  return false;
		}
		return true;
	}
	
	/**Calculo de cuanto tiempo queda de premium
	 * 
	 * @return las horas que quedan de premium
	 * @throws ParseException : si no coincide el formato de la fecha
	 */
	
	public int calcularDuracionPrem() throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date FechaInicio = new Date();
		FechaInicio = dateFormat.parse(this.FechaAltaPremium);
		
		Date FechaFinal = new Date();
		
		long time = FechaFinal.getTime() - FechaInicio.getTime();
		int hours = (int)(time/(1000*60*60));
		
		return hours;
	}
	
	/**
	 * Método implementado de la interfaz IMostrable para devolver el string a imprimir
	 * @return string
	 */
	
	public String dameCadena() {
		
		String SoLong = null;
		SoLong = "\nAlias: " + this.getAlias();
		SoLong = SoLong + "\nContrasenya: " + this.PassToCensored() + "\n";
		SoLong = SoLong + "Nombre: " + this.getNombre() + "\n";
		SoLong = SoLong + "Apellido1: " + this.getApellido1() + "\n";
		SoLong = SoLong + "Apellido2: " + this.getApellido2() + "\n";
		SoLong = SoLong + "Fecha De Nacimiento: " + this.getFechaNacimiento() + "\n";
		SoLong = SoLong + "Edad: " + this.getEdad() + "\n";
		SoLong = SoLong + "Altura: " + this.getAltura() + "\n";
		SoLong = SoLong + "Peso: " + this.getPeso() + "\n";
		SoLong = SoLong + "Sexo: " + this.getSexo() + "\n";
		SoLong = SoLong + "IMC: " + this.getIMC() + "\n";
		SoLong = SoLong + "Sugerencia: " + this.getSugerencia() + "\n";
		SoLong = SoLong + "Factor Actividad: " + this.FactorActivToString() + "\n";
		SoLong = SoLong + "Premium dado de alta: " + this.FechaAltaPremium + "\n";
		SoLong = SoLong + "Tipo de premium: " + this.PremiumRemain + "\n";
		
		SoLong = SoLong + "\n\nActividades Realizadas:\n\n";
		
		boolean activ = true;
		try {
			this.getActivRealiz().size();
		}
		catch(NullPointerException e) {
			SoLong = SoLong + ("No hay Actividades Registradas\n");
			activ = false;
		}
		
		if(activ == true) {
			for(int i = 0 ; i < this.getActivRealiz().size() ; i++) {
				Actividad bucle = this.getActivRealiz().get(i);
				SoLong = SoLong + bucle.dameCadena();
				SoLong = SoLong + "\n\n";
			}
		}
		
		SoLong = SoLong + "\nCambios de peso:\n\n";
		
		boolean cpesos = true;
		try {
			this.getCambiosDePeso().size();
		}
		catch(NullPointerException e) {
			SoLong = SoLong + ("No hay cambios de peso registrados\n");
			cpesos = false;
		}
		
		if(cpesos == true) {
			for(int i = 0 ; i < this.getCambiosDePeso().size() ; i++) {
				CambiosPeso bucle = this.getCambiosDePeso().get(i);
				SoLong = SoLong + bucle.dameCadena();
				SoLong = SoLong + "\n";
			}
		}
		
		SoLong = SoLong + "\n\n";
		
		return SoLong;
	}
	
	
	//PARA GENERAR PDF///////////////////////////////////////////////////////////////////////
	
	/**
	 * Devuelve el string para la generacion del PDF (Usuario)
	 * @return string para los datos del usuario
	 */
	
	public String dameStringPDF() {
		
		String SoLong = null;
		SoLong = "\nAlias: " + this.getAlias() + "\n";
		SoLong = SoLong + "Contrasenya: " + this.PassToCensored() + "\n";
		SoLong = SoLong + "Nombre: " + this.getNombre() + "\n";
		SoLong = SoLong + "Apellido1: " + this.getApellido1() + "\n";
		SoLong = SoLong + "Apellido2: " + this.getApellido2() + "\n";
		SoLong = SoLong + "Fecha De Nacimiento: " + this.getFechaNacimiento() + "\n";
		SoLong = SoLong + "Edad: " + this.getEdad() + "\n";
		SoLong = SoLong + "Altura: " + this.getAltura() + "\n";
		SoLong = SoLong + "Peso: " + this.getPeso() + "\n";
		SoLong = SoLong + "Sexo: " + this.getSexo() + "\n";
		SoLong = SoLong + "IMC: " + this.getIMC() + "\n";
		SoLong = SoLong + "Sugerencia: " + this.getSugerencia() + "\n";
		SoLong = SoLong + "Factor Actividad: " + this.FactorActivToString() + "\n";
		SoLong = SoLong + "Premium dado de alta: " + this.FechaAltaPremium + "\n";
		SoLong = SoLong + "Tipo de premium: " + this.PremiumRemain + "\n";
		
		return SoLong;
	}
}
