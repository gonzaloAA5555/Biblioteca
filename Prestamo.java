package biblioteca;

import java.io.Serializable;

/*

LA CLASE PRÉSTAMO ES IDÉNTICA A LA CLASE AUTOR Y LIBRO
SÓLO CAMBIAN LOS ATRIBUTOS.

AL INICIO DEL PROGRAMA, SE IMPLEMENTA LA 
FUNCIÓN SERIALIZABLE PARA QUE EL SERIALIZADOR
TRANSFORME LOS DATOS A BINARIO Y LOS ESCRIBA.

TAMBIÉN, AL INICIAR LA CLASE, ARRANCA UN 
SCANNER PARA LOS PROMPTS DE LAS VARIABLES.

EL INT Y LOS STRINGS SON LAS VARIABLES QUE SE
USARÁN MÁS ABAJO

*/

public class Prestamo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idLibro;
	private String nombreUsuario;
	private String fPrestamo;
	private String fDevolucion;
	
	/*
	 * 
	 * LO SIGUIENTE DE DECLARAR LAS VARIABLES, ES DECLARAR EL CONSTRUCTOR DE LA
	 * CLASE, SUS GETTERS Y SUS SETTERS CORRESPONDIENTES PARA RELACIONAR LAS
	 * VARIABLES DECLARADAS AL INICIO CON EL CONSTRUCTOR DE LA CLASE
	 * 
	 */

	
	public Prestamo(int idLibro, String nombreUsuario, String fPrestamo, String fDevolucion) {
		super();
		this.idLibro = idLibro;
		this.nombreUsuario = nombreUsuario;
		this.fPrestamo = fPrestamo;
		this.fDevolucion = fDevolucion;
	}
	
	/*
	 * 
	 * EL MÉTODO PRESTAMO() ES POR SI EL USUARIO NO ESCRIBE NADA, QUE SE ASIGNEN ESOS
	 * VALORES POR DEFECTO
	 * 
	 */
	
	public Prestamo() {
		idLibro=0;
		nombreUsuario=" ";
		fPrestamo=" ";
		fDevolucion=" ";
	}
	
	/*
	 * 
	 * SE DECLARAN LOS GETTERS Y LOS SETTERS DE LA CLASE
	 * 
	 */

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getfPrestamo() {
		return fPrestamo;
	}

	public void setfPrestamo(String fPrestamo) {
		this.fPrestamo = fPrestamo;
	}

	public String getfDevolucion() {
		return fDevolucion;
	}

	public void setfDevolucion(String fDevolucion) {
		this.fDevolucion = fDevolucion;
	}
	

	
	
	
}
