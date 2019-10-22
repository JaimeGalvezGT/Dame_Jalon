package com.example.dame_jalon;

public class usuario {
    //Atributos de la clase
    private  static int carne;
    private static String nombre;
    private static String apellido;
    private String email;
    private String password;
    private static String direccion;
    private static String telefono;
    private int id_rol;
    private int estado;

    //Constructor que recibe todos los parametros de usuario


    public usuario(int carne, String nombre, String apellido, String email, String password, String direccion, String telefono, int id_rol, int estado) {
        this.carne = carne;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_rol = id_rol;
        this.estado = estado;
    }

    //Constructor sin parametros
    public usuario() {

    }

    //Metodos gets y sets


    public static int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return id_rol;
    }

    public void setIdRol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getFK_estado() {
        return estado;
    }

    public int getFK_rol() {
        return id_rol;
    }

    public static String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
