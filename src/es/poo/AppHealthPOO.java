package es.poo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.JsonParseException;

public class AppHealthPOO extends TEXTOS{

	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PersistenciaGSON gson;
	public static TEXTOS textos = new TEXTOS();
	
	/**Da la opcion de elegir un idioma y da paso al menu de inicio
	 * 
	 * @param args : String[]
	 * @throws IOException : Error al introducir datos por consola
	 * @throws ParseException : De la funcion Menu()
	 */
	
	public static void main(String[] args) throws IOException, ParseException {
		
		boolean Lang = false;
		while(Lang == false) {
			System.out.println("1: English");
			System.out.println("2: Español");
			
			try {
				int a = Integer.parseInt(br.readLine());
				switch(a) {
				case 1:
					Lang = true;
					textos.getLang("en_EN");
					break;
				case 2:
					textos.getLang("es_ES");
					Lang = true;
					break;
				/*case 3:
					textos.getLang("ja_JA");
					Lang = true;
					break;*/
				default:
					System.out.println("Invalid option / Opción no válida");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("Input error / Introduzca un valor numérico");
			}
		}
		Menu();
	}
	
	
	/**
	 * Compruebo si existen archivos de persistencia, los cargo en memoria y muestro el menu de inicio
	 * 
	 * @throws ParseException : : Error al introducir un objeto de un tipo en otro (PersonaPremium en persona)
	 */
	
	public static void Menu() throws ParseException {
		
		try {
			gson = new PersistenciaGSON();
			Persona.setPeople(gson.getPersistence());
		}
		catch(JsonParseException e) {
			
		}
		
		boolean Sesion = true;
		while(Sesion == true) {
			System.out.println(MENU1);
			System.out.println(MENU2);
			System.out.println(MENU3);
			System.out.println(MENU4);
			System.out.println(MENU5);
			
			try {
				int a = Integer.parseInt(br.readLine());
				
				switch(a) {
				case 1:
					IniciarSesion();
					break;
				case 2:
					Registrarse();
					break;
				case 3:
					System.out.println(MENU6);
					Sesion = false;
					br.close();
					break;
				default:
					System.out.println(MENU7);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			} 
			catch (IOException e) {
				System.out.println(MENU8);
			}
		}
	}
	
	/**
	 * Compruebo si ya existen usuarios y doy opción a iniciar sesion
	 * 
	 * @throws IOException : Error en el System.in
	 * @throws ParseException : Error al introducir un objeto de un tipo en otro (PersonaPremium en persona)
	 */
	
	public static void IniciarSesion() throws IOException, ParseException {
		boolean hayCuentas = true;
		Persona Usuario = null;
		
		try {
			Persona.getPeople().size();
		}
		catch(NullPointerException e) {
			hayCuentas = false;
		}
		
		if(hayCuentas == true) {
			System.out.println(INICIAR);//Muestro por pantalla cuantas personas existen en el arraylist de personas
			int i;
			ArrayList<Persona> InicioSesion = Persona.getPeople();
			for(i=0 ; i<InicioSesion.size() ; i++) {
				Persona bucle_de_busqueda;
				bucle_de_busqueda = InicioSesion.get(i);
				System.out.println(bucle_de_busqueda.getAlias());
				}
			
			System.out.println(INICIAR1);
			
			int UsuarioID = 0;
			
			boolean cancelar = false;
			boolean inicioSesion = false;
			while(inicioSesion == false && cancelar == false) {
				System.out.println(INICIAR2);
				String username = br.readLine();
				
				if(username.equals("cancelar")) {
					cancelar = true;
				}
				else {
					for(i=0 ; i<InicioSesion.size() && inicioSesion == false; i++) {//Busco en el arraylist de personas y compruebo que el alias introducido existe
						Persona bucle_de_busqueda;
						bucle_de_busqueda = InicioSesion.get(i);
						if(bucle_de_busqueda.getAlias().equals(username)) {
							inicioSesion = true;
							UsuarioID = i;//Si existe el alias introducido, me guardo su posición en el arraylist de personas para mayor facilidad
							Usuario = InicioSesion.get(i);
						}
					}
					if(inicioSesion == false) {
						System.out.println(INICIAR3);
					}
				}
			}
			
			if(cancelar == false) {
				boolean contrasenya = false;
				
				while(contrasenya == false && cancelar == false) {
					System.out.println(INICIAR4);
					String password = br.readLine();
					if(Usuario.PassMATCH(password)) {
						System.out.println(INICIAR5);
						contrasenya = true;
					}
					else if(password.equals("cancelar")) {
						cancelar = true;
					}
					else {
						System.out.println(INICIAR6);
					}
				}
				if(contrasenya == true) {//Cuando se termina el bucle while, compruebo si la contraseña introducida corresponde, e inicio el Menu de Usuario
					MenuUsuario(UsuarioID);
				}
			}
			else {}
		}
		else {
			System.out.println(INICIAR7);
		}
	}
	
	/**
	 * Pido los datos necesarios para poder registrar un usuario, guardo este en un arraylist de personas y me guardo su posición en este
	 * 
	 * @throws IOException : Error en el System.in
	 * @throws ParseException : Error al introducir un objeto de un tipo en otro (PersonaPremium en persona)
	 */
	
	public static void Registrarse() throws IOException, ParseException {
		
		Persona Usuario = new Persona();
		
		String alias = null;
		boolean AliasValid = false;
		boolean hayCuentas = true;
		
		try {
			Persona.getPeople().size();
		}
		catch(NullPointerException e) {
			hayCuentas = false;
		}
		
		while(AliasValid == false) {
			System.out.println(REGISTRARSE);
			alias = br.readLine();
			if(E.isValidAlias(alias)) {
				if(hayCuentas == true) {
					boolean CuentaRep = false;
					ArrayList<Persona> cuentas = Persona.getPeople();
					for(int i = 0 ; i < cuentas.size() ; i++) {
						if(cuentas.get(i).getAlias().equals(alias)) {
							System.out.println(REGISTRARSE1);
							CuentaRep = true;
						}
					}
					if(CuentaRep == false)
						Usuario.setAlias(alias);
						AliasValid = true;
				}
				else {
					AliasValid = true;
				}
			}
			else {
				System.out.println(REGISTRARSE2);
			}
		}
		
		
		boolean PassValid = false;
		while(PassValid == false) {
			System.out.println(REGISTRARSE3);
			
			if(Usuario.setPassword(br.readLine()) == true) {
				PassValid = true;
			}
			else {
				System.out.println(REGISTRARSE4);
			}
		}
		
		System.out.println(REGISTRARSE5);
		String nombre = br.readLine();
		Usuario.setNombre(nombre);
		
		System.out.println(REGISTRARSE6);
		String apellido1 = br.readLine();
		Usuario.setApellido1(apellido1);
		
		System.out.println(REGISTRARSE7);
		String apellido2 = br.readLine();
		Usuario.setApellido2(apellido2);
		
		String fecha = null;
		boolean FechaValid = false;
		while(FechaValid == false) {
			System.out.println(REGISTRARSE8);
			fecha = br.readLine();
			if(E.isValidDate(fecha)) {
				FechaValid = true;
				Usuario.setFechaNacimiento(fecha);
			}
			else {
				System.out.println(REGISTRARSE20);
			}
		}
		
		String sexo = null;
		boolean SexoValid = false;
		while(SexoValid == false) {
			System.out.println(REGISTRARSE9);
			sexo = br.readLine();
			if(sexo.equals("Varon"))
				SexoValid = true;
			else if(sexo.equals("Mujer"))
				SexoValid = true;
			else
				System.out.println(REGISTRARSE10);
				
		}
		Usuario.setSexo(sexo);
		
		double peso = 0;
		boolean PesoValid = false;
		while(PesoValid == false) {
			System.out.println(REGISTRARSE11);
			try {
				peso = Double.parseDouble(br.readLine());
				if(peso > 0) {
					PesoValid = true;
					Usuario.setPeso(peso);
				}
				else {
					System.out.println(REGISTRARSE12);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
			catch(IOException e) {
				System.out.println(MENU8);
			}
		}
		
		double estatura = 0;
		boolean EstatValid = false;
		while(EstatValid == false) {
			System.out.println(REGISTRARSE13);
			try {
				estatura = Double.parseDouble(br.readLine());
				if(estatura > 0) {
					EstatValid = true;
					Usuario.setAltura(estatura);
				}
				else {
					System.out.println(REGISTRARSE12);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
			catch(IOException e) {
				System.out.println(MENU8);
			}
		}
		
		
		boolean factActiv = true;
		double factactivid = 0;
		while(factActiv == true) {
			System.out.println(REGISTRARSE14);
			System.out.println(REGISTRARSE15);
			System.out.println(REGISTRARSE16);
			System.out.println(REGISTRARSE17);
			System.out.println(REGISTRARSE18);
			System.out.println(REGISTRARSE19);
			
			try {
				int a = Integer.parseInt(br.readLine());
				
				switch(a) {
				case 1:
					factactivid = 1.2;
					factActiv = false;
					break;
				case 2:
					factactivid = 1.375;
					factActiv = false;
					break;
				case 3:
					factactivid = 1.55;
					factActiv = false;
					break;
				case 4:
					factactivid = 1.725;
					factActiv = false;
					break;
				case 5:
					factactivid = 1.9;
					factActiv = false;
					break;
				default:
					System.out.println(MENU7);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			} 
			catch (IOException e) {
				System.out.println(MENU8);
			}
			
		}
		
		Usuario.setFactorActividad(factactivid);
		
		
		
		
		try {
			Persona.addPersonaToPeople(Usuario);
		}
		catch(NullPointerException e) {
			Persona.inicializePeople();
			Persona.addPersonaToPeople(Usuario);
		}
		
		gson.setPersistence(Persona.getPeople());
		
		int UserID = 0;
		ArrayList<Persona> prueba = Persona.getPeople();
		for(int i = 0 ; i < prueba.size() ; i++) {
			if(prueba.get(i).getAlias().equals(alias)) {
				UserID = i;
			}
		}
		
		MenuUsuario(UserID);
	}
	
	/**Una vez realizado el login o el registro muestro las opciones que puede elejir el usuario. Tambien comprueba, si se es premium, si este ha caducado, y en dicho caso, se convertirá de nuevo a Persona
	 * 
	 * @param UserID : Posicion de la persona seleccionada en el arraylist de persona
	 * @throws IOException : Error en el System.in
	 * @throws ParseException : Error al introducir un objeto de un tipo en otro (PersonaPremium en persona)
	 */
	
	public static void MenuUsuario(int UserID) throws IOException, ParseException {
		
		boolean Sesion = true;
		while(Sesion == true) {
			Persona Usuario = Persona.getSpecificPerson(UserID);
			
			if(Usuario instanceof PersonaPremium) {
				System.out.println(PREMIUM11 + ((PersonaPremium) Usuario).getPremiumRemain());
				System.out.println(PREMIUM12 + ((PersonaPremium) Usuario).getFechaAltaPremium());
				System.out.println(PREMIUM13);
				
				int prem = ((PersonaPremium) Usuario).calcularDuracionPrem();
				
				if( prem < 0 ) {
					System.out.println(String.format(PREMIUM14, (prem*(-1))));
				}
				else {
					if(((PersonaPremium) Usuario).getPremiumRemain().equals("Mensual")){
						
						int dias = (int) (prem/24);
						
						if( dias < 30 ) {
							System.out.println(String.format(PREMIUM15, (30 - dias)));
						}
						else {
							System.out.println(PREMIUM16);
							Usuario = Usuario.PremiumToPersona();
							Persona.setPersonaToPeople(Usuario, UserID);
						}
					}
					else if(((PersonaPremium) Usuario).getPremiumRemain().equals("Anual")){
						
						int meses = (int) (prem / (30.43*24));
						System.out.println(meses);
						if( meses < 12 ) {
							System.out.println(String.format(PREMIUM17, (12 - meses)));
						}
						else {
							System.out.println(PREMIUM16);
							Usuario = Usuario.PremiumToPersona();
							Persona.setPersonaToPeople(Usuario, UserID);
						}
						
					}
					else if(((PersonaPremium) Usuario).getPremiumRemain().equals("Indefinido")){
						System.out.println(PREMIUM18);
					}
				}
				System.out.println("\n");
			}
			
			System.out.println(USUARIO);
			System.out.println(USUARIO1);
			System.out.println(USUARIO2);
			System.out.println(USUARIO3);
			System.out.println(USUARIO4);
			System.out.println(USUARIO5);
			System.out.println(USUARIO6);
			System.out.println(USUARIO7);
			System.out.println(USUARIO8);
			
			try {
				
				int a = Integer.parseInt(br.readLine());
				switch(a) {
				case 1:
					ConvertPremium(Usuario, UserID);
					break;
				case 2:
					PassChange(Usuario, UserID);
					break;
				case 3:
					IntrPeso(Usuario, UserID);
					break;
				case 4:
					RegActiv(Usuario, UserID);
					break;
				case 5:
					MostInf(Usuario);
					break;
				case 6:
					InfPDF(Usuario);
					break;
				case 7:
					Sesion = false;
					System.out.println(USUARIO9);
					break;
				default:
					System.out.println(MENU7);
				}
				
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
		}
	}
	
	/**Opción para convertir una persona en personaPremium, y si ya lo es, especifica el premium establecido, la fecha introducida y si el premium sigue o no activo
	 * 
	 * @param Usuario : Usuario que va a ser convertido
	 * @param UserID : posicion del usuario en el arraylist de personas para sobreescribirlo con la personaPremium
	 * @throws IOException : Error en el System.in
	 * @throws ParseException : Error al introducir un objeto de un tipo en otro (PersonaPremium en persona)
	 */
	
	public static void ConvertPremium(Persona Usuario, int UserID) throws IOException, ParseException {
		if(Usuario instanceof PersonaPremium) {
			System.out.println(PREMIUM);
			
			
		}
		else {
			boolean ValidPrem = false;
			String Remain = null;
			while(ValidPrem == false) {
				System.out.println(PREMIUM1);
				System.out.println(PREMIUM2);
				System.out.println(PREMIUM3);
				System.out.println(PREMIUM4);
				try {
					int a = Integer.parseInt(br.readLine());
					switch(a) {
					case 1:
						Remain = "Mensual";
						ValidPrem = true;
						break;
					case 2:
						Remain = "Anual";
						ValidPrem = true;
						break;
					case 3:
						Remain = "Indefinido";
						ValidPrem = true;
						break;
					default:
						System.out.println(MENU7);
					}
				}
				catch(NumberFormatException e) {
					System.out.println(MENU8);
				}
			}
					
			boolean fechaValid = false;
			String fecha = null;
			while(fechaValid == false) {
				System.out.println(PREMIUM5);
				fecha = br.readLine();
				if(PersonaPremium.isValidDatePremium(fecha)) {
					System.out.println(PREMIUM6);
					fechaValid = true;
				}
				else {
					System.out.println(REGISTRARSE20);
				}
			}
					
			PersonaPremium persona = new PersonaPremium(Usuario);
			String pass = null;
			boolean ValidPassPrem = false;
			while(ValidPassPrem == false) {
				System.out.println(PREMIUM7);
				System.out.println(PREMIUM8);
				pass = br.readLine();
				if(persona.setPassword(pass)) {
					System.out.println(PREMIUM9);
					ValidPassPrem = true;
				}
				else {
					System.out.println(PREMIUM10);
				}
			}
			
			persona.setPremiumRemain(Remain);
			persona.setFechaAltaPremium(fecha);
			Persona.setPersonaToPeople(persona, UserID);
			gson.setPersistence(Persona.getPeople());
		}
	}
	
	/**Doy la opción por cambiar la contraseña al usuario por otra valida dependiendo si es o no premim,
	 * añadiendo primero la introduccion de la contraseña actual
	 * 
	 * @param Usuario : Usuario al que se le va a cambiar la contraseña
	 * @param UserID : Posicion del usuario en el arraylist para actualizarlo con la nueva contraseña
	 * @throws IOException : Error en el System.in
	 */
	
	public static void PassChange(Persona Usuario, int UserID) throws IOException {
		String pass = null;
		boolean PassValid = false;
		boolean cancelar = false;
		
		while(PassValid == false && cancelar == false) {
			System.out.println(CONTRASENYA);
			pass = br.readLine();
			if(pass.equals("cancelar")) {
				PassValid = true;
				cancelar = true;
			}
			else if(Usuario.PassMATCH(pass)) {
				PassValid = true;
			}
			else {
				System.out.println(CONTRASENYA1);
			}
		}
		
		PassValid = false;
		while(PassValid == false && cancelar == false) {
			System.out.println(CONTRASENYA2);
			pass = br.readLine();
			if(pass.equals("cancelar")) {
				PassValid = true;
				cancelar = true;
			}
			else if(Usuario.setPassword(pass)) {
				PassValid = true;
			}
			else {
				if(Usuario instanceof PersonaPremium)
					System.out.println(REGISTRARSE4);
				else
					System.out.println(CONTRASENYA4);
			}
		}
		
		Persona.setPersonaToPeople(Usuario, UserID);
		gson.setPersistence(Persona.getPeople());
	}
	
	/**Opción para introducir cambios de peso en el usuario
	 * 
	 * @param Usuario : Usuario en cuyo arraylist de cambios de peso se guardarán estos
	 * @param UserID : Posición del usuario en el arraylist para actualizarlo en este
	 * @throws IOException : Error en el System.in
	 */
	
	public static void IntrPeso(Persona Usuario, int UserID) throws IOException {
		
		double peso = 0;
		boolean PesoValid = false;
		while(PesoValid == false) {
			System.out.println(REGISTRARSE11);
			try {
				peso = Double.parseDouble(br.readLine());
				if(peso > 0) {
					PesoValid = true;
				}
				else {
					System.out.println(REGISTRARSE12);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
			catch(IOException e) {
				System.out.println(MENU8);
			}
		}
		
		String fecha = null;
		boolean FechaValid = false;
		while(FechaValid == false) {
			System.out.println(PESO);
			fecha = br.readLine();
			if(E.isValidDate(fecha)) {
				FechaValid = true;
			}
			else {
				System.out.println(REGISTRARSE20);
			}
		}
		
		try {
			Usuario.getCambiosDePeso().size();
		}
		catch(NullPointerException e) {
			Usuario.inicializeCambiosDePeso();
		}
		CambiosPeso registro = new CambiosPeso(peso, fecha);
		registro.setIMC(Usuario.calcularIMC(peso, Usuario.getAltura()));
		
		Usuario.setPeso(peso);
		Usuario.setIMC(Usuario.calcularIMC(peso, Usuario.getAltura()));
		Usuario.addCambiosDePeso(registro);
		Persona.setPersonaToPeople(Usuario, UserID);
		gson.setPersistence(Persona.getPeople());
	}
	
	/**Opcion para poder registrar en el usuario una actividad
	 * 
	 * @param Usuario : Usuario en cuyo arraylist de actividades se guardarán estos
	 * @param UserID : Posición del usuario en el arraylist para actualizarlo en este
	 * @throws IOException : Error en el System.in
	 * @throws ParseException : Error al introducir un objeto de un tipo en otro (PersonaPremium en persona)
	 */
	
	public static void RegActiv(Persona Usuario, int UserID) throws IOException, ParseException {
		boolean ActivSelected = false;
		String Active = null;
		
		Actividad nuevaActiv = new Actividad();
		
		while(ActivSelected == false) {
			System.out.println(ACTIVIDAD);
			System.out.println(ACTIVIDAD1);
			System.out.println(ACTIVIDAD2);
			System.out.println(ACTIVIDAD3);
			System.out.println(ACTIVIDAD4);
			try {
				int a = Integer.parseInt(br.readLine());
				
				switch(a) {
				case 1:
					Active = "Actividad Generica";
					ActivSelected = true;
					break;
				case 2:
					Active = "Cycling";
					ActivSelected = true;
					break;
				case 3:
					Active = "Running";
					ActivSelected = true;
					break;
				case 4:
					Active = "Swimming";
					ActivSelected = true;
					break;
				default:
					System.out.println(MENU7);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
		}
		
		String fecha1 = null;
		boolean FechaValid = false;
		while(FechaValid == false) {
			System.out.println(ACTIVIDAD5);
			fecha1 = br.readLine();
			if(nuevaActiv.setFechaInicio(fecha1)) {
				FechaValid = true;
			}
			else {
				System.out.println(REGISTRARSE20);
			}
		}
		
		String fecha2 = null;
		FechaValid = false;
		while(FechaValid == false) {
			System.out.println(ACTIVIDAD6);
			fecha2 = br.readLine();
			if(nuevaActiv.setFechaFin(fecha2)) {
				FechaValid = true;
			}
			else {
				System.out.println(REGISTRARSE20);
			}
		}
		
		nuevaActiv.calcularDuracion(fecha1, fecha2);
		
		boolean distancia = false;
		int distance = 0;
		while(distancia == false) {
			System.out.println(ACTIVIDAD7);
			try {
				distance = Integer.parseInt(br.readLine());
				if(distance > 0) {
					nuevaActiv.setDistancia(distance);
					distancia = true;
				}
				else
					System.out.println(REGISTRARSE12);
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
		}
		
		boolean FC = false;
		int FcMax = 0;
		while(FC == false) {
			System.out.println(ACTIVIDAD8);
			
			try {
				FcMax = Integer.parseInt(br.readLine());
				if(FcMax > 0) {
					nuevaActiv.setFcMax(FcMax);
					FC = true;
				}
				else
					System.out.println(REGISTRARSE12);
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
		}
		
		FC = false;
		int FcMin = 0;
		while(FC == false) {
			System.out.println(ACTIVIDAD9);
			
			try {
				FcMin = Integer.parseInt(br.readLine());
				if(FcMin > 0) {
					nuevaActiv.setFcMin(FcMin);
					FC = true;
				}
				else
					System.out.println(REGISTRARSE12);
			}
			catch(NumberFormatException e) {
				System.out.println(MENU8);
			}
		}
		
		double FcMedia = ((FcMax + FcMin)/2);
		
		nuevaActiv.calcularCaloriasConsumidas(Usuario, FcMedia, nuevaActiv.getDuracion(), Active);
		
		
		if(Active.equals("Actividad Generica")) {
			
			
			try {
				Usuario.getActivRealiz().size();
			}
			catch(NullPointerException e) {
				Usuario.inicializeActivRealiz();
			}
			
			Usuario.addActivRealiz(nuevaActiv);
			Persona.setPersonaToPeople(Usuario, UserID);
			gson.setPersistence(Persona.getPeople());
		}
		else if(Active.equals("Cycling")) {
			
			Cycling ciclismo = new Cycling(nuevaActiv.getFechaInicio(), nuevaActiv.getFechaFin(), nuevaActiv.getDuracion(), nuevaActiv.getDistancia(), nuevaActiv.getFcMax(), nuevaActiv.getFcMin(), FcMedia, nuevaActiv.getKcalConsum());
			
			boolean ratio = false;
			int cadencia = 0;
			while(ratio == false) {
				System.out.println(ACTIVIDAD10);
				
				try {
					cadencia = Integer.parseInt(br.readLine());
					if(cadencia > 0) {
						ciclismo.setCadencia(cadencia);
						ratio = true;
					}
					else
						System.out.println(REGISTRARSE12);
				}
				catch(NumberFormatException e) {
					System.out.println(MENU8);
				}
			}
			
			try {
				Usuario.getActivRealiz().size();
			}
			catch(NullPointerException e) {
				Usuario.inicializeActivRealiz();
			}
			
			Usuario.addActivRealiz(ciclismo);
			Persona.setPersonaToPeople(Usuario, UserID);
			gson.setPersistence(Persona.getPeople());
			
		}
		else if(Active.equals("Running")){
			
			Running correr = new Running(nuevaActiv.getFechaInicio(), nuevaActiv.getFechaFin(), nuevaActiv.getDuracion(), nuevaActiv.getDistancia(), nuevaActiv.getFcMax(), nuevaActiv.getFcMin(), FcMedia, nuevaActiv.getKcalConsum());
			
			String ritmo = null;
			boolean ritmoValid = false;
			while(ritmoValid == false) {
				System.out.println(ACTIVIDAD11);
				ritmo = br.readLine();
				if(E.duracionValid(ritmo)) {
					ritmoValid = true;
					correr.setRitmo(ritmo);
				}
				else {
					System.out.println(ACTIVIDAD12);
				}
			}
			
			boolean elev = false;
			int elevacion = 0;
			while(elev == false) {
				System.out.println(ACTIVIDAD13);
				
				try {
					elevacion = Integer.parseInt(br.readLine());
					if(elevacion > 0) {
						elev = true;
						correr.setElevacion(elevacion);
					}
					else
						System.out.println(REGISTRARSE12);
				}
				catch(NumberFormatException e) {
					System.out.println(MENU8);
				}
			}
			
			boolean pasos = false;
			int passos = 0;
			while(pasos == false) {
				System.out.println(ACTIVIDAD14);
				
				try {
					passos = Integer.parseInt(br.readLine());
					if(passos > 0) {
						pasos = true;
						correr.setNumPasos(passos);
					}
					else
						System.out.println(REGISTRARSE12);
				}
				catch(NumberFormatException e) {
					System.out.println(MENU8);
				}
			}
			
			double cadencia = (passos / E.calcularEnMinutosH(ritmo)) * (-1);
			correr.setCadencia(cadencia);
			
			try {
				Usuario.getActivRealiz().size();
			}
			catch(NullPointerException e) {
				Usuario.inicializeActivRealiz();
			}
			
			Usuario.addActivRealiz(correr);
			Persona.setPersonaToPeople(Usuario, UserID);
			gson.setPersistence(Persona.getPeople());
			
		}
		else if(Active.equals("Swimming")) {
			
			Swimming natacion = new Swimming(nuevaActiv.getFechaInicio(), nuevaActiv.getFechaFin(), nuevaActiv.getDuracion(), nuevaActiv.getDistancia(), nuevaActiv.getFcMax(), nuevaActiv.getFcMin(), FcMedia, nuevaActiv.getKcalConsum());
			
			boolean largoss = false;
			int largos = 0;
			while(largoss == false) {
				System.out.println(ACTIVIDAD15);
				
				try {
					largos = Integer.parseInt(br.readLine());
					if(largos >= 0) {
						largoss = true;
						natacion.setNumLargos(largos);
					}
					else
						System.out.println(ACTIVIDAD16);
				}
				catch(NumberFormatException e) {
					System.out.println(MENU8);
				}
			}
			
			boolean Largos = false;
			String LargosTyp = null;
			while(Largos == false) {
				System.out.println(ACTIVIDAD17);
				System.out.println(ACTIVIDAD18);
				System.out.println(ACTIVIDAD19);
				try {
					int a = Integer.parseInt(br.readLine());
					
					switch(a) {
					case 1:
						LargosTyp = "Piscina";
						Largos = true;
						break;
					case 2:
						LargosTyp = "Mar";
						Largos = true;
						break;
					default:
						System.out.println(MENU7);
					}
				}
				catch(NumberFormatException e) {
					System.out.println(MENU8);
				}
			}
			natacion.setTipoNatacion(LargosTyp);
			
			
			
			try {
				Usuario.getActivRealiz().size();
			}
			catch(NullPointerException e) {
				Usuario.inicializeActivRealiz();
			}
			
			Usuario.addActivRealiz(natacion);
			Persona.setPersonaToPeople(Usuario, UserID);
			gson.setPersistence(Persona.getPeople());
		}
	}
	
	/**Muestro el informe completo por pantalla
	 * 
	 * @param Usuario: Usuario cuyo informe va a mostrarse
	 */
	
	public static void MostInf(Persona Usuario) {
		System.out.println(Usuario.dameCadena());
	}
	
	/**genera un PDF con el informe del usuario
	 * 
	 * @param Usuario: Usuario cuyo informe va a generarse
	 */
	
	public static void InfPDF(Persona Usuario) {
		try {
			InformePDF.generacionPDF(Usuario.dameStringPDF(), Usuario.dameStringActivPDF(), Usuario.dameStringCambiosPesoPDF(), Usuario.getAlias());
		}
		catch(FileNotFoundException e) {
			System.out.println(PDF);
		}
	}
}