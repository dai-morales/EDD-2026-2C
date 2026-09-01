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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca miBiblioteca = new Biblioteca();
        int opcion;

        do {
            System.out.println("\n--- SIMULADOR DE BIBLIOTECA ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Modificar autor o año");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
            
                case 1:
                	System.out.println("Ingrese el titulo.");
                	String titulo = scanner.nextLine();
                	System.out.println("Ingrese el autor.");
                	String autor = scanner.nextLine();
                	System.out.println("Ingrese el año de publicacion.");
                	int anio = scanner.nextInt(); scanner.nextLine();
                	System.out.println("Ingrese el ISBN.");
                	int isbn = scanner.nextInt(); scanner.nextLine();
                	
                	Libro nuevoLibro = new Libro(titulo, autor, anio, isbn);                
                	miBiblioteca.agregarLibro(nuevoLibro);                	
                    break;
                    
                    
                case 2:
                	System.out.println("Va a buscar por titulo o por ISBN? (T/I)");
                	String opc = scanner.nextLine();
                	if (opc.equalsIgnoreCase("T")) {
                		System.out.println("Que titulo va a buscar?");
                		titulo = scanner.nextLine();
                		miBiblioteca.buscarTitulo(titulo);
                	} else if (opc.equalsIgnoreCase("I")) {
                		System.out.println("Qué ISBN va a buscar?");
                		isbn = Integer.parseInt(scanner.nextLine());
                		miBiblioteca.buscarIsbn(isbn);
                	} else {
                		System.out.println("Error, tecla equivocada.");
                	}
                    break;
                    
                    
                case 3:
                    System.out.print("Ingrese el ISBN del libro a modificar: ");
                    int isbnMod = scanner.nextInt();
                    scanner.nextLine();
                    
                    Libro libroEncontrado = miBiblioteca.encontrarIsbn(isbnMod);
                    if (libroEncontrado != null) {
                        System.out.print("¿Qué desea modificar? (autor/anio): ");
                        String mod = scanner.nextLine();
                        System.out.print("Ingrese el nuevo valor: ");
                        String input = scanner.nextLine();
                        miBiblioteca.modificarLibro(libroEncontrado, mod, input);
                    } else {
                        System.out.println("No se encontró ningún libro con ese ISBN.");
                    }
                    break;
                    
                    
                case 4:
                    System.out.print("Ingrese el ISBN a eliminar: ");
                    int isbnElim = scanner.nextInt();
                    miBiblioteca.eliminarIsbn(isbnElim);
                    break;
                    
            }
        } while (opcion != 5);
        scanner.close();
    }
}
