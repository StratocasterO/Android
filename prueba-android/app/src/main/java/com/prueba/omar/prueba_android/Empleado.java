package com.prueba.omar.prueba_android;

public class Empleado {
    private String nombre;
    private String edad;
    private String empleado;

    public Empleado(String nombre, String edad, String empleado){
        this.nombre = nombre;
        this.edad = edad;
        this.empleado = empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
}
