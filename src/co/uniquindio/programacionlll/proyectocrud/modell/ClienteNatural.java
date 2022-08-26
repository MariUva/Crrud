package co.uniquindio.programacionlll.proyectocrud.modell;

/**
 * Clase cliente natural, que representa el cliente natural
 *
 * @author Mariana U
 *
 */

public class ClienteNatural extends Cliente {

	private String email;
	private String fechaNacimiento;

	// Metodo constructor
	public ClienteNatural(String email, String fechaNacimiento) {
		super();
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	// Metodos getters and setters
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

	@Override
	public String toString() {
		return "ClienteNatural [email=" + email + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}