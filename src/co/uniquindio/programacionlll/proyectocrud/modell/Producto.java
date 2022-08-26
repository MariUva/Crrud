package co.uniquindio.programacionlll.proyectocrud.modell;


/**
 * Clase Producto que representa al cliente
 *
 * @author Mariana U
 *
 */

public class Producto {

	public Producto() {
		super();
	}
	// Atributos
	private String codigo;
	public Producto(String codigo, String nombre, String descripcion, String valorUnitario, int cantExistente,
			String fechaEnvasado, Double pesoEnvase, String fechaVencimiento, String aprobado,
			String tiemRefrigeracion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valorUnitario = valorUnitario;
		this.cantExistente = cantExistente;
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
		this.fechaVencimiento = fechaVencimiento;
		this.aprobado = aprobado;
		this.tiemRefrigeracion = tiemRefrigeracion;
	}
	private String nombre;
	private String descripcion;
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valorUnitario="
				+ valorUnitario + ", cantExistente=" + cantExistente + ", fechaEnvasado=" + fechaEnvasado
				+ ", pesoEnvase=" + pesoEnvase + ", fechaVencimiento=" + fechaVencimiento + ", aprobado=" + aprobado
				+ ", tiemRefrigeracion=" + tiemRefrigeracion + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getCantExistente() {
		return cantExistente;
	}
	public void setCantExistente(int cantExistente) {
		this.cantExistente = cantExistente;
	}
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public Double getPesoEnvase() {
		return pesoEnvase;
	}
	public void setPesoEnvase(Double pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getAprobado() {
		return aprobado;
	}
	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}
	public String getTiemRefrigeracion() {
		return tiemRefrigeracion;
	}
	public void setTiemRefrigeracion(String tiemRefrigeracion) {
		this.tiemRefrigeracion = tiemRefrigeracion;
	}
	private String valorUnitario;
	private int cantExistente;


	private String fechaEnvasado;
	private Double pesoEnvase;

	private String fechaVencimiento;

	private String aprobado;
	private String tiemRefrigeracion;

}