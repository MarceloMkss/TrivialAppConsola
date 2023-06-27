package com.formacion.trivial.util;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.formacion.trivial.dominio.Estadistica;
import com.formacion.trivial.dominio.Jugador;
import com.formacion.trivial.dominio.Pregunta;
import com.formacion.trivial.service.TrivialService;
import com.formacion.trivial.serviceImp.TrivialServiceImp;

public class MenuPrincipalTrivialAPP {
	
	private static TrivialService trivialService = new TrivialServiceImp();

	private static final Log LOGGER = LogFactory.getLog(MenuPrincipalTrivialAPP.class);

	private static boolean isValid = false;	
	protected static final int JUGADOR = 1;
	protected static final int MULTIJUGADOR = 2;
	protected static final int PUNTUACIONES = 3;	
	protected static final int SALIR = 4;
	protected static int opcion = 0;

	int totalRespuestasAcertadas = 0;
	int totalPuntuacionObtenida = 0;
	double porcentajeRespuestasAcertadas = 0.0;
	
	private static Scanner entrada = new Scanner(System.in);

	public void mostrarMenu() {
		
		while (!isValid) {

			try {
			
				System.out.println("╔═══════════════════════════════════════════════════╗");
				System.out.println("║             APP Trivial 1.0                       ║");
				System.out.println("║                                                   ║");
				System.out.println("║ ¡Bienvenido al Trivial de Preguntas y Respuestas! ║");
				System.out.println("╠═══════════════════════════════════════════════════╣");
				System.out.println("║                                                   ║");
				System.out.println("║  1. ► Jugar Trivial                               ║");
				System.out.println("║  2. ► Jugar Multijugador                          ║");
				System.out.println("║  3. + Estadísticas                                ║");
				System.out.println("║  4. x Salir                                       ║");				
				System.out.println("║                                                   ║");
				System.out.println("║  Seleccione una opción:                           ║");
				System.out.println("╚═══════════════════════════════════════════════════╝");
				System.out.println();


				opcion = entrada.nextInt();
				entrada.nextLine();

				switch (opcion) {
				
				case JUGADOR:
					
					System.out.println("Escriba su Nombre:");
					String nombre = entrada.nextLine();
					System.out.println();
					System.out.println("¡Hola, " + nombre + "! ¡Bienvenido al Trivial de Preguntas y Respuestas!! Buena Suerte!");									
					
					List<Pregunta> preguntas = trivialService.obtenerPreguntas();			
					barajarPreguntas(preguntas);
					trivialService.jugarTrivial(preguntas);
					break;
					
				case MULTIJUGADOR:
				    
					menuDado();
					break;
				
				case PUNTUACIONES:	
					
					System.out.println("Total de respuestas acertadas: " + totalRespuestasAcertadas);
					System.out.println("Total de puntuación obtenida: " + totalPuntuacionObtenida);
					System.out.println("Porcentaje de respuestas acertadas respecto al total: " + porcentajeRespuestasAcertadas + "%");
					
					Jugador jugador = new Jugador();
					jugador.getName();
					jugador.getPuntos();
					jugador.getPartidasJugadas();
					
					Estadistica estadistica = new Estadistica();
					estadistica.getRespuestasAcertadas();
					estadistica.getPuntuacionObtenida();
					estadistica.getPorcentajeRespuestas();
					
					Map<Jugador, Estadistica> estadisticas = trivialService.obtenerEstadisticas();
					estadisticas.put(jugador, estadistica);
					System.out.println(estadisticas);
					LOGGER.info(estadisticas);									
					break;

				case SALIR:
					
					System.out.println();
					LOGGER.info("Gracias por jugar. ¡Hasta luego!");
					isValid = true;					
					break;
 
				default:
					System.out.println("Opción inválida. Intente nuevamente.");
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Debe ingresar un número del menu de Opciones. Intente nuevamente.");
				entrada.nextLine();
			}

		}

	}	

	private static void menuDado() {
		
		System.out.println("╔═════════════════════════════════════════════╗");
		System.out.println("║                                             ║");
		System.out.println("║           MENÚ JUGADOR ALEATORIO            ║");
		System.out.println("║                                             ║");
		System.out.println("║ ¡lanze el dado Y dejé que el destino elija  ║");
		System.out.println("║   al jugador! ¿Quién será el afortunado?    ║");
		System.out.println("║                                             ║");
		System.out.println("╠═════════════════════════════════════════════╣");
		System.out.println("║                                             ║");
		System.out.println("║ 1. Lanzar dado                              ║");
		System.out.println("║ 2. Salir                                    ║");
		System.out.println("║                                             ║");
		System.out.println("╚═════════════════════════════════════════════╝");
		System.out.print("Selecciona una opción: ");
		System.out.println();
		
		opcion = entrada.nextInt();		
	
		switch (opcion) {
		
		case 1:
			
			// Lógica para lanzar el dado y comenzar la partida
			List<Jugador> listaJugadores = trivialService.getPlayJugadores();
			System.out.println(listaJugadores);
			int numJugadores = listaJugadores.size(); // Obtener el número total de jugadores.
			System.out.println("Lanzando el dado...");
			int jugadorActual = lanzarDado(numJugadores); // Lanzo el dado para determinar el jugador inicial de la partida.
			Jugador jugador = listaJugadores.get(jugadorActual - 1); // Obtengo el jugador actual.	

		    mostrarGiroConsola();
		    
		    System.out.println();			    
		    System.out.printf("Bienvenido al Juego de Trivial \"%s\" ¡¡que te diviertas!!", jugador.getName());

		    System.out.println();
		    
			
			List<Pregunta> preguntasMultijugador = trivialService.obtenerPreguntas();
			System.out.println();
			
			barajarPreguntas(preguntasMultijugador);
			trivialService.jugarTrivial(preguntasMultijugador);
		    break;
		    
		case 2:
			System.out.println("Saliendo del juego. ¡Hasta luego!");
			isValid = true;
			break;
			
		default:
			System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
			break;
		
		}
		
		
	}
	
	public static int lanzarDado(int numJugadores) {
		Random random = new Random();
		return random.nextInt(numJugadores) + 1;
	}
	
	 public static void mostrarGiroConsola() {
		 
	        try {
	        	
	        	List<Jugador> listaJugadores = trivialService.getPlayJugadores();
	        	for (Jugador jugador : listaJugadores) {
	        		System.out.print("\rJugador aleatorio siendo seleccionado...... " + (jugador.getName()));
	                Thread.sleep(2000); // Pausa de 200 milisegundos para simular el giro
				}
	          
	            System.out.println();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	 private static void barajarPreguntas(List<Pregunta> preguntas) {
	        Collections.shuffle(preguntas);
	    }

}
