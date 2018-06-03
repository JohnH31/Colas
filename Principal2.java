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
				System.out.println("Bienvenido al Programa de muestras de medicamentos");
				System.out.println("Seleccione una opcion para Muestra:");
				System.out.println("1.Agregar ");
				System.out.println("2.Quitar ");
				System.out.println("3.Listar Muestras");
				System.out.println("4.Cargar Datos");
				System.out.println("0.Salir");
				opcion = sc.nextInt();
				switch (opcion) {
				case 0:
					System.out.println("Gracias por usar nuestro sistema");
					break;
				case 1:
					cd.insertar();
					break;
				case 2:
					System.out.println("Muestra Quitadas");
					cd.quitar();

					break;
				case 3:
					System.out.println("Muestras Listadas");
					cd.listar();
					break;
				case 4:
					System.out.println("Datos Cargados");
					cd.CargarDatos();
					break;
				}

			} catch (Exception e) { // capturar cualquier excepcion que ocurra
				System.out.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);

	}
			

	}

