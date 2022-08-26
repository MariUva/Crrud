package co.uniquindio.programacionlll.proyectocrud.modell;

/**
 * Clase Cliente juridico, que representa al cliente juridico
 *
 * @author Mariana U
 *
 */

public class ClienteJuridico extends Cliente {

	private String nit;
	private String numIdTrubitaria;

	// Metodo constructor
	public ClienteJuridico(String nit, String numIdTrubitaria) {
		super();
		this.nit = nit;
		this.numIdTrubitaria = numIdTrubitaria;
	}

	// Metodos getters and setters
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

	@Override
	public String toString() {
		return "ClienteJuridico [nit=" + nit + ", numIdTrubitaria=" + numIdTrubitaria + "]";
	}

}