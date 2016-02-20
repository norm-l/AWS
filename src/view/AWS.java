package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class AWS extends Application {
    
    Stage thestage;
    Scene scene1, scene2;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Tablet Version");
        Circle circle = new Circle(100, Color.BLACK);
        
        thestage = primaryStage;
        BorderPane pane1 = new BorderPane();
        BorderPane pane2 = new BorderPane();
        
        pane1.getChildren().add(btn);
        pane1.setCenter(btn);
        
        scene1 = new Scene(pane1, 320, 480);
        scene2 = new Scene(pane2, 1024, 768);
        
        // Small [Phone]: 320x480 | Large [Tablet]: 1024x768
        
        btn.setOnAction((ActionEvent event) -> {
            thestage.setScene(scene2);
        });

        primaryStage.setTitle("AWS");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
