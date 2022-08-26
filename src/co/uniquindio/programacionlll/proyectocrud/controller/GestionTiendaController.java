package co.uniquindio.programacionlll.proyectocrud.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.programacionlll.proyectocrud.application.Aplicacion;
import co.uniquindio.programacionlll.proyectocrud.modell.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestionTiendaController implements Initializable {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnGestionCliente;

	@FXML
	private Button btnGestionProducto;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVentas;
	@FXML
	public void gestionarCrudCliente(ActionEvent event) {

		aplicacion.gestionarCrudCliente();

	}

	@FXML
	public void gestionarCrudProducto(ActionEvent event) {

		aplicacion.gestionarCrudProducto();

	}
	@FXML
	public void mostrarVentanaComprarID(ActionEvent event) {

		aplicacion.llamarComprarID();
	}
	@FXML
	public void mostrarVentanaVentas(ActionEvent event) {
		aplicacion.llamarVentas();

	}

	private Aplicacion aplicacion;

	private Tienda tienda;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void initialize() {

	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		this.tienda = aplicacion.getTienda();

	}

}
