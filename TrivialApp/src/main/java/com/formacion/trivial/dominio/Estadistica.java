package com.formacion.trivial.dominio;

import java.io.Serializable;

public class Estadistica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int respuestasAcertadas;
	private int puntuacionObtenida;
	private int porcentajeRespuestas;
	
	public Estadistica() {
		super();
	}

	public Estadistica(int respuestasAcertadas, int puntuacionObtenida, int porcentajeRespuestas) {
		super();
		this.respuestasAcertadas = respuestasAcertadas;
		this.puntuacionObtenida = puntuacionObtenida;
		this.porcentajeRespuestas = porcentajeRespuestas;
	}

	public int getRespuestasAcertadas() {
		return respuestasAcertadas;
	}

	public void setRespuestasAcertadas(int respuestasAcertadas) {
		this.respuestasAcertadas = respuestasAcertadas;
	}

	public int getPuntuacionObtenida() {
		return puntuacionObtenida;
	}

	public void setPuntuacionObtenida(int puntuacionObtenida) {
		this.puntuacionObtenida = puntuacionObtenida;
	}

	public int getPorcentajeRespuestas() {
		return porcentajeRespuestas;
	}

	public void setPorcentajeRespuestas(int porcentajeRespuestas) {
		this.porcentajeRespuestas = porcentajeRespuestas;
	}

	@Override
	public String toString() {
		return "Estadistica [respuestasAcertadas=" + respuestasAcertadas + ", puntuacionObtenida=" + puntuacionObtenida
				+ ", porcentajeRespuestas=" + porcentajeRespuestas + "]";
	}
	
}
