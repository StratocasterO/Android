package com.pablomonteserin.listview;

public class Pais {
	private String nombre;
	private String img;
	
	Pais(String nombre, String img){
		this.setNombre(nombre);
		this.setImg(img);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

}
