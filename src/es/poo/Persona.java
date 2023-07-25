package es.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Persona implements IMostrable{
	private String Alias;
	private String Password;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String FechaNacimiento;
	private int Edad;
	private String Sexo;//Varon o Mujer
	private double peso;//Debe ser en kilogramos
	private double altura;//Debe ser en metros
	private double IMC;
	private ArrayList<Actividad> ActivRealiz;
	private ArrayList<CambiosPeso> CambiosDePeso;
	private double FactorActividad;
	private String Sugerencia;
	private static ArrayList<Persona> people;
	
	//GETTERS
	public String getAlias() {
		return Alias;
	}
	public boolean PassMATCH(String pass) {
		if(this.Password.equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}
	public String PassToCensored() {
		
		String censored = "";
		for(int i = 0 ; i<this.Password.length() ; i++) {
			censored = censored + "*";
		}
		
		return censored;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public int getEdad() {
		return Edad;
	}
	public String getSexo() {
		return Sexo;
	}
	public double getPeso() {
		return peso;
	}
	public double getAltura() {
		return altura;
	}
	public double getIMC() {
		return IMC;
	}
	public ArrayList<Actividad> getActivRealiz() {
		return ActivRealiz;
	}
	public ArrayList<CambiosPeso> getCambiosDePeso() {
		return CambiosDePeso;
	}
	public double getFactorActividad() {
		return FactorActividad;
	}
	public String getSugerencia() {
		return Sugerencia;
	}
	public static ArrayList<Persona> getPeople() {
		return people;
	}
	
	//SETTERS
	public void setAlias(String alias) {
		Alias = alias;
	}
	public boolean setPassword(String password) {
		if(this.isValidPass(password) == true) {
			Password = password;
			return true;
		}
		else {
			return false;
		}
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setIMC(double iMC) {
		IMC = iMC;
	}
	public void setActivRealiz(ArrayList<Actividad> activRealiz) {
		ActivRealiz = activRealiz;
	}
	public void setCambiosDePeso(ArrayList<CambiosPeso> cambiosDePeso) {
		CambiosDePeso = cambiosDePeso;
	}
	public void setFactorActividad(double factorActividad) {
		FactorActividad = factorActividad;
	}
	public void setSugerencia(double IMC) {
		if(IMC<18.5) {
			this.Sugerencia = "La persona está por debajo de su peso";
		}
		else if( 18.5 <= IMC && 25 >= IMC) {
			this.Sugerencia = "La persona está en su línea";
		}
		else if( 25 <= IMC && 30 >= IMC) {
			this.Sugerencia = "La persona tiene sobrepeso";
		}
		else {
			this.Sugerencia = "La persona tiene obesidad";
		}
	}
	public static void setPeople(ArrayList<Persona> people) {
		Persona.people = people;
	}
	///////////////////////////////////////////////////////////////////////////////
	
	public static void inicializePeople() {
		Persona.people = new ArrayList<>();
	}
	public static void addPersonaToPeople(Persona e) {
		Persona.people.add(e);
	}
	public static void setPersonaToPeople(Persona e, int UserID) {
		Persona.people.set(UserID, e);
	}
	public static Persona getSpecificPerson(int UserID) {
		return Persona.people.get(UserID);
	}
	
	
	
	public void inicializeActivRealiz() {
		this.ActivRealiz = new ArrayList<>();
	}
	public void addActivRealiz(Actividad e) {
		this.ActivRealiz.add(e);
	}
	
	
	
	public void inicializeCambiosDePeso() {
		this.CambiosDePeso = new ArrayList<>();
	}
	public void addCambiosDePeso(CambiosPeso e) {
		this.CambiosDePeso.add(e);
	}
	
	///////////////////////////////////////////////////////////////////////////////
	public Persona() {
		
	}
	
	public Persona(String alias, String nombre, String apellido1, String apellido2, String fecha, String sexo, 
			double peso, double estatura , double factActiv, ArrayList<Actividad> ActivRealiz, ArrayList<CambiosPeso> CambiosDePeso) throws ParseException {
		
		this.Alias = alias;
		this.Nombre = nombre;
		this.Apellido1 = apellido1;
		this.Apellido2 = apellido2;
		this.FechaNacimiento = fecha;
		this.Sexo = sexo;
		this.peso = peso;
		this.altura = estatura;
		this.IMC = this.calcularIMC(this.peso, this.altura);
		this.Edad = this.calcularEdad(fecha);
		this.FactorActividad = factActiv;
		this.setSugerencia(IMC);
		this.ActivRealiz = ActivRealiz;
		this.CambiosDePeso = CambiosDePeso;
	}
	
	/** Una vez introducidos todos los datos del usuario, se calcula el IMC
	 * 
	 * @param peso : del usuario
	 * @param estatura : del usuario
	 * @return imc : devuelve el IMC calculado
	 */
	
	public double calcularIMC(double peso, double estatura) {
		double imc = peso/(estatura * estatura);
		return imc;
	}
	
	/**calcula la edad del usuario
	 * 
	 * @param fecha : con la que se calcula la edad
	 * @return edad : ya calculada
	 * @throws ParseException : si el string fecha no puede introducirse en la variable Date (Improbable ya que se ha controlado por código)
	 */
	
	private int calcularEdad(String fecha) throws ParseException {
		int edad = 0;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date FechaIntroducida = new Date();
		FechaIntroducida = dateFormat.parse(fecha.trim());
		
		Date now = new Date();
		
		long time = now.getTime() - FechaIntroducida.getTime();
		long years = time/(24*60*60*1000);
		
		double a = (int)years;
		a = a/30.43;
		a= a/12;
		edad = (int)a;
		
		return edad;
	}
	
	/**Validador de contraseña cuando queremos cambiar la contraseña una vez iniciada la sesion
	 * Para el registro se usa un validador distinto ya que la persona se inicializa despues de pedir los datos
	 * 
	 * @param pass : la contraseña a validar
	 * @return si la contraseña es valida o no
	 */
	
	public boolean isValidPass(String pass) {
		int i;
		
		if(pass.length()<6) {
			return false;
		}
		else {
			int letra = 0;
			int numero = 0;
			for(i = 0 ; i<pass.length() ; i++) {
				Character letter = new Character(pass.charAt(i)) ;
				String lettToString = Character.toString(letter);
				if(lettToString.matches("[a-zA-Z]")){
					letra++;
				}
				else if(lettToString.matches("[0-9]")) {
					numero++;
				}
			}
			if(letra <= 1 && numero <= 1) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**Método que convierte la PersonaPremium en Persona si su premium ha caducado
	 * 
	 * @return el objeto persona reconvertido
	 * @throws ParseException : si no se puede encajar el usuarioPremium dentro del objeto Persona
	 */
	
	public Persona PremiumToPersona() throws ParseException {
		
		if(this instanceof PersonaPremium) {
			Persona Unconverted = new Persona(this.Alias, this.Nombre, this.Apellido1, this.Apellido2, this.FechaNacimiento, 
					this.Sexo, this.peso, this.altura, this.FactorActividad, this.ActivRealiz, this.CambiosDePeso);
			Unconverted.setPassword(this.Password);
			
			return Unconverted;
		}
		else {
			return this;
		}
		
	}
	
	/**Devuelve string dependiendo de que factor actividad se ha elejido
	 * 
	 * @return el string de factor actividad
	 */
	
	public String FactorActivToString() {
		
		String FactActivString = null;
		
		if(this.FactorActividad == 1.2) {
			FactActivString = "Persona sedentaria";
		}
		else if(this.FactorActividad == 1.375) {
			FactActivString = "Actividad ligera (1 a 3 veces por semana)";
		}
		else if(this.FactorActividad == 1.55) {
			FactActivString = "Actividad moderada (3 a 5 veces por semana)";
		}
		else if(this.FactorActividad == 1.725) {
			FactActivString = "Actividad intensa (6 a 7 veces por semana)";
		}
		else if(this.FactorActividad == 1.9) {
			FactActivString = "Actividad extremadamente alta (atletas profesionales)";
		}
		
		return FactActivString;
	}
	
	/**
	 * Método implementado de la interfaz IMostrable para devolver el string a imprimir
	 * 
	 * @return string
	 */
	
	@Override
	public String dameCadena() {
		String SoLong = null;
		SoLong = "\nAlias: " + this.Alias;
		SoLong = SoLong + "\nContrasenya: " + this.PassToCensored() + "\n";
		SoLong = SoLong + "Nombre: " + this.Nombre + "\n";
		SoLong = SoLong + "Apellido1: " + this.Apellido1 + "\n";
		SoLong = SoLong + "Apellido2: " + this.Apellido2 + "\n";
		SoLong = SoLong + "Fecha De Nacimiento: " + this.FechaNacimiento + "\n";
		SoLong = SoLong + "Edad: " + this.Edad + "\n";
		SoLong = SoLong + "Altura: " + this.altura + "\n";
		SoLong = SoLong + "Peso: " + this.peso + "\n";
		SoLong = SoLong + "Sexo: " + this.Sexo + "\n";
		SoLong = SoLong + "IMC: " + this.IMC + "\n";
		SoLong = SoLong + "Sugerencia: " + this.Sugerencia + "\n";
		SoLong = SoLong + "Factor Actividad: " + this.FactorActivToString() + "\n";
		
		SoLong = SoLong + "\n\nActividades Realizadas:\n\n";
		
		boolean activ = true;
		try {
			this.ActivRealiz.size();
		}
		catch(NullPointerException e) {
			SoLong = SoLong + ("No hay Actividades Registradas\n");
			activ = false;
		}
		
		if(activ == true) {
			for(int i = 0 ; i < this.ActivRealiz.size() ; i++) {
				Actividad bucle = this.ActivRealiz.get(i);
				SoLong = SoLong + bucle.dameCadena();
				SoLong = SoLong + "\n\n";
			}
		}
		
		SoLong = SoLong + "\nCambios de peso:\n\n";
		
		boolean cpesos = true;
		try {
			this.CambiosDePeso.size();
		}
		catch(NullPointerException e) {
			SoLong = SoLong + ("No hay cambios de peso registrados\n");
			cpesos = false;
		}
		
		if(cpesos == true) {
			for(int i = 0 ; i < this.CambiosDePeso.size() ; i++) {
				CambiosPeso bucle = this.CambiosDePeso.get(i);
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
		SoLong = "Alias: " + this.Alias + "\n";
		SoLong = SoLong + "Contrasenya: " + this.PassToCensored() + "\n";
		SoLong = SoLong + "Nombre: " + this.Nombre + "\n";
		SoLong = SoLong + "Apellido1: " + this.Apellido1 + "\n";
		SoLong = SoLong + "Apellido2: " + this.Apellido2 + "\n";
		SoLong = SoLong + "Fecha De Nacimiento: " + this.FechaNacimiento + "\n";
		SoLong = SoLong + "Edad: " + this.Edad + "\n";
		SoLong = SoLong + "Altura: " + this.altura + "\n";
		SoLong = SoLong + "Peso: " + this.peso + "\n";
		SoLong = SoLong + "Sexo: " + this.Sexo + "\n";
		SoLong = SoLong + "IMC: " + this.IMC + "\n";
		SoLong = SoLong + "Sugerencia: " + this.Sugerencia + "\n";
		SoLong = SoLong + "Factor Actividad: " + this.FactorActivToString() + "\n";
		
		return SoLong;
	}
	
	/**
	 * Devuelve el string para la generacion del PDF (Actividades)
	 * @return string para los datos del arraylist de actividades
	 */
	
	public String dameStringActivPDF() {
		
		String SoLong = "";
		
		//SoLong = "\n\nActividades Realizadas:\n\n";
		
		boolean activ = true;
		try {
			this.ActivRealiz.size();
		}
		catch(NullPointerException e) {
			SoLong = SoLong + ("No hay Actividades Registradas\n");
			activ = false;
		}
		
		if(activ == true) {
			for(int i = 0 ; i < this.ActivRealiz.size() ; i++) {
				Actividad bucle = this.ActivRealiz.get(i);
				SoLong = SoLong + bucle.dameCadena();
				SoLong = SoLong + "\n";
			}
		}
		
		return SoLong;
	}
	
	/**
	 * Devuelve el string para la generacion del PDF (CambiosDePeso)
	 * @return string para los datos del arraylist de cambios de peso
	 */
	
	public String dameStringCambiosPesoPDF() {
		
		String SoLong = "";
		
		//SoLong = SoLong + "\nCambios de peso:\n\n";
		
		boolean cpesos = true;
		try {
			this.CambiosDePeso.size();
		}
		catch(NullPointerException e) {
			SoLong = SoLong + ("No hay cambios de peso registrados\n");
			cpesos = false;
		}
		
		if(cpesos == true) {
			for(int i = 0 ; i < this.CambiosDePeso.size() ; i++) {
				CambiosPeso bucle = this.CambiosDePeso.get(i);
				SoLong = SoLong + bucle.dameCadena();
				SoLong = SoLong + "\n";
			}
		}
		
		return SoLong;
	}
}
