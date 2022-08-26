package co.uniquindio.programacionlll.proyectocrud.controller;
	import java.net.URL;
	import java.util.ResourceBundle;

import co.uniquindio.programacionlll.proyectocrud.application.Aplicacion;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;

	public class VentasController {

		private Aplicacion aplicacion;

	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="btnAtras"
	    private Button btnAtras; // Value injected by FXMLLoader

	    @FXML
	    void mostrarVentanaPrincipal(ActionEvent event) {
			aplicacion.mostrarVentanaPrincipal();
	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'Ventas.fxml'.";

	    }
		public void setAplicacion(Aplicacion aplicacion) {

			this.aplicacion = aplicacion;
		}
	}
