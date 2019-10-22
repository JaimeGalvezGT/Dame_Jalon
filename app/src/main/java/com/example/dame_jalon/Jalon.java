package com.example.dame_jalon;

public class Jalon {

    private int idJalon, carne, estado;
    private String Nombre, Apellido,  Direccion, Telefono, Dia, Hora;

    public Jalon(int idJalon, int carne, String nombre, String apellido, String direccion, String telefono, String dia, String hora, int estado) {
        this.idJalon = idJalon;
        this.carne = carne;
        this.estado = estado;
        Nombre = nombre;
        this.Apellido = apellido;
        Direccion = direccion;
        Telefono = telefono;
        Dia = dia;
        Hora = hora;
    }

    public Jalon(){

    }

    public int getIdJalon() {
        return idJalon;
    }

    public void setIdJalon(int idJalon) {
        this.idJalon = idJalon;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
