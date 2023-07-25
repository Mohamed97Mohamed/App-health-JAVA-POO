package es.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class E {
	
	/**Valida cualquier fecha introducida con el formato dd/MM/yyyy
	 * 
	 * @param inDate = string con la fecha introducida
	 * @return si la fecha es válida o no
	 */
	
	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
	

	
	/**Comprueba que la contraseña sea válida al hacer el registro
	 * 
	 * @param password : contraseña introducida
	 * @return : si la contraseña es válida o no
	 */
	
	public static boolean isValidPass(String password) {
		int i;
		int nein = 0;
		
		if(password.length()<6) {
			return false;
		}
		else {
			for(i = 0 ; i<password.length() ; i++) {
				Character letter = new Character(password.charAt(i)) ;
				String lettToString = Character.toString(letter);
				if(lettToString.matches("[a-zA-Z0-9]") == false){
					nein++;
				}
			}
			if(nein == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**Comprueba si el alias tiene al menos un caracter alfanumerico
	 * 
	 * @param alias : introducido
	 * @return : si alias es válido o no
	 */
	
	public static boolean isValidAlias(String alias) {
		int i;
		int characters = 0;
		  
		for(i = 0 ; i<alias.length() ; i++) {
			Character letter = new Character(alias.charAt(i)) ;
			String lettToString = Character.toString(letter);
			if(lettToString.matches("[a-zA-Z0-9]")){
				characters++;
			}
		}
		if(characters >=1) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	/**Calculo de tiempo en minutos de hora con HH:mm:ss
	 * 
	 * @param duracion : String con formato HH:mm:ss
	 * @return : los minutos
	 * @throws ParseException : si no coincide el formato de duracion
	 */
	
	public static int calcularEnMinutos(String duracion) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setLenient(false);
		Date FechaDuracion = new Date();
		FechaDuracion = dateFormat.parse(duracion.trim());
		
		long time = FechaDuracion.getTime();
		int minutes = (int)(time/(1000*60)%60);
		int hours = (int)(time/(1000*60*60));
		minutes = minutes + (hours * 60);
		
		return minutes;
	}
	
	/**Calculo de tiempo en minutos de hora con HH:mm
	 * 
	 * @param duracion : String con formato HH:mm
	 * @return : los minutos
	 * @throws ParseException : si no coincide el formato de duracion
	 */
	
	public static int calcularEnMinutosH(String duracion) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		dateFormat.setLenient(false);
		Date FechaDuracion = new Date();
		FechaDuracion = dateFormat.parse(duracion.trim());
		
		long time = FechaDuracion.getTime();
		int minutes = (int)(time/(1000*60)%60);
		int hours = (int)(time/(1000*60*60));
		minutes = minutes + (hours * 60);
		
		return minutes;
	}
	
	/**Comprobacion si el ritmo de Running es valido
	 * 
	 * @param inDate : ritmo con formato HH:mm
	 * @return si el ritmo es valido o no
	 */
	
	public static boolean duracionValid(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
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
}
