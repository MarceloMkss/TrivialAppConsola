package com.formacion.trivial.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.formacion.trivial.entity.Jugador;
import com.formacion.trivial.entity.Pregunta;
import com.formacion.trivial.service.TrivialService;

public class TrivialServiceImp implements TrivialService {

	private static final Log LOGGER = LogFactory.getLog(TrivialServiceImp.class);
	private static Scanner entrada = null;
	protected static String opcion = "";
	protected static final String VERDADERO = "1";
	protected static final String FALSO = "2";

	@Override
	public List<Pregunta> obtenerPreguntas() {

		List<Pregunta> preguntas = new ArrayList<>();

		preguntas.add(new Pregunta("¿La capital de Francia es París?", true, 1));
		preguntas.add(new Pregunta("¿La caja negra de un avión es negra?", false, 2));
		preguntas.add(new Pregunta("¿Marrakech es la capital de Marruecos?", false, 3));
		preguntas.add(new Pregunta("¿El unicornio es el animal nacional de Escocia?", true, 3));
		preguntas.add(new Pregunta("¿El rugido de un león puede oírse hasta a ocho kilómetros de distancia?", true, 4));
		preguntas.add(new Pregunta("¿Venus es el planeta más caliente del sistema solar.?", true, 3));
		preguntas.add(new Pregunta("¿El monte Fuji es la montaña más alta de Japón.?", true, 3));
		preguntas.add(new Pregunta("¿Cleopatra era de ascendencia egipcia?", false, 3));
		preguntas.add(new Pregunta("¿Los caracoles pueden dormir un mes.?", false, 4));
		preguntas.add(new Pregunta("¿Tomar un vaso de agua fría quema 60 calorías.?", true, 5));

		return preguntas;
	}


	
	@Override
	public void jugarTrivial(List<Pregunta> preguntas) {

		entrada = new Scanner(System.in);
		int aciertos = 0;

		for (Pregunta pregunta : preguntas) {

			menuRespuesta(pregunta);
			aciertos = evaluarRespuesta(aciertos, pregunta);

		}

		LOGGER.info("Juego terminado. has acertado un Total de: " + aciertos + " Puntos");
		System.out.println();
	}

	private static void menuRespuesta(Pregunta pregunta) {
	   
	    String enunciado = pregunta.getEnunciado();
	    int longitudEnunciado = enunciado.length();
	    int longitudLinea = 71; // Longitud fija de la línea del menú

	    System.out.println();
	    System.out.println("╔═════════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                        Pregunta Trivial                                 ║");
	    System.out.println("║                                                                         ║");
	    System.out.println("║ " + enunciado + getEspaciosEnBlanco(longitudLinea - longitudEnunciado) + " ║");
	    System.out.println("╠═════════════════════════════════════════════════════════════════════════╣");
	    System.out.println("║ 1. Verdadero                                                            ║");
	    System.out.println("║ 2. Falso                                                                ║");
	    System.out.println("║                                                                         ║");
	    System.out.println("║ Seleccione una opción:                                                  ║");
	    System.out.println("╚═════════════════════════════════════════════════════════════════════════╝");
	    System.out.println();
	}

	private static String getEspaciosEnBlanco(int cantidad) {
	    StringBuilder espacios = new StringBuilder();
	    for (int i = 0; i < cantidad; i++) {
	        espacios.append(" ");
	    }
	    return espacios.toString();
	}

	 

	private static int evaluarRespuesta(int aciertos, Pregunta pregunta) {

		opcion = entrada.nextLine();
		String enunciado = "";

		if (opcion.equals(VERDADERO)) {

			if (pregunta.isEsCorrecta()) {
				System.out.println();
				System.out.println("¡Respuesta correcta!");
				aciertos += pregunta.getDificultad();
			} else {
				System.out.println();
				System.out.println("Respuesta incorrecta.");
				enunciado = pregunta.getEnunciado().replace("¿", "¡").replace("?", "!");
				System.out.println("+--------------------------------------------+");
				System.out.println(enunciado);

			}
		} else if (opcion.equals(FALSO)) {

			if (!pregunta.isEsCorrecta()) {
				System.out.println();
				System.out.println("¡Respuesta correcta!");
				aciertos += pregunta.getDificultad();
			} else {
				System.out.println();
				System.out.println("Respuesta incorrecta.");
				enunciado = pregunta.getEnunciado().replace("¿", "¡").replace("?", "!");
				System.out.println("+--------------------------------------------+");
				System.out.println(enunciado);

			}
		} else {
			System.out.println("Opción inválida. Por favor, seleccione 1 o 2.");
		}
		return aciertos;
	}

	@Override
	public List<Jugador> getPlayJugadores() {
		
		List<Jugador> jugadores = new ArrayList<>();

		// Agregar jugadores a la lista
		jugadores.add(new Jugador(1, "Marcelo", 0));
		jugadores.add(new Jugador(2, "Aitor", 0));
		jugadores.add(new Jugador(3, "Beatriz", 0));
		jugadores.add(new Jugador(4, "Joseba", 0));

		return jugadores;
	}
	
	 private static String limitarLongitud1(String texto) {
		    int longitudMaxima = 71; // Elige la longitud máxima deseada para la pregunta
		    if (texto.length() <= longitudMaxima) {
		        return texto;
		    } else {
		        return texto.substring(0, longitudMaxima - 3) + "...";
		    }
		}

}
