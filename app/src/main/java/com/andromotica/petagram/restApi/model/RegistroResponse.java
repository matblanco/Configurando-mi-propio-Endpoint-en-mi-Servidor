package com.andromotica.petagram.restApi.model;

public class RegistroResponse {

    private String id_dispositivo;
    private String id_userinstagram;

    public RegistroResponse(String id_dispositivo, String id_userinstagram) {
        this.id_dispositivo = id_dispositivo;
        this.id_userinstagram = id_userinstagram;
    }

    public RegistroResponse() {
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_userinstagram() {
        return id_userinstagram;
    }

    public void setId_userinstagram(String id_userinstagram) {
        this.id_userinstagram = id_userinstagram;
    }
}
