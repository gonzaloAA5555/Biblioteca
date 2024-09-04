# biblioteca

## Proyecto hecho por Miguel Carmona Cicchetti y Gonzalo Árgueda Fernández

## MANEJO DE FICHEROS - BIBLIOTECA

# Introducción

El propósito de este programa es gestionar una biblioteca utilizando archivos binarios, de texto y XML. Se lleva a cabo un CRUD (Crear, Leer, Actualizar y Eliminar) de los libros y autores presentes en la biblioteca. Además, se tiene la intención de gestionar préstamos y facilitar la exportación e importación de datos en formato XML.

# Estructura del Proyecto

Principal: En esta clase se encuentran los formularios y las preguntas que se formulan al usuario, en base a lo que responda, sigue un camino u otro, ya puede ser para crear registros nuevos, o para exportarlos o importarlos. Esta clase lleva la información a través de uno de estos.

Libro/ Autor/ Préstamos: Estas 3 clases contienen los constructores, getters y setters de libro, autor y préstamos, estas clases procesan los datos enviados de la clase principal y los envían a GestorFicheros que se encargará de crear los ficheros con los datos procesados de estas clases.

GestorFicheros: Esta clase recoge los datos de las clases anteriores, genera los ficheros correspondientes dependiendo de quién le ha enviado los datos, y lo devuelve, ya sea un mensaje en consola, o un archivo en la carpeta contenedora. Esta clase también puede borrar registros y/o cambiarlos, dependiendo de la orden que se le mande desde la clase principal.

## Clases

# Libro

Esta clase se utiliza para representar y gestionar la información relacionada con libros en el sistema de gestión de biblioteca. A través del método estático crearLibro(), se solicita al usuario que ingrese información sobre un nuevo libro, como el id, título, autor, fecha de publicación y género. El objeto “nuevo” de esta clase se genera con la información proporcionada. Luego, se utiliza la clase GestorFicheros para agregar el libro recién creado. El método ListarLibros() de la clase GestorFicheros permite mostrar una lista de todos los libros presentes en el sistema y a través del método cambiarLibro de la clase GestorFicheros, se puede modificar la información de un libro existente. El método borrarLibro() de la clase GestroFicheros posibilita eliminar un libro del sistema.

# Autor

La clase Autor tiene un papel similar a la clase Libro. Su función principal es gestionar la información relacionada con los autores en el sistema de gestión de biblioteca. A través del método estático crearAutor(), se solicita al usuario que ingrese información sobre un nuevo autor, como el id, nombre, nacionalidad y fecha de nacimiento. El objeto “nuevo” que se declara en Autor se crea con la información proporcionada. Luego, se utiliza la clase GestorFicheros para agregar el autor recién creado. El método listarAutor() de dicha clase permite mostrar una lista de todos los autores presentes en el sistema y a través del método cambiarAutor() de la clase GestorFicheros, se puede modificar la información de un autor existente. El método borrarAutor() de la clase GestionarFichero posibilita eliminar un autor del sistema.

# Préstamos

A través del constructor de la clase Préstamo (int idLibro, String nombreUsuario, String instancias de la clase Prestamo fPréstamo, String fDevolución), se pueden crear proporcionando los detalles del préstamo, como el identificador único del libro (idLibro), el nombre del usuario que realiza el préstamo (nombreusuario), la fecha de préstamo (fPréstamo), y la fecha estimada de devolución (fDevolución). Los métodos set en la clase Préstamo permiten modificar los atributos de un objeto Préstamo, lo que podría ser útil si se necesita actualizar la información de un préstamo existente.

## Exportar datos a archivos XML

Para exportar un XML hay que crear los archivos binarios de Libro y Autor, este se genera en cada menú gestor de las clases correspondientes, una vez se tengan estos archivos con sus datos integrados, en el menú principal se selecciona la opción de importar/exportar a XML y se selecciona exportar; dentro del submenú, se se dará a elegir sobre qué se quiere exportar. Se selecciona dependiendo de lo que se quiera exportar en ese momento y el archivo xml se genera en la misma carpeta donde se han creado los archivos binarios.

## Importar datos desde archivos XML

Para importar un XML, es independiente si se tienen o no los archivos binarios mencionados en el proceso de exportación, lo único que se necesita son los archivos XML, dentro del submenú de selección de exportar/importar xml, se elegirá la opción importar y el programa preguntará qué archivo queremos importar, es importante que los archivos estén en la misma carpeta donde se generaron porque es donde va a buscar; y una vez importados, se generan los archivos binarios con los datos introducidos al haber exportado los ficheros anteriores.

## Dificultades y soluciones del proyecto

Una de las dificultades encontradas fue la implementación de la lógica de los métodos para importar y exportar en XML. La solución fue recoger los datos que hay en la clase que se esté buscando en ese momento a través de su array correspondiente, generar los elementos XML y se van integrando uno a uno, y con TransformerFactory, el programa expulsa el archivo XML ya generado. Para importar, se lee lo que haya en el XML y, uno a uno, va pasando y escribiendo en un nuevo objeto el cuál se escribe como objeto binario, y eso es lo que genera al final.

## Errores || Aspectos a mejorar

Cuando no hay archivo binario de ninguna clase, al intentar listar, editar o eliminar, genera un error del sistema porque no encuentra el archivo y vuelve al menú anterior, lo que habría que mejorar es que, cuando no encuentre el archivo, que suelte un mensaje por consola que diga por ejemplo “ARCHIVO NO ENCONTRADO”, y que vuelva al menú de gestión correspondiente.
