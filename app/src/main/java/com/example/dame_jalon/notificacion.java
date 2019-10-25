package com.example.dame_jalon;

public class notificacion {
    private int idNotificacion;
    private int carneReceptor;
    private int carneCreador;
    private String nombreCreador;
    private String apellidoCreador;
    private String email;
    private String telefono;
    private int estado;
    public notificacion(){

    }

    public notificacion(int idNotificacion, int carneReceptor, int carneCreador, String nombreCreador, String apellidoCreador, String email, String telefono, int estado) {
        this.idNotificacion = idNotificacion;
        this.carneReceptor = carneReceptor;
        this.carneCreador = carneCreador;
        this.nombreCreador = nombreCreador;
        this.apellidoCreador = apellidoCreador;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getCarneReceptor() {
        return carneReceptor;
    }

    public void setCarneReceptor(int carneReceptor) {
        this.carneReceptor = carneReceptor;
    }

    public int getCarneCreador() {
        return carneCreador;
    }

    public void setCarneCreador(int carneCreador) {
        this.carneCreador = carneCreador;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }

    public String getApellidoCreador() {
        return apellidoCreador;
    }

    public void setApellidoCreador(String apellidoCreador) {
        this.apellidoCreador = apellidoCreador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
