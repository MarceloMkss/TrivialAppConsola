package com.formacion.trivial.entity;

public class Pregunta {

	private String enunciado;
	private boolean esCorrecta;
	private int dificultad;	

	public Pregunta() {
		super();
	}

	public Pregunta(String enunciado, boolean esCorrecta, int dificultad) {
		super();
		this.enunciado = enunciado;
		this.esCorrecta = esCorrecta;
		this.dificultad = dificultad;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
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
		return "Pregunta [enunciado=" + enunciado + ", esCorrecta=" + esCorrecta + ", dificultad=" + dificultad + "]";
	}

}
