package com.formacion.trivial.entity;

public class Jugador {
	
	private int id;
	private String name;	
	private int puntos;	

	public Jugador() {
		super();		
	}

	public Jugador(int id, String name, int puntos) {
		super();
		this.id = id;
		this.name = name;
		this.puntos = puntos;
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

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", name=" + name + ", puntos=" + puntos + "]";
	}

}
