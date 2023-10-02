package Clase04Ejercicios;

import java.util.Scanner;

public class Ejercicio01c {

	public static void main(String[] args) {

		// Declaro vector para que se ingresen los numeros por consola
		int[] vectorDeNumeros = new int[3];

		// Declaro vector y le asigno valores
		//int[] vectorDeNumeros = {4,80,10};

		// Si el vector no tiene valores, entonces lo solicito
		if (!existenNumeros(vectorDeNumeros)) {
			
			vectorDeNumeros = solicitarNumeros(vectorDeNumeros.length);
		}
		
		// Ordeno vector, siendo 'a' = ascendente y 'd' = descendete
		vectorDeNumeros = ordenamiento(vectorDeNumeros, 'd');
			
		// Recorro vector para mostrar por pantalla
		for (int numero : vectorDeNumeros) {
			System.out.println(numero);
		}

	}
	
	public static boolean existenNumeros(int[] numeros) {
		
		boolean existen = false;
		
		for (int num : numeros) {
			
			if (num != 0) {
				existen = true;
			}
		}
		
		return existen;
	}

	
	public static int[] solicitarNumeros(int cantidadDeNumeros) {
		
		int[] numeros = new int[cantidadDeNumeros];
		Scanner scn = new Scanner(System.in);
		
		for (int i = 0; i < cantidadDeNumeros; i++) {
			
			System.out.println("Ingrese un número:");
				
			numeros[i] = scn.nextInt();
		}
		
		return numeros;
	}

	public static int[] ordenamiento(int[] numeros, char letra) {
		
		if (letra == 'a') // Orden ascendente 
		{
			for (int i = 0; i < numeros.length - 1; i++) {
            	
                for (int j = 0; j < numeros.length - i - 1; j++) {
                	
                    if (numeros[j] > numeros[j + 1]) {

                        int temp = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = temp;
                        
                    }
                }                
            }
			
			System.out.println("Orden ascendente: ");
			
		}
		else if (letra == 'd') // Orden descendente
		{
			for (int i = 0; i < numeros.length - 1; i++) {
            	
                for (int j = 0; j < numeros.length - i - 1; j++) {
                	
                    if (numeros[j] < numeros[j + 1]) {
                    	
                        int temp = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = temp;
                    }
                }
            }
			
			System.out.println("Orden descendente: ");
		}

		return numeros;
	}

}
