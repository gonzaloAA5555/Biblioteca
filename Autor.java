package biblioteca;

import java.io.Serializable;
import java.util.Scanner;

/*
 
 LA CLASE AUTOR ES IDÉNTICA A LA CLASE LIBRO,
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

public class Autor implements Serializable {
	private static final Scanner scanner = new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String nacionalidad;
	private String nacimiento;

	/*
	 * 
	 * LO SIGUIENTE DE DECLARAR LAS VARIABLES, ES DECLARAR EL CONSTRUCTOR DE LA
	 * CLASE, SUS GETTERS Y SUS SETTERS CORRESPONDIENTES PARA RELACIONAR LAS
	 * VARIABLES DECLARADAS AL INICIO CON EL CONSTRUCTOR DE LA CLASE
	 * 
	 */

	public Autor(int id, String nombre, String nacionalidad, String nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.nacimiento = nacimiento;
	}

	/*
	 * 
	 * EL MÉTODO AUTOR() ES POR SI EL USUARIO NO ESCRIBE NADA, QUE SE ASIGNEN ESOS
	 * VALORES POR DEFECTO
	 * 
	 */

	public Autor() {
		id = 0;
		nombre = " ";
		nacionalidad = " ";
		nacimiento = " ";
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	/*
	 * 
	 * ESTE ES EL MÉTODO CREARAUTOR(), SE DECLARA AQUÍ Y NO EN PRINCIPAL POR ORDEN
	 * YA QUE DE ESTA FORMA SE USAN LAS CLASES PARA CREAR OBJETOS Y VAN A
	 * GESTORFICHERO DONDE SE PROCESAN.
	 * 
	 */

	public static void crearAutor() {

		/*
		 * 
		 * PREGUNTO LAS VARIABLES
		 * 
		 */

		System.out.println("Introduce el id del autor \n");
		int id_a = scanner.nextInt();

		System.out.println("Introduce el nombre del autor \n");
		String nombre = scanner.next();

		System.out.println("Introduce la nacionalidad del autor \n");
		String nacionalidad = scanner.next();

		System.out.println("Introduce la fecha de nacimiento del autor \n");
		String nacimiento = scanner.next();

		/*
		 * 
		 * CREO UN OBJETO LLAMADO NUEVO Y LE PASO LAS VARIABLES AL CONSTRUCTOR
		 * 
		 */

		Autor nuevo = new Autor(id_a, nombre, nacionalidad, nacimiento);

		/*
		 * 
		 * SE TRASLADA NUEVO A LA CLASE GESTORFICHEROS PARA CREAR EL ARCHIVO Y GUARDARLO
		 * 
		 */

		GestorFicheros.nuevoAutor(nuevo);
	}

}
