package com.formacion.trivial.service;

import java.util.List;

import com.formacion.trivial.entity.Jugador;
import com.formacion.trivial.entity.Pregunta;

public interface TrivialService {
	
	List<Pregunta> obtenerPreguntas();
	void jugarTrivial(List<Pregunta> preguntas);
	List<Jugador> getPlayJugadores();

}
