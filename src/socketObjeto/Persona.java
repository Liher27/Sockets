package socketObjeto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Persona implements Serializable {

	private static final long serialVersionUID = 2646549875587956360L;

	String nif = null;
	String nombre = null;
	String apellido = null;
	Date fechaNacimiento = null;
	char genero = 0;

	public Persona(String nif, String nombre, String apellido, Date fechaNacimiento, char genero) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", genero=" + genero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, fechaNacimiento, genero, nif, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& genero == other.genero && Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre);
	}

}
