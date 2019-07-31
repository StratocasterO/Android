package com.pablomonteserin.mapas.Monumentos;

import java.io.Serializable;

public class Monumento implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private int latitud;
	private int longitud;
	
	
	public Monumento(int id, String nombre, String descripcion, int latitud,
			int longitud){
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getLatitud() {
		return latitud;
	}
	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

}
