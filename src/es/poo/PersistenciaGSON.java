package es.poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class PersistenciaGSON {
	private static ArrayList<Persona> persistence = null;
	
	public PersistenciaGSON() {
		if(PersistenciaGSON.persistence == null) {
			try {
				this.persistenciaFromJSON();
			}
			catch(ClassNotFoundException e) { PersistenciaGSON.persistence = null; }
			catch(IOException e) { PersistenciaGSON.persistence = null; }
		}
	}
	
	public ArrayList<Persona> getPersistence(){
		return PersistenciaGSON.persistence;
	}

	public void setPersistence(ArrayList<Persona> persistence) {
		PersistenciaGSON.persistence = persistence;
		this.persistenciaToJSON();
	}
	
	/**
	 * Persisto el arraylist de esta clase a un archivo json
	 */
	
	private void persistenciaToJSON() {

		
    	RuntimeTypeAdapterFactory<Persona> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
			    .of(Persona.class, "tipo")
			    .registerSubtype(Persona.class, Persona.class.getName())
			    .registerSubtype(PersonaPremium.class, PersonaPremium.class.getName());
		
    	RuntimeTypeAdapterFactory<Actividad> runtimeTypeAdapterFactory2 = RuntimeTypeAdapterFactory
			    .of(Actividad.class, "tipo")
			    .registerSubtype(Actividad.class, Actividad.class.getName())
			    .registerSubtype(Cycling.class, Cycling.class.getName())
    			.registerSubtype(Running.class, Running.class.getName())
    			.registerSubtype(Swimming.class, Swimming.class.getName());
		
    	Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).registerTypeAdapterFactory(runtimeTypeAdapterFactory2).create();
    	
		java.lang.reflect.Type listType = new TypeToken<ArrayList<Persona>>() {}.getType();
		String object = gson.toJson(PersistenciaGSON.persistence, listType);

		try{
			
				//Intentamos abrir el fichero de texto
				FileOutputStream fop;
				File file = new File("./files/Personas.json");
				fop = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fop);

				osw.write(object);//Escribimos la información
				osw.close();//Y cerramos el fichero de texto

		}
		catch (IOException e){}
		}
	
	/**Recupera el archivo persistido en el arraylist de esta clase
	 * 
	 * @throws IOException : Error al introducir el archivo
	 * @throws ClassNotFoundException : si lo que hay en el archivo no coincide con un arraylist de personas
	 */
	
	private void persistenciaFromJSON() throws IOException, ClassNotFoundException {
		String cadena = "";

		try {//Componemos una cadena de texto a partir de varias lineas de archivo, donde estan guardados los datos de los usuarios
			FileInputStream fis;
			File file = new File("./files/Personas.json");
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
		catch (FileNotFoundException e) { PersistenciaGSON.persistence = null; }
		catch (IOException e) { PersistenciaGSON.persistence = null; }

		if (cadena.isEmpty()) {
			PersistenciaGSON.persistence = null;
		}
		else {
			//Deserializar
			
	    	RuntimeTypeAdapterFactory<Persona> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
				    .of(Persona.class, "tipo")
				    .registerSubtype(Persona.class, Persona.class.getName())
				    .registerSubtype(PersonaPremium.class, PersonaPremium.class.getName());
			
	    	RuntimeTypeAdapterFactory<Actividad> runtimeTypeAdapterFactory2 = RuntimeTypeAdapterFactory
				    .of(Actividad.class, "tipo")
				    .registerSubtype(Actividad.class, Actividad.class.getName())
				    .registerSubtype(Cycling.class, Cycling.class.getName())
	    			.registerSubtype(Running.class, Running.class.getName())
	    			.registerSubtype(Swimming.class, Swimming.class.getName());
			
	    	Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).registerTypeAdapterFactory(runtimeTypeAdapterFactory2).create();
	    	
			java.lang.reflect.Type listType = new TypeToken<ArrayList<Persona>>() {}.getType();
			PersistenciaGSON.persistence = gson.fromJson(cadena, listType);
		}
	}
}