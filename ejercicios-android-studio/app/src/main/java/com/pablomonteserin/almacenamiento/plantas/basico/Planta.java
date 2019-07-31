package com.pablomonteserin.almacenamiento.plantas.basico;

import java.io.Serializable;

public class Planta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String frecuenciaRiego;
	private String otrosCuidados;
	private String foto;
	private String ubicacion;

	
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFrecuenciaRiego() {
		return frecuenciaRiego;
	}

	public void setFrecuenciaRiego(String frecuenciaRiego) {
		this.frecuenciaRiego = frecuenciaRiego;
	}

	public String getOtrosCuidados() {
		return otrosCuidados;
	}

	public void setOtrosCuidados(String otrosCuidados) {
		this.otrosCuidados = otrosCuidados;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
