package com.formacion.trivial.dominio;

import com.formacion.trivial.util.TematicaTrivial;

public class Pregunta {

	private String enunciado;
	private TematicaTrivial tematica;
	private boolean esCorrecta;
	private int dificultad;	

	public Pregunta() {
		super();
	}

	public Pregunta(String enunciado, TematicaTrivial tematica, boolean esCorrecta, int dificultad) {
		super();
		this.enunciado = enunciado;
		this.tematica = tematica;
		this.esCorrecta = esCorrecta;
		this.dificultad = dificultad;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public TematicaTrivial getTematica() {
		return tematica;
	}

	public void setTematica(TematicaTrivial tematica) {
		this.tematica = tematica;
	}

	public boolean isEsCorrecta() {
		return esCorrecta;
	}

	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Pregunta [enunciado=" + enunciado + ", tematica=" + tematica + ", esCorrecta=" + esCorrecta
				+ ", dificultad=" + dificultad + "]";
	}
	
}
