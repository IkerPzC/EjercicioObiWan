package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		//Etiquetas
		TextField tfNombreIntroducido = new TextField();
		Label tfMostrarSaludo = new Label();
		
        //Boton cerrar
        Button botonSaludar = new Button("Saludar");
        Button botonCerrar = new Button("Cerrar");
        
        //Al pulsar el botonCerrar se cierra la ventana
        botonCerrar.setOnAction(w -> Platform.exit());       

        //Añadir los nodos a un panel de tipo Grid
        GridPane root = new GridPane();
        root.add(new Label("Nombre:"), 1, 1);
        root.add(tfNombreIntroducido, 2, 1);
        root.add(botonSaludar, 1, 2);
        root.add(botonCerrar, 1, 3);
        root.add(tfMostrarSaludo, 1, 4);
       
        
        //Se crea una escena
        Scene scene = new Scene(root, 400, 100);
        
        //Se añade la escena a la principal
        stage.setScene(scene);
        
        //Se establece el titulo
        stage.setTitle("Ejercicio Obi Wan");
        
        //Se impide redimensionar
        stage.setResizable(false);
        
        //Se muestra
        stage.show();
        
        //Al pulsar el botonSaludar se valida el texto introducido
        botonSaludar.setOnAction(e -> tfMostrarSaludo.setText("Hola "+tfNombreIntroducido.getText())); 	

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}