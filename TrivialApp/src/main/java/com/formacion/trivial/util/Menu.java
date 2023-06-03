package com.formacion.trivial.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.formacion.trivial.entity.Jugador;
import com.formacion.trivial.entity.Pregunta;
import com.formacion.trivial.service.TrivialService;
import com.formacion.trivial.serviceImp.TrivialServiceImp;

public class Menu {
	
	TrivialService trivialService = new TrivialServiceImp();

	private static final Log LOGGER = LogFactory.getLog(Menu.class);

	private static boolean isValid = false;	
	protected static final int PLAY = 1;
	protected static final int PUNTUACIONES = 2;
	protected static final int SALIR = 3;
	
	private static Scanner entrada = new Scanner(System.in);

	public void mostrarMenu() {
		
		while (!isValid) {

			try {

				System.out.println();
				System.out.println("╔═══════════════════════════════════════════════════╗");
				System.out.println("║             APP Trivial 1.0                       ║");
				System.out.println("║                                                   ║");
				System.out.println("║ ¡Bienvenido al Trivial de Preguntas y Respuestas! ║");
				System.out.println("╠═══════════════════════════════════════════════════╣");
				System.out.println("║                                                   ║");
				System.out.println("║  1. Jugar Trivial                                 ║");
				System.out.println("║  2. Puntuaciones                                  ║");
				System.out.println("║  3. Salir                                         ║");				
				System.out.println("║                                                   ║");
				System.out.println("║  Seleccione una opción:                           ║");
				System.out.println("╚═══════════════════════════════════════════════════╝");
				System.out.println();


				int opcion = entrada.nextInt();
				entrada.nextLine();

				switch (opcion) {
				
				case PLAY:
					
					List<Pregunta> preguntas = trivialService.obtenerPreguntas();
					System.out.println();
					barajarPreguntas(preguntas);
					trivialService.jugarTrivial(preguntas);
					break;
				
				case PUNTUACIONES:
					
					List<Jugador> puntuaciones = new ArrayList<>();
					System.out.println(puntuaciones);					
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
				System.out.println("Entrada inválida. Debe ingresar un número. Intente nuevamente.");
				entrada.nextLine();
			}

		}

	}	
	
	 private static void barajarPreguntas(List<Pregunta> preguntas) {
	        Collections.shuffle(preguntas);
	    }

}
