package com.formacion.trivial.util;

public enum TematicaTrivial {
	
    CIENCIA("Ciencia"),
    HISTORIA("Historia"),
    DEPORTES("Deportes"),
    GEOGRAFIA("Geografía"),
    ARTE("Arte"),
    ANIMALES("Animales"),
    CURIOSIDADES("Curiosidades");

    private final String tema;

    TematicaTrivial(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }
}

