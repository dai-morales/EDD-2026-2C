package martin.tp2.ej5;

import java.util.ArrayList;

public class Biblioteca {
	ArrayList<Libro> libros;
	
	
	public Biblioteca() {
		this.libros = new ArrayList<>();//constructor
	}
	
	
	public static boolean mismoIsbn(Libro libro1, Libro libro2) {
		
		if (libro1.getISBN() == libro2.getISBN()) {
			return true;		
		} else {
			return false;
		}
	}
	
	public void agregarLibro(Libro libroNuevo) { //punto a)
		
		for (Libro libroActual : libros) {
			if (mismoIsbn(libroNuevo, libroActual)) {
				System.out.println("Error. ISBN repetido con " + libroActual.getTitulo() + ".");
				return;
			}
		}
		libros.add(libroNuevo);
		System.out.println("Se ha añadido correctamente el libro con el ISBN " + libroNuevo.getISBN() + ".");

	}
	public void buscarTitulo(String tituloBuscado) { //punto b)
		for (Libro libroActual : this.libros) {
			if (libroActual.getTitulo().equalsIgnoreCase(tituloBuscado)) {
				System.out.println(libroActual.toString());
			}
		}
	}	
	public void buscarIsbn(int isbnBuscado) { //punto b)
		for (Libro libroActual : this.libros) {
			if (libroActual.getISBN() == isbnBuscado) {
				System.out.println(libroActual.toString());
			}
		}
	}
	public void eliminarIsbn(int isbnBuscado) { //punto d)
		boolean flagEncontrado = false;
		for (Libro libroActual : this.libros) {
			if (libroActual.getISBN() == isbnBuscado) {
				libros.remove(libroActual);
				flagEncontrado = true;
				System.out.println("El libro con el ISBN " + isbnBuscado + " fue eliminado.");
				break;
			}
		}
		if (!flagEncontrado) {
			System.out.println("No se encontró ningún libro con ese ISBN.");
		}
	}
	public void modificarLibro(Libro libro, String mod, String input) { // punto c)
		if (mod.equals("autor")) {
			libro.setAutor(input);
		} else if (mod.equals("anio")) {
			libro.setAnioPublicacion(Integer.parseInt(input));
		}
	}
	
	public Libro encontrarIsbn(int isbnBuscado) {
		for (Libro libroActual : this.libros) {
			if (libroActual.getISBN() == isbnBuscado) {
				return libroActual;
			}
		}
		return null;
	}
}
