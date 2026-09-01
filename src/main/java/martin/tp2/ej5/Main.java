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
            
            while (true) {
                System.out.print("Elija una opción: ");
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido.");
                }
            }

            switch (opcion) {
            
                case 1:
                	System.out.println("Ingrese el titulo.");
                	String titulo = scanner.nextLine();
                	System.out.println("Ingrese el autor.");
                	String autor = scanner.nextLine();
                	
                	int anio;
                	while (true) {
                		System.out.println("Ingrese el año de publicacion.");
                		try {
                			anio = Integer.parseInt(scanner.nextLine());
                			break;
                		} catch (NumberFormatException e) {
                			System.out.println("Error. Debe ingresar un número entero.");
                		}
                	}
                	
                	int isbn;
                	while (true) {
	                	System.out.println("Ingrese el ISBN.");
	                	try {
	                		isbn = scanner.nextInt(); scanner.nextLine();
	                		break;
	                	} catch (NumberFormatException e){
	                		System.out.println("Error. Debe ingresar un número entero.");
	                	}
	                	
                	}
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
                		int isbnBuscado = 0;
                		while (true) {
                			System.out.println("Qué ISBN va a buscar?");
                			try {
                				isbnBuscado = Integer.parseInt(scanner.nextLine());
                				break;
                			} catch (NumberFormatException e) {
                				System.out.println("Error. Debe ingresar un número entero.");
                			}
                		}
                		
                		miBiblioteca.buscarIsbn(isbnBuscado);
                		
                	} else {
                		System.out.println("Error, tecla equivocada.");
                	}
                    break;
                    
                    
                case 3:
                	int isbnMod;
                	while (true) {
                		System.out.print("Ingrese el ISBN del libro a modificar: ");
                		try {
                			isbnMod = Integer.parseInt(scanner.nextLine());
                			break;
                		} catch (NumberFormatException e) {
                			System.out.println("Error. Debe ingresar un número entero.");
                		}
                	}
                    
                    Libro libroEncontrado = miBiblioteca.encontrarIsbn(isbnMod);
                    
                    if (libroEncontrado != null) {
                        System.out.print("¿Qué desea modificar? (autor/anio): ");
                        String mod = scanner.nextLine();
                        System.out.print("Ingrese el nuevo valor: ");
                        String input = scanner.nextLine();
                        
                        if (mod.equalsIgnoreCase("anio")) {
                        	while (true) {
                        		try {
                        			Integer.parseInt(input);
                        			break;
                        		} catch (NumberFormatException e) {
                        			System.out.print("Error. El año debe ser un número entero. Ingrese el nuevo valor: ");
                        			input = scanner.nextLine();
                        		}
                        	}
                        }
                        
                        miBiblioteca.modificarLibro(libroEncontrado, mod, input);
                    
                    } else {
                        System.out.println("No se encontró ningún libro con ese ISBN.");
                    }
                    break;
                    
                    
                case 4:
                	int isbnElim = 0;
                	while (true) {
                		System.out.print("Ingrese el ISBN a eliminar: ");
                		try {
                			isbnElim = Integer.parseInt(scanner.nextLine());
                			break;
                		} catch (NumberFormatException e) {
                			System.out.println("Error. Debe ingresar un número entero.");
                		}
                	}
                    miBiblioteca.eliminarIsbn(isbnElim);
                    break;                   
            }
        } while (opcion != 5);
        scanner.close();
    }
}
