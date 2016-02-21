package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Small extends Application {
    // Container
    BorderPane borderPane = new BorderPane();
    // Labels
    Label topLbl = new Label("Top");
    Label leftLbl = new Label("Left");
    Label rightLbl = new Label("Right");
    Label bottomLbl = new Label("Bottom");
    // Button
    Button centerBtn = new Button("Click");
    // VBox
    VBox topVb = new VBox();
    VBox leftVb = new VBox();
    VBox rightVb = new VBox();
    VBox bottomVb = new VBox();
    // Stages
    Stage stage;
    
    @Override
    public void init() {
        //VBox Config
        topVb.getChildren().add(topLbl);
        topVb.setAlignment(Pos.CENTER);
        
        leftVb.getChildren().add(leftLbl);
        leftVb.setAlignment(Pos.CENTER);
        
        rightVb.getChildren().add(rightLbl);
        rightVb.setAlignment(Pos.CENTER);
        
        bottomVb.getChildren().add(bottomLbl);
        bottomVb.setAlignment(Pos.CENTER);
        
        //Add VBox to Pane
        borderPane.setTop(topVb);
        borderPane.setLeft(leftVb);
        borderPane.setRight(rightVb);
        borderPane.setBottom(bottomVb);
        borderPane.setCenter(centerBtn);
        
        //centerBtn.setOnAction(new EventHandler<ActionEvent>() {
        //    public void handle(ActionEvent event) {
        //        Large.setStage(stage);
        //    }
        //});
        //stage.setTitle("AWS | Large");
        //stage.setScene(new Scene(borderPane, 1024, 768));
        //stage.show();
    }
    
    @Override
    public void start(Stage stage) {
        // Small [Phone]: 320x480 | Large [Tablet]: 1024x768
        this.stage = stage;
        stage.setTitle("AWS | Small");
        stage.setScene(new Scene(borderPane, 320, 480));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
