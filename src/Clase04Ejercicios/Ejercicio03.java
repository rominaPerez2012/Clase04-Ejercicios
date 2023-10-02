package Clase04Ejercicios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path archivoDeEntrada = Paths.get("recursos/archivoDeEntrada");

		//Path archivoDeSalida = codificacionDeArchivo(false, 1, archivoDeEntrada);
		Path archivoDeSalida =  Paths.get("recursos/archivoDeSalida.txt");
		
		if (codificacionDeArchivo(false, 2, archivoDeEntrada, archivoDeSalida)) {
			
			System.out.println("Se generó un archivo con el resultado: \n" + archivoDeSalida.toAbsolutePath());
		}
	}
	
	public static boolean codificacionDeArchivo(boolean esCodificacion, int desplazamiento, Path unArchivo, Path otroArchivo) {
			
		//Path otroArchivo = Paths.get("recursos/archivoDeSalida.txt");
		boolean exito = false;
		
		try {
			
			if (!Files.exists(otroArchivo)) {
					Files.createFile(otroArchivo);
				}
				
				if (!esCodificacion) {
					
					byte[] decodedBytes = null;

					System.out.println("Se procederá a decodificar el archivo.");
										
					for (String linea : Files.readAllLines(unArchivo)) {
						decodedBytes = linea.getBytes();
					}

					byte[] graboArchivo = new byte[decodedBytes.length];
					
					for (int i=0; i < decodedBytes.length; i++) {
						
						graboArchivo[i] = (byte) (decodedBytes[i] + desplazamiento);
					}

					Files.write(otroArchivo, graboArchivo);

				}
				else {
					
					System.out.println("Se procederá a codificar el archivo.");
					
					for (String linea : Files.readAllLines(unArchivo)) {
						Files.write(otroArchivo, linea.getBytes(StandardCharsets.ISO_8859_1));
					}
				}
				
				exito = true;
				System.out.println("El archivo se procesó con éxito.");
				
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Hubo un error al procesar.");
			e.printStackTrace();
		}
		
		
		
		return exito;
	}

}
