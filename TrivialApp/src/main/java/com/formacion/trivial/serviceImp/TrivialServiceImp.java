package com.formacion.trivial.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.formacion.trivial.dominio.Estadistica;
import com.formacion.trivial.dominio.Jugador;
import com.formacion.trivial.dominio.Partida;
import com.formacion.trivial.dominio.Pregunta;
import com.formacion.trivial.service.TrivialService;
import com.formacion.trivial.util.TematicaTrivial;

public class TrivialServiceImp implements TrivialService {

	private static final Log LOGGER = LogFactory.getLog(TrivialServiceImp.class);
	private static Scanner entrada = null;
	protected static String opcion = "";
	protected static final String VERDADERO = "1";
	protected static final String FALSO = "2";
	
	private static int totalRespuestasAcertadas;
	private static int puntuacionTotal;
	private static int totalPreguntas;
	private static double porcentajeRespuestasAcertadas = 0.0;
	public TrivialServiceImp() {
		totalRespuestasAcertadas = 0;
		puntuacionTotal = 0;
		totalPreguntas = 0;
	}

	@Override
	public List<Pregunta> obtenerPreguntas() {
				
		List<Pregunta> preguntas = new ArrayList<>();

		preguntas.add(new Pregunta("¿La capital de Francia es París?", TematicaTrivial.GEOGRAFIA, true, 1));
		preguntas.add(new Pregunta("¿La caja negra de un avión es negra?", TematicaTrivial.HISTORIA, false, 2));
		preguntas.add(new Pregunta("¿Marrakech es la capital de Marruecos?", TematicaTrivial.GEOGRAFIA, false, 3));
		preguntas.add(new Pregunta("¿El unicornio es el animal nacional de Escocia?", TematicaTrivial.CURIOSIDADES, true, 3));
		preguntas.add(new Pregunta("¿El rugido de un león puede oírse hasta a ocho kilómetros de distancia?", TematicaTrivial.ANIMALES, true, 4));
		preguntas.add(new Pregunta("¿Venus es el planeta más caliente del sistema solar?", TematicaTrivial.CIENCIA, true, 3));
		preguntas.add(new Pregunta("¿El monte Fuji es la montaña más alta de Japón?", TematicaTrivial.GEOGRAFIA, true, 3));
		preguntas.add(new Pregunta("¿Cleopatra era de ascendencia egipcia?", TematicaTrivial.HISTORIA, false, 3));
		preguntas.add(new Pregunta("¿Los caracoles pueden dormir un mes?", TematicaTrivial.CURIOSIDADES, false, 4));
		preguntas.add(new Pregunta("¿Tomar un vaso de agua fría quema 60 calorías?", TematicaTrivial.CURIOSIDADES, true, 5));

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
	    
	    String tematica = pregunta.getTematica().getTema();	        
	    int longitudTematica = tematica.length(); // Longitud fija para mostrar la temática

	    System.out.println();
	    System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                        Pregunta Trivial                                           ║");
	    System.out.println("║                                                                                   ║");
	    System.out.println("║" + enunciado + getEspaciosEnBlanco(longitudLinea - longitudEnunciado) + "            ║");
	    System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════╣");
	    System.out.println("║                                                                                   ║");
	    System.out.println("║ Temática: " + tematica + getEspaciosEnBlanco(longitudLinea  - longitudTematica) + " ║");
	    System.out.println("║                                                                                   ║");
	    System.out.println("║ 1. Verdadero                                                                      ║");
	    System.out.println("║ 2. Falso                                                                          ║");
	    System.out.println("║                                                                                   ║");
	    System.out.println("║ Seleccione una opción:                                                            ║");
	    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════╝");
	    System.out.println();
	}

	
	/**
	 * Devuelve una cadena de espacios en blanco. para ajustar el diseño de menu en la consola.. ok
	 * 
	 * @param cantidad La cantidad de espacios en blanco que se desean obtener.
	 * @return Una cadena con una cantidad especificada de espacios en blanco.
	 */
	private static String getEspaciosEnBlanco(int cantidad) {
	    StringBuilder espacios = new StringBuilder();
	    for (int i = 0; i < cantidad; i++) {
	        espacios.append(" ");
	    }
	    return espacios.toString();
	}

	 
	
	/**
	 * Evalúa la respuesta proporcionada por el jugador a una pregunta dada y devuelve la cantidad de aciertos actualizada.
	 * 
	 * @param aciertos La cantidad de aciertos actual.
	 * @param pregunta La pregunta a evaluar.
	 * @return La cantidad de aciertos actualizada.
	 */
	private static int evaluarRespuesta(int aciertos, Pregunta pregunta) {
				
		opcion = entrada.nextLine();
		String enunciado = "";

		if (opcion.equals(VERDADERO)) {

			if (pregunta.isEsCorrecta()) {
				System.out.println();
				System.out.println("¡Respuesta correcta!");
				aciertos += pregunta.getDificultad();
				totalRespuestasAcertadas++;
				porcentajeRespuestasAcertadas = (double) totalRespuestasAcertadas / totalPreguntas * 100;
				System.out.println("total de Respuestas Acertadas: " + totalRespuestasAcertadas);
				System.out.println("total de porcentaje Respuestas Acertadas: " + porcentajeRespuestasAcertadas);

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
				totalRespuestasAcertadas++;
				System.out.println("total de Respuestas Acertadas: " + totalRespuestasAcertadas);
				
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
		
		totalPreguntas++;
		System.out.println("total de Preguntas: " + totalPreguntas);
		
		System.out.println("has acertado un total de: " + totalRespuestasAcertadas + " de: " + totalPreguntas);
		
		return aciertos;
	}

	@Override
	public List<Jugador> getPlayJugadores() {
		
		List<Jugador> jugadores = new ArrayList<>();

		jugadores.add(new Jugador(1, "Marcelo", 0, new ArrayList<>()));
		jugadores.add(new Jugador(2, "Aitor", 0, new ArrayList<>()));
		jugadores.add(new Jugador(3, "Beatriz", 0, new ArrayList<>()));
		jugadores.add(new Jugador(4, "Joseba", 0, new ArrayList<>()));

		return jugadores;
	}

	@Override
	 public Map<Jugador, Estadistica> obtenerEstadisticas() {
	        
		 Map<Jugador, Estadistica> estadisticas = new HashMap<>();

	        for (Jugador jugador : getPlayJugadores()) {
	            int partidasJugadas = 0;
	            int partidasGanadas = 0;
	            int partidasPerdidas = 0;

	            for (Partida partida : jugador.getPartidasJugadas()) {
	                partidasJugadas++;

	                if (partida.isGanada()) {
	                    partidasGanadas++;
	                } else {
	                    partidasPerdidas++;
	                }
	            }

	            Estadistica estadisticasJugador = new Estadistica(partidasJugadas, partidasGanadas, partidasPerdidas);
	            estadisticas.put(jugador, estadisticasJugador);
	        }

	        return estadisticas;
	    }
	 
	
}
