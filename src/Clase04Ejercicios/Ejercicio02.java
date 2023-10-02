package Clase04Ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese S si quiere sumar los números o M si quiere multplicar:");
		
		String operacion = scn.nextLine();
		
		int resultadoOperacion = operacionConNumerosDelArchivo(Paths.get("recursos/archivoDeNumeros"), operacion);
		
		if ((operacion.startsWith("S")) || (operacion.startsWith("M"))) {

			System.out.println("El resultado de la operación \"" + operacion + "\" con los números del archivo es: " + resultadoOperacion);
			
		}
		else {
			System.out.println("Operación inválida");
		}
	}
	
	// Suma = 150
	// Multiplicacion = 226800
	public static int operacionConNumerosDelArchivo(Path rutaDeArchivo, String operacion) {
		
		int resultado = 0;
		
		if (operacion.matches("M")) {
			resultado = 1;
		}
		
		try {
			
			for (String linea : Files.readAllLines(rutaDeArchivo)){
				switch (operacion) {

				case "S":
					resultado = resultado + Integer.parseInt(linea);
					break;
					
				case "M":
					resultado = resultado * Integer.parseInt(linea);
					break;
					
				default:
					
					break;
				}
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}

}
