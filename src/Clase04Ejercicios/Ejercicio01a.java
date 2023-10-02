package Clase04Ejercicios;

public class Ejercicio01a {

	public static void main(String[] args) {
		
		int[] vectorDeNumeros = {4,80,10};
		
		vectorDeNumeros = ordenamiento(vectorDeNumeros, 'd');
		
		
		for (int numero : vectorDeNumeros) {
			System.out.println(numero);
		}
		
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
