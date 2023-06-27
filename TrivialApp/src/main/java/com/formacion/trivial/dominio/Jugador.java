package com.formacion.trivial.dominio;

import java.util.List;

public class Jugador {
	
	private int id;
	private String name;	
	private int puntos;
	private List<Partida> partidasJugadas;

	public Jugador() {
		super();		
	}

	public Jugador(int id, String name, int puntos, List<Partida> partidasJugadas) {
		super();
		this.id = id;
		this.name = name;
		this.puntos = puntos;
		this.partidasJugadas = partidasJugadas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Partida> getPartidasJugadas() {
		return partidasJugadas;
	}

	public void setPartidasJugadas(List<Partida> partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", name=" + name + ", puntos=" + puntos + ", partidasJugadas=" + partidasJugadas
				+ "]";
	}

}
