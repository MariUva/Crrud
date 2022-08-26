package co.uniquindio.programacionlll.proyectocrud.modell;

public class ProductosRefrigerados {

	private Boolean aprobado;
	private String temRefrigeracion;

	// Metodo constructor
	public ProductosRefrigerados(Boolean aprobado, String temRefrigeracion) {
		super();
		this.aprobado = aprobado;
		this.temRefrigeracion = temRefrigeracion;
	}

	// Metodos getters and setters
	public Boolean getAprobado() {
		return aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}

	public String getTemRefrigeracion() {
		return temRefrigeracion;
	}

	public void setTemRefrigeracion(String temRefrigeracion) {
		this.temRefrigeracion = temRefrigeracion;
	}

	@Override
	public String toString() {
		return "ProductosRefrigerados [aprobado=" + aprobado + ", temRefrigeracion=" + temRefrigeracion + "]";
	}

}