package Dominio;

import java.time.LocalDate;

public class Panes {
	private String nombre;
	private float precio;
	private int existencia;
	private String sabor;
	private LocalDate fechalabo;

	public Panes(String nombre, float precio, int existencia, String sabor, LocalDate fechalabo) {
		this.nombre = nombre;
		this.precio = precio;
		this.existencia = existencia;
		this.sabor = sabor;
		this.fechalabo = fechalabo;
	}

	public Panes() {
	}

	@Override
	public String toString() {
		return "Panes [nombre=" + nombre + ", precio=" + precio + ", existencia=" + existencia + ", sabor=" + sabor
				+ ", fechalabo=" + fechalabo + "]\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public LocalDate getFechalabo() {
		return fechalabo;
	}

	public void setFechalabo(LocalDate fechalabo) {
		this.fechalabo = fechalabo;
	}

}
