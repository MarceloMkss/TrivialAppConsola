package com.formacion.trivial.dominio;

public class Partida {
	
	private boolean ganada;

	public Partida() {
		super();
	}

	public Partida(boolean ganada) {
		super();
		this.ganada = ganada;
	}

	public boolean isGanada() {
		return ganada;
	}

	public void setGanada(boolean ganada) {
		this.ganada = ganada;
	}

	@Override
	public String toString() {
		return "PartidaTrivial [ganada=" + ganada + "]";
	}
		
}
