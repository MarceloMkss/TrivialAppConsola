package com.formacion.trivial.service;

import java.util.List;
import java.util.Map;

import com.formacion.trivial.dominio.Estadistica;
import com.formacion.trivial.dominio.Jugador;
import com.formacion.trivial.dominio.Pregunta;

public interface TrivialService {
	
	List<Pregunta> obtenerPreguntas();
	void jugarTrivial(List<Pregunta> preguntas);
	List<Jugador> getPlayJugadores();
	Map<Jugador, Estadistica> obtenerEstadisticas();
}
