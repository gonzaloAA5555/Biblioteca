package biblioteca;

import java.util.Scanner;

// CUANDO INICIA EL PROGRAMA, SE ABRE EL MENÚ PARA GESTIONAR LIBROS, AUTORES, PRÉSTRAMOS Y LOS ARCHIVOS XML

public class Principal {
		private static Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
			
			/*
			SE DECLARA UNA VARIABLE BOOLEANA PARA EL SWITCH
			DE FORMA QUE SI EL USUARIO PULSA 5, LA BOOLEANA
			PASA A TRUE Y TERMINA EL PROGRAMA 
			*/
			
			//EL SWITCH SE VA REPITIENDO MIENTRAS QUE LA BOOLEANA SEA FALSE
			
				boolean salir = false;
						while (!salir) {
							mostrarMenu();
							int opcion = scanner.nextInt();
							switch (opcion) {
						case 1:
							gestionarLibros();
							break;
						case 2:
							gestionarAutores();
							break;
						case 3:
							gestionarPrestamos();
							break;
						case 4:
							gestionarExportImportXML();
							break;
						case 5:
							salir = true;
							break;
						default:
							System.out.println("Opción no válida. Por favor, intente de nuevo.");
						}
				}
		}
		
		// MOSTRARMENU() DA LAS OPCIONES AL USUARIO DENTRO DEL SWITCH ANTERIOR
		
		private static void mostrarMenu() {
			System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
			System.out.println("1. Gestionar Libros");
			System.out.println("2. Gestionar Autores");
			System.out.println("3. Gestionar Préstamos");
			System.out.println("4. Exportar/Importar Datos (XML)");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
		}
		
		/* 
			SI EL USUARIO PULSA 1 EN EL SWITCH DE LA CLASE MAIN,
			VA AL SIGUIENTE MÉTODO QUE ES OTRO
			SWITCH CON EL MISMO FUNCIONAMIENTO QUE EL MAIN, PERO GESTIONARLIBROS()
			ES PARA GESTIONAR LIBROS 
		*/
		
		private static void gestionarLibros() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE LIBROS");
				System.out.println("1. CREAR LIBRO");
				System.out.println("2. LISTAR LIBRO");
				System.out.println("3. CAMBIAR LIBRO");
				System.out.println("4. BORRAR LIBRO");
				System.out.println("5. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					
					//EL PROGRAMA VA A LA CLASE LIBRO Y BUSCA EL MÉTODO CREARLIBRO()
					
					Libro.crearLibro();
					break;
				case 2:
					
					//EL PROGRAMA VA A LA CLASE GESTORFICHEROS Y BUSCA EL MÉTODO LISTARLIBROS()
					
					GestorFicheros.listarLibros();
					break;
				case 3:
					
					//EL PROGRAMA VA A LA CLASE GESTORFICHEROS Y BUSCA EL MÉTODO CAMBIARLIBRO()
					
					GestorFicheros.cambiarLibro();
					break;
				case 4:
					
					//EL PROGRAMA VA A LA CLASE GESTORFICHEROS Y BUSCA EL MÉTODO BORRARLIBROS()
					
					GestorFicheros.borrarLibro();
					break;
				case 5:
					
					// EL PROGRAMA SALE
					
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
				}
			}
		}		
		
		/* 
		 SI EL USUARIO PULSA 2 EN EL SWITCH DE LA CLASE MAIN, 
		 VA AL SIGUIENTE MÉTODO QUE ES OTRO
		 SWITCH CON EL MISMO FUNCIONAMIENTO QUE EL MAIN, PERO GESTIONARAUTORES()
		 ES PARA GESTIONAR AUTORES 
		*/
		
		private static void gestionarAutores() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE AUTORES");
				System.out.println("1. CREAR AUTOR");
				System.out.println("2. LISTAR AUTOR");
				System.out.println("3. CAMBIAR AUTOR");
				System.out.println("4. BORRAR AUTOR");
				System.out.println("5. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				
				/*
				  LO MISMO QUE EN EL SWITCH DE GESTIONARLIBROS(),
				  SI PULSA 1, EL PROGRAMA VA A LA CLASE AUTOR Y BUSCA
				  EL MÉTODO CORRESPONDIENTE, SI PULSA 2, 3 O 4, EL
				  EL PROGRAMA VA A LA CLASE GESTORFICHEROS Y BUSCA EL
				  MÉTODO QUE CORRESPONDA, SI PULSA 5, EL SWITCH TERMINA
				  Y VUELVE AL MENÚ DE GESTIÓN PRINCIPAL
				 */
				
				case 1:
					Autor.crearAutor();
					break;
				case 2:
					GestorFicheros.listarAutor();
					break;
				case 3:
					GestorFicheros.cambiarAutor();
					break;
				case 4:
					GestorFicheros.borrarAutor();
					break;
				case 5:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
				}
			}
		}
		
		/* 
		 SI EL USUARIO PULSA 3 EN EL SWITCH DE LA CLASE MAIN,
		 VA AL SIGUIENTE MÉTODO QUE ES OTRO
		 SWITCH CON EL MISMO FUNCIONAMIENTO QUE EL MAIN, PERO ESTE
		 ES PARA GESTIONAR PRÉSTAMOS 
		*/
		
		private static void gestionarPrestamos() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE PRESTAMOS");
				System.out.println("1. CREAR PRESTAMO");
				System.out.println("2. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();
				
				/*
				  LO MISMO QUE EN EL SWITCH DE GESTIONARLIBROS(),
				  SI PULSA 1, EL PROGRAMA VA A LA CLASE GESTORFICHEROS Y BUSCA
				  EL MÉTODO CORRESPONDIENTE, SI PULSA 2, EL SWITCH TERMINA
				  Y VUELVE AL MENÚ DE GESTIÓN PRINCIPAL
				 */

				switch (opcion2) {
				case 1:
					GestorFicheros.crearPrestamo();
					break;
				case 2:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
				}
			}
		}
		
		/* 
		 SI EL USUARIO PULSA 4 EN EL SWITCH DE LA CLASE MAIN,
		 VA AL SIGUIENTE MÉTODO QUE ES OTRO
		 SWITCH CON UN FUNCIONAMIENTO SIMILAR QUE EL MAIN, PERO ESTE
		 ES PARA GESTIONAR ARCHIVOS XML
		*/
		
		private static void gestionarExportImportXML() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN XML");
				System.out.println("1. EXPORTAR XML");
				System.out.println("2. IMPORTAR XML");
				System.out.println("3. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					exportarXML();
					break;
				case 2:
					importarXML();
					break;
				case 3:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		
		
		/*
		  SI EL USUARIO PULSA 1 EN GESTIONAREXPORIMPORTXML(),
		  SE ABRE EL MENÚ DE EXPORTARXML(), QUE SIRVE PARA SABER
		  SI EL USUARIO QUIERE EXPORTAR LIBROS O AUTORES.
		*/
			

		private static void exportarXML() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("ELIGE EL ARCHIVO A EXPORTAR EN XML");
				System.out.println("1. LIBROS");
				System.out.println("2. AUTORES");
				System.out.println("3. VOLVER ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();
				
				/*
					EN EL SIGUIENTE SWITCH, SI EL USUARIO PULSA 1,
					VA A LA CLASE GESTORFICHEROS Y VA AL MÉTODO DE
					EXPORTAR LIBROS, Y SI PULSA 2, BUSCA EL MÉTODO
					DE EXPORTAR AUTORES DENTRO DE LA MISMA CLASE.
				*/

				switch (opcion2) {
				case 1:
					GestorFicheros.crearXMLLibros();
					break;
				case 2:
					GestorFicheros.crearXMLAutores();
					break;
				case 3:
					saliendo = true;
					System.out.println("VOLVIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		
		
		/*
		  SI EL USUARIO PULSA 2 EN GESTIONAREXPORIMPORTXML(),
		  SE ABRE EL MENÚ DE IMPORTARRXML(), QUE SIRVE PARA SABER
		  SI EL USUARIO QUIERE IMPORTAR LIBROS O AUTORES.
		*/
		
		private static void importarXML() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("ELIGE EL ARCHIVO A IMPORTAR DE XML");
				System.out.println("1. LIBROS");
				System.out.println("2. AUTORES");
				System.out.println("3. VOLVER ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();
				
				/*
					EN EL SIGUIENTE SWITCH, SI EL USUARIO PULSA 2,
					VA A LA CLASE GESTORFICHEROS Y VA AL MÉTODO DE
					IMPORTAR LIBROS, Y SI PULSA 2, BUSCA EL MÉTODO
					DE IMPORTAR AUTORES DENTRO DE LA MISMA CLASE.
				 */

				switch (opcion2) {
				case 1:
					GestorFicheros.importarXMLLibros();
					break;
				case 2:
					GestorFicheros.importarXMLAutores();
					break;
				case 3:
					saliendo = true;
					System.out.println("VOLVIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		
}
