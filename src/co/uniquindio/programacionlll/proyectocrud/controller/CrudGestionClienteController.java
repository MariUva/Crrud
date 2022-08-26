package co.uniquindio.programacionlll.proyectocrud.controller;

import java.net.URL;
import java.util.ResourceBundle;
import co.uniquindio.programacionlll.proyectocrud.application.Aplicacion;
import co.uniquindio.programacionlll.proyectocrud.modell.Cliente;
//import co.uniquindio.programacionlll.proyectocrud.modell.ClienteJuridico;
//import co.uniquindio.programacionlll.proyectocrud.modell.ClienteNatural;
import co.uniquindio.programacionlll.proyectocrud.modell.Tienda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CrudGestionClienteController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<String, Cliente> columNombre;

	@FXML
	private TableColumn<String, Cliente> columApellidos;

	@FXML
	private TableColumn<String, Cliente> columIdentificacion;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtFechaNacimiento;

	@FXML
	private Button btnNuevo;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtNit;

	@FXML
	private Button btnAgregar;

	@FXML
	private Button btnLimpiar;

	@FXML
	private TextField txtIdentificacion;

	@FXML
	private TableView<Cliente> tableViewClientes;

	@FXML
	private Button btnEliminar;

	@FXML
	private TextField txtTelefono;

	@FXML
	private TextField txtNombres;

	@FXML
	private Button btnActualizar;

	@FXML
	private Button btnAtras;

	@FXML
	private ToggleGroup seleccionarTipPersona;

	@FXML
	private TextField txtNumeroIdenTributaria;

	private Aplicacion aplicacion;

	private Tienda tienda;

	@FXML
	private void limpiarCliente(ActionEvent event) {

		txtNombres.clear();
		txtApellidos.clear();
		txtDireccion.clear();
		txtIdentificacion.clear();
		txtTelefono.clear();

		txtNit.clear();
		txtNumeroIdenTributaria.clear();

		txtEmail.clear();
		txtFechaNacimiento.clear();

		txtIdentificacion.setDisable(false);
		txtFechaNacimiento.setDisable(false);

	}

	/*
	 *
	 * @FXML void seleccionarTipPersona(ActionEvent event) {
	 *
	 * if (rButtonPerJuri.isSelected()) {
	 *
	 * txtEmail.setDisable(true); txtNacimineto.setDisable(true);
	 *
	 * txtNit.setDisable(false); txtNumeroIdenTributaria.setDisable(false);
	 *
	 * } else if (rButtonPerNatural.isSelected()) {
	 *
	 * txtNit.setDisable(true); txtNumeroIdenTributaria.setDisable(true);
	 *
	 * txtEmail.setDisable(false); txtNacimineto.setDisable(false); }
	 *
	 * }
	 */

	@FXML
	private void actualizarCliente(ActionEvent event) {

		String nombre = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		String identificacion = txtIdentificacion.getText();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();

		String email = txtEmail.getText();
		String fechaNacimiento = txtFechaNacimiento.getText();
		String numIdTrubitaria = txtNumeroIdenTributaria.getText();
		String nit = txtNit.getText();

		if (clienteSeleccion != null) {

			if (datosValidos(nombre, apellidos, identificacion, direccion, telefono, email, numIdTrubitaria, nit,
					fechaNacimiento)) {
				aplicacion.actualizarCliente(nombre, apellidos, identificacion, direccion, telefono, email,
						numIdTrubitaria, nit, fechaNacimiento);

				clienteSeleccion.setApellido(apellidos);
				clienteSeleccion.setDireccion(direccion);
				clienteSeleccion.setNombre(nombre);
				clienteSeleccion.setIdentificacion(identificacion);
				clienteSeleccion.setTelefono(telefono);

				clienteSeleccion.setEmail(email);
				clienteSeleccion.setFechaNacimiento(fechaNacimiento);
				clienteSeleccion.setNit(nit);
				clienteSeleccion.setNumIdTrubitaria(numIdTrubitaria);

				tableViewClientes.refresh();
				mostrarMensaje("Información", "Actualizar", "El cliente ha sido actualizado.", AlertType.CONFIRMATION);

			}

		} else {
			mostrarMensaje("Advertencia", "Actualizar", "No se ha realizado la selección de un cliente.",
					AlertType.WARNING);

		}
	}

	@FXML
	private void agregarCliente(ActionEvent event) {

		String nombre = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		String identificacion = txtIdentificacion.getText();
		String direccion = txtDireccion.getText();
		String telefono = txtTelefono.getText();

		String email = txtEmail.getText();
		String fechaNacimiento = txtFechaNacimiento.getText();
		String nit = txtNit.getText();
		String numIdTrubitaria = txtNumeroIdenTributaria.getText();
		/*
		 * if (rButtonPerJuri.isSelected()) {
		 *
		 * String nit = txtNit.getText(); String numIdTrubitaria =
		 * txtNumeroIdenTributaria.getText();
		 *
		 * } else if (rButtonPerNatural.isSelected()) {
		 *
		 * String email = txtEmail.getText(); // String fechaNacimiento =
		 * txtNacimineto.getText();
		 *
		 * }
		 *
		 */
		// String email = txtEmail.getText();
		// String numIdTrubitaria = txtNumeroIdenTributaria.getText();
		// String nit = txtNit.getText();

		if (datosValidos(nombre, apellidos, identificacion, direccion, telefono, email, numIdTrubitaria, nit,
				fechaNacimiento)) {
			crearCliente(nombre, apellidos, identificacion, direccion, telefono, email, numIdTrubitaria, nit,
					fechaNacimiento);
			actualizarTabla();

		}

		/**
		 * 0. User: Diligenciar formulario 1. worker: Capturar los datos 2.
		 * Worker:Validar la informacion 3. Worker: Si esta bien: Lo debe
		 * registrar 3.1 Sino debe mostrar un mensaje indicando que la
		 * informacion es invalida
		 */

	}

	private void crearCliente(String nombre, String apellido, String identificacion, String direccion, String telefono,
			String email, String numIdTrubitaria, String nit, String fechaNacimiento) {
		// Notificar al usuario que el cliente fue registrado

		Cliente cliente = aplicacion.crearCliente(nombre, apellido, identificacion, direccion, telefono, email,
				numIdTrubitaria, nit, fechaNacimiento);

		if (cliente != null) {
			listadoClientes.add(0, cliente);
			listadoClientes.add(cliente);
			mostrarMensaje("Notificación Cliente", "Cliente registrado",
					"El cliente " + cliente.getNombre() + " ha sido registrado", AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificación Cliente", "Cliente no registrado",
					"El cliente " + nombre + " no ha sido registrado", AlertType.WARNING);
		}

	}

	/**
	 * Este metodo muestra un mensaje al usuario
	 *
	 * @param titulo
	 * @param header
	 * @param contenido
	 * @param alertType
	 */
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(contenido);
		alerta.showAndWait();

	}

	/*
	 * Metodo que permite verificar si todos los campos han sido dilingeciados
	 */
	private boolean datosValidos(String nombre, String apellido, String identificacion, String direccion,
			String telefono, String email, String numIdTrubitaria, String nit, String fechaNacimiento) {

		String notificacion = "";

		if (nombre == null || nombre.equals("")) {
			notificacion += "Nombre no tiene información\n";

		}
		if (apellido == null || apellido.equals("")) {
			notificacion += "Apellido no tiene información\n";

		}
		if (identificacion == null || identificacion.equals("")) {
			notificacion += "Identificación no tiene información\n";

		}
		if (direccion == null || direccion.equals("")) {
			notificacion += "Dirección no tiene información\n";
		}
		if (telefono == null || telefono.equals("")) {
			notificacion += "Telefono no tiene información\n";

		}

		if (notificacion.equals("")) {
			return true;

		}

		mostrarMensaje("Advertencia", "Información del cliente invalida", notificacion, AlertType.WARNING);
		return false;

	}

	@FXML
	private void eliminarCliente(ActionEvent event) {

		if (clienteSeleccion != null) {
			if (aplicacion.eliminarCliente(clienteSeleccion.getIdentificacion())) {
				mostrarMensaje("Información", "Cliente eliminado", "El cliente ha sido eliminado", AlertType.ERROR);

			} else {

				mostrarMensaje("Información", "Cliente selección", "No se ha realizado una seleccion de un cliente",
						AlertType.INFORMATION);

			}
			listadoClientes.remove(clienteSeleccion);

		} else {
			mostrarMensaje("Advertencia", "Cliente selección", "No se ha realizado una seleccion de un cliente",
					AlertType.ERROR);

		}

	}

	// -------------------------BOTONES PERSONA NATURAL Y //
	// JURIDICA---------------------

	/*
	 * @FXML void seleccionPersoNatural(ActionEvent event) {
	 *
	 * txtEmail.setDisable(false); txtNacimineto.setDisable(false);
	 *
	 * txtNit.setDisable(true); txtNumeroIdenTributaria.setDisable(true);
	 *
	 * }
	 *
	 * @FXML void seleccionPersoJuridica(ActionEvent event) {
	 *
	 * txtNit.setDisable(false); txtNumeroIdenTributaria.setDisable(false);
	 *
	 * txtEmail.setDisable(true); txtNacimineto.setDisable(true);
	 *
	 * }
	 *
	 */
	// ------------------------------TABLA----------------------------------------------

	ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();

	private Cliente clienteSeleccion;

	private void mostrarInformacion() {

		if (clienteSeleccion != null) {
			txtNombres.setText(clienteSeleccion.getNombre());
			txtApellidos.setText(clienteSeleccion.getApellido());
			txtIdentificacion.setText(clienteSeleccion.getIdentificacion());
			txtDireccion.setText(clienteSeleccion.getDireccion());
			txtTelefono.setText(clienteSeleccion.getTelefono());

			txtEmail.setText(clienteSeleccion.getEmail());
			txtFechaNacimiento.setText(clienteSeleccion.getFechaNacimiento());
			txtNit.setText(clienteSeleccion.getNit());
			txtNumeroIdenTributaria.setText(clienteSeleccion.getNumIdTrubitaria());

			txtIdentificacion.setDisable(true);
			txtFechaNacimiento.setDisable(true);

		}
	}

	public void actualizarTabla() {

		tableViewClientes.getItems().clear();
		listadoClientes.clear();

		listadoClientes.addAll(tienda.getListaClientes());
		tableViewClientes.getItems().addAll(listadoClientes);
		tableViewClientes.refresh();

	}

	@FXML
	void initialize() {

		this.columIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
		this.columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));

		tableViewClientes.getSelectionModel().selectedItemProperty().addListener((obs, olSelection, newSelection) -> {

			if (newSelection != null) {
				clienteSeleccion = newSelection;
				mostrarInformacion();

			}

		});

	}

	public void setAplicacion(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
		this.tienda = aplicacion.getTienda();

		tableViewClientes.getItems().clear();
		tableViewClientes.setItems(getClientes());

	}

	private ObservableList<Cliente> getClientes() {

		listadoClientes.addAll(tienda.getListaClientes());
		return listadoClientes;
	}

	@FXML
	public void mostrarVentanaPrincipal(ActionEvent event) {

		aplicacion.mostrarVentanaPrincipal();

	}

	public void setAplicacion(GestionTiendaController gestionTiendaController) {

	}

}