package es.poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

class TEXTOS {
	//Textos por si falla la deserializacion de idiomas
	
	//MENU INICIO
	public static String MENU1 = "Bienvenido a App Health POO--------------------------------------------\n";
	public static String MENU2 = "1: Iniciar Sesión";
	public static String MENU3 = "2: Crear Usuario";
	public static String MENU4 = "3: Salir";
	public static String MENU5 = "\nElija que opción desea:";
	public static String MENU6 = "Saliendo...";
	public static String MENU7 = "Introduzca una opción válida";
	public static String MENU8 = "Introduzca un valor numérico";
	//INICIO SESION
	public static String INICIAR  = "Usuarios disponibles :";
	public static String INICIAR1 = "--------------------------------------------------------------------------------";
	public static String INICIAR2 = "Introduzca su alias o introduzca 'cancelar'";
	public static String INICIAR3 = "No existe el usuario introducido";
	public static String INICIAR4 = "Introduzca su contraseña o introduzca 'cancelar'";
	public static String INICIAR5 = "Contraseña correcta";
	public static String INICIAR6 = "La contraseña no es correcta";
	public static String INICIAR7 = "Debe crear una cuenta para poder iniciar sesión";
	//REGISTRARSE
	public static String REGISTRARSE   = "Introduzca el alias que desee:";
	public static String REGISTRARSE1  = "Este alias ya existe";
	public static String REGISTRARSE2  = "Introduzca un alias con al menos una letra o numero";
	public static String REGISTRARSE3  = "Introduzca la contraseña que desee:";
	public static String REGISTRARSE4  = "Introduzca una contraseña de al menos 6 caracteres que debe ser solo letras y números (Obligatorio una letra y un numero)";
	public static String REGISTRARSE5  = "Introduzca su nombre:";
	public static String REGISTRARSE6  = "Introduzca su primer apellido:";
	public static String REGISTRARSE7  = "Introduzca su segundo apellido:";
	public static String REGISTRARSE8  = "Introduzca su fecha de nacimiento con formato DD/MM/AAA :";
	public static String REGISTRARSE9  = "Introduzca su sexo ( Varon / Mujer ):";
	public static String REGISTRARSE10 = "Introduzca una opción válida";
	public static String REGISTRARSE11 = "Introduzca su peso en kilogramos separando los decimales con '.':";
	public static String REGISTRARSE12 = "Introduzca un valor mayor que 0";
	public static String REGISTRARSE13 = "Introduzca su estatura en metros separando los decimales con '.':";
	public static String REGISTRARSE14 = "Elija que tipo de persona es respecto a su frecuencia de actividad";
	public static String REGISTRARSE15 = "1: Persona sedentaria";
	public static String REGISTRARSE16 = "2: Actividad ligera (1 a 3 veces por semana)";
	public static String REGISTRARSE17 = "3: Actividad moderada (3 a 5 veces por semana)";
	public static String REGISTRARSE18 = "4: Actividad intensa (6 a 7 veces por semana)";
	public static String REGISTRARSE19 = "5: Actividad extremadamente alta (atletas profesionales)";
	public static String REGISTRARSE20 = "Introduzca una fecha válida, que sea la actual o que haya pasado";
	//MENUUSUARIO
	public static String USUARIO  = "Bienvenido Usuario:";
	public static String USUARIO1 = "Indique que opción desea realizar:\n";
	public static String USUARIO2 = "1: Conversión de cuenta a cuenta premium";
	public static String USUARIO3 = "2: Cambio de contraseña";
	public static String USUARIO4 = "3: Introducir peso";
	public static String USUARIO5 = "4: Registrar actividad";
	public static String USUARIO6 = "5: Mostrar informe";
	public static String USUARIO7 = "6: Generar informe PDF";
	public static String USUARIO8 = "7: Cerrar sesión";
	public static String USUARIO9 = "Cerrando sesión...\n";
	//PREMIUM
	public static String PREMIUM   = "\nUsted ya es premium\n";
	public static String PREMIUM1  = "Introduzca que duración quiere de suscripción";
	public static String PREMIUM2  = "1: Mensual";
	public static String PREMIUM3  = "2: Anual";
	public static String PREMIUM4  = "3: Indefinida";
	public static String PREMIUM5  = "Introduzca la fecha en la que quiere que su premium comience con formato DD/MM/AAA :";
	public static String PREMIUM6  = "A partir de esta fecha comenzará su suscripción premium";
	public static String PREMIUM7  = "Para mayor seguridad debe introducir una nueva contraseña, que debe tener una longitud de 8 caracteres, conteniendo en estos 1 número, una mayúscula y un caracter no alfanumérico (+,*,#,$,...)";
	public static String PREMIUM8  = "Introduzca su nueva contraseña";
	public static String PREMIUM9  = "Contraseña cambiada correctamente";
	public static String PREMIUM10 = "Debe introducir una contraseña correspondiente a lo especificado anteriormente";
	public static String PREMIUM11 = "Opción elegida de premium: ";
	public static String PREMIUM12 = "Premium dado de alta: ";
	public static String PREMIUM13 = "Estado de premium: ";
	public static String PREMIUM14 = "Faltan %s horas para que comience su periodo premium";
	public static String PREMIUM15 = "Le quedan %s dias de premium";
	public static String PREMIUM16 = "Su premium ha caducado, por lo que se convertirá de nuevo en un usuario estándar";
	public static String PREMIUM17 = "Le quedan %s meses de premium";
	public static String PREMIUM18 = "Su premium es indefinido";
	//CAMBIAR CONTRASENYA
	public static String CONTRASENYA  = "Introduzca la contraseña que actualmente tiene o introduzca 'cancelar':";
	public static String CONTRASENYA1 = "La contraseña no coincide";
	public static String CONTRASENYA2 = "Introduzca la contraseña que desee o introduzca 'cancelar':";
	public static String CONTRASENYA4 = "Introduzca una contraseña de al menos 8 caracteres, conteniendo en estos 1 número, una mayúscula y un caracter no alfanumérico (+,*,#,$,...)";
	//INTRODUCIR PESO
	public static String PESO = "Introduzca la fecha en la que se pesó con formato DD/MM/AAA :";
	//REGISTRAR ACTIVIDAD
	public static String ACTIVIDAD   = "Elija que tipo de actividad quiere realizar";
	public static String ACTIVIDAD1  = "1: Actividad genérica";
	public static String ACTIVIDAD2  = "2: Cycling";
	public static String ACTIVIDAD3  = "3: Running";
	public static String ACTIVIDAD4  = "4: Swimming";
	public static String ACTIVIDAD5  = "Introduzca cuando comenzó la actividad con formato DD/MM/AAA HH:MM:SS :";
	public static String ACTIVIDAD6  = "Introduzca cuando finalizó la actividad con formato DD/MM/AAA HH:MM:SS :";
	public static String ACTIVIDAD7  = "Introduzca cuanta distancia ha recorrido en metros:";
	public static String ACTIVIDAD8  = "Introduzca las pulsaciones máxima que ha tenido:";
	public static String ACTIVIDAD9  = "Introduzca las pulsaciones mínima que ha tenido:";
	public static String ACTIVIDAD10 = "Introduzca el ratio por minuto de pedaleos:";
	public static String ACTIVIDAD11 = "Introduzca cual era su ritmo con formato 'HH:MM' :";
	public static String ACTIVIDAD12 = "Introduzca una duración con el formato anterior";
	public static String ACTIVIDAD13 = "Introduzca cuantos metros ha ascendido:";
	public static String ACTIVIDAD14 = "Introduzca cuantos pasos ha realizado:";
	public static String ACTIVIDAD15 = "Introduzca cuantos largos ha realizado:";
	public static String ACTIVIDAD16 = "Introduzca un valor positivo";
	public static String ACTIVIDAD17 = "Elija donde realizó la natación:";
	public static String ACTIVIDAD18 = "1: Piscina";
	public static String ACTIVIDAD19 = "2: Mar";
	//PDF
	public static String PDF = "Cierre su informe para que pueda ser editado";
	
	
	public static ArrayList<String> ChosenLang = new ArrayList<>();
	
	/**Obtengo de persistencia los strings del idioma correspondiente
	 * 
	 * @param Lang : Idioma elegido
	 */
	public void getLang(String Lang) {
		
		String cadena = "";

		try {//Componemos una cadena de texto a partir de varias lineas de archivo, donde estan guardados los datos de los usuarios
			FileInputStream fis;
			File file = new File("./lang/" + Lang + ".txt");
			fis = new FileInputStream(file);
			if (fis != null) {
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linea = "";
				StringBuilder sb = new StringBuilder();
				while ((linea = br.readLine()) != null) {
					sb.append(linea);//Vamos leyendo linea a linea del texto y los vamos concatenando en un StringBuilder
				}
			isr.close();
			cadena = sb.toString();//El StringBuilder lo transformamos a string
			}
		}
		catch (FileNotFoundException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }

		if (cadena.isEmpty()) {}
		else {
			//Deserializar
			
			
	    	Gson gson = new Gson();
	    	
			java.lang.reflect.Type listType = new TypeToken<ArrayList<String>>() {}.getType();
			TEXTOS.ChosenLang = gson.fromJson(cadena, listType);
		}
		
		CambiarCads();
		
	}
	
	/**
	 * Almaceno los strings del idioma seleccionado
	 */
	
	private void CambiarCads() {
		//MENU INICIO
		MENU1 = ChosenLang.get(0);
		MENU2 = ChosenLang.get(1);
		MENU3 = ChosenLang.get(2);
		MENU4 = ChosenLang.get(3);
		MENU5 = ChosenLang.get(4);
		MENU6 = ChosenLang.get(5);
		MENU7 = ChosenLang.get(6);
		MENU8 = ChosenLang.get(7);
		//INICIO SESION
		INICIAR  = ChosenLang.get(8);
		INICIAR1 = ChosenLang.get(9);
		INICIAR2 = ChosenLang.get(10);
		INICIAR3 = ChosenLang.get(11);
		INICIAR4 = ChosenLang.get(12);
		INICIAR5 = ChosenLang.get(13);
		INICIAR6 = ChosenLang.get(14);
		INICIAR7 = ChosenLang.get(15);
		//REGISTRARSE
		REGISTRARSE   = ChosenLang.get(16);
		REGISTRARSE1  = ChosenLang.get(17);
		REGISTRARSE2  = ChosenLang.get(18);
		REGISTRARSE3  = ChosenLang.get(19);
		REGISTRARSE4  = ChosenLang.get(20);
		REGISTRARSE5  = ChosenLang.get(21);
		REGISTRARSE6  = ChosenLang.get(22);
		REGISTRARSE7  = ChosenLang.get(23);
		REGISTRARSE8  = ChosenLang.get(24);
		REGISTRARSE9  = ChosenLang.get(25);
		REGISTRARSE10 = ChosenLang.get(26);
		REGISTRARSE11 = ChosenLang.get(27);
		REGISTRARSE12 = ChosenLang.get(28);
		REGISTRARSE13 = ChosenLang.get(29);
		REGISTRARSE14 = ChosenLang.get(30);
		REGISTRARSE15 = ChosenLang.get(31);
		REGISTRARSE16 = ChosenLang.get(32);
		REGISTRARSE17 = ChosenLang.get(33);
		REGISTRARSE18 = ChosenLang.get(34);
		REGISTRARSE19 = ChosenLang.get(35);
		REGISTRARSE20 = ChosenLang.get(36);
		//MENUUSUARIO
		USUARIO  = ChosenLang.get(37);
		USUARIO1 = ChosenLang.get(38);
		USUARIO2 = ChosenLang.get(39);
		USUARIO3 = ChosenLang.get(40);
		USUARIO4 = ChosenLang.get(41);
		USUARIO5 = ChosenLang.get(42);
		USUARIO6 = ChosenLang.get(43);
		USUARIO7 = ChosenLang.get(44);
		USUARIO8 = ChosenLang.get(45);
		USUARIO9 = ChosenLang.get(46);
		//PREMIUM
		PREMIUM   = ChosenLang.get(47);
		PREMIUM1  = ChosenLang.get(48);
		PREMIUM2  = ChosenLang.get(49);
		PREMIUM3  = ChosenLang.get(50);
		PREMIUM4  = ChosenLang.get(51);
		PREMIUM5  = ChosenLang.get(52);
		PREMIUM6  = ChosenLang.get(53);
		PREMIUM7  = ChosenLang.get(54);
		PREMIUM8  = ChosenLang.get(55);
		PREMIUM9  = ChosenLang.get(56);
		PREMIUM10 = ChosenLang.get(57);
		PREMIUM11 = ChosenLang.get(58);
		PREMIUM12 = ChosenLang.get(59);
		PREMIUM13 = ChosenLang.get(60);
		PREMIUM14 = ChosenLang.get(61);
		PREMIUM15 = ChosenLang.get(62);
		PREMIUM16 = ChosenLang.get(63);
		PREMIUM17 = ChosenLang.get(64);
		PREMIUM18 = ChosenLang.get(65);
		//CAMBIAR CONTRASENYA
		CONTRASENYA  = ChosenLang.get(66);
		CONTRASENYA1 = ChosenLang.get(67);
		CONTRASENYA2 = ChosenLang.get(68);
		CONTRASENYA4 = ChosenLang.get(69);
		//INTRODUCIR PESO
		PESO = ChosenLang.get(70);
		//REGISTRAR ACTIVIDAD
		ACTIVIDAD   = ChosenLang.get(71);
		ACTIVIDAD1  = ChosenLang.get(72);
		ACTIVIDAD2  = ChosenLang.get(73);
		ACTIVIDAD3  = ChosenLang.get(74);
		ACTIVIDAD4  = ChosenLang.get(75);
		ACTIVIDAD5  = ChosenLang.get(76);
		ACTIVIDAD6  = ChosenLang.get(77);
		ACTIVIDAD7  = ChosenLang.get(78);
		ACTIVIDAD8  = ChosenLang.get(79);
		ACTIVIDAD9  = ChosenLang.get(80);
		ACTIVIDAD10 = ChosenLang.get(81);
		ACTIVIDAD11 = ChosenLang.get(82);
		ACTIVIDAD12 = ChosenLang.get(83);
		ACTIVIDAD13 = ChosenLang.get(84);
		ACTIVIDAD14 = ChosenLang.get(85);
		ACTIVIDAD15 = ChosenLang.get(86);
		ACTIVIDAD16 = ChosenLang.get(87);
		ACTIVIDAD17 = ChosenLang.get(88);
		ACTIVIDAD18 = ChosenLang.get(89);
		ACTIVIDAD19 = ChosenLang.get(90);
		//PDF
		PDF = ChosenLang.get(91);
	}
	
	public TEXTOS() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Nada importante. Generacion del txt con los strings para poder persistirlo y traducirlo a otros idiomas
	
	/*
	public void toLang() {
		
    	Gson gson = new Gson();
    	
    	TEXTOS.ChosenLang = this.ES();
    	
		java.lang.reflect.Type listType = new TypeToken<ArrayList<String>>() {}.getType();
		String object = gson.toJson(TEXTOS.ChosenLang, listType);

		try{
			
				//Intentamos abrir el fichero de texto
				FileOutputStream fop;
				File file = new File("./lang/es_ES.txt");
				fop = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fop);

				osw.write(object);//Escribimos la informaciÃ³n
				osw.close();//Y cerramos el fichero de texto

		}
		catch (IOException e){}
	}
	
	
	
	
	
	public ArrayList<String> ES() {
		ArrayList<String> lol = new ArrayList<>();
		lol.add("Bienvenido a App Health POO--------------------------------------------\n");
		lol.add("1: Iniciar Sesión");
		lol.add("2: Crear Usuario");
		lol.add("3: Salir");
		lol.add("\nElija que opción desea:");
		lol.add("Saliendo...");
		lol.add("Introduzca una opción válida");
		lol.add("Introduzca un valor numérico");
		//INICIO SESION
		lol.add("Usuarios disponibles :");
		lol.add("--------------------------------------------------------------------------------");
		lol.add("Introduzca su alias o introduzca 'cancelar'");
		lol.add("No existe el usuario introducido");
		lol.add("Introduzca su contraseña o introduzca 'cancelar'");
		lol.add("Contraseña correcta");
		lol.add("La contraseña no es correcta");
		lol.add("Debe crear una cuenta para poder iniciar sesión");
		//REGISTRARSE
		lol.add("Introduzca el alias que desee:");
		lol.add("Este alias ya existe");
		lol.add("Introduzca un alias con al menos una letra o numero");
		lol.add("Introduzca la contraseña que desee:");
		lol.add("Introduzca una contraseña de al menos 6 caracteres que debe ser solo letras y números (Obligatorio una letra y un numero)");
		lol.add("Introduzca su nombre:");
		lol.add("Introduzca su primer apellido:");
		lol.add("Introduzca su segundo apellido:");
		lol.add("Introduzca su fecha de nacimiento con formato DD/MM/AAA :");
		lol.add("Introduzca su sexo ( Varon / Mujer ):");
		lol.add("Introduzca una opción válida");
		lol.add("Introduzca su peso en kilogramos separando los decimales con '.':");
		lol.add("Introduzca un valor mayor que 0");
		lol.add("Introduzca su estatura en metros separando los decimales con '.':");
		lol.add("Elija que tipo de persona es respecto a su frecuencia de actividad");
		lol.add("1: Persona sedentaria");
		lol.add("2: Actividad ligera (1 a 3 veces por semana)");
		lol.add("3: Actividad moderada (3 a 5 veces por semana)");
		lol.add("4: Actividad intensa (6 a 7 veces por semana)");
		lol.add("5: Actividad extremadamente alta (atletas profesionales)");
		lol.add("Introduzca una fecha válida, que sea la actual o que haya pasado");
		//MENUUSUARIO
		lol.add("Bienvenido Usuario:");
		lol.add("Indique que opción desea realizar:\n");
		lol.add("1: Conversión de cuenta a cuenta premium");
		lol.add("2: Cambio de contraseña");
		lol.add("3: Introducir peso");
		lol.add("4: Registrar actividad");
		lol.add("5: Mostrar informe");
		lol.add("6: Generar informe PDF");
		lol.add("7: Cerrar sesión");
		lol.add("Cerrando sesión...\n");
		//PREMIUM
		lol.add("\nUsted ya es premium\n");
		lol.add("Introduzca que duración quiere de suscripción");
		lol.add("1: Mensual");
		lol.add("2: Anual");
		lol.add("3: Indefinida");
		lol.add("Introduzca la fecha en la que quiere que su premium comience con formato DD/MM/AAA :");
		lol.add("A partir de esta fecha comenzará su suscripción premium");
		lol.add("Para mayor seguridad debe introducir una nueva contraseña, que debe tener una longitud de 8 caracteres, conteniendo en estos 1 número, una mayúscula y un caracter no alfanumérico (+,*,#,$,...)");
		lol.add("Introduzca su nueva contraseña");
		lol.add("Contraseña cambiada correctamente");
		lol.add("Debe introducir una contraseña correspondiente a lo especificado anteriormente");
		lol.add("Opción elegida de premium: ");
		lol.add("Premium dado de alta: ");
		lol.add("Estado de premium: ");
		lol.add("Faltan %s horas para que comience su periodo premium");
		lol.add("Le quedan %s dias de premium");
		lol.add("Su premium ha caducado, por lo que se convertirá de nuevo en un usuario estándar");
		lol.add("Le quedan %s meses de premium");
		lol.add("Su premium es indefinido");
		//CAMBIAR CONTRASENYA
		lol.add("Introduzca la contraseña que actualmente tiene o introduzca 'cancelar':");
		lol.add("La contraseña no coincide");
		lol.add("Introduzca la contraseña que desee o introduzca 'cancelar':");
		lol.add("Introduzca una contraseña de al menos 8 caracteres, conteniendo en estos 1 número, una mayúscula y un caracter no alfanumérico (+,*,#,$,...)");
		//INTRODUCIR PESO
		lol.add("Introduzca la fecha en la que se pesó con formato DD/MM/AAA :");
		//REGISTRAR ACTIVIDAD
		lol.add("Elija que tipo de actividad quiere realizar");
		lol.add("1: Actividad genérica");
		lol.add("2: Cycling");
		lol.add("3: Running");
		lol.add("4: Swimming");
		lol.add("Introduzca cuando comenzó la actividad con formato DD/MM/AAA HH:MM:SS :");
		lol.add("Introduzca cuando finalizó la actividad con formato DD/MM/AAA HH:MM:SS :");
		lol.add("Introduzca cuanta distancia ha recorrido en metros:");
		lol.add("Introduzca las pulsacionas máxima que ha tenido:");
		lol.add("Introduzca las pulsacionas mínima que ha tenido:");
		lol.add("Introduzca el ratio por minuto de pedaleos:");
		lol.add("Introduzca cual era su ritmo con formato 'HH:MM' :");
		lol.add("Introduzca una duración con el formato anterior");
		lol.add("Introduzca cuantos metros ha ascendido:");
		lol.add("Introduzca cuantos pasos ha realizado:");
		lol.add("Introduzca cuantos largos ha realizado:");
		lol.add("Introduzca un valor positivo");
		lol.add("Elija donde realizó la natación:");
		lol.add("1: Piscina");
		lol.add("2: Mar");
		//PDF
		lol.add("Cierre su informe para que pueda ser editado");
		
		
		return lol;
	}
	*/
}
