package biblioteca;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/*
 
  LA CLASE GESTORFICHEROS SERVIRÁ PARA CREAR, LISTAR, EDITAR O BORRAR
  SOBRE EL FICHERO BINARIO QUE SE VAYA CREANDO EN LA CLASE.
  
  SE RECOMIENDA MIRAR ANTES LAS CLASES PRINCIPAL, AUTOR, LIBRO Y PRESTAMO
  
  AL ABRIR LA CLASE GESTORFICHEROS, SE INICIAN TRES ARRAYS DIFERENTES, 
  UNO PARA LIBROS, OTRO PARA AUTORES Y OTRO PARA PRESTAMOS, TAMBIÉN
  INICIA EL SCANNER PARA PREGUNTAR LOS PROMPT.
 
 */

public class GestorFicheros {
	private static final List<Libro> listaLibros = new ArrayList<>();
	private static final List<Autor> listaAutores = new ArrayList<>();
	private static final List<Prestamo> listaPrestamos = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

	/*
	 * EMPIEZA EL PROGRAMA CON EL MÉTODO NUEVOLIBRO(),
	 * Y LE PASO COMO ARGUMENTO EL OBJETO NUEVO QUE ESTÁ
	 * EN LA CLASE LIBRO
	 */
	
	public static void nuevoLibro(Libro nuevo) {

		/*
		 * SE HACE UN TRY CATCH EN EL QUE SE DECLARA
		 * UN FILEOUTPUTSTREAM PARA CREAR UN ARCHIVO
		 * LLAMADO LIBRO.BIN, TAMBIÉN SE INICIA UN
		 * OBJECTOUTPUTSTREAM PARA PODER ESCRIBIR EN ÉL
		 * LO QUE HAYA EN NUEVO.
		 */
		
		try {
			FileOutputStream fos = new FileOutputStream("Libro.bin", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// UNA VEZ INICIADOS, EL PROGRAMA ESCRIBE EN EL OBJECT
			
			oos.writeObject(nuevo);
			
			// SE CIERRA EL OBJECTOUTPUTSTREAM PARA QUE PARE DE ESCRIBIR.
			
			oos.close();

			// SE AÑADE LO QUE SE HA ESCRITO AL ARRAY DE LOS LIBROS
			// Y SE MANDA UN MENSAJE DE CONFIRMACIÓN
			
			listaLibros.add(nuevo);
			System.out.println("Libro creado.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/*
	 * MÉTODO PARA LISTAR LIBROS
	 * */
	

	public static void listarLibros() {
		
		/*
		 * HAGO UN TRY CATCH INICIALIZANDO UN 
		 * FILEINPUTSTREAM QUE LEERÁ LO QUE HAYA
		 * EN LIBRO.BIN
		 * */
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Libro.bin"))) {
			System.out.println("\nListado de Libros");
			
			/*
			 * BUCLE FOR EACH PARA QUE VAYA IMPRIMIENDO EN PANTALLA LOS LIBROS A
			 * MEDIDA QUE SE LOS VA ENCONTRANDO EN EL ARRAY DE LIBROS
			 * */
			
			for (Libro libro : listaLibros) {
				System.out.println(
						"ID: " + libro.getId() + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
								+ ", Publicación: " + libro.getPublicacion() + ", Género: " + libro.getGenero());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * MÉTODO PARA CAMBIAR LIBROS
	 * */

	
	
	public static void cambiarLibro() {
		System.out.println("Introduce el ID del libro:");
		int idBuscado = scanner.nextInt();
		
		/*
		 * PREGUNTO EL ID Y CREO UNA VARIABLE BOOLEANA
		 * QUE SERVIRÁ PARA CONFIRMAR SI SE ENCUENTRA
		 * EL ID O NO
		 * */

		boolean libroEncontrado = false;
		
		/*
		 * BUCLE FOR EACH PARA QUE VAYA BUSCANDO LOS LIBROS A
		 * MEDIDA QUE SE LOS VA ENCONTRANDO EN EL ARRAY DE LIBROS
		 * */

		for (Libro libro : listaLibros) {
			
			/*
			 * CONDICIONAL QUE SIRVE PARA SABER QUE SI LO ENCUENTRA,
			 * QUE IMPRIMA UN MENSAJE EN PANTALLA QUE DIGA QUE LO 
			 * HA ENCONTRADO Y QUE PREGUNTE EL RESTO DE VARIABLES.
			 * LUEGO, LA VARIABLE BOOLEANA LA CAMBIA A TRUE PARA 
			 * QUE DEJE DE BUSCAR.
			 * 
			 * */
			
			if (libro.getId() == idBuscado) {
				libroEncontrado = true;
				System.out.println("Libro encontrado: " + libro.getTitulo());

				System.out.println("Ingrese el nuevo título: ");
				String nuevoTitulo = scanner.next();

				System.out.println("Ingrese el nuevo autor: ");
				String nuevoAutor = scanner.next();

				System.out.println("Ingrese el nuevo publicación: ");
				String nuevoPublicacion = scanner.next();

				System.out.println("Ingrese el nuevo género: ");
				String nuevoGenero = scanner.next();

				/*
				 * 
				 * PREGUNTO LAS VARIABLES Y SE SUSTITUYEN
				 * CON LA FUNCIÓN SET...
				 * 
				 * */
				
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setPublicacion(nuevoPublicacion);
				libro.setGenero(nuevoGenero);

				System.out.println("Libro actualizado: " + libro.getTitulo());
				return;
			}
		}
		
		/*
		 * SI NO LO ENCUENTRA, AVISA QUE NO LO HA ENCONTRADO
		 * Y VUELVE AL MENÚ DE GESTIÓN DE LIBROS
		 */

		if (!libroEncontrado) {
			System.out.println("LIBRO NO ENCONTRADO");
		}

	}
	
	
	/*
	 * MÉTODO PARA BORRAR LIBROS
	 * */
	
	

	public static void borrarLibro() {

		System.out.println("Introduce el ID del libro:");
		int idBuscado = scanner.nextInt();
		
		/*
		 * PREGUNTO EL ID Y CREO UNA VARIABLE BOOLEANA
		 * QUE SERVIRÁ PARA CONFIRMAR SI SE ENCUENTRA
		 * EL ID O NO
		 * */

		boolean libroEncontrado = false;
		
		/*
		 * BUCLE FOR EACH PARA QUE VAYA BUSCANDO LOS LIBROS A
		 * MEDIDA QUE SE LOS VA ENCONTRANDO EN EL ARRAY DE LIBROS
		 * */

		for (Libro libro : listaLibros) {
			
			/*
			 * CONDICIONAL QUE SIRVE PARA SABER QUE SI LO ENCUENTRA,
			 * QUE IMPRIMA UN MENSAJE EN PANTALLA QUE DIGA QUE LO 
			 * HA ENCONTRADO Y QUE PREGUNTE EL RESTO DE VARIABLES.
			 * LUEGO, LA VARIABLE BOOLEANA LA CAMBIA A TRUE PARA 
			 * QUE DEJE DE BUSCAR.
			 * 
			 * */
			
			if (libro.getId() == idBuscado) {
				libroEncontrado = true;
				System.out.println("Libro encontrado: " + libro.getTitulo());
				
				/*
				 * 
				 * PASA LA FUNCIÓN REMOVE PARA BORRAR EL REGISTRO
				 * 
				 */
				
				listaLibros.remove(libro);
				return;
			}
		}

		/*
		 * SI NO LO ENCUENTRA, AVISA QUE NO LO HA ENCONTRADO
		 * Y VUELVE AL MENÚ DE GESTIÓN DE LIBROS
		 */
		
		if (!libroEncontrado) {
			System.out.println("LIBRO NO ENCONTRADO");
		}
	}
	
	
	/*
	 * MÉTODO PARA CREAR AUTORES
	 * */
	

	public static void nuevoAutor(Autor nuevo) {
		
		/*
		 * SE HACE UN TRY CATCH EN EL QUE SE DECLARA
		 * UN FILEOUTPUTSTREAM PARA CREAR UN ARCHIVO
		 * LLAMADO AUTOR.BIN, TAMBIÉN SE INICIA UN
		 * OBJECTOUTPUTSTREAM PARA PODER ESCRIBIR EN ÉL
		 * LO QUE HAYA EN NUEVO.
		 */

		try {
			FileOutputStream fos = new FileOutputStream("Autor.bin", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// UNA VEZ INICIADOS, EL PROGRAMA ESCRIBE EN EL OBJECT
			
			oos.writeObject(nuevo);
			
			// SE CIERRA EL OBJECTOUTPUTSTREAM PARA QUE PARE DE ESCRIBIR.
			
			oos.close();
			
			// SE AÑADE LO QUE SE HA ESCRITO AL ARRAY DE LOS LIBROS
			// Y SE MANDA UN MENSAJE DE CONFIRMACIÓN

			listaAutores.add(nuevo);
			System.out.println("Autor creado.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/*
	 * MÉTODO PARA LISTAR AUTORES
	 * */
	
	

	public static void listarAutor() {
		
		/*
		 * HAGO UN TRY CATCH INICIALIZANDO UN 
		 * FILEINPUTSTREAM QUE LEERÁ LO QUE HAYA
		 * EN AUTOR.BIN
		 * */
		
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Autor.bin"))) {
			System.out.println("\nListado de Autores:");
			
			/*
			 * BUCLE FOR EACH PARA QUE VAYA IMPRIMIENDO EN PANTALLA LOS AUTORES A
			 * MEDIDA QUE SE LOS VA ENCONTRANDO EN EL ARRAY DE AUTORES
			 * */
			
			for (Autor autor : listaAutores) {
				System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre() + ", Nacionalidad: "
						+ autor.getNacionalidad() + ", Nacimiento: " + autor.getNacimiento());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * MÉTODO PARA CAMBIAR AUTORES
	 * */
	

	public static void cambiarAutor() {
		System.out.println("Introduce el ID del autor:");
		int idBuscado = scanner.nextInt();
		
		/*
		 * PREGUNTO EL ID Y CREO UNA VARIABLE BOOLEANA
		 * QUE SERVIRÁ PARA CONFIRMAR SI SE ENCUENTRA
		 * EL ID O NO
		 * */

		boolean autorEncontrado = false;		
		
		/*
		 * BUCLE FOR EACH PARA QUE VAYA BUSCANDO LOS AUTORES A
		 * MEDIDA QUE SE LOS VA ENCONTRANDO EN EL ARRAY DE AUTORES
		 * */


		for (Autor autor : listaAutores) {
			
			/*
			 * CONDICIONAL QUE SIRVE PARA SABER QUE SI LO ENCUENTRA,
			 * QUE IMPRIMA UN MENSAJE EN PANTALLA QUE DIGA QUE LO 
			 * HA ENCONTRADO Y QUE PREGUNTE EL RESTO DE VARIABLES.
			 * LUEGO, LA VARIABLE BOOLEANA LA CAMBIA A TRUE PARA 
			 * QUE DEJE DE BUSCAR.
			 * 
			 * */
			
			if (autor.getId() == idBuscado) {
				autorEncontrado = true;
				System.out.println("Autor encontrado: " + autor.getNombre());

				System.out.println("Ingrese el nuevo nombre: ");
				String nuevoNombre = scanner.next();

				System.out.println("Ingrese la nueva nacionalidad: ");
				String nuevoNacionalidad = scanner.next();

				System.out.println("Ingrese la fecha de nacimiento: ");
				String nuevoNacimiento = scanner.next();
				
				
				/*
				 * 
				 * PREGUNTO LAS VARIABLES Y SE SUSTITUYEN
				 * CON LA FUNCIÓN SET...
				 * 
				 * */

				autor.setNombre(nuevoNombre);
				autor.setNacionalidad(nuevoNacionalidad);
				autor.setNacimiento(nuevoNacimiento);

				System.out.println("Autor actualizado: " + autor.getNombre());
				return;
			}
		}
		
		/*
		 * SI NO LO ENCUENTRA, AVISA QUE NO LO HA ENCONTRADO
		 * Y VUELVE AL MENÚ DE GESTIÓN DE AUTORES
		 */

		if (!autorEncontrado) {
			System.out.println("AUTOR NO ENCONTRADO");
		}

	}
	
	
	/*
	 * MÉTODO PARA BORRAR AUTORES
	 * */
	
	

	public static void borrarAutor() {
		
		System.out.println("Introduce el ID del autor:");
		int idBuscado = scanner.nextInt();
		
		/*
		 * PREGUNTO EL ID Y CREO UNA VARIABLE BOOLEANA
		 * QUE SERVIRÁ PARA CONFIRMAR SI SE ENCUENTRA
		 * EL ID O NO
		 * */

		boolean autorEncontrado = false;
		
		/*
		 * BUCLE FOR EACH PARA QUE VAYA BUSCANDO LOS AUTORES A
		 * MEDIDA QUE SE LOS VA ENCONTRANDO EN EL ARRAY DE AUTORES
		 * */

		for (Autor autor : listaAutores) {
			
			/*
			 * CONDICIONAL QUE SIRVE PARA SABER QUE SI LO ENCUENTRA,
			 * QUE IMPRIMA UN MENSAJE EN PANTALLA QUE DIGA QUE LO 
			 * HA ENCONTRADO Y QUE PREGUNTE EL RESTO DE VARIABLES.
			 * LUEGO, LA VARIABLE BOOLEANA LA CAMBIA A TRUE PARA 
			 * QUE DEJE DE BUSCAR.
			 * 
			 * */
			
			if (autor.getId() == idBuscado) {
				autorEncontrado = true;
				System.out.println("Autor borrado: " + autor.getNombre());
				
				/*
				 * 
				 * PASA LA FUNCIÓN REMOVE PARA BORRAR EL REGISTRO
				 * 
				 */
				
				listaAutores.remove(autor);
				return;
			}
		}
		
		/*
		 * SI NO LO ENCUENTRA, AVISA QUE NO LO HA ENCONTRADO
		 * Y VUELVE AL MENÚ DE GESTIÓN DE AUTORES
		 */
		
		if (!autorEncontrado) {
			System.out.println("AUTOR NO ENCONTRADO");
		}
	}
	
	
	
	/*
	 * MÉTODO PARA CREAR PRESTAMOS
	 * */
	

	public static void crearPrestamo() {

		System.out.println("Introduce el id del libro \n");
		int idLibro = scanner.nextInt();
		
		/*
		 * PREGUNTO EL ID DEL LIBRO Y CREO UNA VARIABLE BOOLEANA
		 * QUE SERVIRÁ PARA CONFIRMAR SI SE ENCUENTRA
		 * EL ID O NO
		 * */

		boolean libroEncontrado = false;

		for (Libro libro : listaLibros) {
			
			/*
			 * CONDICIONAL QUE SIRVE PARA SABER QUE SI LO ENCUENTRA,
			 * QUE PREGUNTE EL RESTO DE VARIABLES.
			 * LUEGO, LA VARIABLE BOOLEANA LA CAMBIA A TRUE PARA 
			 * QUE DEJE DE BUSCAR.
			 * 
			 * */

			if (libro.getId() == idLibro) {
				libroEncontrado = true;

				System.out.println("Introduce el nombre del usuario \n");
				String nombreUsuario = scanner.next();

				System.out.println("Introduce la fecha del préstamo \n");
				String fPrestamo = scanner.next();

				System.out.println("Introduce la fecha de la devolución \n");
				String fDevolucion = scanner.next();
				
				/*
				 * 
				 * PREGUNTO LAS VARIABLES Y LAS GUARDO EN 
				 * UN OBJETO NUEVO DENTRO DE LA CLASE PRESTAMO
				 * 
				 * */

				Prestamo nuevo = new Prestamo(idLibro, nombreUsuario, fPrestamo, fDevolucion);
				
				/*
				 * AQUÍ PASO UN MÉTODO LLAMADO NUEVOPRESTAMO() QUE SE 
				 * DECLARA MÁS ABAJO, ESTE SERVIRÁ PARA ESCRIBIR EN 
				 * EL TXT LA INFORMACIÓN QUE SE HA PREGUNTADO EN LAS
				 * LÍNEAS ANTERIORES.
				 */

				nuevoPrestamo(nuevo);

			}
		}
		
		/*
		 * SI NO LO ENCUENTRA, AVISA QUE NO LO HA ENCONTRADO
		 * Y VUELVE AL MENÚ DE GESTIÓN DE PRESTAMOS
		 */

		if (!libroEncontrado) {
			System.out.println("EL LIBRO NO EXISTE");
		}
	}
	
	
	/*
	 * 
	 * MÉTODO PARA ESCRIBIR UN NUEVO PRESTAMO
	 * 
	 */

	public static void nuevoPrestamo(Prestamo nuevo) {
		
		/*
		 * SE HACE UN TRY CATCH EN EL QUE SE CREA UN ARCHIVO
		 * CON FILEWRITER, Y EN ÉL, LE PASO LA INFORMACIÓN
		 * QUE SE HA PREGUNTADO EN EL MÉTODO ANTERIOR.
		 */

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Prestamo.txt", true))) {
			
			writer.write("Id del Libro: " + nuevo.getIdLibro()); //BUSCA LO QUE HAY EN EL IDLIBRO DEL OBJETO NUEVO DE LA CLASE PRESTAMO
			writer.newLine(); //SALTO DE LÍNEA
			writer.write("Nombre del usuario que lo solicita: " + nuevo.getNombreUsuario()); // BUSCA EL NOMBRE Y LO ESCRIBE
			writer.newLine(); //SALTO DE LÍNEA
			writer.write("Fecha del préstamo: " + nuevo.getfPrestamo()); // BUSCA LA FECHA DEL PRÉSTAMO Y LO ESCRIBE
			writer.newLine(); //SALTO DE LÍNEA
			writer.write("Fecha de la devolución: " + nuevo.getfDevolucion()); // BUSCA LA FECHA DE LA DEVOLUCIÓN Y LO ESCRIBE
			writer.newLine(); //SALTO DE LÍNEA
			writer.newLine(); //SALTO DE LÍNEA POR SI SE ESCRIBE OTRO PRÉSTAMO MÁS

			// GUARDA TODO LO QUE SE HA ESCRITO EN EL ARRAY DE PRESTAMOS 
			// E IMPRIME EL MENSAJE POR PANTALLA.
			
			listaPrestamos.add(nuevo);
			System.out.println("Prestamo creado.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	/*
	 * MÉTODO PARA EXPORTAR EL XML DE LIBROS
	 */
	
	

	public static void crearXMLLibros() {
		/*
		 * AQUÍ SE UTILIZAN LIBRERÍAS COMO
		 * DOCUMENTBUILDERFACTORY O DOCUMENTBUILDER
		 * QUE SERVIRÁN PARA HACER TODO EL XML
		 */
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); // SE INICIA EL BUILDER
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); // INICIO EL CONSTRUCTOR DEL BUILDER
			Document doc = docBuilder.newDocument(); // ABRO UN ARCHIVO NUEVO

			Element rootElement = doc.createElement("libros"); // NOMBRE DEL ELEMENTO RAÍZ DEL XML
			doc.appendChild(rootElement); // UNO LA RAÍZ AL DOCUMENTO VACÍO

			// BUCLE PARA QUE ME VAYA DANDO LOS LIBROS
			// A MEDIDA QUE LOS VA ENCONTRANDO
			
			for (Libro nuevo : listaLibros) {
				Element libroElement = doc.createElement("libro"); //CREO UN ELEMENTO LIBRO DENTRO DE LA RAÍZ LIBROS
				rootElement.appendChild(libroElement); //LO UNO A LA RAÍZ

				Element idElement = doc.createElement("id"); // CREO EL ELEMENTO ID
				idElement.appendChild(doc.createTextNode(String.valueOf(nuevo.getId()))); //PARSEO EL ENTERO A STRING Y LO UNO AL ID
				libroElement.appendChild(idElement); // UNO EL ELEMENTO A LA RAÍZ

				/*
				 * A PARTIR DE AQUÍ, EL PROCEDIMIENTO ES EL MISMO:
				 * SE CREA UN ELEMENTO, SE UNE A LA VARIABLE QUE PIDO,
				 * Y LO UNO A LA RAÍZ
				 */
				
				Element tituloElement = doc.createElement("titulo");
				tituloElement.appendChild(doc.createTextNode(nuevo.getTitulo()));
				libroElement.appendChild(tituloElement);

				Element autorElement = doc.createElement("autor");
				autorElement.appendChild(doc.createTextNode(nuevo.getAutor()));
				libroElement.appendChild(autorElement);

				Element publicacionElement = doc.createElement("publicacion");
				publicacionElement.appendChild(doc.createTextNode(nuevo.getPublicacion()));
				libroElement.appendChild(publicacionElement);

				Element generoElement = doc.createElement("genero");
				generoElement.appendChild(doc.createTextNode(nuevo.getGenero()));
				libroElement.appendChild(generoElement);

			}
			
			/*
			 * DECLARO UN TRANSFORMERFACTORY PARA QUE AHORA, TRANSFORME TODA
			 * LA SINTAXIS QUE LE HE IDO AÑADIENDO ANTES Y LO PASE A XML
			 */

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("libros.xml"));
			transformer.transform(source, result);

			/*
			 * MENSAJE DE QUE HA TERMINADO
			 */
			
			System.out.println("EXPORTACIÓN REALIZADA");

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void crearXMLAutores() {
		/*
		 * AQUÍ SE UTILIZAN LIBRERÍAS COMO
		 * DOCUMENTBUILDERFACTORY O DOCUMENTBUILDER
		 * QUE SERVIRÁN PARA HACER TODO EL XML
		 */
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance(); // SE INICIA EL BUILDER
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); // INICIO EL CONSTRUCTOR DEL BUILDER
			Document doc = docBuilder.newDocument(); // ABRO UN ARCHIVO NUEVO

			Element rootElement = doc.createElement("autores"); // NOMBRE DEL ELEMENTO RAÍZ DEL XML
			doc.appendChild(rootElement); // UNO LA RAÍZ AL DOCUMENTO VACÍO
			
			// BUCLE PARA QUE ME VAYA DANDO LOS AUTORES
			// A MEDIDA QUE LOS VA ENCONTRANDO

			for (Autor nuevo : listaAutores) {
				Element autorElement = doc.createElement("autor"); //CREO UN ELEMENTO LIBRO DENTRO DE LA RAÍZ LIBROS
				rootElement.appendChild(autorElement); //LO UNO A LA RAÍZ
 
				Element idElement = doc.createElement("id"); // CREO EL ELEMENTO ID
				idElement.appendChild(doc.createTextNode(String.valueOf(nuevo.getId()))); //PARSEO EL ENTERO A STRING Y LO UNO AL ID
				autorElement.appendChild(idElement); // UNO EL ELEMENTO A LA RAÍZ
				
				/*
				 * A PARTIR DE AQUÍ, EL PROCEDIMIENTO ES EL MISMO:
				 * SE CREA UN ELEMENTO, SE UNE A LA VARIABLE QUE PIDO,
				 * Y LO UNO A LA RAÍZ
				 */

				Element nombreElement = doc.createElement("nombre");
				nombreElement.appendChild(doc.createTextNode(nuevo.getNombre()));
				autorElement.appendChild(nombreElement);

				Element nacionalidadElement = doc.createElement("nacionalidad");
				nacionalidadElement.appendChild(doc.createTextNode(nuevo.getNacionalidad()));
				autorElement.appendChild(nacionalidadElement);

				Element nacimientoElement = doc.createElement("nacimiento");
				nacimientoElement.appendChild(doc.createTextNode(nuevo.getNacimiento()));
				autorElement.appendChild(nacimientoElement);

			}
			
			/*
			 * DECLARO UN TRANSFORMERFACTORY PARA QUE AHORA, TRANSFORME TODA
			 * LA SINTAXIS QUE LE HE IDO AÑADIENDO ANTES Y LO PASE A XML
			 */

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("autores.xml"));
			transformer.transform(source, result);

			System.out.println("EXPORTACIÓN REALIZADA");

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/*
	 * MÉTODO PARA IMPORTAR UN XML
	 * EL PROCEDIMIENTO ES A LA INVERSA DE EXPORTAR,
	 * PARA EXPORTAR, HAY QUE PASAR DE BINARIO A XML,
	 * Y PARA IMPORTAR, HAY QUE PASAR DE XML A BINARIO
	 */
	
	
	public static void importarXMLLibros() {
		try {
			File xmlFile = new File("libros.xml"); // DECLARO UN OBJETO PASANDO EL NOMBRE DEL ARCHIVO QUE QUIERO QUE BUSQUE
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // DECLARO UN BUILDER NUEVO PARA PARSEAR
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			NodeList nodeList = doc.getElementsByTagName("libro"); // DECLARO UNA NODELIST DE TODOS LOS LIBROS QUE HAYA EN EL XML

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Libro.bin"))) {
				for (int i = 0; i < nodeList.getLength(); i++) { // INICIO UN FOR QUE RECORRA TODA LA NODELIST EN BUSCA DE LIBRO
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) { //SI LO ENCUENTRA, USO GET PARA TRANSFORMARLO A UN ELEMENTO BINARIO
						Element element = (Element) node;
						int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
						String titulo = element.getElementsByTagName("titulo").item(0).getTextContent();
						String autor = element.getElementsByTagName("autor").item(0).getTextContent();
						String publicacion = element.getElementsByTagName("publicacion").item(0).getTextContent();
						String genero = element.getElementsByTagName("genero").item(0).getTextContent();

						// LOS ELEMENTOS ANTERIORES LOS ESCRIBO CON WRITEOBJECT 
						
						oos.writeInt(id);
						oos.writeObject(titulo);
						oos.writeObject(autor);
						oos.writeObject(publicacion);
						oos.writeObject(genero);
						
						// DECLARO UN OBJETO PARA GUARDAR LO QUE SE HA ESCRITO Y ESCRIBO EL OBJETO

						Libro nuevoLibro = new Libro(id, titulo, autor, publicacion, genero);

						oos.writeObject(nuevoLibro);
						
						// LO AÑADO A LA LISTA DE LOS LIBROS

						listaLibros.add(nuevoLibro);

					}
				}
				System.out.println("Conversión exitosa: XML a binario.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * MÉTODO PARA IMPORTAR UN XML
	 * EL PROCEDIMIENTO ES A LA INVERSA DE EXPORTAR,
	 * PARA EXPORTAR, HAY QUE PASAR DE BINARIO A XML,
	 * Y PARA IMPORTAR, HAY QUE PASAR DE XML A BINARIO
	 */
	
	public static void importarXMLAutores() {
		try {
			File xmlFile = new File("autores.xml"); // DECLARO UN OBJETO PASANDO EL NOMBRE DEL ARCHIVO QUE QUIERO QUE BUSQUE
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // DECLARO UN BUILDER NUEVO PARA PARSEAR
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			NodeList nodeList = doc.getElementsByTagName("autor"); // DECLARO UNA NODELIST DE TODOS LOS LIBROS QUE HAYA EN EL XML

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Autor.bin"))) {
				for (int i = 0; i < nodeList.getLength(); i++) { // INICIO UN FOR QUE RECORRA TODA LA NODELIST EN BUSCA DE LIBRO
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) { //SI LO ENCUENTRA, USO GET PARA TRANSFORMARLO A UN ELEMENTO BINARIO
						Element element = (Element) node;
						int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
						String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
						String nacionalidad = element.getElementsByTagName("nacionalidad").item(0).getTextContent();
						String nacimiento = element.getElementsByTagName("nacimiento").item(0).getTextContent();
						
						// LOS ELEMENTOS ANTERIORES LOS ESCRIBO CON WRITEOBJECT 

						oos.writeInt(id);
						oos.writeObject(nombre);
						oos.writeObject(nacionalidad);
						oos.writeObject(nacimiento);
						
						// DECLARO UN OBJETO PARA GUARDAR LO QUE SE HA ESCRITO Y ESCRIBO EL OBJETO

						Autor nuevoAutor = new Autor(id, nombre, nacionalidad, nacimiento);

						oos.writeObject(nuevoAutor);
						
						// LO AÑADO A LA LISTA DE LOS AUTORES

						listaAutores.add(nuevoAutor);

					}
				}
				System.out.println("Conversión exitosa: XML a binario.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
