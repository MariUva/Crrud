package co.uniquindio.programacionlll.proyectocrud.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.programacionlll.proyectocrud.application.Aplicacion;
import co.uniquindio.programacionlll.proyectocrud.modell.Producto;
import co.uniquindio.programacionlll.proyectocrud.modell.Tienda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CrudGestionProductoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<String, Producto> columNombre;

	@FXML
	private Button btnLimpiar;

	@FXML
	private TableColumn<String, Producto> columValorUnitario;

	@FXML
	private TableColumn<String, Producto> columCodigo;

	@FXML
	private TextField txtCodigo;

	@FXML
	private Button btnAgregar;

	@FXML
	private TextField txtFechaEnvasado;

	@FXML
	private TextField txtValorUnitario;

	@FXML
	private TextField txtAprobado;

	@FXML
	private Button btnAtras;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtCantidad;

	@FXML
	private Button btnEliminar;

	@FXML
	private TextField txtFechaVencimiento;

	@FXML
	private TextArea txtDescripcion;

	@FXML
	private TextField txtPesoEnvasado;

	@FXML
	private TextField txtTemperatura;

	@FXML
	private Button btnActualizar;

	@FXML
	private TableView<Producto> tableViewProductos;

	private Aplicacion aplicacion;

	private Tienda tienda;

	@FXML
	void limpiarProducto(ActionEvent event) {

		txtCantidad.clear();
		txtCodigo.clear();
		txtDescripcion.clear();
		txtFechaVencimiento.clear();
		txtNombre.clear();
		txtFechaEnvasado.clear();
		txtTemperatura.clear();
		txtValorUnitario.clear();
		txtAprobado.clear();
		txtPesoEnvasado.clear();
		txtCantidad.clear();

		txtCodigo.setDisable(false);

	}

	@FXML
	void actualizarProducto(ActionEvent event) {

		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText();
		String descripcion = txtDescripcion.getText();
		String valorUnitario = txtValorUnitario.getText();
		String tiemRefrigeracion = txtTemperatura.getText();
		String aprobado = txtAprobado.getText();
		double pesoEnvase = Double.parseDouble(this.txtPesoEnvasado.getText());
		int cantExistente = Integer.parseInt(this.txtCantidad.getText());
		String fechaEnvasado = txtFechaEnvasado.getText();
		String fechaVencimiento = txtFechaVencimiento.getText();

		if (productoSeleccion != null) {
			if (datosValidos(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion, aprobado, pesoEnvase,
					cantExistente, fechaEnvasado, fechaVencimiento)) {
				aplicacion.actualizarProducto(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion, aprobado,
						pesoEnvase, cantExistente, fechaEnvasado, fechaVencimiento);

				productoSeleccion.setAprobado(aprobado);
				productoSeleccion.setCantExistente(cantExistente);
				productoSeleccion.setCodigo(codigo);
				productoSeleccion.setValorUnitario(valorUnitario);
				productoSeleccion.setTiemRefrigeracion(tiemRefrigeracion);
				productoSeleccion.setNombre(nombre);
				productoSeleccion.setPesoEnvase(pesoEnvase);
				productoSeleccion.setFechaVencimiento(fechaVencimiento);
				productoSeleccion.setDescripcion(descripcion);
				productoSeleccion.setFechaEnvasado(fechaEnvasado);

				tableViewProductos.refresh();
				mostrarMensaje("InformaciÃ³n", "Actualizar", "El producto ha sido actualizado.", AlertType.CONFIRMATION);

			} else {
				mostrarMensaje("Advertencia", "Actualizar", "No se ha realizado la selecciÃ³n de un producto.",
						AlertType.WARNING);
			}

		}

	}

	@FXML
	void agregarProducto(ActionEvent event) {

		String codigo = txtCodigo.getText();
		String nombre = txtNombre.getText();
		String descripcion = txtDescripcion.getText();
		String valorUnitario = txtValorUnitario.getText();
		String tiemRefrigeracion = txtTemperatura.getText();
		String aprobado = txtAprobado.getText();
		double pesoEnvase = Double.parseDouble(this.txtPesoEnvasado.getText());
		int cantExistente = Integer.parseInt(this.txtCantidad.getText());
		String fechaEnvasado = txtFechaEnvasado.getText();
		String fechaVencimiento = txtFechaVencimiento.getText();

		if (datosValidos(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion, aprobado, pesoEnvase,
				cantExistente, fechaEnvasado, fechaVencimiento)) {

			crearProducto(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion, aprobado, pesoEnvase,
					cantExistente, fechaEnvasado, fechaVencimiento);
			actualizarTabla();

		}

	}

	private void crearProducto(String codigo, String nombre, String descripcion, String valorUnitario,
			String tiemRefrigeracion, String aprobado, double pesoEnvase, int cantExistente, String fechaEnvasado,
			String fechaVencimiento) {

		Producto producto = aplicacion.crearProducto(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion,
				aprobado, pesoEnvase, cantExistente, fechaEnvasado, fechaVencimiento);

		if (producto != null) {
			listadoProductos.add(0, producto);
			listadoProductos.add(producto);
			mostrarMensaje("NotificaciÃ³n Producto", "Producto registrado",
					"El producto " + producto.getNombre() + " ha sido registrado", AlertType.INFORMATION);
		} else {
			mostrarMensaje("NotificaciÃ³n Producto", "Producto no registrado",
					"El producto " + nombre + " no ha sido registrado", AlertType.WARNING);
		}

	}

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
	private boolean datosValidos(String codigo, String nombre, String descripcion, String valorUnitario,
			String tiemRefrigeracion, String aprobado, double pesoEnvase, int cantExistente, String fechaEnvasado,
			String fechaVencimiento) {

		String notificacion = "";

		if (nombre == null || nombre.equals("")) {
			notificacion += "Nombre no tiene informaciÃ³n\n";

		}

		if (codigo == null || codigo.equals("")) {
			notificacion += "Codigo no tiene informaciÃ³n\n";

		}
		if (descripcion == null || descripcion.equals("")) {
			notificacion += "DescripciÃ³n no tiene informaciÃ³n\n";

		}
		if (valorUnitario == null || valorUnitario.equals("")) {
			notificacion += "Valor unitario no tiene informaciÃ³n\n";

		}

		if (notificacion.equals("")) {
			return true;

		}

		// if (cantExistente == null || cantExistente.equals(0)) {
		// notificacion += "Nombre no tiene informaciÃ³n\n";

		// }

		mostrarMensaje("Advertencia", "InformaciÃ³n del producto invalida", notificacion, AlertType.WARNING);
		return false;

	}

	@FXML
	void eliminarProducto(ActionEvent event) {

		if (productoSeleccion != null) {
			if (aplicacion.eliminarProducto(productoSeleccion.getCodigo())) {
				mostrarMensaje("InformaciÃ³n", "Producto eliminado", "El producto ha sido eliminado", AlertType.ERROR);
			} else {
				mostrarMensaje("InformaciÃ³n", "Producto selecciÃ³n", "No se ha realizado la selecciÃ³n de un producto",
						AlertType.INFORMATION);
			}
			listadoProductos.remove(productoSeleccion);

		} else {
			mostrarMensaje("Advertencia", "Producto selecciÃ³n", "No se ha realizado la selecciÃ³n de un producto",
					AlertType.ERROR);
		}

	}
	// ----------------------------------------

	ObservableList<Producto> listadoProductos = FXCollections.observableArrayList();

	private Producto productoSeleccion;

	private void mostrarInformacion() {
		if (productoSeleccion != null) {

			// txtPesoEnvasado.setText(productoSeleccion.getPesoEnvase());
			txtFechaVencimiento.setText(productoSeleccion.getFechaVencimiento());
			txtTemperatura.setText(productoSeleccion.getTiemRefrigeracion());
			txtFechaEnvasado.setText(productoSeleccion.getFechaEnvasado());
			txtAprobado.setText(productoSeleccion.getAprobado());
			txtCodigo.setText(productoSeleccion.getCodigo());
			txtNombre.setText(productoSeleccion.getNombre());
			txtDescripcion.setText(productoSeleccion.getDescripcion());
			txtCantidad.setText(productoSeleccion.getCantExistente() + "");
			txtValorUnitario.setText(productoSeleccion.getValorUnitario());
			txtCodigo.setDisable(true);

		}
	}

	public void actualizarTabla() {
		tableViewProductos.getItems().clear();
		listadoProductos.clear();

		listadoProductos.addAll(tienda.getListaProductos());
		tableViewProductos.getItems().addAll(listadoProductos);
		tableViewProductos.refresh();

	}

	@FXML
	void mostrarVentanaPrincipal(ActionEvent event) {
		aplicacion.mostrarVentanaPrincipal();

	}

	@FXML
	void initialize() {

		this.columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));

		tableViewProductos.getSelectionModel().selectedItemProperty().addListener((obs, olSelection, newSelection) -> {

			if (newSelection != null) {
				productoSeleccion = newSelection;
				mostrarInformacion();

			}

		});

	}

	public void setAplicacion(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
		this.tienda = aplicacion.getTienda();

		tableViewProductos.getItems().clear();
		tableViewProductos.setItems(getProductos());
	}

	private ObservableList<Producto> getProductos() {

		listadoProductos.addAll(tienda.getListaProductos());
		return listadoProductos;
	}

	public void setAplicacion(GestionTiendaController gestionTiendaController) {
	}

}
