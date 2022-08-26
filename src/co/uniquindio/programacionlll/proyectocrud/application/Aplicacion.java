package co.uniquindio.programacionlll.proyectocrud.application;

import co.uniquindio.programacionlll.proyectocrud.controller.ComprarController;
import co.uniquindio.programacionlll.proyectocrud.controller.ComprarIDController;
import co.uniquindio.programacionlll.proyectocrud.controller.CrudGestionClienteController;
import co.uniquindio.programacionlll.proyectocrud.controller.CrudGestionProductoController;
import co.uniquindio.programacionlll.proyectocrud.controller.GestionTiendaController;
import co.uniquindio.programacionlll.proyectocrud.controller.VentasController;
import co.uniquindio.programacionlll.proyectocrud.modell.Cliente;
import co.uniquindio.programacionlll.proyectocrud.modell.Producto;
import co.uniquindio.programacionlll.proyectocrud.modell.Tienda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;
	private Tienda tienda;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.tienda = new Tienda();

		mostrarVentanaPrincipal();

	}

	public void mostrarVentanaPrincipal() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacionlll/proyectocrud/view/GestionTiendaview.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			GestionTiendaController gestionTiendaController = loader.getController();
			gestionTiendaController.setAplicacion(this);
			primaryStage.getIcons().add(new Image("/co/uniquindio/programacionlll/proyectocrud/images/icon.png"));
			primaryStage.setX(500);
			primaryStage.setY(150);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void gestionarCrudCliente() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacionlll/proyectocrud/view/CrudGestionCliente.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			CrudGestionClienteController crudGestionClienteController = loader.getController();
			crudGestionClienteController.setAplicacion(this);
			primaryStage.setX(350);
			primaryStage.setY(80);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

			// stage.setOnCloseRequest(e ->
			// crudGestionClienteController.cerrarVentana());

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void gestionarCrudProducto() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacionlll/proyectocrud/view/CrudGestionProducto.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			CrudGestionProductoController CrudGestionProductoController = loader.getController();
			CrudGestionProductoController.setAplicacion(this);
			primaryStage.setX(325);
			primaryStage.setY(40);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void llamarComprarID() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacionlll/proyectocrud/view/ComprarID.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			ComprarIDController controller = loader.getController();
			controller.setAplicacion(this);
			primaryStage.setX(500);
			primaryStage.setY(250);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void llamarComprar() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacionlll/proyectocrud/view/Comprar.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			ComprarController controller = loader.getController();
			controller.setAplicacion(this);
			primaryStage.setX(350);
			primaryStage.setY(130);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void llamarVentas() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("/co/uniquindio/programacionlll/proyectocrud/view/Ventas.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			VentasController controller = loader.getController();
			controller.setAplicacion(this);
			primaryStage.setX(300);
			primaryStage.setY(110);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda proyecto) {
		this.tienda = proyecto;
	}

	public static void main(String[] args) {
		launch(args);
	}

	// ---------------------------------------------- CLIENTE
		// ----------------------------------------

		public Cliente crearCliente(String nombre, String apellido, String identificacion, String direccion,
				String telefono, String email, String numIdTrubitaria, String nit, String fechaNacimiento) {

			Cliente cliente = tienda.agregarCliente(nombre, apellido, identificacion, direccion, telefono, email,
					numIdTrubitaria, nit, fechaNacimiento);
			return cliente;

		}

		public void actualizarCliente(String nombre, String apellidos, String identificacion, String direccion,
				String telefono, String email, String numIdTrubitaria, String nit, String fechaNacimiento) {

			tienda.actualizarCliente(nombre, apellidos, direccion, identificacion, telefono, email, numIdTrubitaria, nit,
					email);

		}

		public boolean eliminarCliente(String identificacion) {

			boolean eliminarCliente = tienda.eliminarCliente(identificacion);
			return eliminarCliente;
		}

		// ----------------------------------------------------------------------------------
		public Producto crearProducto(String codigo, String nombre, String descripcion, String valorUnitario,
				String tiemRefrigeracion, String aprobado, double pesoEnvase, int cantExistente, String fechaEnvasado,
				String fechaVencimiento) {

			Producto producto = tienda.agregarProducto(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion,
					aprobado, pesoEnvase, cantExistente, fechaEnvasado, fechaVencimiento);
			return producto;
		}

		public void actualizarProducto(String codigo, String nombre, String descripcion, String valorUnitario,
				String tiemRefrigeracion, String aprobado, double pesoEnvase, int cantExistente, String fechaEnvasado,
				String fechaVencimiento) {

			tienda.actualizarProducto(codigo, nombre, descripcion, valorUnitario, tiemRefrigeracion, aprobado, pesoEnvase,
					cantExistente, fechaEnvasado, fechaVencimiento);
		}

		public boolean eliminarProducto(String codigo) {
			boolean eliminarProducto = tienda.eliminarProducto(codigo);
			return eliminarProducto;
		}

}
