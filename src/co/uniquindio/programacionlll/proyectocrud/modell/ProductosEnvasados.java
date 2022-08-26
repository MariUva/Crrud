package co.uniquindio.programacionlll.proyectocrud.modell;

import java.time.LocalDate;

public class ProductosEnvasados {

	private LocalDate fechaEnvasado;
	private Double pesoEnvase;

	// Meotodo constructor
	public ProductosEnvasados(LocalDate fechaEnvasado, Double pesoEnvase) {
		// super();
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
	}

	// Metodos getters and setters
	// public LocalDate getFechaEnvasado() {
//	return fechaEnvasado;

	//}

	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public Double getPesoEnvase() {
		return pesoEnvase;
	}

	public void setPesoEnvase(Double pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}

	@Override
	public String toString() {
		return "ProductosEnvasados [fechaEnvasado=" + fechaEnvasado + ", pesoEnvase=" + pesoEnvase + "]";
	}

}