package co.uniquindio.programacionlll.proyectocrud.modell;

/**
 * Clase Cliente que representa al cliente
 *
 * @author Mariana U
 *
 */

public class Cliente {

	// Atributos
	private String nombre;
	private String apellido;
	private String identificacion;
	private String direccion;
	private String telefono;

	private String nit;
	private String numIdTrubitaria;

	private String email;
	private String fechaNacimiento;

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", identificacion=" + identificacion
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", nit=" + nit + ", numIdTrubitaria="
				+ numIdTrubitaria + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + "]";
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNumIdTrubitaria() {
		return numIdTrubitaria;
	}

	public void setNumIdTrubitaria(String numIdTrubitaria) {
		this.numIdTrubitaria = numIdTrubitaria;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}