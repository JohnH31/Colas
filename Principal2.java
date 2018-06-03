package Pilass;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Principal2 {
	private final String ruta = "C:\\Users\\jona9\\Desktop\\John\\data.dat";
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Principal2 ad = new Principal2();
		ad.Tipo();
	}

	public void Tipo() {
		int opcion = 0;
		Cola cd = new Cola();
		do {
			try {
				cd.fichero = new RandomAccessFile(ruta, "rw");
				System.out.println("Seleccione su opcion");
				System.out.println("1.\t\tAgregar");
				System.out.println("2.\t\tQuitar");
				System.out.println("3.\t\tListar");

				opcion = sc.nextInt();
				switch (opcion) {
				case 0:
					System.out.println("Gracias por usar nuestro sistema");
					break;
				case 1:
					cd.insertar();
					cd.contador++;
					break;
				case 2:
					System.out.println("Quitar dato");
					cd.quitar();

					break;
				case 3:
					System.out.println("Datos Listados");
					cd.listar();
					break;
				}

			} catch (Exception e) { // capturar cualquier excepcion que ocurra
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);

	}

}
