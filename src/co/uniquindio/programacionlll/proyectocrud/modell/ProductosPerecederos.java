package co.uniquindio.programacionlll.proyectocrud.modell;

import java.time.LocalDate;

public class ProductosPerecederos  {

	private LocalDate fechaVencimiento;

	// Metodo constructor
	public ProductosPerecederos(LocalDate fechaVencimiento) {
		super();
		this.fechaVencimiento = fechaVencimiento;
	}

	// Metodos getters and setters
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public String toString() {
		return "ProductosPerecederos [fechaVencimiento=" + fechaVencimiento + "]";
	}

}