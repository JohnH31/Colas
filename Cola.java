package Pilass;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Cola {
	Scanner sc = new Scanner(System.in);
	RandomAccessFile fichero = null;
	private final int totalBytes = 29;
	private Nodo raiz, cima;
	int contador = 1;

	public Cola() {
		raiz = null;
		cima = null;

	}

	public boolean colaVacia() {
		if (raiz == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean insertar() {
		boolean resultado = false;
		int cant = contador;
		try {
			Nodo nuevo = new Nodo();
			System.out.println("Ingrese el codigo");
			nuevo.setCodigo(sc.nextInt());
			System.out.println("Ingrese el nombre");
			String strNombre = "";
			int longitud = 0;
			do {
				strNombre = sc.nextLine();
				longitud = strNombre.length();
				if (longitud <= 0 || longitud > 20) {
					System.out.println("La longitud del nombre no es valida [1 - 20]");
				}
			} while (longitud <= 0 || longitud > 20);
			nuevo.setNombre(strNombre);

			fichero.seek(fichero.length());// calcular la longitud el archivo
			fichero.writeInt(cant);
			fichero.writeInt(nuevo.getCodigo());
			fichero.write(nuevo.getBytesNombre());
			fichero.write("\n".getBytes()); // cambio de linea para que el siguiente registro se agregue abajo
			nuevo.siguiente = null;
			if (colaVacia()) {
				raiz = nuevo;
				cima = nuevo;
			} else {
				cima.siguiente = nuevo;
				cima = nuevo;
			}
			resultado = true;

		} catch (Exception e) {
			resultado = false;
			System.out.println("Error al agregar el registro " + e.getMessage());
		}
		return resultado;
	}

	public int quitar() {
		if (colaVacia()) {
			System.out.println("Cola Vacia");
			return -1;
		}
		int aux = raiz.codigo;
		String aud = raiz.nombre;

		if (raiz == cima) {
			raiz = null;
			cima = null;
		} else {
			raiz = raiz.siguiente;
		}
		System.out.println("Eliminado" + aux);
		System.out.println("Eliminado" + aud);
		return aux;
	}

	public void listar() {
		try {
			long longitud = fichero.length();
			if (longitud <= 0) {
				System.out.println("No hay registros");
				return; // finalizar el procedimiento
			}
			// posicionarse al principio del archivo
			fichero.seek(0);
			// System.out.println(longitud);
			Nodo a;
			while (longitud >= totalBytes) {
				a = new Nodo();
				contador = fichero.readInt();
				a.setCodigo(fichero.readInt());
				byte[] bNombre = new byte[20]; // leer 50 bytes para el nombre
				fichero.read(bNombre);
				a.setBytesNombre(bNombre);
				fichero.readByte();// leer el cambio de linea
				// imprimir los campos del registro
				System.out.println("Muestra No." + contador);
				System.out.println("Codigo: " + a.getCodigo());
				System.out.println("Nombre: " + a.getNombre());
				// restar los bytes del registro leido
				longitud -= totalBytes;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

		}
	}
}
