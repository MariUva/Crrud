package co.uniquindio.programacionlll.proyectocrud.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import co.uniquindio.programacionlll.proyectocrud.application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import co.uniquindio.programacionlll.proyectocrud.modell.Cliente;
import co.uniquindio.programacionlll.proyectocrud.modell.Producto;
import co.uniquindio.programacionlll.proyectocrud.modell.Tienda;

public class ComprarIDController {

	private Aplicacion aplicacion;

	private Tienda tienda;


	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="btnIngresar"
	private Button btnIngresar; // Value injected by FXMLLoader

	@FXML // fx:id="btnAtras"
	private Button btnAtras; // Value injected by FXMLLoader

    @FXML // fx:id="txtID"
    private TextField txtID; // Value injected by FXMLLoader

    @FXML // fx:id="columCodigo"
    private TableColumn<?, ?> columCodigo; // Value injected by FXMLLoader

    @FXML // fx:id="columNombre"
    private TableColumn<?, ?> columNombre; // Value injected by FXMLLoader

    @FXML // fx:id="tableProductos"
    private TableView<?> tableProductos; // Value injected by FXMLLoader

    @FXML
	private void llamarCompras(ActionEvent event) {

			aplicacion.llamarComprar();
	}

	@FXML
	void mostrarVentanaPrincipal(ActionEvent event) {
		aplicacion.mostrarVentanaPrincipal();
	}

	public void setAplicacion(Aplicacion aplicacion) {

		this.aplicacion = aplicacion;
	}
}
