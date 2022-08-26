package co.uniquindio.programacionlll.proyectocrud.modell;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<Cliente> listaClientes = new ArrayList<>();
	ArrayList<Producto> listaProductos = new ArrayList<>();

	public Tienda() {

		// CLIENTE
		Cliente cliente = new Cliente();
		cliente.setNombre("Ana");
		cliente.setIdentificacion("1234");
		cliente.setApellido("Cardona");
		cliente.setDireccion("Carrera 13 # 2-40");
		cliente.setTelefono("3114323456");
		cliente.setNit("131412");
		cliente.setNumIdTrubitaria("102030");
		getListaClientes().add(cliente);

		cliente = new Cliente();
		cliente.setNombre("Luis");
		cliente.setIdentificacion("5678");
		cliente.setApellido("Ramirez");
		cliente.setDireccion("Calle 12 #15-20");
		cliente.setTelefono("348678943");
		cliente.setFechaNacimiento("10 de octubre del 2000");
		cliente.setEmail("luis@hotmail.com");
		getListaClientes().add(cliente);

		cliente = new Cliente();
		cliente.setNombre("Ramón");
		cliente.setIdentificacion("349103");
		cliente.setApellido("Velez");
		cliente.setDireccion("Carrera 13 # 2-40");
		cliente.setTelefono("3114323456");
		cliente.setFechaNacimiento("2 de enero de 1994");
		cliente.setEmail("Ramon10@hotmail.com");
		getListaClientes().add(cliente);

		// PRODUCTO

		Producto producto = new Producto();
		producto.setCantExistente(10);
		producto.setCodigo("12345");
		producto.setDescripcion("Bbebida para el consumo humano");
		producto.setNombre("Coca cola");
		producto.setValorUnitario("13000");
		producto.setPesoEnvase(20.0);
		producto.setFechaEnvasado("10 de enero de 2021");
		getListaProductos().add(producto);

		producto = new Producto();
		producto.setCantExistente(3);
		producto.setCodigo("6789");
		producto.setDescripcion("Alimento gatuno");
		producto.setNombre("Chunky");
		producto.setValorUnitario("20000");
		producto.setTiemRefrigeracion("20°");
		producto.setAprobado("101010");
		getListaProductos().add(producto);

		producto = new Producto();
		producto.setCantExistente(8);
		producto.setCodigo("101112");
		producto.setDescripcion("Consumo humano");
		producto.setNombre("Atún");
		producto.setValorUnitario("30000");
		producto.setFechaVencimiento("10 de octubre de 2025");
		getListaProductos().add(producto);

	}

	// ------------ GETTERS AND SETTERS-----------------

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;

	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	// ---------------------------CLIENTE----------------------

	public Cliente agregarCliente(String nombre, String apellido, String identificacion, String direccion,
			String telefono, String email, String numIdTrubitaria, String nit, String fechaNacimiento) {

		if (existeCliente(identificacion)) {
			return null;

		} else {

			Cliente nuevoCliente = new Cliente();
			nuevoCliente.setNombre(nombre);
			nuevoCliente.setApellido(apellido);
			nuevoCliente.setIdentificacion(identificacion);
			nuevoCliente.setDireccion(direccion);
			nuevoCliente.setEmail(email);
			nuevoCliente.setNumIdTrubitaria(numIdTrubitaria);
			nuevoCliente.setFechaNacimiento(fechaNacimiento);
			nuevoCliente.setNit(nit);
			nuevoCliente.setTelefono(telefono);
			getListaClientes().add(nuevoCliente);
			return nuevoCliente;

		}

	}

	private boolean existeCliente(String identificacion) {

		boolean existe = false;
		for (Cliente cliente : listaClientes) {
			if (cliente.getIdentificacion().equals(identificacion)) {
				existe = true;
				return existe;

			}
		}
		return existe;

	}

	public void actualizarCliente(String nombre, String apellido, String identificacion, String direccion,
			String telefono, String email, String numIdTrubitaria, String nit, String fechaNacimiento) {
		Cliente cliente = obtenerCliente(identificacion);

		if (cliente != null) {
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			cliente.setIdentificacion(identificacion);
			cliente.setTelefono(telefono);
			cliente.setNit(nit);
			cliente.setFechaNacimiento(fechaNacimiento);
			cliente.setNumIdTrubitaria(numIdTrubitaria);
			cliente.setEmail(email);
		}
	}

	public Boolean eliminarCliente(String identificacionCliente) {

		Boolean flagEliminado = false;
		Cliente cliente = obtenerCliente(identificacionCliente);

		if (cliente != null) {
			getListaClientes().remove(cliente);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Cliente obtenerCliente(String identificacionCliente) {

		Cliente clienteEncontrado = null;

		for (Cliente cliente : listaClientes) {
			if (cliente.getIdentificacion().equals(identificacionCliente)) {
				clienteEncontrado = cliente;
				break;

			}
		}
		return clienteEncontrado;
	}

	// -----------------------------PRODUCTO------------------------


	public Producto agregarProducto(String codigo, String nombre, String descripcion, String valorUnitario,
			String tiemRefrigeracion, String aprobado, double pesoEnvase, int cantExistente, String fechaEnvasado,
			String fechaVencimiento) {



		if (existeProducto(codigo)) {
			return null;

		} else {

			Producto nuevoProducto = new Producto();
			nuevoProducto.setCantExistente(cantExistente);
			nuevoProducto.setCodigo(codigo);
			nuevoProducto.setDescripcion(descripcion);
			nuevoProducto.setNombre(nombre);
			nuevoProducto.setValorUnitario(valorUnitario);
			nuevoProducto.setPesoEnvase(pesoEnvase);
			nuevoProducto.setAprobado(aprobado);
			nuevoProducto.setFechaVencimiento(fechaVencimiento);
			nuevoProducto.setTiemRefrigeracion(tiemRefrigeracion);
			nuevoProducto.setFechaEnvasado(fechaEnvasado);

			return nuevoProducto;

		}
	}
	private boolean existeProducto(String codigo) {

		boolean existe = false;
		for (Producto producto : listaProductos) {
			if (producto.getCodigo().equals(codigo)) {
				existe = true;
				return existe;
			}

		}
		return existe;

	}


	public void actualizarProducto(String codigo, String nombre, String descripcion, String valorUnitario,
			String tiemRefrigeracion, String aprobado, double pesoEnvase, int cantExistente, String fechaEnvasado,
			String fechaVencimiento) {
		Producto producto = obtenerProducto(codigo);
		if (producto != null) {
			producto.setCantExistente(cantExistente);
			producto.setCodigo(codigo);
			producto.setDescripcion(descripcion);
			producto.setNombre(nombre);
			producto.setValorUnitario(valorUnitario);
			producto.setPesoEnvase(pesoEnvase);
			producto.setAprobado(aprobado);
			producto.setFechaVencimiento(fechaVencimiento);
			producto.setTiemRefrigeracion(tiemRefrigeracion);
			producto.setFechaEnvasado(fechaEnvasado);

		}

	}


	public Boolean eliminarProducto(String codigo) {

		Boolean flagEliminado = false;
		Producto producto = obtenerProducto(codigo);

		if (producto != null) {
			getListaProductos().remove(producto);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Producto obtenerProducto(String codigoProducto) {

		Producto productoEncontrado = null;

		for (Producto producto : listaProductos) {

			if (producto.getCodigo().equals(codigoProducto)) {
				productoEncontrado = producto;
				break;

			}

		}
		return productoEncontrado;
	}




}