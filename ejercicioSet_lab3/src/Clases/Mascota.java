package Clases;

import java.util.Objects;

public class Mascota {
	private String nombre;
	private String raza;
	private int edad;
	private int numIdentificacion;
	public Mascota(String nombre, String raza, int edad, int numIdentificacion) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.numIdentificacion = numIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumIdentificacion() {
		return numIdentificacion;
	}
	public void setNumIdentificacion(int numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numIdentificacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre)
				&& numIdentificacion == other.numIdentificacion && Objects.equals(raza, other.raza);
	}
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", numIdentificacion="
				+ numIdentificacion + "]";
	}
	
	

}
