package com.formacion.trivial;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.formacion.trivial.entity.Jugador;
import com.formacion.trivial.service.TrivialService;
import com.formacion.trivial.serviceImp.TrivialServiceImp;
import com.formacion.trivial.util.Menu;

public class ApplicationTrivial {

	static TrivialService trivialService = new TrivialServiceImp();
	private static boolean isValid = false;	
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcion;

		do {
			menuDado();
			System.out.println();
			opcion = entrada.nextInt();		

			switch (opcion) {
			case 1:
				// Lógica para lanzar el dado y comenzar la partida
				List<Jugador> listaJugadores = trivialService.getPlayJugadores();
				int numJugadores = listaJugadores.size(); // Obtener el número total de jugadores.
				System.out.println("Lanzando el dado...");
				int jugadorActual = lanzarDado(numJugadores); // Lanzo el dado para determinar el jugador inicial de la partida.
				Jugador jugador = listaJugadores.get(jugadorActual - 1); // Obtengo el jugador actual.		

				
				
				System.out.println("Comienza el juego. Jugador aleatorio siendo seleccionado...");				

			    mostrarGiroConsola();
			    
			    System.out.println();
			    System.out.println("Bienvenido al Juego de Trivial " + jugador.getName() + " ¡¡que te diviertas!!");								
			    System.out.println();
			   
				Menu menu = new Menu();
				menu.mostrarMenu();
				break;
			case 2:
				System.out.println("Saliendo del juego. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
				break;
			}
		} while (!isValid);


	}// main

	private static void menuDado() {
		System.out.println("╔══════════════════════╗");
		System.out.println("║        MENÚ          ║");
		System.out.println("╠══════════════════════╣");
		System.out.println("║ 1. Lanzar dado       ║");
		System.out.println("║ 2. Salir             ║");
		System.out.println("╚══════════════════════╝");
		System.out.print("Selecciona una opción: ");
	}

	public static int lanzarDado(int numJugadores) {
		Random random = new Random();
		return random.nextInt(numJugadores) + 1;
	}
	
	 public static void mostrarGiroConsola() {
	        try {
	        	List<Jugador> listaJugadores = trivialService.getPlayJugadores();
	        	for (Jugador jugador : listaJugadores) {
	        		System.out.print("\rBuscando Jugador Aleatorio... " + (jugador.getName()));
	                Thread.sleep(100); // Pausa de 200 milisegundos para simular el giro
				}
	          
	            System.out.println();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}