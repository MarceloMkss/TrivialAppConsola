package com.formacion.trivial.util;

public enum TematicaTrivial {
	
    CIENCIA("Ciencia"),
    HISTORIA("Historia"),
    DEPORTES("Deportes"),
    GEOGRAFIA("Geografía"),
    ARTE("Arte"),
    ENTRETENIMIENTO("Entretenimiento");

    private final String tema;

    TematicaTrivial(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }
}

