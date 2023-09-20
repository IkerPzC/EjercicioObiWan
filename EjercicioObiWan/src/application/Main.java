package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Group;
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
        botonSaludar.setOnAction(e -> {
            if (tfNombreIntroducido.getText().equals("Obi Wan")) {
               mostrarAlerta();
            } else {
            	tfMostrarSaludo.setText("Hola "+tfNombreIntroducido.getText());
            }
        });

	}
	
	 protected void mostrarAlerta() {
		 
		 //Se crea un stage y se hace modal
	     Stage stage = new Stage(StageStyle.UTILITY);
	     stage.initModality(Modality.APPLICATION_MODAL);
	     
	     //Se crea una etiqueta
	     Label etiqueta = new Label("!General Kenobi!");
	     
	     //Se crea un grupo al que se añade la etiqueta
	     Group root = new Group(etiqueta);
	     
	     //Se crea una escena, la cual se asigna como escena principal y se le da un titulo
	     Scene scene = new Scene(root);
	     stage.setScene(scene);
	     stage.setTitle("FX Alert");
	     
	     //Se muestra la escena
	     stage.show();
	 }
	
	public static void main(String[] args) {
		launch(args);
	}
}