# App health JAVA POO
## Introducción
El objetivo de este proyecto es aplicar conocimientos avanzados de Programación Orientada a Objetos (POO). Se busca afianzar los conceptos básicos de POO y abordar temas avanzados como herencia y polimorfismo. El proyecto consiste en desarrollar una aplicación de control de salud y actividad física que permita dar de alta perfiles de personas, realizar modificaciones del peso, registrar actividades de running, cycling y swimming, y generar informes. Se ha utilizado Java versión 1.7 o 1.8.

## Funcionalidades
Hoy en día, es común encontrar aplicaciones de control de salud y actividad física. Este proyecto propone desarrollar una aplicación que cubra las funcionalidades básicas de este tipo de herramientas.

### Alta de Persona
Permite dar de alta a una persona solicitando los datos básicos, como alias, nombre, edad, peso, etc. Se valida que el password tenga al menos longitud 6 y contenga letras y números. Se garantiza que no se pueden dar de alta dos personas con el mismo alias.

### Login de Persona
Se muestra un menú para que el usuario ingrese su alias y password. Se verifica si el usuario está dado de alta en la aplicación.

### Conversión a Cuenta Premium
Permite convertir una cuenta en una cuenta premium. Se solicita la duración de la suscripción y la fecha de suscripción para comprobar si la cuenta sigue siendo premium. Se utiliza un constructor de copia para la conversión.

### Cambio de Contraseña
El cliente puede modificar su contraseña ingresando el password antiguo y el nuevo. Se validan ambos passwords y se garantiza que el nuevo cumpla con las restricciones de seguridad.

### Introducir Peso
El cliente puede ingresar la fecha y el peso, registrándolo en el historial de cambios de peso.

### Registro de Actividad
El cliente puede dar de alta actividades realizadas, incluyendo actividades de running, cycling y swimming. Se solicitan los datos correspondientes por pantalla.


### Mostrar Informe
Muestra un informe con los datos del cliente, los cambios de peso y las actividades realizadas. Se muestra el peso con asteriscos ocultando el valor real.

## Definiciones
Se detallan las clases principales involucradas en el programa:

+ Persona: Almacena los datos de las personas, como alias, password, nombre, apellidos, fecha de nacimiento, peso, altura, IMC, listado de actividades realizadas y listado de cambios de peso. También tiene un factor de actividad y una sugerencia basada en el IMC.
+ PersonaPremium: Hereda de Persona y almacena datos adicionales de cuentas premium, como fecha de alta premium y duración de la suscripción.
+ Actividad: Almacena los datos de las actividades, como fecha y hora de inicio y fin, duración, distancia, kcal consumidas, FcMax, FcMedia y FcMin.
+ Running: Hereda de Actividad y almacena datos específicos de la actividad de Running, como ritmo y elevación.
+ Cycling: Hereda de Actividad y almacena datos específicos de la actividad de Cycling, como cadencia.
+ Swimming: Hereda de Actividad y almacena datos específicos de la actividad de Swimming, como número de largos y tipo de natación.
+ InformePDF: Genera un informe en PDF utilizando la librería iText.

Se ha utilizado una interfaz IMostrable para estandarizar la impresión por pantalla de los datos de cualquier clase. Los datos se persistiten en fichero, y se utiliza la librería GSON.





