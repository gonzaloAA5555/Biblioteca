package biblioteca;

import java.io.Serializable;
import java.util.Scanner;

/*

LA CLASE LIBRO ES IDÉNTICA A LA CLASE AUTOR,
SÓLO CAMBIAN LOS ATRIBUTOS.

AL INICIO DEL PROGRAMA, SE IMPLEMENTA LA 
FUNCIÓN SERIALIZABLE PARA QUE EL SERIALIZADOR
TRANSFORME LOS DATOS A BINARIO Y LOS ESCRIBA.

TAMBIÉN, AL INICIAR LA CLASE, ARRANCA UN 
SCANNER PARA LOS PROMPTS DE LAS VARIABLES Y
SE DECLARA LA VERSIÓN DEL SERIALIZADOR.

EL INT Y LOS STRINGS SON LAS VARIABLES QUE SE
USARÁN MÁS ABAJO

*/

public class Libro implements Serializable {
	private static final Scanner scanner = new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String autor;
	private String publicacion;
	private String genero;

	/*
	 * 
	 * LO SIGUIENTE DE DECLARAR LAS VARIABLES, ES DECLARAR EL CONSTRUCTOR DE LA
	 * CLASE, SUS GETTERS Y SUS SETTERS CORRESPONDIENTES PARA RELACIONAR LAS
	 * VARIABLES DECLARADAS AL INICIO CON EL CONSTRUCTOR DE LA CLASE
	 * 
	 */

	public Libro(int id, String titulo, String autor, String publicacion, String genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.publicacion = publicacion;
		this.genero = genero;
	}

	/*
	 * 
	 * EL MÉTODO LIBRO() ES POR SI EL USUARIO NO ESCRIBE NADA, QUE SE ASIGNEN ESOS
	 * VALORES POR DEFECTO
	 * 
	 */

	public Libro() {
		id = 0;
		titulo = " ";
		autor = " ";
		publicacion = " ";
		genero = " ";
	}

	/*
	 * 
	 * SE DECLARAN LOS GETTERS Y LOS SETTERS DE LA CLASE
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	public String getPublicacion() {
		return publicacion;
	}

	public void publicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	/*
	 * 
	 * ESTE ES EL MÉTODO CREARLIBRO(), SE DECLARA AQUÍ Y NO EN PRINCIPAL POR ORDEN
	 * YA QUE DE ESTA FORMA SE USAN LAS CLASES PARA CREAR OBJETOS Y VAN A
	 * GESTORFICHERO DONDE SE PROCESAN.
	 * 
	 */

	public static void crearLibro() {

		/*
		 * 
		 * PREGUNTO LAS VARIABLES
		 * 
		 */

		System.out.println("Introduce el id del libro \n");
		int id_l = scanner.nextInt();

		System.out.println("Introduce el título del libro \n");
		String titulo = scanner.next();

		System.out.println("Introduce el id del autor \n");
		String autor = scanner.next();

		System.out.println("Introduce la fecha de publicación del libro \n");
		String publicacion = scanner.next();

		System.out.println("Introduce el género del libro \n");
		String genero = scanner.next();

		/*
		 * 
		 * CREO UN OBJETO LLAMADO NUEVO Y LE PASO LAS VARIABLES AL CONSTRUCTOR
		 * 
		 */

		Libro nuevo = new Libro(id_l, titulo, autor, publicacion, genero);

		/*
		 * 
		 * SE TRASLADA NUEVO A LA CLASE GESTORFICHEROS PARA CREAR EL ARCHIVO Y GUARDARLO
		 * 
		 */

		GestorFicheros.nuevoLibro(nuevo);
	}

}
