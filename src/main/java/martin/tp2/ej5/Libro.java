package martin.tp2.ej5;

/*5)​ Crear un programa que simule una biblioteca personal, para lo cual se debe crear la clase Libro con
atributos como isbn, titulo, autor y anioPublicacion. El usuario debe poder guardar cualquier cantidad de
libros. El programa debe permitir:
a)​ Agregar nuevos libros. El ISBN ingresado no puede repetirse (validar antes de agregar).
b)​ Buscar un libro por su título o ISBN y mostrar toda su información.
c)​ Solicitar el ISBN de un libro y modificar el autor o el año de publicación.
d)​ Eliminar un libro de la biblioteca buscándolo por su ISBN.

Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.

Preguntas sobre el problema
a)​ Para resolver este ejercicio ¿Sería conveniente crear un arreglo de 1000 posiciones? ¿Cuáles serían las
ventajas y desventajas de esta implementación?
b)​ ¿Qué ocurre si se intenta eliminar un libro cuyo ISBN no existe en la biblioteca? ¿Cómo debe responder
el programa?
c)​ Si la biblioteca tiene 3 libros y se elimina el libro de la posición 1 (el del medio), sin ejecutar el
programa: ¿Qué índice le corresponde al libro que antes estaba en la posición 2?
d)​ Un compañero propone que para el punto c), en lugar de modificar el objeto existente, se elimine el
libro viejo y se agregue uno nuevo con los datos actualizados. ¿Qué ventajas y desventajas tiene esta
alternativa frente a usar los métodos setAutor() o setAnio()?*/

public class Libro {
	
	String titulo, autor;
	int anioPublicacion, ISBN;
	
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
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
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", anioPublicacion=" 
				+ anioPublicacion + ", ISBN=" + ISBN + "]";
	}
	

}
